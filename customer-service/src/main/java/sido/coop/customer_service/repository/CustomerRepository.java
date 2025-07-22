package sido.coop.customer_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import sido.coop.customer_service.entities.Customer;

@RepositoryRestResource//annotation fournie par spring data rest, permet de demander a spring de demarrer auto un web Service qui permet d'acceder à toutes les méthodes se trouvant dans cette interface
public interface CustomerRepository extends JpaRepository <Customer, Long>{
}
