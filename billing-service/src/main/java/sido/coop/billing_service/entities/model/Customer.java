package sido.coop.billing_service.entities.model;

import lombok.Data;

//ce n'est pas une entité Jpa car si je  le déclare ainsi, il va me cree une table dans la bd or les customer ne sont pas gérer dans ce service ils sont gerer
//dans une autre bd, cest juste une classe contenant des getters et setter
@Data
public class Customer {
    private Long id;
    private String name;
    private String email;
}
