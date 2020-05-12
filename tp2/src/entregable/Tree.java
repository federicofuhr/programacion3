package entregable;

import java.util.ArrayList;

public class Tree {
		// ATRIBUTOS DE CLASE
	private Node root;
	private int height;
	
	public Tree() {
		// CONSTRUCTOR
		this.root = null;
		this.height = 0;
	}
	
	public Integer getRoot() {
		// ESTE METODO RETORNA EL ELEMENTO DE LA RAIZ
		// COMPLEJIDAD O(1)
		return (this.root).getValue();
	}
	
	public boolean isEmpty() {
		// ESTE METODO RESPONDE SI EL ARBOL ESTA VACIO O NO
		// AL CONSULTARLE EL ESTADO A LA RAIZ ES O(1)
		return (this.root == null);
	}
	
	public void insert(int value) {
		// ESTE METODO INSERTA UN ELEMENTO EN EL ARBOL
		// SU COMPLEJIDAD ES O(LOG(N)) POR LLAMAR AL METODO RECURSIVO
		if (this.root == null) {
			this.root = new Node(value);
		} else {
			int height = 1;
			this.insert(this.root, value, height + 1);
		}
	}
	
	private Node newNode(Integer value, int height) {
		// ESTE METODO PRIVADO MODIFICA LA VARIABLE ALTURA Y RETORNA UN NUEVO NODO
		// LA COMPLEJIDAD ES O(1)
		Node temp = new Node(value);
		if (height > this.height)
			this.height = height;
		return temp;
	}
	
	private void insert(Node actual, int value, int height) {
		// ESTE METODO SE ENCARGA DE INSERTAR EL NODO EN EL LUGAR CORRESPIENTE
		// AL MOVERSE POR LAS RAMAS SEGUN UN CRITERIO LA COMPLEJIDAD ES O(LOG(N)) SIENDO N LA CANTIDAD DE ELEMENTOS
		// LA COMPLEJIDAD ES O(LOG(N)) SIEMPRE QUE SE ASUMA QUE EL ARBOL ESTA BALANCEADO
		if (actual.getValue() > value) {
			if (actual.getLeft() == null) { 
				Node temp = newNode(value, height);
				actual.setLeft(temp);
			} else {
				insert(actual.getLeft(), value, height + 1);
			}
		} else {
			if (actual.getRight() == null) { 
				Node temp = newNode(value, height);
				actual.setRight(temp);
			} else {
				insert(actual.getRight(), value, height + 1);
			}
		}
	}
	
	private void printPreOrder(Node actual, ArrayList<Integer> list) {
		// ESTE METODO SE ENCARGA DE OBTENER LOS ELEMENTOS DE LA ESTRUCTURA EN PRE ORDER
		// AL RECORRER TODA LA ESTRUCTURA LA COMPLEJIDAD ES O(N) SIENDO N LA CANTIDAD DE ELEMENTOS
		if (actual != null) {
			list.add(actual.getValue());
			printPreOrder(actual.getLeft(), list);
			printPreOrder(actual.getRight(), list);
		}
	}
	
	public ArrayList<Integer> printPreOrder() {
		// ESTE METODO CREA UNA LISTA PARA CARGARLA CON LOS ELEMENTOS DE ESTA ESTRUCTURA EN FORMA DE PRE ORDER
		// ESTE LLAMA AL METODO RECURSIVO POR LO QUE SU COMPLEJIDAD ES O(N)
		ArrayList<Integer> list = new ArrayList<Integer>();
		printPreOrder(this.root, list);
		return list;
	}
	
	private void printInOrder(Node actual, ArrayList<Integer> list) {
		// ESTE METODO SE ENCARGA DE OBTENER LOS ELEMENTOS DE LA ESTRUCTURA EN IN ORDER
		// AL RECORRER TODA LA ESTRUCTURA LA COMPLEJIDAD ES O(N) SIENDO N LA CANTIDAD DE ELEMENTOS
		if (actual != null) {
			printInOrder(actual.getLeft(), list);
			list.add(actual.getValue());
			printInOrder(actual.getRight(), list);
		}
	}
	
