package main.arc.domain;

public abstract class Vertex {

	// Identificador do vertice
	private int vertexID;
	
	// Grau do vertice
	private int vertexDegree;
	
	public Vertex(int vertexID) {
		this.vertexID = vertexID;
	}
	
	public Vertex(int vertexID, int vertexDegree) {
		this.vertexID = vertexID;
		this.vertexDegree = vertexDegree;
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
		this.vertexDegree = vertexDegree;
	}

}
