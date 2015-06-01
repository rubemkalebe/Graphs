package main.arc.iterator;

import java.util.ArrayList;

import main.arc.domain.Vertex;

/**
 * Classe abstrata para iteradores de vertices.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 01.06.2015
 */

public abstract class AbstractVertexIterator {

	// Indice atual
	protected int index;
	
	// Estrutura de vertices
	protected ArrayList<Vertex> vertices;
	
	/**
	 * Construtor padrão.
	 * @param vertices Estrutura de vertices
	 */
	public AbstractVertexIterator(ArrayList<Vertex> vertices) {
		this.vertices = vertices;
		this.index = 0;
	}
	
	/**
	 * 
	 * @return true se ainda existem elementos a serem percorridos, false caso contrário
	 */
	public abstract boolean hasNext();
	
	/**
	 * 
	 * @return O proximo vertice
	 */
	public abstract Vertex next();
	
	/**
	 * 
	 * @return O indice atual do iterador
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * 
	 * @return Estrutura de vertices
	 */
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}
	
}
