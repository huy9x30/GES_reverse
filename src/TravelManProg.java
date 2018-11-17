import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.TextIO;

/**
 * @overview
 *   Represents a worksheet program that enables a user to create hostel objects,
 *   display a report about them, and to search for hostels using name or address.
 *
 * @attributes
 *   hostels    SortedSet<Hostel>
 *
 * @abstract_properties
 *   mutable(hostels)=true /\ optional(hostels)=false
 * @author congnv
 */
public class TravelManProg {
    @DomainConstraint(type="Collection",mutable=true,optional=false)
    private SortedSet hostels;

    /**
     * @effects
     *   initialize a TravelManProg
     *   ask the users to create Hostel objects and display a report
     *   show options menu to user for next operations
     */
    public static void main(String[] args) {
        // initialise a TravelManProg
        TextIO.putln("Initialising program...");
        TravelManProg program = new TravelManProg();

        try {
            // create some hostel objects
            program.addHostels();

            if (!program.isEmpty()) {
                // display options menu to user
                program.showMenu();
            }

            // end
            TextIO.putln("\nGood bye.");
        } catch (NotPossibleException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    /**************************************************************
     * ABOVE THIS LINE ARE GIVEN CODE. STUDENTS SHOULD READ THE SPECS
     * BUT MUST NOT CHANGE ANYTHING!
     * ------------------------------------------------------------
     * BELOW THIS LINE ARE CODE THAT MUST BE COMPLETED BY STUDENTS.
     **************************************************************/

    /**
     * @effects
     *   initialize this to include an empty set of hostels
     */
    public TravelManProg() {
        // TODO
        hostels = new SortedSet();
    }

    /**
     * @modifies this.hostels
     * @effects
     *  Invoke promptForHostel create some hostel objects until user choose cancel to stop
     *  Add these objects to this.hostels
     *  Invoke displayReport to display a report about them.
     * @see #promptForHostel()
     * @see #displayReport(SortedSet)
     */
    public void addHostels() throws NotPossibleException {
        // TODO:
        this.promptForHostel();
    }

    /**
     * @effects <pre>
     *   prompt the user whether to enter details for (1) Hostel, (2) Hotel or (3) cancel,
     *
     *   then prompt the user for the data values needed to create an object
     *   for the selected type.
     *   create an object of selected type using the inputed data values and return.
     *
     *   if user cancel adding hostel
     *    return null
     *
     *   if failed to create object
     *    throws NotPossibleException
     * </pre>
     */
    private Hostel promptForHostel() throws  NotPossibleException {
        // TODO:
        // stub
        System.out.println(
                "=============================\n" +
                "| Create new Hostel/ Hotel |\n" +
                "|---------------------------|\n" +
                "| (1) Hostel |\n" +
                "| (2) Hotel |\n" +
                "| - Press any key to Cancel |\n" +
                "=============================");
        String option = TextIO.getln();
        switch(option) {
            case "1": this.createHostel(); break;
            case "2": this.createHotel(); break;
            default: System.exit(0);
        }
        return null;
    }
    
    private void createHostel() {
        Hostel h = new Hostel();
        
        this.inputId(h);
        this.inputName(h);
        this.inputAddress(h);
        this.inputNoRooms(h);
        this.inputPrice(h);
        
        hostels.add(h);
        System.out.println("Created: " + h.toString());
    }
    
    private void createHotel() {
        Hotel h = new Hotel();
        
        this.inputId(h);
        this.inputName(h);
        this.inputAddress(h);
        this.inputNoRooms(h);
        this.inputPrice(h);
        this.inputNoStar(h);
        
        hostels.add(h);
        System.out.println("Created: " + h.toString());
    }
    
    private void inputId(Hostel h) {
        System.out.println("Enter id: ");
        int id = TextIO.getInt();
        TextIO.getln();
        while (!h.validateId(id)) {
            System.out.println();
            System.out.println("  ***Error: id has to be integer, greater than zero and unique");
            System.out.println();
            System.out.println("Please re-enter:");
            id = TextIO.getInt();
        TextIO.getln();
        }
        h.setId(id);
    }
    
    private void inputName(Hostel h) {
        System.out.println("Enter name: ");
        String name = TextIO.getln();
        while (!h.validateName(name)) {
            System.out.println();
            System.out.println("  ***Error: name has to be not null and has maximum 70 characters");
            System.out.println();
            System.out.println("Re-enter:");
            name = TextIO.getln();
        }
        h.setName(name);
    }
    
    private void inputAddress(Hostel h) {
        System.out.println("Enter address: ");
        String address = TextIO.getln();
        while (!h.validateAddress(address)) {
            System.out.println();
            System.out.println("  ***Error: address has to be not null and has maximum 150 characters");
            System.out.println();
            System.out.println("Please re-enter:");
            address = TextIO.getln();
        }
        h.setAddress(address);
    }
    
    private void inputNoRooms(Hostel h) {
        System.out.println("Enter number of rooms: ");
        int rooms = TextIO.getInt();
        TextIO.getln();
        while (!h.validateNoRooms(rooms)){ 
            System.out.println();
            System.out.println("  ***Error: number of rooms has to from 3 to 14 rooms");
            System.out.println();
            System.out.println("Please re-enter:");
            rooms = TextIO.getInt();
            TextIO.getln();
        }
        h.setNoRooms(rooms);
    }
    
    private void inputPrice(Hostel h) {
        System.out.println("Enter price / room: ");
        float price = TextIO.getFloat();
        TextIO.getln();
        while (!h.validatePrice(price)) {
            System.out.println();
            System.out.println("  ***Error: price / room has to greater than zero.");
            System.out.println();
            System.out.println("Please re-enter:");
            price = TextIO.getFloat();
            TextIO.getln();
        }
        h.setPrice(price);
    }
    
    private void inputNoStar(Hotel h) {
        System.out.println("Enter hotel's number of stars: ");
        float stars = TextIO.getFloat();
        TextIO.getln();
        while (!h.validateNoStars(stars)) {
            System.out.println();
            System.out.println("  ***Error: number of stars has to from 3 to 5 rooms.");
            System.out.println();
            System.out.println("Please re-enter:");
            stars = TextIO.getFloat();
            TextIO.getln();
        }
        h.setNoStars(stars);
    }

    /**
     * display a list of hostels (one per line) in s
     * @modifies  System.out
     * @effects
     *    if s is empty
     *      prints "(empty)"
     *    else
     *      prints each object in  (one per line) to the standard output
     */
    public void displayReport(SortedSet s) {
        // TODO:
        if (s.isEmpty()) {
            System.out.println("(empty)");
        } else {
            System.out.println(s.toString());
        }
    }

    /**
     * @effects
     *  if hostels is empty
     *    return true
     *  else
     *    return false
     */
    public boolean isEmpty() {
        // TODO:
        // stub
        return hostels.isEmpty();
    }

    /**
     * @effects <pre>
     *    display options menu to user including,
     *    (1) show all hostels, (2) search for hostels by name or location, (3) add hostels, or (4) quit program
     *    prompt the user to choose functions,
     *    invoke the corresponding selected function
     *
     *    repeat until user choose to quit program
     *    </pre>
     */
    public void showMenu() {
        // TODO:
        System.out.println(
                "===============================================\n" +
                "| TravelMan Program |\n" +
                "|---------------------------------------------|\n" +
                "| (1) Show all hostels |\n" +
                "| (2) Search for hostels by name or location |\n" +
                "| (3) Add hostels |\n" +
                "| - Press any key to Quit |\n" +
                "===============================================");
        String option = TextIO.getln();
        switch(option) {
            case "1": this.displayReport(hostels); break;
            case "2": System.out.println("Searching..."); break;
            case "3": this.addHostels(); break;
            default: System.exit(0);
        }
    }

    /**
     * @effects <pre>
     *    prompt for user to input keywords for searching
     *
     *    if keywords is null or empty
     *        throws NotPossibleException
     *    else
     *        search for objects whose "name or location" contains the keywords
     *        and return a SortedSet object containing the result
     *
     * @see java.lang.String.contains()
     * @see #displayReport(SortedSet)
     * </pre>
     */
    public SortedSet searchHostels() throws NotPossibleException {
        // TODO:
        // stub
        return null;
    }

    /**
     * @effects
     *   if objects is empty
     *     return "(empty)"
     *   else
     *     return a string containing each object in this.hostels (one per line)
     */
    @Override
    public String toString() {
        // TODO:
        // stub
        return null;
    }
}

