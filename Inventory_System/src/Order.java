import java.io.*;

/**
 * Object which orders parts
 * @author Garth
 *
 */
public class Order {
	/**
	 * Orderline to be stored 
	 */
	private Orderline line;
	/**
	 * Stream to file 
	 */
	private File myFile;
	/**
	 * Default constructor for Order
	 */
	public Order() {
		line = new Orderline();
		myFile = null;
	}
	/**
	 * Places and order by calling orderline
	 * @param item Item to be ordered 
	 */ 
	public void placeOrder(Item item) {
		if(myFile == null ) {
			createFile();
		}
		line.setOrderItem(item);
		line.generateOrder(myFile);
	}
	/**
	 * Print the order from the day 
	 */
	public void print() {
		if(myFile == null) {
			System.out.print("No orders placed yet\n");
			return;
		}
		try {
	    BufferedReader reader = new BufferedReader(new FileReader(myFile));
	    String s;
			s = reader.readLine();
	    while(s != null) {
	    	System.out.print(s + "\n");
	    	s = reader.readLine();
	    }
	    reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Make a new file 
	 */
	public void createFile() {
    try {
    	myFile = new File("C:\\Users\\Garth\\Documents\\GitHub\\ENSF-409\\Inventory_System\\src\\orders.txt");
		  FileWriter myWriter = new FileWriter(myFile);
			myWriter.write("*********************************************************************************************************\n");
			myWriter.write("ORDER ID:" + "            " + (int)((Math.random() * ((99999 - 00000) + 1)) + 00000) + "\n");
			myWriter.write("Date Ordered:" + "        " + java.time.LocalDate.now() + "\n\n");
			myWriter.close();
		} catch (IOException e) {
				e.printStackTrace();
		}
	}
}
