import java.util.ArrayList;

/** 
 * Class which models the supplier which the shop uses
 * @author Garth
 *
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
}