	public ArrayList<Integer> printInOrder() {
		// ESTE METODO CREA UNA LISTA PARA CARGARLA CON LOS ELEMENTOS DE ESTA ESTRUCTURA EN FORMA DE IN ORDER
		// ESTE LLAMA AL METODO RECURSIVO POR LO QUE SU COMPLEJIDAD ES O(N)
		ArrayList<Integer> list = new ArrayList<Integer>();
		printInOrder(this.root, list);
		return list;
	}
	
	private void printPosOrder(Node actual, ArrayList<Integer> list) {
		// ESTE METODO SE ENCARGA DE OBTENER LOS ELEMENTOS DE LA ESTRUCTURA EN POS ORDER
		// AL RECORRER TODA LA ESTRUCTURA LA COMPLEJIDAD ES O(N) SIENDO N LA CANTIDAD DE ELEMENTOS
		if (actual != null) {
			printPosOrder(actual.getLeft(), list);
			printPosOrder(actual.getRight(), list);
			list.add(actual.getValue());
		}
	}
	
	public ArrayList<Integer> printPosOrder() {
		// ESTE METODO CREA UNA LISTA PARA CARGARLA CON LOS ELEMENTOS DE ESTA ESTRUCTURA EN FORMA DE POS ORDER
		// ESTE LLAMA AL METODO RECURSIVO POR LO QUE SU COMPLEJIDAD ES O(N)
		ArrayList<Integer> list = new ArrayList<Integer>();
		printPosOrder(this.root, list);
		return list;
	}
	
	private void getLeafs(Node actual, ArrayList<Integer> list) {
		// ESTE METODO CARGA UNA LISTA CON LOS NODOS QUE SEAN HOJA
		// AL RECORRER TODA LA ESTRUCTURA TIENE COMPLEJIDAD O(N)
		if (actual != null) {
			getLeafs(actual.getLeft(), list);
			if (actual.isLeaf()) {
				list.add(actual.getValue());
			}
			getLeafs(actual.getRight(), list);
		}
	}
	
	public ArrayList<Integer> getFrontier() {
		// ESTE METODO RETORNA UNA LISTA QUE SE CARGA CON LAS HOJAS QUE ENCUENTRA EL METODO RECURSIVO POR LO QUE
		// SU COMPLEJIDAD ES O(N)
		ArrayList<Integer> list = new ArrayList<Integer>();
		getLeafs(this.root, list);
		return list;
	}
	
	private boolean hasElem(Node actual, Integer i) {
		// ESTE METODO BUSCA EL ELEMENTO PASADO POR PARAMETRO EN LA ESTRUCTURA
		// AL RECORRER EL ARBOL POR LAS RAMAS SEGUN EL VALOR TIENE COMPLEJIDAD O(LOG(N))
		// LA COMPLEJIDAD ES O(LOG(N)) SIEMPRE QUE SE ASUMA QUE EL ARBOL ESTA BALANCEADO
		if (actual != null) {
			if (actual.getValue() > i) {
				return hasElem(actual.getLeft(), i);			
			} else if (actual.getValue() < i) {
				return hasElem(actual.getRight(), i);
			} else if (actual.getValue() == i) {
				return true;
			}			
		} 
		return false;
	}
	
	public boolean hasElem(Integer i) {
		// ESTE METODO RETORNA UN V/F DEPENDIENDO DEL RESULTADO DEL METODO RECURSIVO DE BUSCAR EN LA ESTRUCTURA
		// POR LO QUE SU COMPLEJIDAD ES O(LOG(N))
		// LA COMPLEJIDAD ES O(LOG(N)) SIEMPRE QUE SE ASUMA QUE EL ARBOL ESTA BALANCEADO
		return hasElem(this.root, i);
	}

	private void getElemAtLevel(Node actual, Integer level, int currentLevel, ArrayList<Integer> list) {
		// ESTE METODO AGREGA EN LA LISTA LOS ELEMENTOS QUE SE ENCUENTREN EN UN NIVEL EN ESPECIFICO
		// AL RECORRER TODA LA LISTA TIENE UNA COMPLEJIDAD DE O(N)
		if (actual != null) {
			getElemAtLevel(actual.getLeft(), level, currentLevel + 1, list);
			if (level == currentLevel) {
				list.add(actual.getValue());
			}
			getElemAtLevel(actual.getRight(), level, currentLevel + 1, list);
		}
	}
	
