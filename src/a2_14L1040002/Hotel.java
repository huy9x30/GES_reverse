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
 *  A typical object Hotel is <id, name, address, noRooms, price, noStars>
 *
 * @abstract_properties
 *  mutable(noStars) = true /\ optional(noStars) = false /\ min(noStars) = 3 /\ max(noStars) = 5
 *
 */
public class Hotel extends Hostel {
    @DomainConstraint(type = "float", optional = false, min = 3, max = 5)
    private float noStars;

    /**
     * @effects
     *  initialize an empty object Hotel
     */
    public Hotel(){

    }

    /**
     *  @effects
     *   initialize this as object Hotel:<id, name, address, noRooms, price, noStars>,
     *      where id = autoId
     */
    public Hotel(int id, String name, String address, int noRooms, float price, float noStars) throws IllegalArgumentException {
        super(id, name, address, noRooms, price);
        if (validateNoStars(noStars)) {
            this.noStars = noStars;
        } else {
            throw new IllegalArgumentException("Hotel constructor: illegal argument");
        }
    }

    /**
     *  @effects
     *      return noStars
     */
    public float getNoStars() {
        return noStars;
    }

    /**
     *  @effects
     *      set this.noStars = noStars
     */
    public void setNoStars(float noStars) {
        if(validateNoStars(noStars))
            this.noStars = noStars;
    }

    /**
     *  @effects
     *      if noStars is valid
     *          return true
     *      else
     *          return false
     */
    public boolean validateNoStars(float noStars) {
        return (noStars >=3) && (noStars <= 5);
    }
    
    /**
     *  @effects
     *      return Hotel:<id,name,address,noRooms,price,noStars>
     */
    @Override
    public String toString() {
        return "Hotel:[\"id=" + id 
                + "\",\" name=" + name 
                + "\",\" address=" + address 
                + "\",\" no-Rooms=" + noRooms 
                + "\",\" price=" + price
                + "\",\" no-Stars=" + noStars
                +"\"]";
    }
}