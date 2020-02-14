import java.util.*;

/**
 * Class which implements the front end of the program 
 * @author Garth Slaney
 *
 */
public class FrontEnd {
	/**
	 * The back-end which calls the functions need to complete menu tasks 
	 */
	private Shop theShop;
	/**
	 * Scanner to use for reading user input
	 */
	private Scanner scan;
	/**
	 * Default constructor for the front end 
	 */
	FrontEnd() {
		FileManager file = new FileManager() ;
		ArrayList<Supplier> suppliers = file.loadSuppliers();
		ArrayList<Item> items = file.loadItems();
		theShop = new Shop(new SupplierList(suppliers), new Inventory(items));
		scan = new Scanner(System.in);
	}
	/**
	 * The main function of the program to run 
	 * @param args String args to start the main function 
	 */
	public static void main(String args[]) {
		FrontEnd frontEnd = new FrontEnd();
		frontEnd.menu();
	}
	/**
	 * Runs the menu which the user selects the tasks
	 */
	public void menu() {
		boolean quit = false; // keeps track of quitting condition 
		
		while(true) {
			printMenu();
			int key = scan.nextInt(); 
			scan.nextLine();		
			switch(key) {
				case 1:
					listAllTools();
					break;
				case 2:
					searchToolName();
					break;
				case 3:
					searchToolId();
					break;
				case 4:
					checkItemQuantity();
					break;
				case 5:
					decreaseItem();
					break;
				case 6:
					printOrder();
					break;
				case 7:
					quit = true;
					break;
				default:
					System.out.println("Invalid input enetered. Please enter a different input.");
			}
			if(quit)
				break;
		}
	}
	/**
	 * Print the order from the day 
	 */
	private void printOrder() {
		theShop.getItems().printOrder();
	}
	/**
	 * Decrease the item by one to simulate a sale 
	 */
	private void decreaseItem() {
		System.out.println("Please enter the name of the item");
		String s = scan.nextLine();
		theShop.getItems().manageItem(s);
	}
	/**
	 * Check how much stock for an Item 
	 */
	private void checkItemQuantity() {
		searchToolName(); //returns quantity along with information
	}
	/**
	 * Search by ID to return Tool 
	 */
	private void searchToolId() {
		System.out.println("Please enter the ID of the item\n");
		int s = scan.nextInt();
		scan.nextLine();
		System.out.print(theShop.getItems().searchID(s));		
	}
	/**
	 * Search by name to return Tool 
	 */
	private void searchToolName() {
		System.out.println("Please enter the name of the item\n");
		String s = scan.nextLine();
		System.out.print(theShop.getItems().searchName(s));

	}
	/** 
	 * List all the tools that the shop sells 
	 */
	private void listAllTools() {
		System.out.print(theShop.getItems());	
	}
	/**
	 * Prints the menu for selecting what task the user wishes to do 
	 */
	private void printMenu() {
		System.out.print("1.    List all tools\n2.    Search for tool by toolName\n3.    Search for tool by toolID\n4.    Check item quantity\n5.    Decrease item quantity\n6.    Print today's order\n7.    Exit\n");
	}
}
