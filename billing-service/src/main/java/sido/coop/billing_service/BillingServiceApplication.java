package sido.coop.billing_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import sido.coop.billing_service.entities.Bill;
import sido.coop.billing_service.entities.ProductItem;
import sido.coop.billing_service.entities.model.Customer;
import sido.coop.billing_service.entities.model.Product;
import sido.coop.billing_service.feign.CustomerRestClient;
import sido.coop.billing_service.feign.ProductRestClient;
import sido.coop.billing_service.repository.BillRepository;
import sido.coop.billing_service.repository.ProductItemRepository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients//Spring va scanner ces classes
public class BillingServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(BillingServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(BillRepository billRepository, ProductItemRepository productItemRepository,
										CustomerRestClient customerRestClient, ProductRestClient productRestClient){

		return args -> {

			Collection<Customer> customers= customerRestClient.getAllCustomer().getContent();
//			Collection<Product> products= productRestClient.getAllProduct().getContent(); quand il s	gissait de pageModel
			Collection<Product> products= productRestClient.getAllProduct();

			customers.forEach(customer -> {
				Bill bill= Bill.builder()
						.billingDate(new Date())
						.customeId(customer.getId())
						.build();

				billRepository.save(bill);

				products.forEach(product -> {
					ProductItem productItem = ProductItem.builder()
							.bill(bill)
							.productId(product.getId())
							.quantity(1+new Random().nextInt(10))
							.unitPrice(product.getPrice())
							.build();
					productItemRepository.save(productItem);
				});
			});
		};
	}

}
