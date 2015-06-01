package main.arc.domain;

/**
 * Classe abstrata para vértices.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 01.06.2015
 */

public abstract class Vertex {

	// Identificador do vertice
	protected int vertexID;
	
	// Grau do vertice
	protected int vertexDegree;
	
	/**
	 * Construtor padrão. Inicializa o vértice com o ID e degree = 0.
	 * @param vertexID ID do vertice
	 */
	public Vertex(int vertexID) {
		this.vertexID = vertexID;
		this.vertexDegree = 0;
	}
	
	/**
	 * Construtor que inicializa o vértice com o ID e degree especificados.
	 * @param vertexID ID do vertice
	 * @param vertexDegree Grau do vertice
	 */
	public Vertex(int vertexID, int vertexDegree) {
		this.vertexID = vertexID;
		this.vertexDegree = vertexDegree;
	}
	
	/**
	 * Incrementa o grau do vértice em uma unidade.
	 */
	public void increaseDegree() {
		this.vertexDegree += 1;
	}
	
	/**
	 * Decrementa o grau do vértice em uma unidade.
	 */
	public void decreaseDegree() {
		if(this.vertexDegree - 1 >= 0) {
			this.vertexDegree -= 1;
		}
	}

	public int getVertexID() {
		return vertexID;
	}

	public void setVertexID(int vertexID) {
		this.vertexID = vertexID;
	}

	public int getVertexDegree() {
		return vertexDegree;
	}

	public void setVertexDegree(int vertexDegree) {
		if(vertexDegree >= 0) {
			this.vertexDegree = vertexDegree;
		}
	}

}
