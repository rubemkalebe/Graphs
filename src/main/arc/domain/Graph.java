package main.arc.domain;

import java.util.ArrayList;

import main.arc.iterator.*;
import main.arc.visitor.PreInPostVisitorInterface;
import main.arc.visitor.VisitorInterface;

/**
 * Classe abstrata para grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 01.06.2015
 */

public abstract class Graph implements GraphInterface{
	
	// Número de arestas
	protected int edgesNumber;
	
	// Estrutura para armazenar vértices
	protected ArrayList<Vertex> vertices;
	
	// Contador de arestas
	protected int edgesCounter;
	
	/**
	 * Construtor padrão.
	 */
	public Graph() {
		this.edgesNumber = 0;
		this.vertices = new ArrayList<Vertex>();
		this.edgesCounter = 0;
	}
	
	/**
	 * Construtor por cópia.
	 * @param g Grafo a ser copiado
	 */
	public Graph(Graph g) {
		if(g != null) {
			this.edgesNumber = g.getEdgesNumber();
			this.vertices = new ArrayList<Vertex>(g.getVertices());
			this.edgesCounter = g.getEdgesCounter();
		}
	}
	
	public int getVerticesNumber() {
		return vertices.size();
	}
	
	public int getEdgesNumber() {
		return edgesNumber;
	}

	/**
	 * Altera o número de vértices da estrutura.
	 * @param edgesNumber Número de vértices
	 */
	public void setEdgesNumber(int edgesNumber) {
		if(edgesNumber >= 0) {
			this.edgesNumber = edgesNumber;
		}
	}

	public ArrayList<Vertex> getVertices() {
		return vertices;
	}

	/**
	 * Altera o objeto que armazena vértices.
	 * @param vertices Novo objeto
	 */
	public void setVertices(ArrayList<Vertex> vertices) {
		if(vertices != null) {
			this.vertices = vertices;
		}
	}

	/**
	 * @return Contador de arestas
	 */
	public int getEdgesCounter() {
		return edgesCounter;
	}

	/**
	 * Altera o valor do contador de arestas.
	 * @param edgesCounter Novo valor
	 */
	public void setEdgesCounter(int edgesCounter) {
		this.edgesCounter = edgesCounter;
	}

	public void addVertex(Vertex v) throws Exception{
		if(v != null){
			this.vertices.add(v);
		}
		else
			throw new Exception("Vertice nulo!");			
	}
	
	public void removeVertex(Vertex v) throws Exception{
		if(this.vertices.contains(v)){
			this.vertices.remove(v);
		}
		else
			throw new Exception("Vertice não existe!");
	}
	
	public void removeVertex(int id) throws IndexOutOfBoundsException{
		if(this.vertices.get(id) != null){
				this.vertices.remove(id);
		}
		else
			throw new IndexOutOfBoundsException();
	}
	
	public Vertex getVertex(int id) {
		for(Vertex v : vertices) {
			if(v.getVertexID() == id) {
				return v;
			}
		}
		return null;
	}
	
	public Iterator createVertexIterator() {
		return new VertexDefaultIterator(vertices); 
	}
	
	public void breadthFirstTraversal(VisitorInterface vis) {
		// -------
	}
	
	public void breadthFirstTraversal(VisitorInterface vis, Vertex v) {
		// -------		
	}
	
	public void depthFirstTraversal(PreInPostVisitorInterface vis) {
		// -------
	}
	
	public void depthFirstTraversal(PreInPostVisitorInterface vis, Vertex v) {
		// -------
	}
	
	public boolean isConnected() {
		return true; // -------
	}

}
