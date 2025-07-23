package sido.coop.billing_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sido.coop.billing_service.entities.Bill;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
