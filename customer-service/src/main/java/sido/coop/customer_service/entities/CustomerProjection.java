package sido.coop.customer_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = Customer.class)
public interface CustomerProjection {
    //on génère les getters en respectant la syntax
String getName();
String getEmail();
}
