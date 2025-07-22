package sido.coop.customer_service.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "email", types = Customer.class)
public interface CustomerProjectionEmail {
    //on génère les getters en respectant la syntax

String getEmail();
}
