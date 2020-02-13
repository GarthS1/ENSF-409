
/** 
 * The back end of the program that controls the Inventory and all the data loaded from the file
 * @author Garth Slaney
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
	 * Constructor for Shop 
	 * @param suppliers SupplierList to be set to 
	 * @param items Inventory to be set to 
	 */
	public Shop (SupplierList suppliers, Inventory items) {
		setSuppliers(suppliers);
		setItems(items);
	}
	/**
	 * Gets the SupplierList 
	 * @return The Supplier List in the shop 
	 */
	public SupplierList getSuppliers() {
		return suppliers;
	}
	/**
	 * Set the suppliers List 
	 * @param suppliers The Supplier List to be set to 
	 */
	public void setSuppliers(SupplierList suppliers) {
		this.suppliers = suppliers;
	}
	/**
	 * Gets the Inventory 
	 * @return The inventory Shop uses 
	 */
	public Inventory getItems() {
		return items;
	}
	/**
	 * Sets the items list
	 * @param items The Inventory to be set to 
	 */
	public void setItems(Inventory items) {
		this.items = items;
	}
}
