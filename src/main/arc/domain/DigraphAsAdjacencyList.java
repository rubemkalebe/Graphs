package main.arc.domain;

import main.arc.iterator.Iterator;
import main.arc.iterator.TopologicalOrderIterator;

/**
 * Classe abstrata para dígrafos que utilizam listas de adjacência.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 07.06.2015
 */

public abstract class DigraphAsAdjacencyList extends GraphAsAdjancencyList implements
																DigraphInterface {
	
	public DigraphAsAdjacencyList() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Override
	public void connectVertices(Vertex v1, Vertex v2) throws Exception {
		if(super.vertices.contains(v1) && super.vertices.contains(v2) && !isEdge(v1, v2)){
					this.listAdj.get(v1.getVertexID()).add(v1.getVertexOutDegree(), v2);
					v1.increaseOutDegree();
					v2.increaseInDegree();
		}
		else {
			throw new Exception("Conexão inválida! Vértices não existentes ou aresta já"
					+ "inserida anteriormente");
		}
	}
	
	@Override
	public void disconnectVertices(Vertex v1, Vertex v2) throws Exception{
		if((super.vertices.contains(v1) && super.vertices.contains(v2)) && isEdge(v1, v2)){
			this.listAdj.get(v1.getVertexID()).remove(v2);
			v1.decreaseOutDegree();
			v2.decreaseInDegree();
		}
		else {
			throw new Exception("Vertices ou a aresta não existem!");
		}
	}
	
	@Override
	public boolean isDirected() {
		return true;
	}
	
	public Iterator topologicalOrderTraversal() throws Exception {
		return new TopologicalOrderIterator(this);
	}
	
	public boolean isStronglyConnected() {
		return false; // ------
	}
	
	public boolean isCyclic() {
		return false; // ------
	}

}