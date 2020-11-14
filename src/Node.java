/**
 * 
 * @author coreyclark
 * This Class implements a node object for a BST object.
 */
public class Node {

	Node left, right;
	int data;
	String name;

	/**
	 * This constructs an IP address node and it takes a data value and a name, 
	 * and it sets two additional node object pointers to null (left and right).
	 * @param data
	 * @param name
	 */
	public Node(int data, String name) {
		this.data = data;
		this.name = name;
		left = null;
		right = null;
	}
}
