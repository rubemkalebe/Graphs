package main.arc.iterator;

import java.util.ArrayList;

import main.arc.domain.Vertex;

/**
 * Classe para iterador padrão da estrutura de vertices.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 03.06.2015
 */

public class VertexDefaultIterator implements Iterator {
	
	private ArrayList<Vertex> vertices;
	private int index;
	
	/**
	 * Construtor padrão.
	 * @param vertices Estrutura de vertices
	 */
	public VertexDefaultIterator(ArrayList<Vertex> vertices) {
		super();
		this.index = 0;
		this.vertices = vertices;
	}
	
	/**
	 * 
	 * @return true se ainda existem elementos a serem percorridos, false caso contrário
	 */
	@Override
	public boolean hasNext() {
		if(this.index > this.vertices.size() || this.vertices.get(this.index) == null)
			return false;
		return true;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		if(this.index > this.vertices.size() || this.vertices.get(this.index) == null) {
			return null;
		} else {
			Vertex v = this.vertices.get(this.index);
			this.index++;
			return v;
		}		
	}
	
}