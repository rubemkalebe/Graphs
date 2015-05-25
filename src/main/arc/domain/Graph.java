package main.arc.domain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public abstract class Graph {
	private int verticeNumber;
	private int edgeNumber;
	private HashSet<Vertex> vertices = new HashSet<Vertex>();
	private HashSet<Edge> edges = new HashSet<Edge>();
	private int edgeCounter;
	
	Graph(){
		
	}
	
	public void addVertice(Vertex v) throws Exception{
		if(v != null)
			this.vertices.add(v);
		else
			throw new Exception("Vertice nulo!");			
	}
	
	public void removeVertice(Vertex v) throws Exception{
		if(this.vertices.contains(v))
			this.vertices.remove(v);
		else
			throw new Exception("Vertice não existe!");
	}
	
	public void connectVertices(Vertex v1, Vertex v2){
		if((v1 != null) && (v2 != null)){
			Random random = new Random();
			Edge e = new Edge(v1, v2, random.nextInt());
			this.addVertice(v1);
			this.addVertice(v2);
			this.edges.add(e);
			
			/*
			 *É na estrutura de arestas que eu sei onde quem tá ligado com quem, é fácil pensar o pq: 
			 * 	Se eu tenho informações sobre minhas arestas, tenho informações de quem que elas ligam e 
			 * consequentemente tenho informação do meu grafo todo. 
			 */
			
		}
	}
	
	public void desconnectVertice(Vertex v1, Vertex v2) throws Exception{
		if(this.vertices.contains(v1) && this.vertices.contains(v2)){
			Iterator<Edge> it = this.edges.iterator();
			while(it.hasNext()){
				it.next();
				if(((Edge) it).getVertexA() == v1 && ((Edge) it).getVertexB() == v2){
					it.remove();					
				}				
			}
		}
		else
			throw new Exception("Vertices não existem!");
		
	}
}
