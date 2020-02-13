import java.util.ArrayList;

/** 
 * Class which models the supplier which the shop uses
 * @author Garth Slaney
 */
public class Supplier {
	/**
	 * Unique Id associated with the supplier
	 */
	private int supplierId;
	/**
	 * Company's name 
	 */
	private String name;
	/**
	 * Location of the company stored
	 */
	private String address;
	/**
	 * Person who is the sale's contact at the company
	 */
	private String salesContact;
	/** 
	 * List of all items that the supplier supplies the company 
	 */
	private ArrayList<Item> items;
	/**
	 * Constructor for supplier 
	 * @param supplierId The supplier Id to be set to
	 * @param name The name to be set to
	 * @param address The address to be set to
	 * @param salesContact The sales contact to be set to 
	 */
	public Supplier(int supplierId, String name, String address, String salesContact) {
		setSupplierId(supplierId);
		setName(name);
		setAddress(address);
		setSalesContact(salesContact);
		items = new ArrayList<Item>();
	}
	/**
	 * Get the items list
	 * @return ArrayList of items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}
	/**
	 * Sets an ArrayList to our items
	 * @param items ArrayList of items
	 */
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	/**
	 * Gets supplier Id
	 * @return The supplierId associated 
	 */
	public int getSupplierId() {
		return supplierId;
	}
	/**
	 * Sets the supplier Id 
	 * @param supplierId Supplier Id to be set to
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * Gets the name of the supplier
	 * @return name of supplier
	 */
	public String getName() {
		return name;
	}
	/**
	 * Changes the name of the supplier
	 * @param name Name to be set to 
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Gets the address of the company
	 * @return The address of the company
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Changes the address of the company 
	 * @param address The address of the company to be changed to 
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * Gets the sales contact of the company
	 * @return The sales contact of the company
	 */
	public String getSalesContact() {
		return salesContact;
	}
	/**
	 * Changes the sales contact of the company 
	 * @param salesContact The sales contact to be set to 
	 */
	public void setSalesContact(String salesContact) {
		this.salesContact = salesContact;
	}

}
