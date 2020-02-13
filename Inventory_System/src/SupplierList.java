import java.util.ArrayList;

/**
 * Stores all the suppliers and the relevant information about them
 * @author Garth Slaney
 *
 */
public class SupplierList {
	/**
	 * List of all the suppliers the company uses
	 */
	private ArrayList<Supplier> suppliers;
	/**
	 * Constructor for Supplier List 
	 * @param suppliers Supplier List to be set to 
	 */
	public SupplierList(ArrayList<Supplier> suppliers) {
		setSuppliers(suppliers);
	}
	/**
	 * Gets the supplier list
	 * @return Supplier List 
	 */
	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}
 /**
  * Sets the supplier list
  * @param suppliers Supplier list to be set to 
  */
	public void setSuppliers(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}
}