	public ArrayList<Integer> getElemAtLevel(Integer level) {
		// ESTE METODO RETORNA LA LISTA DE LOS ELEMENTOS QUE SE ENCUENTRAN EN UN DETERMINADO NIVEL
		// CUYA LISTA SE LLAMA POR EL METODO RECURSIVO POR LO QUE SU COMPLEJIDAD ES O(N)
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (!this.isEmpty()) {
			int currentLevel = 1;
			getElemAtLevel(this.root, level, currentLevel, list);			
		}
		return list;
	}
	
	private Integer getMaxElem(Node actual) {
		// ESTE METODO BUSCA DE FORMA RECURSIVA EL VALOR MAS GRANDE DE LA ESTRUCTURA
		// AL BUSCARLO SEGUN SU VALOR TIENE COMPLEJIDAD O(LOG(N))
		// LA COMPLEJIDAD ES O(LOG(N)) SIEMPRE QUE SE ASUMA QUE EL ARBOL ESTA BALANCEADO
		if (actual.getRight() != null) {
			return getMaxElem(actual.getRight());
		} else {
			return actual.getValue();
		}
	}
	
	public Integer getMaxElem() {
		// ESTE METODO RETORNA EL VALOR MAS GRANDE DE LA ESTRUCTURA
		// SE ENCARGA DE LLAMAR AL METODO RECURSIVO CON EL NODO RAIZ POR LO QUE SU COMPLEJIDAD ES O(LOG(N))
		// LA COMPLEJIDAD ES O(LOG(N)) SIEMPRE QUE SE ASUMA QUE EL ARBOL ESTA BALANCEADO
		return getMaxElem(this.root);
	}
	
	private int getMax(int elemLeft, int elemRight) {
		// ESTE METODO DEVUELVE CUAL ELEMENTO PASADOS POR PARAMETRO ES MAS GRANDE
		// SU COMPLEJIDAD ES O(1)
		if (elemLeft > elemRight)
			return elemLeft;
		return elemRight;
	}

	protected int updateHeight(Node actual) {
		// ESTE METODO RETORNA LA ALTURA DEL NODO EN EL QUE SE ENCUENTRA
		// AL RECORRER TODOS LOS NODOS TIENE COMPLEJIDAD O(N)
		if (actual != null) {
			return getMax(this.updateHeight(actual.getLeft()), this.updateHeight(actual.getRight())) + 1;
		}
		return 0;
	}
	
	public int getHeight() {
		// ESTE METODO RETORNA EL VALOR DE LA ALTURA
		// TIENE COMPLEJIDAD O(1)
		return (this.height);
	}

	private void getLongestBranch(Node actual, int maxHeight, ArrayList<Integer> res) {
		// ESTE METODO CARGA UNA LISTA CON LOS NODOS DE LA RAMA MAS GRANDE
		// AL RECORRERLA COMPLETAMENTE TIENE COMPLEJIDAD O(N)
		if (actual != null) {
			res.add(actual.getValue());
			getLongestBranch(actual.getLeft(), maxHeight, res);
			getLongestBranch(actual.getRight(), maxHeight, res);
			if (res.size() != maxHeight) {
				res.remove(res.size() - 1);
			}
		}
	}
	
	public ArrayList<Integer> getLongestBranch() {
		// ESTE METODO RETORNA LA LISTA CON LOS ELEMENTOS DE LA RAMA MAS GRANDE
		// SE ENCARGA DE LLAMAR AL METODO RECURSIVO CON EL NODO RAIZ POR LO QUE SU COMPLEJIDAD ES O(N)
		ArrayList<Integer> res = new ArrayList<Integer>();
		if (!this.isEmpty()) {
			int maxHeight = this.getHeight();
			getLongestBranch(this.root, maxHeight, res);
		}
		return res;
	}
	
