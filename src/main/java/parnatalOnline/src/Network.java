package main.java.parnatalOnline.src;

import java.util.ArrayList;

import main.arc.domain.Edge;
import main.arc.domain.GraphAsList;

/**
 * A classe Network representa uma árvore (rede) de distribuição válida.
 * 
 */

public class Network extends GraphAsList {

	// Quantidade máxima de vértices (residencias)
	private int vertexMax;
	
	// Grau máximo de um vértice
	private int degreeMax;

	// Custo da solução
	private int totalCost;
	
	// Estrutura union-find para verificar ciclos na solução
	private UnionFind uf;
	
	/**
	 * Construtor padrão.
	 */
	public Network(int vertexMax, int degreeMax) {
		super();
		this.vertexMax = vertexMax;
		this.degreeMax = degreeMax;
		uf = new UnionFind(vertexMax);
		totalCost = 0;
	}
	
	/**
	 * Adiciona uma conexão/aresta na rede de distribuição.
	 * @param e Aresta/conexão a ser adicionada
	 * @return true se ela pode/foi adicionada ou false, caso contrário
	 */
	public boolean addConnection(Edge e) {
		if(((e.getVertexA().getVertexOutDegree() < degreeMax) && (e.getVertexB().getVertexInDegree() < degreeMax))
				&& (!uf.same_component(e.getVertexA().getVertexID(), e.getVertexB().getVertexID()))) {
			try {
				addEdge(e);
				totalCost += e.getEdgeCost();
				uf.union(e.getVertexA().getVertexID(), e.getVertexB().getVertexID());
				return true;
			} catch(Exception ex) {
				// do nothing
			}
		}
		return false;
	}
	
	/**
	 * Remove a última conexão/aresta do vetor e atualiza as informações da rede.
	 */
	public void removeConnection() {
		try {
			totalCost -= this.edgeList.get(this.edgeList.size() - 1).getEdgeCost();
			this.removeEdge(this.edgeList.get(this.edgeList.size() - 1));
		} catch(Exception ex) {
			// do nothing
		}
		uf = new UnionFind(vertexMax);
		for(Edge edge : edgeList) {
			edge = (Edge) edge;
			uf.union(edge.getVertexA().getVertexID(), edge.getVertexB().getVertexID());
		}
	}
	
	/**
	 * Adiciona uma rede de distribuição; Troca as informações atuais pelas novas.
	 * @param tree Nova rede de distribuição
	 */
	public void changeNetwork(Network tree) {
		if(tree != null) {
			this.edgeList = new ArrayList<Edge>(tree.getEdgeList());
			this.vertexMax = tree.getVertexMax();
			this.degreeMax = tree.getDegreeMax();
			this.totalCost = tree.getTotalCost();
			this.uf = tree.getUf();
		}
	}
	
	/**
	 * 
	 * @return Retorna a quantidade máxima de vértices (casa)
	 */
	public int getVertexMax() {
		return vertexMax;
	}
	
	/**
	 * 
	 * @return Grau máximo de um vértice
	 */
	public int getDegreeMax() {
		return degreeMax;
	}
	
	/**
	 * Atribui a quantidade máxima de vértices (casa) a partir do arquivo.
	 * @param n Quantidade máxima de vértices (casa)
	 */
	public void setVertexMax(int n) {
		vertexMax = n;
	}
	
	/**
	 * Atribui grau máximo de um vértice.
	 * @param d Grau máximo de um vértice
	 */
	public void setDegreeMax(int d) {
		degreeMax = d;
	}
	
	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public UnionFind getUf() {
		return uf;
	}

	public void setUf(UnionFind uf) {
		this.uf = uf;
	}
	
}