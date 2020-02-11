import java.io.FileNotFoundException;

/** 
 * The back end of the program that controls the Inventory and all the data loaded from the file
 * @author Garth
 *
 */
public class Shop {
	/**
	 * List of all the suppliers
	 */
	private SupplierList suppliers;
	/**
	 * List of all the items
	 */
	private Inventory items;
	/**
	 * loads the file and initializes the items and suppliers
	 * @throws FileNotFoundException when file not found 
	 */
	public void loadFile() throws FileNotFoundException {
		FileManager file = new FileManager();
		items = file.loadItems("C:\\Users\\Garth\\Documents\\GitHub\\ENSF-409\\Inventory_System\\src\\items.txt");
	}
}
