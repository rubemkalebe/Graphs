package main.arc.iterator;

import main.arc.domain.Edge;

/**
 * Classe abstrata para iteradores de arestas.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public abstract class AbstractEdgeIterator {

	// Indice atual
	protected int index;
	
	
	/**
	 * Construtor padrão. 
	 */
	public AbstractEdgeIterator() {
		this.index = 0;
	}
	
	/**
	 * Retorna a primeira aresta da estrutura.
	 * @return Primeira aresta
	 */
	public abstract Edge first();
	
	/**
	 * 
	 * @return true se ainda existem elementos a serem percorridos, false caso contrário
	 */
	public abstract boolean hasNext();
	
	/**
	 * 
	 * @return A proxima aresta
	 */
	public abstract Edge next();
	
	/**
	 * 
	 * @return O indice atual do iterador
	 */
	public int getIndex() {
		return index;
	}
	
}
