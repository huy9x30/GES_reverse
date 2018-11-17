import java.util.*;
import java.util.TreeSet;
import utils.NotPossibleException;

/**
 * 
 * @author Hydyrow Bayram
 */
public class SortedSet {
    private Vector<Comparable> elements;

    /**
     * @effects
     */
    public SortedSet() {
        elements = new Vector<>();
    }

    /**
     * @modifies <tt>this</tt>
     * @effects
     *      if element is already in this
     *          do nothing
     *      else
     *          add element to this
     */
    public void add(Comparable element) throws NotPossibleException{
        if (!this.contains(element)) {
            elements.add(element);
            TreeSet<Comparable> sorted = new TreeSet<Comparable>(new Comparator<Comparable>() {
                @Override
                public int compare(Comparable o1, Comparable o2) {
                    return o2.compareTo(o1);
                }
            });
            sorted.addAll(elements);
            elements = new Vector<>();
            elements.addAll(sorted);
        } else {
            throw new NotPossibleException("SortedSet.add: element exists");
        }
    }
    
    /**
     * @modifies <tt>this</tt>
     * @effects
     *      if element is not in this
     *          do nothing
     *      else
     *          remove element from this
     */
    public void remove(Comparable element) {
        if (!this.contains(element)) return;
        elements.remove(element);
    }

    /**
     * @effects <pre>
     *  if this contains element
     *    return true
     *  else
     *    return false
     */
    public boolean contains(Comparable element) {
        return elements.contains(element);
    }

    /**
     * @effects return the size of set.
     */
    public int size(){
        return elements.size();
    }

    /**
     * @effects
     *      if element size is 0
     *          return true
     *      else
     *          return false
     */
    public boolean isEmpty(){
        if(elements.size() == 0)
            return true;
        else
            return false;
    }
    
    @Override
    public String toString() {
        String str = "";
        for (Object a : elements) {
            str = str + a.toString() + "\n";
        }
        
        return str;
    }
    
    public Comparable elementAt(int index)throws NotPossibleException {
        if (index < elements.size()) {
            return elements.elementAt(index);
        } else { 
            throw new NotPossibleException("SortedSet.elementAt: index does not exist");
        }
    }
}