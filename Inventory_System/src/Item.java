/**
 * Class that stores tools and the related functions
 * @author Garth Slaney
 *
 */
public class Item {
	/**
	 *  Unique identification number associated with each Item
	 */
	private int toolId;
	/**
	 *  Description or name of the tool  
	 */
	private String name;
	/**
	 *  Quantity of the tool in stock
	 */
	private int stock;
	/** 
	 *  Price of the tool 
	 */
	private float price;
	/**
	 *  Supplier number which supplies the tool 
	 */
	private int supplierId;
	/** 
	 * Supplier which supplies the tool 
	 */
	private Supplier itemSupplier;
	/**
	 * Constructor for Item
	 * @param toolId Id to be set too  
	 * @param name Name of the item
	 * @param stock Amount of item in stock
	 * @param price Price of item
	 * @param itemSupplier Supplier of the item
	 */
	public Item(int toolId, String name, int stock, float price, Supplier itemSupplier) {
		setToolId(toolId);
		setName(name);
		setStock(stock);
		setPrice(price);
		setItemSupplier(itemSupplier);
	}
	/**
	 * Returns the unique number associated with the tool
	 * @return Tool Id
	 */
	public int getToolId() {
		return toolId;
	}
	/**
	 * Sets the tool id 
	 * @param toolId tool id to be set to
	 */
	public void setToolId(int toolId) {
		this.toolId = toolId;
	}
	/** 
	 * Returns the Supplier of the tool 
	 */
	public Supplier getItemSupplier() {
		return itemSupplier;
	}
	/**
	 * Set the Supplier of the tool 
	 * @param itemSupplier Supplier to be set to
	 */
	public void setItemSupplier(Supplier itemSupplier) {
		this.itemSupplier = itemSupplier;
	}
	/**
	 * Returns the unique number associated with the supplier 
	 * @return supplierId Id associated with supplier 
	 */
	public int getSupplierId() {
		return supplierId;
	}
	/**
	 * Sets the supplier Id
	 * @param supplierId supplier Id assocaited with tool 
	 */
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * Shows the price of the tool
	 * @return price of the tool 
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * Changes the price of the tool 
	 * @param price to be set to
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * Shows how many tools are left
	 * @return number of tools left
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * Changes the amount of items left in stock
	 * @param stock items left in stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * Shows the name of the item
	 * @return name of item
	 */
	public String getName() {
		return name;
	}
	/**
	 * Changes the name of the item 
	 * @param name of the item to be set to 
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
