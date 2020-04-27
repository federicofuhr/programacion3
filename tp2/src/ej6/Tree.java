package ej6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Tree {
	private Node root;
	private int height;
	private Integer maxElem;
	private ArrayList<Node> deeperElements;
	
	public Tree() {
		this.root = null;
		this.height = 0;
		this.maxElem = 0;
		this.deeperElements = new ArrayList<Node>();
	}
	
	public Integer getRoot() {
		return (this.root).getValue();
	}
	
	public int getHeight() {
		return (this.height);
	}
	
	public boolean isEmpty() {
		return (this.root == null);
	}
	
	public void insert(int value) {
		if (this.root == null) {
			this.root = new Node(value);
			this.maxElem = value;
			this.deeperElements.add(this.root);
		}
		else {
			int height = 0;
			
			this.insert(this.root, null, value, height + 1);
		}
	}
	
	private void insert(Node actual, Node father, int value, int height) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				Node temp = new Node(value, actual);
				actual.setLeft(temp);
				temp.setFather(actual);
				if (height > this.height) {
					this.height = height;
					this.deeperElements.clear();
					this.deeperElements.add(temp);
				} else if (height == this.height) {
					this.deeperElements.add(temp);
				}
			} else {
				insert(actual.getLeft(), actual, value, height + 1);
			}
		} else {
			if (actual.getRight() == null) { 
				Node temp = new Node(value, actual);
				actual.setRight(temp);
				temp.setFather(actual);
				if (height > this.height) {
					this.height = height;
					this.deeperElements.clear();
					this.deeperElements.add(temp);
				} else if (height == this.height) {
					this.deeperElements.add(temp);
				}
				if (value > this.getMaxElem()) {
					this.maxElem = value;					
				}
			} else {
				insert(actual.getRight(), actual, value, height + 1);
			}
		}
	}
	
	private void printPreOrder(Node actual, ArrayList<Integer> list) {
		if (actual != null) {
			list.add(actual.getValue());
			printPreOrder(actual.getLeft(), list);
			printPreOrder(actual.getRight(), list);
		}
	}
	
	public void printPreOrder() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		printPreOrder(this.root, list);
		System.out.println("Pre order: " + list);
	}
	
	private void printInOrder(Node actual, ArrayList<Integer> list) {
		if (actual != null) {
			printInOrder(actual.getLeft(), list);
			list.add(actual.getValue());
			printInOrder(actual.getRight(), list);
		}
	}
	
	public void printInOrder() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		printInOrder(this.root, list);
		System.out.println("In Order: " + list);
	}
	
	private void printPosOrder(Node actual, ArrayList<Integer> list) {
		if (actual != null) {
			printPosOrder(actual.getLeft(), list);
			printPosOrder(actual.getRight(), list);
			list.add(actual.getValue());
		}
	}
	
	public void printPosOrder() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		printPosOrder(this.root, list);
		System.out.println("Pos Order: " + list);
	}
	
	private void getLeafs(Node actual, ArrayList<Integer> list) {
		if (actual != null) {
			getLeafs(actual.getLeft(), list);
			if (actual.isLeaf()) {
				list.add(actual.getValue());
			}
			getLeafs(actual.getRight(), list);
		}
	}
	
	public ArrayList<Integer> getFrontier() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		getLeafs(this.root, list);
		return list;
	}
	
	private boolean searchElem(Node actual, Integer i) {
		// TODO Auto-generated method stub
		if (actual != null) {
			if (actual.getValue() > i) {
				return searchElem(actual.getLeft(), i);			
			} else if (actual.getValue() < i) {
				return searchElem(actual.getRight(), i);
			} else if (actual.getValue() == i) {
				return true;
			}			
		} 
		return false;
	}
	
	public boolean hasElem(Integer i) {
		return searchElem(this.root, i);
	}
	
	public ArrayList<Integer> getElemAtLevel(Integer level) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int currentLevel = 0;
		getElemAtLevel(this.root, level, currentLevel, list);
		return list;
	}

	private void getElemAtLevel(Node actual, Integer level, int currentLevel, ArrayList<Integer> list) {
		// TODO Auto-generated method stub
		if (actual != null) {
			getElemAtLevel(actual.getLeft(), level, currentLevel + 1, list);
			if (level == currentLevel) {
				list.add(actual.getValue());
			}
			getElemAtLevel(actual.getRight(), level, currentLevel + 1, list);
		}
	}
	
	public Integer getMaxElem() {
		return (this.maxElem);
	}
	
	
	public void getLongestBranch(Node actual, ArrayList<Integer> list) {
		if (actual != null) {
			getLongestBranch(actual.getFather(), list);
			list.add(actual.getValue());
		}
	}
	
	public ArrayList<ArrayList<Integer>> getLongestBranch() {
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
		
		for (int i = 0; i < this.deeperElements.size(); i++) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			getLongestBranch(this.deeperElements.get(i), list);
			temp.add(list);
		}
		
		return temp;
	}
	
	
//	private boolean delete(Node actual, Integer value) {
//		// TODO Auto-generated method stub
//		if (actual.getValue() > value) {
//			if (actual.getLeft().getValue() != value) {
//				return delete(actual.getLeft(), value);
//			} else {
//				if (actual.getLeft().isLeaf()) {
//					actual.setLeft(null);
//					return true;
//				} else if (actual.getLeft().onlyHasLeft()) {
//					actual.setLeft(actual.getLeft());
//					return true;
//				} else if (actual.onlyHasRight()) {
//					actual.setLeft(actual.getRight());
//					return true;
//				} else {
//					return true;
//				}
//			}			
//		} else if (actual.getValue() < value) {
//			return delete(actual.getRight(), value);
//		} else if (actual.getValue() == value) {
//			
//		}
//		return false;
//	}
//	
//	public boolean delete(Integer value) {
//		if (this.hasElem(value)) {
//			return delete(this.root, value);
//		}
//		return false;
//	}
	
}
