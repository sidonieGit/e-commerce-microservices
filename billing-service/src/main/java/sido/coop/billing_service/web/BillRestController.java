package sido.coop.billing_service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sido.coop.billing_service.entities.Bill;
import sido.coop.billing_service.feign.CustomerRestClient;
import sido.coop.billing_service.feign.ProductRestClient;
import sido.coop.billing_service.repository.BillRepository;
import sido.coop.billing_service.repository.ProductItemRepository;

@RestController
public class BillRestController {
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;
@GetMapping(path = "/bills/{id}")
    public Bill getBill(@PathVariable Long id){

        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.getCustomerById(bill.getCustomeId()));
        bill.getProductItems().forEach(productItem -> {
            productItem.setProduct(productRestClient.getProductById(productItem.getProductId()));
        });
        return bill;
    }


}
