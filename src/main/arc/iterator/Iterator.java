package main.arc.iterator;

/**
 * Classe abstrata para iteradores de arestas.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 09.06.2015
 */

public interface Iterator {
	
	/**
	 * 
	 * @return true se ainda existem elementos a serem percorridos, false caso contrário
	 */
	public boolean hasNext();
	
	/**
	 * 
	 * @return A proxima aresta
	 */
	public Object next(); 
	
}
