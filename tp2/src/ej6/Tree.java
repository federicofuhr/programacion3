package ej6;

import java.util.ArrayList;

public class Tree {
	private Node root;
	private int height;
	
	public Tree() {
		this.root = null;
		this.height = 0;
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
		if (this.root == null)
			this.root = new Node(value);
		else {
			int height = 0;
			this.insert(this.root,value, height + 1);
		}
	}
	
	private void insert(Node actual, int value, int height) {
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				Node temp = new Node(value);
				actual.setLeft(temp);
				if (height > this.height)
					this.height = height;
			} else {
				insert(actual.getLeft(),value, height + 1);
			}
		} else {
			if (actual.getRight() == null) { 
				Node temp = new Node(value);
				actual.setRight(temp);
				if (height > this.height)
					this.height = height;
			} else {
				insert(actual.getRight(),value, height + 1);
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
			if ((actual.getLeft() == null) && (actual.getRight() == null)) {
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
}
