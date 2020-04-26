package ej6;

public class Node {
	
	private Integer value;
	private Node left;
	private Node right;
	private Node father;
	
	public Node(Integer value) {
		super();
		this.value = value;
		this.left = null;
		this.right = null;
		this.father = null;
	}
	
	public Node(Integer value, Node father) {
		super();
		this.value = value;
		this.father = father;
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

	public Node getFather() {
		return father;
	}

	public void setFather(Node father) {
		this.father = father;
	}
	
	public boolean isLeaf() {
		return ((this.getLeft() == null) && this.getRight() == null);
	}
	
	public boolean onlyHasLeft() {
		return ((this.getLeft() != null) && (this.getRight() == null));
	}
	
	public boolean onlyHasRight() {
		return ((this.getLeft() == null) && (this.getRight() != null));
	}
	
}
