package main.arc.domain;

import java.util.ArrayList;

public abstract class GraphAsList extends Graph{
	private ArrayList<Edge> edgeList = new ArrayList<Edge>();
	private int edgeCounter;
	
	public GraphAsList() {
		// TODO Auto-generated constructor stub
		this.edgeCounter = 0;
	}
	
	public ArrayList<Edge> getEdges(){
		return this.edgeList;
	}
	
	public void addEdge(Vertex v1, Vertex v2){
		if(super.vertices.contains(v1) && super.vertices.contains(v2)){
			Edge e = new Edge(v1, v2, this.edgeCounter++);//temos que pensar se realmente Edge precisa ser abstrato, ou resolver esse problema.
			this.edgeList.add(e);
		}
		else
			throw new Exception("Vertices não existem!");
	}
	
	public void addEdge(Vertex v1, Vertex v2, int cost){
		if(super.vertices.contains(v1) && super.vertices.contains(v2)){
			Edge e = new Edge(v1, v2, this.edgeCounter++, cost);
			this.edgeList.add(e);
		}
		else
			throw new Exception("Vertices não existem!");
	}
	

}
