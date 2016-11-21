package exercises.domain.roles;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "viewer")
public class Viewer extends Role {
}
