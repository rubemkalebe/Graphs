package main.arc.iterator;

import java.util.HashSet;

import main.arc.domain.Vertex;

/**
 * Classe para iterador padrão da estrutura de vertices.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public class VertexDefaultIterator extends AbstractVertexIterator {
	
	/**
	 * Construtor padrão.
	 * @param vertices Estrutura de vertices
	 */
	public VertexDefaultIterator(HashSet<Vertex> vertices) {
		super(vertices);
	}
	
	/**
	 * Retorna o primeiro vertice da estrutura.
	 * @return Primeira vertice
	 */
	public Vertex first() {
		return null; // -----
	}
	
	/**
	 * 
	 * @return true se ainda existem elementos a serem percorridos, false caso contrário
	 */
	public boolean hasNext() {
		return true; // -----
	}
	
	/**
	 * 
	 * @return O proximo vertice
	 */
	public Vertex next() {
		return null; // -----
	}
	
}
