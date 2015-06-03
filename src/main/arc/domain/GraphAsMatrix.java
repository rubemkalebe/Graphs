package main.arc.domain;

public abstract class GraphAsMatrix extends Graph {
	private int[][] adjMatrix;
	private int edgeCounter;
	
	public GraphAsMatrix() {
		// TODO Auto-generated constructor stub
		this.edgeCounter = 0;
		this.adjMatrix = new int[super.vertices.size()][super.vertices.size()];
		
		for(int i =0; i< super.vertices.size(); i++){
			for(int j =0; j < super.vertices.size(); j++){
				this.adjMatrix[i][j] = 0;
			}
		}
	}
	
	@Override
	public void connectVertices(Vertex v1, Vertex v2) throws Exception {
		// TODO Auto-generated method stub
		if(super.vertices.contains(v1) && super.vertices.contains(v2)){
			this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)] = 1;
			this.adjMatrix[super.vertices.indexOf(v2)][super.vertices.indexOf(v1)] = this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)];
			this.edgeCounter++;
		}
		else
			throw new Exception("Vertices não existem!");
	}
	
	@Override
	public void disconnectVertices(Vertex v1, Vertex v2) throws Exception {
		// TODO Auto-generated method stub
		if(super.vertices.contains(v1) && super.vertices.contains(v2)){
			this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)] = 0;
			this.adjMatrix[super.vertices.indexOf(v2)][super.vertices.indexOf(v1)] = this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)];
		}
		else
			throw new Exception("Vertices não existem!");
	}
	
	@Override
	public void removeAllConnections() {
		// TODO Auto-generated method stub
		for(int i =0; i< super.vertices.size(); i++){
			for(int j =0; j < super.vertices.size(); j++){
				this.adjMatrix[i][j] = 0;
			}
		}
	}
	
	@Override
	public boolean isDirected() {
		// TODO Auto-generated method stub
		for(int i =0; i < super.vertices.size(); i++){
			for(int j =0; j < super.vertices.size(); j++){
				if(i != j){
					if(this.isEdge(i, j) && !this.isEdge(j, i))
						return false;
				}
			}
		}
		return true;
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

}
