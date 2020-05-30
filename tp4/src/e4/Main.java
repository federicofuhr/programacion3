package e4;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrafoDirigido<Integer> grafo = new GrafoDirigido<Integer>();
		
		grafo.agregarVertice(1);
		grafo.agregarVertice(2);
		grafo.agregarVertice(3);
		grafo.agregarVertice(4);
		grafo.agregarVertice(5);
		
		grafo.agregarArco(1, 2, 10);
		grafo.agregarArco(1, 4, 30);
		grafo.agregarArco(1, 5, 100);
		grafo.agregarArco(2, 3, 50);
		grafo.agregarArco(3, 5, 10);
		grafo.agregarArco(4, 3, 20);
		grafo.agregarArco(4, 5, 60);
		
		System.out.println(grafo);
		
		int[] caminoMasCorto = dijkstra(grafo, 1);
		
		for (int i = 0; i < caminoMasCorto.length; i++) {
			System.out.print(caminoMasCorto[i] + ", ");
		}
	}

	private static int[] dijkstra(GrafoDirigido<Integer> grafo, int origen) {
		int[] dis = new int[grafo.cantidadVertices()];
		int[] padre = new int[grafo.cantidadVertices()];

		ArrayList<Integer> considerados = new ArrayList<Integer>();
		
		for (int i = 0; i < grafo.cantidadVertices(); i++) {
			dis[i] = Integer.MAX_VALUE;
			padre[i] = 0;
		}
		
		dis[origen - 1] = 0;
		
		while (considerados.size() != grafo.cantidadVertices()) {
			
			int u = buscaMenorDistancia(dis, considerados) + 1;
			considerados.add(u);
			u--;
			
			Iterator<Arco<Integer>> it = grafo.obtenerArcos(u + 1);
			
			while (it.hasNext()) {
				Arco<Integer> arco = it.next();
				if (!considerados.contains(arco.getVerticeDestino())) {
					int v = arco.getVerticeDestino() - 1;
					if ((dis[u] + arco.getEtiqueta() < dis[v])) {
						dis[v] = dis[u] + arco.getEtiqueta();
						padre[v] = u + 1;
					}
				}
			}
		}
		
		return padre;
	}

	private static int buscaMenorDistancia(int[] distancia, ArrayList<Integer> considerados) {
		// TODO Auto-generated method stub
		int elementoElegido = 0;
		int menorDistancia = Integer.MAX_VALUE;
		int i = 0;
		while (i < distancia.length) {
			if ((distancia[i] != Integer.MAX_VALUE) && (distancia[i] <= menorDistancia)) {
				if (!considerados.contains(i + 1)) {
					elementoElegido = i;
					menorDistancia = distancia[i];
				}
			}
			i++;	
		}
		return elementoElegido;
	}
	
	
}
