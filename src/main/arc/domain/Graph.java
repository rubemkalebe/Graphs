package main.arc.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public abstract class Graph {
	protected int verticeNumber;
//	protected int edgeNumber;
	protected ArrayList<Vertex> vertices = new ArrayList<Vertex>();
//	protected int edgeCounter;
	
	Graph(){
		this.verticeNumber = 0;
	}
	
	public void addVertice(Vertex v) throws Exception{
		if(v != null){
			this.verticeNumber++;
			this.vertices.add(v);
		}
		else
			throw new Exception("Vertice nulo!");			
	}
	
	public void removeVertice(Vertex v) throws Exception{
		if(this.vertices.contains(v)){
			this.verticeNumber--;
			this.vertices.remove(v);
		}
		else
			throw new Exception("Vertice não existe!");
	}
	
	public ArrayList<Vertex> getVertices(){
		return this.vertices;
	}
	
	public int getNumbVertices(){
		return this.verticeNumber;
	}
	
	public abstract void addEdge(Vertex v1, Vertex v2) throws Exception;
}
