package main.arc.domain;

/**
 * Classe abstrata para vértices.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 07.06.2015
 */

public abstract class Vertex {

	// Identificador do vertice
	protected int vertexID;
	
	// Grau de entrada do vertice
	protected int vertexInDegree;

	// Grau de saida do vertice
	protected int vertexOutDegree;
	
	/**
	 * Construtor padrão. Inicializa o vértice com o ID e degree = 0.
	 * @param vertexID ID do vertice
	 */
	public Vertex(int vertexID) {
		this.vertexID = vertexID;
		this.vertexInDegree = 0;
		this.vertexOutDegree = 0;
	}
	
	/**
	 * Construtor que inicializa todos os campos.
	 * @param vertexID ID do vertice
	 * @param vertexInDegree Grau de entrada do vertice
	 * @param vertexOutDegree Grau de saida do vertice
	 */
	public Vertex(int vertexID, int vertexInDegree, int vertexOutDegree) {
		this.vertexID = vertexID;
		this.vertexInDegree = vertexInDegree;
		this.vertexOutDegree = vertexOutDegree;
	}
	
	/**
	 * Incrementa o grau de entrada do vértice em uma unidade.
	 */
	public void increaseInDegree() {
		this.vertexInDegree += 1;
	}
	
	/**
	 * Decrementa o grau de entrada do vértice em uma unidade.
	 */
	public void decreaseInDegree() {
		if(this.vertexInDegree - 1 >= 0) {
			this.vertexInDegree -= 1;
		}
	}
	
	/**
	 * Incrementa o grau de saida do vértice em uma unidade.
	 */
	public void increaseOutDegree() {
		this.vertexOutDegree += 1;
	}
	
	/**
	 * Decrementa o grau de saida do vértice em uma unidade.
	 */
	public void decreaseOutDegree() {
		if(this.vertexOutDegree - 1 >= 0) {
			this.vertexOutDegree -= 1;
		}
	}

	public int getVertexID() {
		return vertexID;
	}

	public void setVertexID(int vertexID) {
		this.vertexID = vertexID;
	}

	public int getVertexOutDegree() {
		return vertexOutDegree;
	}

	public void setVertexOutDegree(int vertexDegree) {
		if(vertexDegree >= 0) {
			this.vertexOutDegree = vertexDegree;
		}
	}

	public int getVertexInDegree() {
		return vertexInDegree;
	}

	public void setVertexInDegree(int vertexInDegree) {
		this.vertexInDegree = vertexInDegree;
	}

}