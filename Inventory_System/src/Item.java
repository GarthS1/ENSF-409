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
	private double price;
	/** 
	 * Supplier which supplies the tool 
	 */
	private Supplier itemSupplier;
	/**
	 * Boolean which tracks if item has yet to be ordered
	 */
	private boolean ordered;
	/**
	 * Constructor for Item
	 * @param toolId Id to be set too  
	 * @param name Name of the item
	 * @param stock Amount of item in stock
	 * @param price Price of item
	 * @param itemSupplier Supplier of the item
	 */
	public Item(int toolId, String name, int stock, double price, Supplier itemSupplier) {
		setToolId(toolId);
		setName(name);
		setStock(stock);
		setPrice(price);
		setItemSupplier(itemSupplier);
		ordered = false;
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
	 * Shows the price of the tool
	 * @return price of the tool 
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * Changes the price of the tool 
	 * @param price to be set to
	 */
	public void setPrice(double price) {
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
	/**
	 * Overrides the toString function to print relevant information 
	 */
	@Override
	public String toString() {
		String s = "ID: " + getToolId() + " Name: " + getName() + " Stock: " + getStock() + "  Price $"  + getPrice() + "\n";
		return s;
	}
	/**
	 * Decrease the item stock by 1
	 */
	public void decreaseItem() {
		stock--;
	}
	/**
	 * Checks the quantity of the item and if the item already has an order
	 * @return If the item needs to be ordered 
	 */
	public boolean needToOrder() {
		boolean order = false;
		if(getStock() < 40 && ordered == false) {
			order = true;
			ordered = true;
		}
		return order;
	}
	
}
