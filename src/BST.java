/**
 * 
 * @author coreyclark
 * This class implements a BST manager to manage all IP address nodes.
 *
 */
public class BST {

	Node root;
	static int count = 0;
	
	/**
	 * This builds an IP address node by taking a root node value, a data value, a name 
	 * and it inserts it into this BST structure.
	 * @param root is the first node in this BST structure.
	 * @param value is the data value that this BST is organized by. 
	 * It is also the last digits of each nodes IP address in this BST.
	 * @param name is associated with a specific node's IP address in this BST.
	 * @return A node value.
	 */
	public Node insert(Node root, int value, String name) {
		if (root == null) {
			return new Node(value, name);
		}
		if (value < root.data) {
			root.left = insert(root.left, value, name);
		} else if (value > root.data) {
			root.right = insert(root.right, value, name);
		}
		return root;
	}

	/**
	 * This assigns this instance variable root and accesses the Insert method to start building this BST.
	 * @param value is the data value that this BST is organized by.
	 * @param name is the associated with a specific node's IP address in this BST.
	 */
	public void add(int value, String name) {
		root = insert(root, value, name);
	}

	/**
	 * This prints to the console all the IP address nodes In Order. 
	 * @param node is a specific node value in this BST.
	 */
	public void print(Node node) {
		if (node != null) {
			print(node.left);
			System.out.print(" \n" + node.data + " " + node.name);
			print(node.right);
		}
	}

	/**
	 * This is an overloaded print method.
	 * It takes this BST root value and prints this BST In Order. 
	 */
	public void print() {
		print(root);
	}

	/**
	 * This takes a node value and a number,
	 * and it searches this BST for that specific node that has this value.
	 * @param node is the this root.
	 * @param value is the value to be searched in this BST.
	 * @return a Node value.
	 */
	public Node searchNum(Node node, int value) {

		if (node == null)
			return null;
		if (node.data == value) {
			return node;
		} else {
			Node left = searchNum(node.left, value);
			Node right = searchNum(node.right, value);
			if (left != null) {
				return left;
			} else {
				return right;
			}
		}
	}

	/**
	 * This takes a node value and a name,
	 * and it searches this BST for that specific node that has this name.
	 * @param node is this root.
	 * @param name the value to be searched in this BST.
	 * @return a Node value.
	 */
	public Node searchName(Node node, String name) {

		if (node == null)
			return null;
		if (node.name.equals(name)) {
			return node;
		} else {
			Node left = searchName(node.left, name);
			Node right = searchName(node.right, name);
			if (left != null) {
				return left;
			} else {
				return right;
			}
		}
	}

	/**
	 * This traverses through this BST structure, and it counts all IP address nodes.
	 * @param node is this root.
	 * @return the amount of IP address nodes in this BST.
	 */
	public int countNodes(Node node) {
		if (node != null) {
			countNodes(node.left);
			count++;
			countNodes(node.right);

		}
		return count;
	}
}


// (Do not sort before hand and just insert as is from file using insert method.
// and do not accidentally create a avl or red black tree. this will be
// unbalanced.)
// Size
// Search
// Print
// Remove
// isEmpty

// Iteration
// or Recursion

// IN ORDER printing
// (Least to Greatest)
// NATURAL ORDER printing
// (The visual of the tree)
