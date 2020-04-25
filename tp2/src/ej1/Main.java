package ej1;

public class Main {

	public static void main(String[] args) {

		int arr[] = {1, 5, 7, 2, 3, 9};
		int arr2[] = {4, 10, 67, 101, 200};
		
		System.out.println(estaOrdenado(arr));
		System.out.println(estaOrdenado(arr2));
	}

	
	private static boolean estaOrdenado(int[] arr) {
		// TODO Auto-generated method stub
		return checkSort(arr);
	}

	public static boolean checkSort(int a[]) {
		if (a == null || a.length < 0) 
			return true;  
		return checkSort(a,0);
	}
	
	private static boolean checkSort(int a[], int pos) {
		if (pos == a.length - 1) 
			return true; 
		if (a[pos+1] < a[pos]) 
			return false;
		else 
			return checkSort(a, pos+1);
	}

}
