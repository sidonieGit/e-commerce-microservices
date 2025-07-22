package sido.coop.customer_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// c'est annotation c'est du JPA
@Entity// il correspond à une table dans le BD
@NoArgsConstructor
@AllArgsConstructor @Data @Builder//pour creer les objet
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//chaque fois il fa incrementer de 1
    private Long id;
    private String name;
    private String email;
}
