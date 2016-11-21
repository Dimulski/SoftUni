package exercises.domain.roles;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "onwer")
public class Owner extends Role {
}
