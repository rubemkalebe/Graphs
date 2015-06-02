package main.java.parnatalOnline.src;

/**
 * Essa é a classe principal do projeto.
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		if(args.length > 0) {
			FileLoader loader = new FileLoader();
			CostMatrix costMatrix = new CostMatrix(loader.readVertexInfo(args[0]));
			BestNetwork best = new BestNetwork(costMatrix, loader.readVertexInfo(args[0]),
					loader.readDegreeInfo(args[0]));			
			loader.readCostMatrix(costMatrix, args[0]);
			best.findBest();
			WriteResultsToOUT writer = new WriteResultsToOUT();
			writer.writeToFile(best);
			System.out.println("Menor custo: " + best.getBest().getTotalCost());
			System.out.println("Soluções válidas: " + best.getSolutions());
			System.out.println("Tempo total gasto na busca pela solução: " +
            		best.getExecutionTime() + "ms");
			System.out.println("**Fim de execução**");	
		} else {
			System.err.println("Essa versão só funciona a partir da leitura de um arquivo!" +
					" Caso não tenha um arquivo, você pode enviar o arquivo de teste padrão" +
					" localizado em tests/in1.in");
		}
		
	}
	
}
