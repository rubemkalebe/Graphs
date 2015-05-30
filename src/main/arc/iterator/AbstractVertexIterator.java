package main.arc.iterator;

import java.util.HashSet;

import main.arc.domain.Vertex;

/**
 * Classe abstrata para iteradores de vertices.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public abstract class AbstractVertexIterator {

	// Indice atual
	protected int index;
	
	// Estrutura de vertices
	protected HashSet<Vertex> vertices;
	
	/**
	 * Construtor padrão.
	 * @param vertices Estrutura de vertices
	 */
	public AbstractVertexIterator(HashSet<Vertex> vertices) {
		this.vertices = vertices;
		this.index = 0;
	}
	
	/**
	 * Retorna o primeiro vertice da estrutura.
	 * @return Primeira vertice
	 */
	public abstract Vertex first();
	
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
	public HashSet<Vertex> getVertices() {
		return vertices;
	}
	
}
