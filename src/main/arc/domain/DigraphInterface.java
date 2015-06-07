package main.arc.domain;

import main.arc.iterator.Iterator;

/**
 * Interface para dígrafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 07.06.2015
 */

public interface DigraphInterface {
	
	/**
	 * @return true se o dígrafo é fortemente conexo, ou false caso contrário
	 */
	public boolean isStronglyConnected();
	
	/**
	 * @return Iterador para UMA possível ordenação topológica do dígrafo
	 * @throws Exception Caso haja ciclo na estrutura (evitando loops infinitos)
	 */
	public Iterator topologicalOrderTraversal() throws Exception;
}
