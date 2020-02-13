	import java.io.*;
import java.util.*;

/**
 * Class which loads the file information for the inventory system
 * @author Garth
 *
 */
public class FileManager {
	/**
	 * Supplier list from file 
	 */
	ArrayList<Supplier> suppliers;
	/**
	 * Default constructor has no variables
	 */
	public FileManager () { }
	/**
	 * Loads the file for items
	 * I separated the load function for items and suppliers as the File IO will be different for each
	 * and each will need to read into different objects making a generic load() impractical 
	 * @return The item list from the file 
	 */
	public ArrayList<Item> loadItems(){
		
		ArrayList<Item> items = new ArrayList<Item>();
		
		try {
			FileReader fr = new FileReader("C:\\Users\\Garth\\Documents\\GitHub\\ENSF-409\\Inventory_System\\src\\items.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			while((line = br.readLine()) != null) {
				String[] temp = line.split(";");
				int supplierId = Integer.parseInt(temp[4]);
				
				Supplier theSupplier = findSupplier(supplierId);
				if(theSupplier != null) {
					Item myItem = new Item(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]),
							Double.parseDouble(temp[3]), theSupplier);
					items.add(myItem);
					theSupplier.getItems().add(myItem);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return items;
	}
	/**
	 * Searches for the correct supplier 
	 * @param supplierId The Id associated with the supplier 
	 * @return The supplier which supplies the item 
	 */
	private Supplier findSupplier(int supplierId) {
		Supplier theSupplier = null;
		for(Supplier s : suppliers) {
			if(s.getSupplierId() == supplierId) {
				theSupplier = s;  	 	
				break;
			}
		}
		return theSupplier;
	}
	/**
	 * Loads the file for suppliers
	 * @returns The supplier list from the file 
	 */
	public ArrayList<Supplier> loadSuppliers() {
		 suppliers = new ArrayList<Supplier>();	
		
		try {
			FileReader suppliersTxt = new FileReader("C:\\Users\\Garth\\Documents\\GitHub\\ENSF-409\\Inventory_System\\src\\suppliers.txt");
			BufferedReader br = new BufferedReader(suppliersTxt);
			
			String line = "";
			while((line = br.readLine()) != null) {
				String[] temp = line.split(";");
				suppliers.add(new Supplier(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3]));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return suppliers;
	}
}
