package main.arc.domain;

public abstract class Edge {

	private Vertex vertexA;
	
	private Vertex vertexB;
	
	private int edgeID;
	
	private int edgeCost;
	
	public Edge(Vertex v1, Vertex v2, int edgeID) {
		vertexA = v1;
		vertexB = v2;
		this.edgeID = edgeID;
	}
	
	public Edge(Vertex v1, Vertex v2, int edgeID, int edgeCost) {
		vertexA = v1;
		vertexB = v2;
		this.edgeID = edgeID;
		this.edgeCost = edgeCost;
	}

	public Vertex getVertexA() {
		return vertexA;
	}

	public void setVertexA(Vertex vertexA) {
		this.vertexA = vertexA;
	}

	public Vertex getVertexB() {
		return vertexB;
	}

	public void setVertexB(Vertex vertexB) {
		this.vertexB = vertexB;
	}

	public int getEdgeID() {
		return edgeID;
	}

	public void setEdgeID(int edgeID) {
		this.edgeID = edgeID;
	}

	public int getEdgeCost() {
		return edgeCost;
	}

	public void setEdgeCost(int edgeCost) {
		this.edgeCost = edgeCost;
	}
	
}
