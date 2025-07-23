package sido.coop.billing_service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sido.coop.billing_service.entities.model.Product;

import java.util.Collection;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id);
    @GetMapping("/products")
//    public PagedModel<Product> getAllProduct();
    public Collection<Product> getAllProduct();

}
