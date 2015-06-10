package main.arc.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import main.arc.domain.Graph;

/**
 * Interface para salvar grafos.
 * 
 * @author Pedro Coelho
 * @author Rubem Kalebe
 * @version 29.05.2015
 */

public abstract class GraphDAO {
	protected GenerateXML gen;
	protected ReaderXML read;
	
	/**
	 * Método responsável por salvar um grafo
	 * @param g Grafo a ser salvo
	 * @param path Caminho para onde arquivo devera ser salvo
	 * @throws IOException 
	 */
	public void saveGraph(Graph g, String path) throws IOException{
		gen = new GenerateXML(g);
		BufferedWriter out = new BufferedWriter(new FileWriter(path));
		
		try{
			out.write(gen.getXML().toString());
			out.flush();
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
			System.err.println("Erro ao salvar o arquivo!");
		}
		
	}
	
	public Graph loadGraph(String path){
		read = new ReaderXML();
		read.init(path);
		return read.getGraph();
	}
	
}
