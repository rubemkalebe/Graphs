package main.arc.domain;

import java.util.ArrayList;

public abstract class Graph implements GraphInterface{
	protected int verticeNumber;
//	protected int edgeNumber;
	protected ArrayList<Vertex> vertices = new ArrayList<Vertex>();
//	protected int edgeCounter;
	
	Graph(){
		this.verticeNumber = 0;
	}
	
	public void addVertex(Vertex v) throws Exception{
		if(v != null){
			this.verticeNumber++;
			this.vertices.add(v);
		}
		else
			throw new Exception("Vertice nulo!");			
	}
	
	public void removeVertex(Vertex v) throws Exception{
		if(this.vertices.contains(v)){
			this.verticeNumber--;
			this.vertices.remove(v);
		}
		else
			throw new Exception("Vertice não existe!");
	}
	
	public void removeVertex(int id) throws IndexOutOfBoundsException{
		if(this.vertices.get(id) != null){
				this.verticeNumber--;
				this.vertices.remove(id);
		}
		else
			throw new IndexOutOfBoundsException();
	}

}
