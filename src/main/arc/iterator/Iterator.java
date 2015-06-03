package main.arc.iterator;

/**
 * Classe abstrata para iteradores de arestas.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 03.06.2015
 */

public interface Iterator {	
	
	/**
	 * Retorna a primeira aresta da estrutura.
	 * @return Primeira aresta
	 */
	public Object first();
	
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
