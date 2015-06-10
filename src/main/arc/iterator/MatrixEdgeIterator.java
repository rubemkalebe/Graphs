package main.arc.iterator;

import main.arc.domain.Edge;

/**
 * Classe para iterador padrão de uma matriz de adjacencia.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public class MatrixEdgeIterator implements Iterator {

	// Lista de adjencia
	private int[][] adjMatrix;
	private int index = 0;
	
	/**
	 * Construtor padrão.
	 * @param edges Lista de adjencia
	 */
	public MatrixEdgeIterator(int[][] adjMatrix) {
		super();
		this.adjMatrix = adjMatrix;
	}
	
	/**
	 * 
	 * @return true se ainda existem elementos a serem percorridos, false caso contrário
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * 
	 * @return A proxima aresta
	 */
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public Edge[][] getEdges() {
		return null; // -------
	}

	public void setEdges(Edge[][] edges) {
		// -------
	}
	
}
