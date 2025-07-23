package sido.coop.billing_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sido.coop.billing_service.entities.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem,Long> {
}
