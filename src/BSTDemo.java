import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * The BSTDemo program utilizes two other classes (Node class and BST class) to
 * build a BST of IP addresses. It allows the user to search for an IP address,
 * print the addresses, and to display the number of IP address nodes.
 * 
 * @author coreyclark
 *
 */
public class BSTDemo {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		String dataFile = "/Users/coreyclark/Documents/CSIS 2420 PROJECTS/Week 9/src/csvgithub.txt";
		BufferedReader reader = new BufferedReader(new FileReader(dataFile));

		boolean exit = false;
		BST bst = new BST();

		do {
			System.out.println("\n\n Please enter a Option for the BST: "
					+ "\n 1 -- Build Users Tree \n 2 -- Find by IP Address \n 3 -- Find by Username "
					+ "\n 4 -- Report Number of Nodes \n 5 -- Print Entire Tree \n 6 -- Exit ");
			int option = input.nextInt();

			switch (option) {

			// Builds a BST out of the CSV file.
			case 1:
				String line = reader.readLine();
				while (line != null) {
					String[] arrOfStr = line.split(",");
					int nums = Integer.parseInt(arrOfStr[0]);
					String name = arrOfStr[1];
					bst.add(nums, name);
					line = reader.readLine();
				}
				exit = false;
				break;

			// Searches the BST for an IP address that corresponds to the IP address given.
			case 2:
				System.out.println("Please enter an IP address you would like to search for.");
				int search = input.nextInt();
				try {
					Node node = bst.searchNum(bst.root, search);
					System.out.print("\n Found: 10.0.0." + node.data);
					System.out.println(" " + node.name);
				} catch (Exception e) {
					System.out.println("IP 10.0.0." + search + " not found.");
				}
				exit = false;
				break;

			// Searches the BST for an IP address that corresponds to the name given.
			case 3:
				System.out.println("Please enter the name of the IP address you would like to search for.");
				String search2 = input.next();
				try {
					Node node2 = bst.searchName(bst.root, search2);
					System.out.print("\n Found: 10.0.0." + node2.data);
					System.out.println(" " + node2.name);
				} catch (Exception e) {
					System.out.println("User " + search2 + " not found.");
				}
				exit = false;
				break;

			// Gives the correct amount of IP address Nodes in the given BST.
			case 4:

				if (bst.root == null) {
					System.out.println("There is 0 IP address Nodes.");
				} else {
					int count = bst.countNodes(bst.root);
					System.out.println("There are " + count + " amount of IP address nodes in this BST.");
				}
				exit = false;
				break;

				// Prints out the entire BST InOrder.
			case 5:
				if (bst.root == null) {
					System.out.println("There are no IP address Nodes to print.");
				} else {
					bst.print();
				}
				exit = false;
				break;

				// Terminates the program.
			case 6:
				System.out.println("You have terminated the session.");
				exit = true;
				break;

			}
		} while (exit == false);

	}

}
