package main.arc.domain;

import java.util.ArrayList;

import main.arc.iterator.ListEdgeIterator;

/**
 * Classe abstrata para grafos que utilizam listas de arestas.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 07.06.2015
 */

public abstract class GraphAsList extends Graph {
	
	// Lista de arestas
	protected ArrayList<Edge> edgeList;
	
	// Contador de arestas
	protected int edgeCounter;
	
	public GraphAsList() {
		// TODO Auto-generated constructor stub
		super();
		this.edgeCounter = 0;
		edgeList = new ArrayList<Edge>();
	}
	
	@Override
	public void connectVertices(Vertex v1, Vertex v2) throws Exception{
		// TODO Auto-generated method stub
		if(super.vertices.contains(v1) && super.vertices.contains(v2) && !isEdge(v1, v2)){
			this.edgeList.add(new Edge(v1, v2, this.edgeCounter++, false));
			v1.increaseOutDegree();
			v2.increaseInDegree();
		}
		else {
			throw new Exception("Conexão inválida! Vértices não existentes ou aresta já"
					+ "inserida anteriormente");
		}
		if(super.vertices.contains(v1) && super.vertices.contains(v2) && !isEdge(v2, v1)){
			this.edgeList.add(new Edge(v2, v1, this.edgeCounter++, false));
			v2.increaseOutDegree();
			v1.increaseInDegree();
		}
		else {
			throw new Exception("Conexão inválida! Vértices não existentes ou aresta já"
					+ "inserida anteriormente");
		}
	}
	
	/**
	 * Adiciona uma aresta diretamente no grafo.
	 * @param e Aresta a ser inserida
	 * @throws Exception se algum dos vértices não tiver presente na estrutura
	 */
	public void addEdge(Edge e) throws Exception {
		if(super.vertices.contains(e.getVertexA()) && super.vertices.contains(e.getVertexB()) &&
				!super.vertices.contains(getEdge(e.getVertexA(), e.getVertexB()))) {
			e.setEdgeID(this.edgeCounter);
			this.edgeList.add(e);
			e.getVertexA().increaseOutDegree();
			e.getVertexB().increaseInDegree();
			this.edgeCounter += 1;
		} else {
			throw new Exception("Vertices não existem!");
		}
		if(super.vertices.contains(e.getVertexA()) && super.vertices.contains(e.getVertexB()) &&
				!super.vertices.contains(getEdge(e.getVertexB(), e.getVertexA()))) {
			this.edgeList.add(new Edge(e.getVertexB(), e.getVertexA(), this.edgeCounter, false));
			e.getVertexB().increaseOutDegree();
			e.getVertexA().increaseInDegree();
			this.edgeCounter += 1;
		} else {
			throw new Exception("Vertices não existem!");
		}
	}
	
	@Override
	public void disconnectVertices(Vertex v1, Vertex v2) throws Exception{
		// TODO Auto-generated method stub
		if((super.vertices.contains(v1) && super.vertices.contains(v2)) && isEdge(v1, v2)){
			Edge e = this.getEdge(v1, v2);
			this.edgeList.remove(e);
			v1.decreaseOutDegree();
			v2.decreaseInDegree();
		} else {
			throw new Exception("Vertices ou a aresta não existem!");
		}
		if((super.vertices.contains(v1) && super.vertices.contains(v2)) && isEdge(v2, v1)){
			Edge e = this.getEdge(v2, v1);
			this.edgeList.remove(e);
			v2.decreaseOutDegree();
			v1.decreaseInDegree();
		} else {
			throw new Exception("Vertices ou a aresta não existem!");
		}
	}
	
	/**
	 * Remove uma aresta diretamente no grafo.
	 * @param e Aresta a ser removida
	 * @throws Exception Caso a aresta não esteja presente na estrutura
	 */
	public void removeEdge(Edge e) throws Exception {
		if(edgeList.contains(e)) {
			edgeList.remove(e);
			e.getVertexA().decreaseOutDegree();
			e.getVertexB().decreaseInDegree();
		} else {
			throw new Exception("Aresta não existe!");
		}
		if(edgeList.contains(getEdge(e.getVertexB(), e.getVertexA()))) {
			edgeList.remove(getEdge(e.getVertexB(), e.getVertexA()));
			e.getVertexB().decreaseOutDegree();
			e.getVertexA().decreaseInDegree();
		} else {
			throw new Exception("Aresta não existe!");
		}
	}
	
	@Override
	public void removeAllConnections() {
		// TODO Auto-generated method stub
		if(!this.edgeList.isEmpty())
			this.edgeList.clear();
	}
	
	public Edge getEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		for(int i = 0; i < this.edgeList.size(); i++){
			if(this.edgeList.get(i).getVertexA() == v1){
				if(this.edgeList.get(i).getVertexB() == v2){
					return this.edgeList.get(i);
				}
			}
		}		
		return null;
	}
	
	@Override
	public boolean isEdge(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		if(this.getEdge(v1, v2) != null){
			return true;
		}
		return false;
	}
	
	public main.arc.iterator.Iterator createEdgeIterator() {
		return new ListEdgeIterator(edgeList);
	}

	public ArrayList<Edge> getEdgeList() {
		return edgeList;
	}

	public void setEdgeList(ArrayList<Edge> edgeList) {
		this.edgeList = edgeList;
	}

	public int getEdgeCounter() {
		return edgeCounter;
	}

	public void setEdgeCounter(int edgeCounter) {
		this.edgeCounter = edgeCounter;
	}

}