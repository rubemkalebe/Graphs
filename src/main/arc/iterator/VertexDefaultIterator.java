package main.arc.iterator;

import java.util.ArrayList;

import main.arc.domain.Vertex;

/**
 * Classe para iterador padrão da estrutura de vertices.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 01.06.2015
 */

public class VertexDefaultIterator extends AbstractVertexIterator {
	
	/**
	 * Construtor padrão.
	 * @param vertices Estrutura de vertices
	 */
	public VertexDefaultIterator(ArrayList<Vertex> vertices) {
		super(vertices);
	}
	
	/**
	 * 
	 * @return true se ainda existem elementos a serem percorridos, false caso contrário
	 */
	public boolean hasNext() {
		if(index + 1 < vertices.size()) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 
	 * @return O proximo vertice
	 */
	public Vertex next() {
		return vertices.get(index);
	}
	
}
