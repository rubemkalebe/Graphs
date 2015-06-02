package main.arc.domain;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Classe abstrata para grafos que utilizam listas de adjacencia.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 01.06.2015
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
	public void connectVertices(Vertex v1, Vertex v2) throws Exception{
		int degreev1 = v1.vertexDegree, degreev2 = v2.vertexDegree;
		if(super.vertices.contains(v1) && super.vertices.contains(v2)){
					this.listAdj.get(v1.vertexID).add(degreev1++, v2);
					this.listAdj.get(v2.vertexID).add(degreev2++, v2);
					v1.setVertexDegree(degreev1++);
					v2.setVertexDegree(degreev2++);
		}
		else
			throw new Exception("Vertices não existem!");
	}
	
	@Override
	public void disconnectVertices(Vertex v1, Vertex v2) throws Exception{
		if((super.vertices.contains(v1) && super.vertices.contains(v2))){
			this.listAdj.get(v1.vertexID).remove(v2);
			v1.setVertexDegree(v1.vertexDegree--);
		}
		else
			throw new Exception("Vertices não existem!");
	}
	
	@Override
	public void removeAllConnections() {
		// TODO Auto-generated method stub
		if(!this.listAdj.isEmpty()){
			for(int i =0; i < this.listAdj.size(); i++)
				this.listAdj.get(i).clear();
		}
			
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
		for(int i  =0; i< this.listAdj.size(); i++){
			for(int j =0; j< this.listAdj.size(); j++){
				if((this.listAdj.get(i).get(j) != null) && (this.listAdj.get(j).get(i) != null))
					return false;
			}
		}
		return true;
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

}
