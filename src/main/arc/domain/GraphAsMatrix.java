package main.arc.domain;

/**
 * Classe abstrata para grafos que utilizam matriz de adjacencia.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 07.06.2015
 */

public abstract class GraphAsMatrix extends Graph {
	
	// Matriz de adjacencia
	protected int[][] adjMatrix;
	
	// Contador de arestas
	protected int edgeCounter;
	
	// Tamanho do grafo
	protected int size;
	
	public GraphAsMatrix(int size) {
		// TODO Auto-generated constructor stub
		this.edgeCounter = 0;
		this.size = size;
		this.adjMatrix = new int[size][size];
		
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				this.adjMatrix[i][j] = 0;
			}
		}
	}
	
	@Override
	public void connectVertices(Vertex v1, Vertex v2) throws Exception {
		// TODO Auto-generated method stub
		if(super.vertices.contains(v1) && super.vertices.contains(v2) && !isEdge(v1, v2)){
			this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)] = 1;
			v1.increaseOutDegree();
			v2.increaseInDegree();
			this.edgeCounter++;
		}
		else {
			throw new Exception("Conexão inválida! Vértices não existentes ou aresta já"
					+ "inserida anteriormente");
		}
		if(super.vertices.contains(v1) && super.vertices.contains(v2) && !isEdge(v2, v1)){
			this.adjMatrix[super.vertices.indexOf(v2)][super.vertices.indexOf(v1)] = 1;
			v2.increaseOutDegree();
			v1.increaseInDegree();
			this.edgeCounter++;
		}
		else {
			throw new Exception("Conexão inválida! Vértices não existentes ou aresta já"
					+ "inserida anteriormente");
		}
	}
	
	@Override
	public void disconnectVertices(Vertex v1, Vertex v2) throws Exception {
		// TODO Auto-generated method stub
		if((super.vertices.contains(v1) && super.vertices.contains(v2)) && isEdge(v1, v2)){
			this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)] = 0;
			v1.decreaseOutDegree();
			v2.decreaseInDegree();
			this.edgeCounter--;
		}
		else {
			throw new Exception("Vertices ou a aresta não existem!");
		}
		if((super.vertices.contains(v1) && super.vertices.contains(v2)) && isEdge(v2, v1)){
			this.adjMatrix[super.vertices.indexOf(v2)][super.vertices.indexOf(v1)] = 0;
			v2.decreaseOutDegree();
			v1.decreaseInDegree();
			this.edgeCounter--;
		}
		else {
			throw new Exception("Vertices ou a aresta não existem!");
		}
	}
	
	@Override
	public void removeAllConnections() {
		// TODO Auto-generated method stub
		for(int i = 0; i < super.vertices.size(); i++){
			for(int j = 0; j < super.vertices.size(); j++){
				this.adjMatrix[i][j] = 0;
			}
		}
	}
	
	@Override
	public boolean isEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		if(this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)] == 1)
			return true;
		return false;
	}
	
	public boolean isEdge(int id1, int id2){
		if(this.adjMatrix[id1][id2] == 1)
			return true;
		return false;
	}
	
	public int[][] getMatrix(){
		return this.adjMatrix;
	}

	public int getEdgeCounter() {
		return edgeCounter;
	}

	public int[][] getAdjMatrix() {
		return adjMatrix;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}