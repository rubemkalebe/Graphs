package main.arc.domain;

import java.util.ArrayList;
import java.util.List;

import main.arc.iterator.*;

/**
 * Classe abstrata para grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 09.06.2015
 */

public abstract class Graph {
	
	// Número de arestas
	protected int edgesNumber;
	
	// Estrutura para armazenar vértices
	protected ArrayList<Vertex> vertices;
	
	/**
	 * Construtor padrão.
	 */
	public Graph() {
		this.edgesNumber = 0;
		this.vertices = new ArrayList<Vertex>();
	}
	
	/**
	 * Construtor por cópia.
	 * @param g Grafo a ser copiado
	 */
	public Graph(Graph g) {
		if(g != null) {
			this.edgesNumber = g.getEdgesNumber();
			this.vertices = new ArrayList<Vertex>(g.getVertices());
		}
	}
	
	/**
	 * @return Numero de vertices da estrutura
	 */
	public int getVerticesNumber() {
		return vertices.size();
	}
	
	/**
	 * 
	 * @return Numero de arestas da estrutura
	 */
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

	/**
	 * @return A estrutura que armazena os vertices
	 */
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
	 * Adiciona um vértice no grafo.
	 * @param v Vertice a ser adicionado
	 * @throws Exception Caso o vertice esteja nulo 
	 */
	public void addVertex(Vertex v) throws Exception{
		if(v != null){
			this.vertices.add(v);
		}
		else
			throw new Exception("Vertice nulo!");			
	}
	
	/**
	 * Remove um vértice no grafo.
	 * @param v Vertice a ser removido
	 * @throws Exception Caso o vertice nao esteja na estrutura 
	 */
	public void removeVertex(Vertex v) throws Exception{
		if(this.vertices.contains(v)){
			this.vertices.remove(v);
		}
		else
			throw new Exception("Vertice não existe!");
	}
	
	/**
	 * Remove um vértice no grafo pelo identificador do mesmo.
	 * @param id Identificador do vertice a ser removido
	 * @throws IndexOutOfBoundsException Caso o ID seja invalido
	 */
	public void removeVertex(int id) throws IndexOutOfBoundsException{
		if(this.vertices.get(id) != null){
				this.vertices.remove(id);
		}
		else
			throw new IndexOutOfBoundsException();
	}
	
	/**
	 * Recupera um vértice a partir de seu identificador.
	 * @param id Identificador do vertice
	 * @return O vertice, caso exista
	 */
	public Vertex getVertex(int id) {
		for(Vertex v : vertices) {
			if(v.getVertexID() == id) {
				return v;
			}
		}
		return null;
	}
	
	/**
	 * @return Iterador para percorrer os vértices da estrutura
	 */
	public Iterator createVertexIterator() {
		return new VertexDefaultIterator(vertices); 
	}
	
	/**
	 * @return Iterador para percurso em largura da estrutura
	 */
	public Iterator breadthFirstTraversal() {
		return new BreadthFirstIterator(this, vertices.get(0));
	}
	
	/**
	 * 
	 * @param v Vértice inicial
	 * @return Iterador para percurso em largura a partir de um vértice
	 */
	public Iterator breadthFirstTraversal(Vertex v) {
		return new BreadthFirstIterator(this, v);
	}
	
	/**
	 * @return Iterador para percurso em pré-ordem na estrutura
	 */
	public Iterator preOrderDepthFirstTraversal() {
		return new PreOrderDFSIterator(this, vertices.get(0));
	}
	
	/**
	 * @param v Vértice inicial
	 * @return Iterador para percurso em pré-ordem a partir de um vértice
	 */
	public Iterator preOrderDepthFirstTraversal(Vertex v) {
		return new PreOrderDFSIterator(this, v);
	}
	
	/**
	 * @return Iterador para percurso em ordem na estrutura
	 */
	public Iterator inOrderDepthFirstTraversal() {
		return new InOrderDFSIterator(this, vertices.get(0));
	}
	
	/**
	 * @param v Vértice inicial
	 * @return Iterador para percurso em ordem a partir de um vértice
	 */
	public Iterator inOrderDepthFirstTraversal(Vertex v) {
		return new InOrderDFSIterator(this, v);
	}
	
	/**
	 * @return Iterador para percurso em pós-ordem na estrutura
	 */
	public Iterator postOrderDepthFirstTraversal() {
		return new PostOrderDFSIterator(this, vertices.get(0));
	}
	
	/**
	 * @param v Vértice inicial
	 * @return Iterador para percurso em pós-ordem a partir de um vértice
	 */
	public Iterator postOrderDepthFirstTraversal(Vertex v) {
		return new PostOrderDFSIterator(this, v);
	}
	
	/**
	 * Verifica se o grafo é conexo.
	 * @return true se o grafo é conexo, false caso contrário
	 */
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
	
	/**
	 * Verifica se o grafo é cíclico.
	 * @return true se o grafo é cíclico, false caso contrário
	 */
	public boolean isCyclic() {
		return false;
	}
	
	/**
	 * Verifica se o grafo é direcionado.
	 * @return true se o grafo é direcionado, false caso contrário
	 */
	public boolean isDirected() {
		return false;
	}
	
	/**
	 * Conecta dois vértices. Caso algum deles não esteja na estrutura será adicionado.
	 * @param v1 Vertice de uma extremidade
	 * @param v2 Vertice de outra extremidade
	 * @throws Exception 
	 */
	public abstract void connectVertices(Vertex v1, Vertex v2) throws Exception;

	/**
	 * Disconecta dois vértices.
	 * @param v1 Vertice de uma extremidade
	 * @param v2 Vertice de outra extremidade
	 * @throws Exception
	 */
	public abstract void disconnectVertices(Vertex v1, Vertex v2) throws Exception;

	/**
	 * Remove todas as arestas.
	 */
	public abstract void removeAllConnections();

	/**
	 * Verifica se os vértices constituem uma aresta, caso estejam na estrutura.
	 * @param v1 Vertice de uma extremidade
	 * @param v2 Vertice de outra extremidade
	 * @return true se os vértices constituem uma aresta, false caso contrário
	 */
	public abstract boolean isEdge(Vertex v1, Vertex v2) throws Exception;

	/**
	 * @return Iterador para percorrer as arestas da estrutura
	 */
	public abstract Iterator createEdgeIterator();

	/**
	 * 
	 * @param v Vértice
	 * @return Lista de vértices conectados ao vértice v
	 * @throws Exception Caso o vertice nao esteja na estrutura
	 */
	public abstract List<Vertex> getNeighbors(Vertex v) throws Exception;

}
