import utils.DomainConstraint;
/**
 * @author Hydyrow Bayram
 *
 * @overview
 *  This class represent a Hostel object
 *
 * @attributes
 *  float       noStars
 *
 * @object
 *  A typical object Hostel is <id, name, address, noRooms, price>
 *
 * @abstract_properties
 *  mutable(noStars) = true /\ optional(noStars) = false /\ min(noStars) = 3 /\ max(noStars) = 5
 *
 */
public class Hotel extends Hostel {
    @DomainConstraint(type = "int", mutable = true, optional = false, min = 3, max = 5)
    private int noStars;

    /**
     * @effects
     *  initialise an empty object Hotel
     */
    public Hotel(){

    }
}
