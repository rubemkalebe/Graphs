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

public class VertexDefaultIterator implements Iterator {
	
	private ArrayList<Vertex> vertices;
	private int index = 0;
	/**
	 * Construtor padrão.
	 * @param vertices Estrutura de vertices
	 */
	public VertexDefaultIterator(ArrayList<Vertex> vertices) {
		super();
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
	public Object first() {
		// TODO Auto-generated method stub
		if(!this.vertices.isEmpty()){
			this.index++;
			return this.vertices.get(this.index);
		}
		return null;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Vertex v = this.vertices.get(this.index);
		this.index++;
		return v;
	}

	
	
}
