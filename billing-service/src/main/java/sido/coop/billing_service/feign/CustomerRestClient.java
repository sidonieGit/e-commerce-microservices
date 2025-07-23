package sido.coop.billing_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sido.coop.billing_service.entities.model.Customer;

//c'est un client rest , ie jai besoin de methode pour communiquer avec customer
@FeignClient (name = "customer-service")// pour que cette méthode puisse fonctionner, il faut l'ajouter et
// spécifier le nom du microservice
public interface CustomerRestClient {

    @GetMapping("/customers")
    public PagedModel <Customer>  getAllCustomer();

    @GetMapping("/customers/{id}")
    public Customer  getCustomerById(@PathVariable Long id);

}
