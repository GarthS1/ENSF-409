import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

/**
 * Asks the user for the name of the file they would like to read and creates a binary search tree using the
 * given text file.
 * @author jiho
 *
 */
public class FileInput {
	private String fileName;
	private BinSearchTree tree;
	
	public FileInput(){
		fileName = JOptionPane.showInputDialog("Enter the file name:");
		tree = new BinSearchTree();
	}
	
	/**
	 * Takes the file and puts all the data into the binary search tree.
	 */
	public void saveData() {
		File inputFile = new File(fileName);
		Scanner scan;
		try {
			scan = new Scanner(inputFile);
			while(scan.hasNext()) {
				tree.insert(scan.next(), scan.next(), scan.next(), scan.next() );
			}
			scan.close();
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Invalid File.", "Invalid File", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public BinSearchTree getTree() {
		return tree;
	}
}