	private boolean delete(Node actual, Integer i) {
		// ESTE METODO SE ENCARDA DE BORRAR EL ELEMENTO PASADO POR PARAMETRO
		// TIENE COMPLEJIDAD O(LOG(N))
		// LA COMPLEJIDAD ES O(LOG(N)) SIEMPRE QUE SE ASUMA QUE EL ARBOL ESTA BALANCEADO
		if (actual != null) {
			if (actual.getValue() != i) {				
				if (actual.getValue() < i) {
					if (actual.getRight() != null)
						if (actual.getRight().getValue() == i)  {
								// EL PADRE ENCUENTRA EL ELEMENTO EN EL HIJO DERECHO
							if (actual.getRight().isLeaf()) {
								// SI ES HOJA EL HIJO DERECHO SE VUELVE NULL
								actual.setRight(null);
							} else if (actual.getRight().onlyHasLeft()) {
								// SI EL HIJO DERECHO SOLO TIENE UN HIJO IZQUIERDO ESTE SE VUELVE SU NUEVO HIJO DERECHO
								actual.setRight(actual.getRight().getLeft());
							} else if (actual.getRight().onlyHasRight()) {
								// SI EL HIJO DERECHO SOLO TIENE UN HIJO DERECHO ESTE SE VUELVE SU NUEVO HIJO DERECHO
								actual.setRight(actual.getRight().getRight());
							} else {
								// SI TIENE 2 HIJOS ENTONCES BUSCO AL MAYOR DE LA RAMA IZQUIERDA
								Integer maxElem = this.getMaxElem(actual.getRight().getLeft());
								delete(actual.getRight(), maxElem);
								actual.getRight().setValue(maxElem);
							}
							return true;
						} else {
							return delete(actual.getRight(), i);
						}
				} else if (actual.getValue() > i) {
					if (actual.getLeft() != null)	
						if (actual.getLeft().getValue() == i) {
								// EL PADRE ENCUENTRA EL ELEMENTO EN EL HIJO IZQUIERDO
							if (actual.getLeft().isLeaf()) {
								// SI ES HOJA EL HIJO IZQUIERDO SE VUELVE NULL
								actual.setLeft(null);
							} else if (actual.getLeft().onlyHasLeft()) {
								// SI EL HIJO IZQUIERDO SOLO TIENE UN HIJO IZQUIERDO ESTE SE VUELVE SU NUEVO HIJO IZQUIERDO
								actual.setLeft(actual.getLeft().getLeft());
							} else if (actual.getLeft().onlyHasRight()) {
								// SI EL HIJO IZQUIERDO SOLO TIENE UN HIJO DERECHO ESTE SE VUELVE SU NUEVO HIJO IZQUIERDO
								actual.setLeft(actual.getLeft().getRight());
							} else {
								// SI TIENE 2 HIJOS ENTONCES BUSCO AL MAYOR DE LA RAMA IZQUIERDA
								Integer maxElem = this.getMaxElem(actual.getLeft().getLeft());
								delete(actual.getLeft(), maxElem);
								actual.getLeft().setValue(maxElem);
							}
							return true;
						} else {
							return delete(actual.getLeft(), i);
						}
				}				
			} else {
				Integer maxElem = this.getMaxElem(actual.getLeft());
				delete(actual, maxElem);
				actual.setValue(maxElem);
				return true;
			}
		}
		return false;
	}
	
	public boolean delete(Integer i) {
		// ESTE METODO RETORNA EL RESULTADO DE QUERER ELIMINAR UN ELEMENTO
		// LLAMA AL METODO RECURSIVO DE BORRAR Y EL METODO RECURSIVO PARA ACTUALIZAR ALTURA
		// SU COMPLEJIDAD ES O(LOG(N)) + O(N)
		// LA COMPLEJIDAD ES O(LOG(N)) SIEMPRE QUE SE ASUMA QUE EL ARBOL ESTA BALANCEADO
		if (this.hasElem(i)) {
			if (this.delete(this.root, i)) {
				this.height = this.updateHeight(this.root);
				return true;
			}			
		}
		return false;
	}
}
