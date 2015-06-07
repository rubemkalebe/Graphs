package main.arc.domain;

import java.util.ArrayList;

import main.arc.iterator.*;

/**
 * Classe abstrata para grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 07.06.2015
 */

public abstract class Graph implements GraphInterface {
	
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
	
	public Iterator breadthFirstTraversal() {
		return new BreadthFirstIterator(this, vertices.get(0));
	}
	
	public Iterator breadthFirstTraversal(Vertex v) {
		return new BreadthFirstIterator(this, v);
	}
	
	public Iterator preOrderDepthFirstTraversal() {
		return new PreOrderDFSIterator(this, vertices.get(0));
	}
	
	public Iterator preOrderDepthFirstTraversal(Vertex v) {
		return new PreOrderDFSIterator(this, v);
	}
	
	public Iterator inOrderDepthFirstTraversal() {
		return new InOrderDFSIterator(this, vertices.get(0));
	}
	
	public Iterator inOrderDepthFirstTraversal(Vertex v) {
		return new InOrderDFSIterator(this, v);
	}
	
	public Iterator postOrderDepthFirstTraversal() {
		return new PostOrderDFSIterator(this, vertices.get(0));
	}
	
	public Iterator postOrderDepthFirstTraversal(Vertex v) {
		return new PostOrderDFSIterator(this, v);
	}
	
	public boolean isConnected() {
		/*
		 * Um grafo não orientado é conexo se existe um caminho entre todo par de vértices
		 * da estrutura.
		 * 
		 * Um dígrafo é fortemente conexo se existe um caminho entre todo par de vértices
		 * da estrutura.
		 * 
		 * Um dígrafo é fracamento conexo se seu grafo não orientado subjacente for
		 * conexo. 
		 */
		
		int count = 0;
		Iterator it = this.breadthFirstTraversal();
		while(it.hasNext()) {
			it.next();
			count += 1;
		}
		return count == getVerticesNumber();
	}
	
	public boolean isCyclic() {
		return false;
	}
	
	public boolean isDirected() {
		return false;
	}

}
