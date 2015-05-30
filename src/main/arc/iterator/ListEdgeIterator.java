package main.arc.iterator;

import java.util.LinkedList;

import main.arc.domain.Edge;

/**
 * Classe para iterador padrão de uma lista de adjacencia.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public class ListEdgeIterator extends AbstractEdgeIterator {

	// Lista de adjencia
	private LinkedList<Edge>[] edges;
	
	/**
	 * Construtor padrão.
	 * @param edges Lista de adjencia
	 */
	public ListEdgeIterator(LinkedList<Edge>[] edges) {
		super();
		this.edges = edges;
	}
	
	/**
	 * Retorna a primeira aresta da estrutura.
	 * @return Primeira aresta
	 */
	public Edge first() {
		return null; // ------
	}
	
	/**
	 * 
	 * @return true se ainda existem elementos a serem percorridos, false caso contrário
	 */
	public boolean hasNext() {
		return true; // ------
	}
	
	/**
	 * 
	 * @return A proxima aresta
	 */
	public Edge next() {
		return null; // ------
	}

	public LinkedList<Edge>[] getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Edge>[] edges) {
		this.edges = edges;
	}
	
}
