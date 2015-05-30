package main.arc.domain;

/**
 * Interface para grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
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
	 * Verifica se os vértices constituem uma aresta.
	 * @param v1 Vertice de uma extremidade
	 * @param v2 Vertice de outra extremidade
	 * @return true se os vértices constituem uma aresta, false caso contrário
	 */
	public boolean isEdge(Vertex v1, Vertex v2);
}
