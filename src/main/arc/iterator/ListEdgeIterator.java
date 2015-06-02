package main.arc.iterator;

import java.util.ArrayList;
import java.util.LinkedList;

import main.arc.domain.Edge;

/**
 * Classe para iterador padrão de uma lista de arestas.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public class ListEdgeIterator implements Iterator {

	// Lista de adjencia
	private ArrayList<Edge> edges;
	private int index = 0;
	
	/**
	 * Construtor padrão.
	 * @param edges Lista de adjencia
	 */
	public ListEdgeIterator(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	/**
	 * Retorna a primeira aresta da estrutura.
	 * @return Primeira aresta
	 */
	@Override
	public Object first() {
		// TODO Auto-generated method stub
		if(!this.edges.isEmpty()){
			this.index++;
			return this.edges.get(0);
		}
		return null;
	}
	
	/**
	 * 
	 * @return true se ainda existem elementos a serem percorridos, false caso contrário
	 */
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(this.index > this.edges.size() || this.edges.get(this.index) == null)
			return false;
		return true;
	}
	
	/**
	 * 
	 * @return A proxima aresta
	 */
	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Edge e = this.edges.get(this.index);
		this.index++;
		return e;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
}
