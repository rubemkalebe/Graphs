package main.java.parnatalOnline.src;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Savepoint;
import java.util.Vector;

import main.arc.persistence.GraphSaver;

/**
 * Classe responsável por salvar as conexões da rede em um arquivo XML, o que é
 * necessário para a exibir a árvore de maneira gráfica.
 * 
 */

public class GenerateXML implements GraphSaver {

	/**
	 * Método responsável por gerar o arquivo XML que servirá de base para o grafo que
	 * será criado pelo framework PREFUSE.
	 * 
	 * Salva as conexões da rede.
	 * 
	 * @param best Melhor rede de distribuição
	 */
	public void writeToFile(BestNetwork best) {
		StringBuffer arquivo = new StringBuffer(
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\"\n" +
				" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
				" xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns\n" +
				"  http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd\">\n" +
				"<graph id=\"G\" edgedefault=\"undirected\">\n"				
				);
		for(int i = 1; i <= Network.getVertexMax(); i++) {
			arquivo.append(" <node id=\"" + String.valueOf(i) + "\"/>\n");
		}
		Vector<Edge> links = new Vector<Edge>(best.getBest().getTree()); 
        for(Edge edge : links) {
        	edge = (Connection) edge;
        	arquivo.append(" <edge source=\"" + String.valueOf(edge.getInicial().getID()) + "\" target=\"" + String.valueOf(edge.getTerminal().getID()) + "\"/>\n");
        }
		arquivo.append("</graph>\n");
		arquivo.append("</graphml>");
		final String filename = "BestNetwork.xml";
		try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(arquivo.toString());
            out.flush();
            out.close();
	    } catch (IOException e) {
	    	System.err.println("Erro ao salvar arquivo \' " + filename + "\'");
	    }
	}
	
}
