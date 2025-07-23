package sido.coop.billing_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sido.coop.billing_service.entities.model.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Entity @AllArgsConstructor @NoArgsConstructor @Data @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;

    //relation bidirectionnelle regarder dans l'autre classe pour spécifier l'entité
    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems = new ArrayList<>();

    private long customeId;//il le faut absolument vu que customer est transient
    @Transient//atribut non persistant dire au jpa de lignore dans ne pas lenregistrer dans la bd,  nest pas représenté dans la bd, on peut toujours ajouter des attribué
    //qui sont plutot liés au dto et pas enregistré dans la bd donc de type transien
    private Customer customer;
}
