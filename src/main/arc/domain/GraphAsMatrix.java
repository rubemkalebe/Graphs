package main.arc.domain;

public class GraphAsMatrix extends Graph {
	private int[][] adjMatrix;
	private int edgeCounter;
	
	public GraphAsMatrix() {
		// TODO Auto-generated constructor stub
		this.edgeCounter = 0;
		this.adjMatrix = new int[super.verticeNumber][super.verticeNumber];
		
		for(int i =0; i< super.verticeNumber; i++){
			for(int j =0; j < super.verticeNumber; j++){
				this.adjMatrix[i][j] = 0;
			}
		}
	}
	
	@Override
	public void addEdge(Vertex v1, Vertex v2) throws Exception{
		if(super.vertices.contains(v1) && super.vertices.contains(v2)){
			this.adjMatrix[super.vertices.indexOf(v1)][super.vertices.indexOf(v2)] = 1;
			this.edgeCounter++;
		}
		else
			throw new Exception("Vertices nao existem!");
	}
	
	public int[][] getMatrix(){
		return this.adjMatrix;
	}

}
