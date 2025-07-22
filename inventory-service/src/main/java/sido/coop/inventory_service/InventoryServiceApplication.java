package sido.coop.inventory_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sido.coop.inventory_service.repository.ProductRepository;
import sido.coop.inventory_service.entities.Product;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	//au démarrage je vais creer quelque produit

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args -> {
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Computer")
					.price(3332)
					.quantity(22)
					.build());
			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Printer")
					.price(337732)
					.quantity(2)
					.build());

			productRepository.save(Product.builder()
					.id(UUID.randomUUID().toString())
					.name("Smart phone")
					.price(332)
					.quantity(32)
					.build());

			productRepository.findAll().forEach(product -> {
				System.out.println(product.toString());
			});

		};

	};
}
