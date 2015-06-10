package main.arc.persistence;

import main.arc.domain.Graph;

/**
 * Interface para carregar grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public interface GraphLoader {

	/**
	 * Método responsável por carregar um grafo a partir de um arquivo.
	 * @param path Caminho para o arquivo
	 * @return O grafo construído a partir da leitura
	 */
	public Graph loadFile(String path);
	
}
