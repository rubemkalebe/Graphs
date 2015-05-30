package main.java.parnatalOnline.src;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import main.arc.persistence.GraphSaver;

/**
 * A classe WriteResultsToFile é responsável por salvar informações importantes sobre
 * a simulação em um arquivo.
 * 
 */

public class WriteResultsToOUT implements GraphSaver {

	/**
	 * Salva informações sobre a melhor rede de distribuição no arquivo "BestSolution.out";
	 * 
	 * Informações a serem salvas: vetor de arestas, quantidade de soluções válidas
	 * geradas e tempo gasto na obtenção da solução.
	 * 
	 */
	public void writeToFile(BestNetwork best) {
		final String filename = "BestSolution.out";
		try {			
            FileWriter writer = new FileWriter(filename);
            Vector<Edge> links = new Vector<Edge>(best.getBest().getTree()); 
            writer.write("Menor custo: " + Integer.toString(best.getBest().totalCost()) + "\n");
            writer.write("Árvore de menor custo: ");
            for(Edge edge : links) {
            	edge = (Connection) edge;
            	writer.write(Integer.toString(edge.getInicial().getID()) + "-" + Integer.toString(edge.getTerminal().getID()));
            	writer.write(' ');
            }
            writer.write('\n');
            writer.write("Soluções válidas geradas: " + 
            		Integer.toString(best.getSolutions()) + "\n");
            writer.write("Tempo total gasto na busca pela solução: " +
            		Long.toString(best.getExecutionTime()) + "ms");
            writer.close();
        }
        catch(IOException e) {
            System.err.println("Erro ao salvar arquivo \' " + filename + "\'");
        }
	}
	
}
