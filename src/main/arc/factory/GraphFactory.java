package main.arc.factory;

import main.arc.domain.GraphInterface;

/**
 * Interface comum a fábricas de grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public interface GraphFactory {

	/**
	 * Cria um grafo aleatório seguindo certas propriedades e restrições.
	 * @return O grafo criado
	 */
	public GraphInterface generateGraph();
	
}
