package sido.coop.inventory_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor @AllArgsConstructor @Data @Builder
public class Product {

    @Id //pas de genarate car cets un string
    private String id;
    private String name;
    private double price;
    private int quantity;
}
