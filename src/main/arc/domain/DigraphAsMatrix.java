package main.arc.domain;

import main.arc.iterator.Iterator;
import main.arc.iterator.TopologicalOrderIterator;

public abstract class DigraphAsMatrix extends GraphAsMatrix implements DigraphInterface {

	public DigraphAsMatrix(int size) {
		super(size);
	}
	
	@Override
	public void connectVertices(Vertex v1, Vertex v2) throws Exception {
		// TODO Auto-generated method stub
		if(super.vertices.contains(v1) && super.vertices.contains(v2) && !isEdge(v1, v2)){
			this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)] = 1;
			v1.increaseOutDegree();
			v2.increaseInDegree();
			this.edgeCounter++;
		}
		else {
			throw new Exception("Conexão inválida! Vértices não existentes ou aresta já"
					+ "inserida anteriormente");
		}
	}
	
	@Override
	public void disconnectVertices(Vertex v1, Vertex v2) throws Exception {
		// TODO Auto-generated method stub
		if((super.vertices.contains(v1) && super.vertices.contains(v2)) && isEdge(v1, v2)){
			this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)] = 0;
			v1.decreaseOutDegree();
			v2.decreaseInDegree();
			this.edgeCounter--;
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
