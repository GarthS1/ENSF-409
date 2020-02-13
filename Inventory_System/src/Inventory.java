import java.util.ArrayList;

/**
 * Keeps track of all the items and allows for items to be ordered
 * @author Garth Slaney
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
	private Order myOrder;
	/**
	 *  Constructor to initialize array of items
	 *  @param Items to be set to 
	 */
	public Inventory(ArrayList<Item> items) {
		setItems(items);
		myOrder = new Order();	
	}
	/**
	 * Decrease the item and see if an order needs to be placed 
	 * @param s Item name 
	 */
	public void manageItem(String s) {
		Item manage = null;
		for(int i = 0; i <  items.size(); i++) {
			if(s.equalsIgnoreCase(items.get(i).getName())) {
				manage = items.get(i);
				break;
			}
		}
		if(manage != null) {
			manage.decreaseItem();
			if(manage.needToOrder())
				myOrder.placeOrder(manage);
		}
		else
			System.out.println("No item found");
	}
	/**
	 * Gets the items list
	 * @return Items list
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	/**
	 * Sets the item list
	 * @param items The item list 
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	/**
	 * Makes a string for printing.
	 */
	@Override
	public String toString() {
		String s = "The items in the Inventory are: \n";
		for(int i = 0; i < items.size(); i++) {
			s += items.get(i);
		}
		s += "\n";
		return s;
	}
	/**
	 * Search for an item by it's name
	 * @param s The name of the item
	 * @return Return error if can't find display information if found 
	 */
	public String searchName(String s) {
		String ret = "No item found.\n";
		for(int i = 0; i <  items.size(); i++) {
			if(s.equalsIgnoreCase(items.get(i).getName())) {
				ret = items.get(i).toString();
				break;
			}
		}
		return ret;
	}
	/**
	 * Search for an item by ID
	 * @param id The ID of the item
	 * @return Return String of Item 
	 */
	public String searchID(int id) {
		String ret = "No item found. \n";
		for(int i = 0; i < items.size(); i++) {
			if(id == items.get(i).getToolId()) {
				ret = items.get(i).toString();
				break;
			}
		}
		return ret;
	}
	/** 
	 * Calls the print order function from order 
	 */
	public void printOrder() {
		myOrder.print();	
	}
}
