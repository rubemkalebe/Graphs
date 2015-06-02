package main.java.parnatalOnline.src;

import java.io.FileWriter;
import java.io.IOException;

import main.arc.domain.Edge;
import main.arc.iterator.Iterator;

/**
 * A classe WriteResultsToFile é responsável por salvar informações importantes sobre
 * a simulação em um arquivo.
 * 
 */

public class WriteResultsToOUT {

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
            Iterator it = best.getBest().createEdgeIterator(); 
            writer.write("Menor custo: " + Integer.toString(best.getBest().getTotalCost()) + "\n");
            writer.write("Árvore de menor custo: ");
            while(it.hasNext()) {
            	Edge e = (Edge) it.next();
            	writer.write(Integer.toString(e.getVertexA().getVertexID()) + "-" + Integer.toString(e.getVertexB().getVertexID()));
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