package sido.coop.inventory_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sido.coop.inventory_service.entities.Product;


public interface ProductRepository extends JpaRepository<Product, String> {
}
