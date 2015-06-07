package main.arc.domain;

import main.arc.iterator.Iterator;
import main.arc.iterator.TopologicalOrderIterator;

/**
 * Classe abstrata para dígrafos que utilizam listas de arestas.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 07.06.2015
 */

public abstract class DigraphAsList extends GraphAsList implements DigraphInterface {

	public DigraphAsList() {
		super();
	}
	
	@Override
	public void connectVertices(Vertex v1, Vertex v2) throws Exception{
		// TODO Auto-generated method stub
		if(super.vertices.contains(v1) && super.vertices.contains(v2) && !isEdge(v1, v2)){
			this.edgeList.add(new Edge(v1, v2, this.edgeCounter++, true));
			v1.increaseOutDegree();
			v2.increaseInDegree();
		}
		else
			throw new Exception("Conexão inválida! Vértices não existentes ou aresta já"
					+ "inserida anteriormente");
	}
	
	@Override
	public void disconnectVertices(Vertex v1, Vertex v2) throws Exception{
		// TODO Auto-generated method stub
		if((super.vertices.contains(v1) && super.vertices.contains(v2)) && isEdge(v1, v2)){
			Edge e = this.getEdge(v1, v2);
			this.edgeList.remove(e);
			v1.decreaseOutDegree();
			v2.decreaseInDegree();
		}
		else
			throw new Exception("Vertices não existem!");
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
