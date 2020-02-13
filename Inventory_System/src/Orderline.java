import java.io.*;

/**
 * Object which generates the order line 
 * @author Garth
 *
 */
public class Orderline {
	/**
	 * Item which is to ordered
	 */
	private Item orderItem;
	/**
	 * Default constructor 
	 */
	Orderline() { }
	/**
	 * Get the order item
	 * @return Item for the order line 
	 */
	public Item getOrderItem() {
		return orderItem;
	}
	/**
	 * Sets the order Item
	 * @param orderItem Item to be set too 
	 */
	public void setOrderItem(Item orderItem) {
		this.orderItem = orderItem;
	}
	/**
	 * Generate the order line for the item
	 */
	public void generateOrder(File myFile) {
		try {
			FileWriter myWriter = new FileWriter(myFile, true);
			myWriter.append("Item descripation:" + "   " + orderItem.getName() + "\n");
			myWriter.append("Amount ordered:" + "      " + (50 - orderItem.getStock()) + "\n");
			myWriter.append("Supplier:" + "            " + orderItem.getItemSupplier().getName() + "\n\n");
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
