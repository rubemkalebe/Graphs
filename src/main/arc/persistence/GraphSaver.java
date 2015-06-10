package main.arc.persistence;

import main.arc.domain.Graph;

/**
 * Interface para salvar grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public interface GraphSaver {

	/**
	 * Método responsável por salvar um grafo em um arquivo.
	 * @param g Grafo a ser salvo
	 * @param path Caminho para onde arquivo devera ser salvo
	 */
	public void saveGraph(Graph g, String path); 
	
}
