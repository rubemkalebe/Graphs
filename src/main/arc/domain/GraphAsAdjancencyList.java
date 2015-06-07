package main.arc.domain;

import java.util.ArrayList;
import java.util.LinkedList;

import main.arc.iterator.AdjacencyListEdgeIterator;

/**
 * Classe abstrata para grafos que utilizam listas de adjacencia.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 07.06.2015
 */

public abstract class GraphAsAdjancencyList extends Graph {
	
	// Lista de adjacencia
	protected ArrayList<LinkedList<Vertex>> listAdj;
	
	public GraphAsAdjancencyList() {
		super();
		this.listAdj = new ArrayList<LinkedList<Vertex>>();
	}
	
	public ArrayList<LinkedList<Vertex>> getEdges(){
		return this.listAdj;
	}
	
	
	//	Por padrão faz uma conexão simétrica: v1 -> v2 && v2 -> v1;
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
		if(super.vertices.contains(v1) && super.vertices.contains(v2) && !isEdge(v2, v1)){
			this.listAdj.get(v2.getVertexID()).add(v2.getVertexOutDegree(), v1);
			v2.increaseOutDegree();
			v1.increaseInDegree();
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
		if((super.vertices.contains(v1) && super.vertices.contains(v2)) && isEdge(v2, v1)){
			this.listAdj.get(v2.getVertexID()).remove(v1);
			v2.decreaseOutDegree();
			v1.decreaseInDegree();
		}
		else {
			throw new Exception("Vertices ou a aresta não existem!");
		}
	}
	
	@Override
	public void removeAllConnections() {
		// TODO Auto-generated method stub
		if(!this.listAdj.isEmpty()){
			for(int i = 0; i < this.listAdj.size(); i++)
				this.listAdj.get(i).clear();
		}
	}
	
	@Override
	public boolean isEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		if(super.vertices.contains(v1) && super.vertices.contains(v2)){
			if(this.listAdj.get(v1.vertexID).get(v2.vertexID) != null)
				return true;
		}
		return false;
	}
	
	public main.arc.iterator.Iterator createEdgeIterator() {
		return new AdjacencyListEdgeIterator(listAdj);
	}

	public ArrayList<LinkedList<Vertex>> getListAdj() {
		return listAdj;
	}

	public void setListAdj(ArrayList<LinkedList<Vertex>> listAdj) {
		this.listAdj = listAdj;
	}

}
