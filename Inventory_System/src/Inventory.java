import java.util.ArrayList;

/**
 * Keeps track of all the items and allows for items to be ordered
 * @author Garth
 *
 */
public class Inventory {
	/**
	 * List of all items
	 */
	private ArrayList<Item> items;
	/** 
	 * Object which orders part
	 */
	private Order orderPart;
	/**
	 * Default constructor to initialize array of items and order object
	 */
	public Inventory() {
		items = new ArrayList<Item>();
		orderPart = new Order();
	}
	/**
	 * Adds an item to the list 
	 * @param part item to be added to the ArrayList 
	 */
	public void addItem(Item part) {
		items.add(part);
	}
}
