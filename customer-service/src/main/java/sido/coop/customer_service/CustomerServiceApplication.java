package sido.coop.customer_service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sido.coop.customer_service.entities.Customer;
import sido.coop.customer_service.repository.CustomerRepository;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(Customer.builder()
					//on peut utiliser new customer ou Built() suivi par les paramètre
					.name("Sido").email("sifohouo@gmail.com").build());

			customerRepository.save(Customer.builder()
					//on peut utiliser new customer ou Built() suivi par les paramètre
					.name("Imana").email("imana@gmail.com").build());
			customerRepository.save(Customer.builder()
					//on peut utiliser new customer ou Built() suivi par les paramètre
					.name("Oumou").email("oumou@gmail.com").build());



			customerRepository.findAll().forEach(customer ->{
				System.out.println("==================");
				System.out.println(customer.getId());
				System.out.println(customer.getName());
				System.out.println(customer.getEmail());
				System.out.println("==================");
			} );



		};

	}
}
