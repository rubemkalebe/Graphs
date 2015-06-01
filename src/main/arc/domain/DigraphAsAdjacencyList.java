package main.arc.domain;

import java.util.ArrayList;

/**
 * Classe abstrata para dígrafos que utilizam listas de arestas.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 01.06.2015
 */

public abstract class DigraphAsAdjacencyList extends GraphAsAdjancencyList implements
																DigraphInterface {
	
	public GraphAsList() {
		// TODO Auto-generated constructor stub
		this.edgeCounter = 0;
	}
	
	public ArrayList<Edge> getEdges(){
		return this.edgeList;
	}
	
	@Override
	public void connectVertices(Vertex v1, Vertex v2) throws Exception{
		// TODO Auto-generated method stub
		if(super.vertices.contains(v1) && super.vertices.contains(v2)){
			this.edgeList.add(new Edge(v1, v2, this.edgeCounter, false));
			this.edgeCounter++;
		}
		else
			throw new Exception("Vertices não existem!");
	}
	
	@Override
	public void disconnectVertices(Vertex v1, Vertex v2) throws Exception{
		// TODO Auto-generated method stub
		if((super.vertices.contains(v1) && super.vertices.contains(v2))){
			Edge e = this.getEdge(v1, v2);
			this.edgeList.remove(e);
			this.edgeCounter--;
		}
		else
			throw new Exception("Vertices não existem!");
	}
	
	@Override
	public void removeAllConnections() {
		// TODO Auto-generated method stub
		if(!this.edgeList.isEmpty())
			this.edgeList.clear();
	}
	
	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub

		//Falta implementar um algoritmo de busca em profundidade(Depth-first search).
		
		return false;
	}
	
	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		for(int i  =0; i< this.edgeList.size(); i++){
			if(!this.edgeList.get(i).isEDirected())
				return false;
		}
		return true;
	}
	
	public Edge getEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		for(int i =0; i < this.edgeList.size(); i++){
			if(this.edgeList.get(i).getVertexA() == v1){
				if(this.edgeList.get(i).getVertexB() == v2){
					return this.edgeList.get(i);
				}
			}
		}		
		return null;
	}
	
	@Override
	public boolean isEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		if(this.getEdge(v1, v2) != null){
			return true;
		}
		return false;
	}

}