package entregable;

public class Node {
	
	private Integer value;
	private Node left;
	private Node right;
	
	public Node(Integer value) {
		super();
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public Node getRight() {
		return right;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public void setRight(Node right) {
		this.right = right;
	}
	
	public boolean isLeaf() {
		return ((this.getLeft() == null) && this.getRight() == null);
	}
	
	public boolean hasLeftAndRight() {
		return ((this.getLeft() != null) && (this.getRight() != null));
	}
	
	public boolean onlyHasLeft() {
		return ((this.getLeft() != null) && (this.getRight() == null));
	}
	
	public boolean onlyHasRight() {
		return ((this.getLeft() == null) && (this.getRight() != null));
	}
	
}
