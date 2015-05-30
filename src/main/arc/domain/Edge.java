package main.arc.domain;

/**
 * Classe que modela uma aresta.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public class Edge {

	// Vertice de uma extremidade
	private Vertex vertexA;
	
	// Vertice de outra extremidade
	private Vertex vertexB;
	
	// Identificador da aresta
	private int edgeID;
	
	// Custo/peso da aresta (0 caso não tenha peso/custo)
	private int edgeWeight;
	
	// Booleano que identifica se a aresta é direcionada
	private boolean _isDirected;
	
	/**
	 * Construtor padrão com os vértices das extremidades e o ID da aresta.
	 * @param v1 Vertice de uma extremidade
	 * @param v2 Vertice de outra extremidade
	 * @param edgeID Identificador da aresta
	 * @param _isDirected Especifica se a aresta é orientada ou não
	 */
	public Edge(Vertex v1, Vertex v2, int edgeID, boolean _isDirected) {
		this.vertexA = v1;
		this.vertexB = v2;
		this.edgeID = edgeID;
		this._isDirected = _isDirected;
		this.edgeWeight = 0;
	}
	
	/**
	 * Construtor completo para uma aresta.
	 * @param v1 Vertice de uma extremidade
	 * @param v2 Vertice de outra extremidade
	 * @param edgeID Identificador da aresta
	 * @param edgeWeight Peso/custo da aresta
	 * @param _isDirected Especifica se a aresta é orientada ou não
	 */
	public Edge(Vertex v1, Vertex v2, int edgeID, int edgeWeight, boolean _isDirected) {
		this.vertexA = v1;
		this.vertexB = v2;
		this.edgeID = edgeID;
		this.edgeWeight = edgeWeight;
		this._isDirected = _isDirected;
	}

	/**
	 * 
	 * @return true se a aresta for direcionada, false caso contrário.
	 */
	public boolean isEDirected() {
		return _isDirected;
	}
	
	/**
	 * Retorna o vértice da outra extremidade.
	 * @param v Vertice de uma extremidade
	 * @return o vértice da outra extremidade
	 */
	public Vertex getConnectedVertex(Vertex v) throws Exception {
		if(v == vertexA) {
			return vertexB;
		} else if(v == vertexB) {
			return vertexA;
		} else {
			throw new Exception("O vértice não está presenta nesta aresta");
		}
	}
	
	@Override
	public String toString() {
		return null; // --------
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
		return edgeWeight;
	}

	public void setEdgeCost(int edgeCost) {
		this.edgeWeight = edgeCost;
	}

	public void set_isDirected(boolean _isDirected) {
		this._isDirected = _isDirected;
	}
	
}
