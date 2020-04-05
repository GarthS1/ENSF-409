import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
/**
 * The logic behind the interface
 * @author Garth Slaney, Jiho Kim, Eddie Kim
 *
 */
public class Logic {
	/**
	 * The binary search tree used
	 */
	private BinSearchTree theTree;
	/**
	 * Constructor which takes the text area to write to 
	 * @param t1
	 */
	public Logic() {
	}
	/**
	 * Uses file data to create a binary search tree
	 */
	public void createTreeFromFile() {
		FileInput input = new FileInput();
		input.saveData();
		theTree = input.getTree();
	}
	/**
	 * Displays the information stored in the binary tree 
	 */
	public void browse(JTextArea t1) {
		try {
			theTree.print_tree(theTree.root, t1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Tries to find the record in the tree based on the student's id number
	 */
	public void find() {
		String num = JOptionPane.showInputDialog("Please enter the student's id");
		Node n = theTree.find(theTree.root, num);
		String s = "Unable to find record";
		if(n != null) {
			s = n.toString();
		}
		JOptionPane.showMessageDialog(null,   s,   "Message",  JOptionPane.PLAIN_MESSAGE);
		
	}
	/**
	 * Insert a new node into the Binary Search Tree using user-input data
	 */
	public void insert() {
		NewNodeGUI g = new NewNodeGUI(theTree);
		
	}

}
