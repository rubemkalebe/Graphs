package main.arc.domain;

import main.arc.visitor.VisitorInterface;

/**
 * Interface para dígrafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 01.06.2015
 */

public interface DigraphInterface {
	
	/**
	 * @return true se o dígrafo é fortemente conexo, ou false caso contrário
	 */
	public boolean isStronglyConnected();
	
	/**
	 * Ordenação topológica do dígrafo (UMA possível ordem topológica).
	 * @param vis Visitante
	 */
	public void topologicalOrderTraversal(VisitorInterface vis);
}
