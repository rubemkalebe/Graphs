package main.arc.domain;

import java.util.ArrayList;

import main.arc.iterator.AbstractEdgeIterator;
import main.arc.iterator.AbstractVertexIterator;
import main.arc.visitor.PreInPostVisitorInterface;
import main.arc.visitor.VisitorInterface;

/**
 * Interface para grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 01.06.2015
 */

public interface GraphInterface {

	/**
	 * Adiciona um vértice no grafo.
	 * @param v Vertice a ser adicionado
	 * @throws Exception 
	 */
	public void addVertex(Vertex v) throws Exception;
	
	/**
	 * Remove um vértice no grafo.
	 * @param v Vertice a ser removido
	 * @throws Exception 
	 */
	public void removeVertex(Vertex v) throws Exception;
	
	/**
	 * Remove um vértice no grafo pelo identificador do mesmo.
	 * @param id Identificador do vertice a ser removido
	 */
	public void removeVertex(int id) throws IndexOutOfBoundsException;

	/**
	 * Conecta dois vértices. Caso algum deles não esteja na estrutura será adicionado.
	 * @param v1 Vertice de uma extremidade
	 * @param v2 Vertice de outra extremidade
	 * @throws Exception 
	 */
	public void connectVertices(Vertex v1, Vertex v2) throws Exception;
	
	/**
	 * Disconecta dois vértices.
	 * @param v1 Vertice de uma extremidade
	 * @param v2 Vertice de outra extremidade
	 */
	public void disconnectVertices(Vertex v1, Vertex v2) throws Exception;
	
	/**
	 * Remove todas as arestas.
	 */
	public void removeAllConnections();
	
	/**
	 * Verifica se o grafo é conexo.
	 * @return true se o grafo é conexo, false caso contrário
	 */
	public boolean isConnected();
	
	/**
	 * Verifica se o grafo é cíclico.
	 * @return true se o grafo é cíclico, false caso contrário
	 */
	public boolean isCyclic();
	
	/**
	 * Verifica se o grafo é direcionado.
	 * @return true se o grafo é direcionado, false caso contrário
	 */
	public boolean isDirected();
	
	/**
	 * Verifica se os vértices constituem uma aresta, caso estejam na estrutura.
	 * @param v1 Vertice de uma extremidade
	 * @param v2 Vertice de outra extremidade
	 * @return true se os vértices constituem uma aresta, false caso contrário
	 */
	public boolean isEdge(Vertex v1, Vertex v2) throws Exception;
	
	/**
	 * @return Iterador para percorrer as arestas da estrutura
	 */
	public AbstractEdgeIterator createEdgeIterator();
	
	/**
	 * @return Iterador para percorrer os vértices da estrutura
	 */
	public AbstractVertexIterator createVertexIterator();
	
	/**
	 * Realiza percurso em largura em toda a estrutura.
	 * @param vis Visitante
	 */
	public void breadthFirstTraversal(VisitorInterface vis);
	
	/**
	 * Realiza percurso em largura a partir de um vértice.
	 * @param vis Visitante
	 * @param v Vertice inicial
	 */
	public void breadthFirstTraversal(VisitorInterface vis, Vertex v);
	
	/**
	 * Realiza percurso em profundidade em toda a estrutura.
	 * @param vis Visitante
	 */
	public void depthFirstTraversal(PreInPostVisitorInterface vis);
	
	/**
	 * Realiza percurso em profundidade a partir de um vértice.
	 * @param vis Visitante
	 * @param v Vertice inicial
	 */
	public void depthFirstTraversal(PreInPostVisitorInterface vis, Vertex v);
	
	/**
	 * 
	 * @return Numero de arestas da estrutura
	 */
	public int getEdgesNumber();
	
	/**
	 * @return Numero de vertices da estrutura
	 */
	public int getVerticesNumber();
	
	/**
	 * Recupera um vértice a partir de seu identificador.
	 * @param id Identificador do vertice
	 * @return O vertice, caso exista
	 */
	public Vertex getVertex(int id);
	
	/**
	 * @return A estrutura que armazena os vertices
	 */
	public ArrayList<Vertex> getVertices();
	
}
