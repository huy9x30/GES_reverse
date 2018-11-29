import utils.DomainConstraint;

/**
 * @author Hydyrow Bayram
 *
 * @overview
 *  This class represent a Hostel object
 *
 * @attributes
 *  int         id
 *  String      name
 *  String      address
 *  int         noRooms
 *  float       price
 *
 * @object
 *  A typical object Hostel is <id, name, address, noRooms, price>
 *
 * @abstract_properties
 *  mutable(id) = false /\ optional(id) = false /\ min(id) = 1 /\
 *  mutable(name) = true /\ optional(name) = false /\ length(name) = 70 /\
 *  mutable(address) = true /\ optional(address) = false /\ length(address) = 150 /\
 *  mutable(noRooms) = true /\ optional(noRooms) = false /\ min(noRooms) = 3 /\ max(noRooms) = 14
 *  mutable(price) = true /\ optional(price) = false /\ min(price) = 1
 *
 */
public class Hostel implements Comparable<Hostel> {
    @DomainConstraint(type = "int", mutable = false, optional = false, min = 1)
    protected int id;
    @DomainConstraint(type = "String", optional = false, length = 70)
    protected String name;
    @DomainConstraint(type = "String", optional = false, length = 150)
    protected String address;
    @DomainConstraint(type = "int", optional = false, min = 3, max = 14)
    protected int noRooms;
    @DomainConstraint(type = "float", optional = false, min = 1)
    protected float price;

    /**
     * @effects
     *  initialize an empty object Hostel
     */
    public Hostel(){

    }

    /**
     *  @effects
     *   initialize this as object Hostel:<id, name, address, noRooms, price>,
     *      where id = autoId
     */
    public Hostel(int id, String name, String address, int noRooms, float price) throws IllegalArgumentException {
        if(validate(id, name, address, noRooms, price)) {
            this.id = id;
            this.name = name;
            this.address = address;
            this.noRooms = noRooms;
            this.price = price;
        } else {
            throw new IllegalArgumentException("Hostel constructor: illegal argument");
        }
    }

    /**
     *  @effects
     *      return id
     */
    public int getId() {
        return id;
    }
    
     /**
     *  @effects
     *      set this.id = id
     */
    public void setId(int id) {
        if (validateId(id))
            this.id = id;
    }

    /**
     *  @effects
     *      return name
     */
    public String getName() {
        return name;
    }

    /**
     *  @effects
     *      set this.name = name
     */
    public void setName(String name) {
        if (validateName(name))
            this.name = name;
    }

    /**
     *  @effects
     *      return address
     */
    public String getAddress() {
        return address;
    }

    /**
     *  @effects
     *      set this.address = address
     */
    public void setAddress(String address) {
        if (validateAddress(address))
            this.address = address;
    }

    /**
     *  @effects
     *      return noRooms
     */
    public int getNoRooms() {
        return noRooms;
    }

    /**
     *  @effects
     *      set this.noRooms = noRooms
     */
    public void setNoRooms(int noRooms) {
        if (validateNoRooms(noRooms))
            this.noRooms = noRooms;
    }

    /**
     *  @effects
     *      return price
     */
    public float getPrice() {
        return price;
    }

    /**
     *  @effects
     *      set this.price = price
     */
    public void setPrice(float price) {
        if (validatePrice(price))
            this.price = price;
    }

    /**
     *  @effects
     *      if name is valid
     *          return true
     *      else
     *          return false
     */
    public boolean validateName(String name) {
        return (name != null) && (name.length() <= 70);
    }

    /**
     *  @effects
     *      if address is valid
     *          return true
     *      else
     *          return false
     */
    public boolean validateAddress (String address) {
        return (address != null) && (address.length() <= 150);
    }

    /**
     *  @effects
     *      if noRooms is valid
     *          return true
     *      else
     *          return false
     */
    public boolean validateNoRooms(int noRooms) {
       return (noRooms >= 3) && (noRooms <= 14);
    }

    /**
     *  @effects
     *      if price is valid
     *          return true
     *      else
     *          return false
     */
    public boolean validatePrice(float price) {
        return price >= 1;
    }
    
     /**
     *  @effects
     *      if price is valid
     *          return true
     *      else
     *          return false
     */
    public boolean validateId(int id) {
        return id >= 1;
    }

    /**
     *  @effects
     *      if name is valid, address is valid, noRooms is valid, and price is valid
     *          return true
     *      else
     *          return false
     *
     */
    public boolean validate(int id, String name, String address, int noRooms, float price) {
        return validateId(id) && validateName(name) && validateAddress(address) && validateNoRooms(noRooms) && validatePrice(price);
    }

    /**
     *  @effects
     *      return Hostel:<id,name,address,noRooms,price>
     */
    @Override
    public String toString() {
        return "Hostel:[\"id=" + id 
                + "\",\" name=" + name 
                + "\",\" address=" + address 
                + "\",\" no-Rooms=" + noRooms 
                + "\",\" price=" + price 
                +"\"]";
    }

    public int compareTo(Hostel hostel) {
        if (this.price > hostel.price) return 1;
        if (this.price < hostel.price) return -1;
        else                           return 0;
    }
}
