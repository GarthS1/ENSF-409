import java.io.*;
import java.util.*;

/**
 * Class which loads the file information for the inventory system
 * @author Garth
 *
 */
public class FileManager {
	private SupplierList suppliers;
	/**
	 * Loads the file for items
	 * I separated the load function for items and suppliers as the File IO will be different for each
	 * and each will need to read into different objects making a generic load() impractical 
	 * @throws FileNotFoundException when file not found
	 */
	public Inventory loadItems(String fileName) throws FileNotFoundException{
		Inventory items = new Inventory();
		try {
			FileReader fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			while((line = br.readLine()) != null) {
				String[] temp = line.split(";");
				int supplierId = Integer.parseInt(temp[4]);
				
				Supplier theSupplier = findSupplier(supplierId);
				if(theSupplier != null) {
					Item myItem = new Item(Integer.parseInt(temp[0]), temp[1], Integer.parseInt(temp[2]),
							Float.parseFloat(temp[3]), theSupplier);
					items.addItem(myItem);
					theSupplier.getItemList().add(myItem);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return items;
	}
	
	private Supplier findSupplier(int supplierId) {
		Supplier theSupplier = null;
		for(Supplier s : suppliers) {
			if(s.getSupId() == supplierId) {
				theSupplier = s; 
				break;
			}
		}
		return theSupplier;
	}
	/**
	 * Loads the file for suppliers
	 */
	public ArrayList<Supplier> loadSuppliers(String fileName) {
		ArrayList<Supplier> suppliers = new ArrayList<Supplier>();	
		File suppliersTxt = new File(fileName);
		return suppliers;
	}
}
