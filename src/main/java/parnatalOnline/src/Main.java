/**
 * Essa é a classe principal do projeto.
 * 
 * @author Lilian Ketlyn
 * @author Rubem Kalebe
 * @version 14.03.2015
 */

public class Main {

	public static void main(String[] args) {
		
		if(args.length > 0) {
			FileLoader loader = new FileLoader(args[0]);
			loader.readNetworkInfo();
			CostMatrix costMatrix = new CostMatrix(Network.getVertexMax());
			loader.readCostMatrix(costMatrix);
			BestNetwork best = new BestNetwork(costMatrix);
			best.findBest();
			WriteResultsToOUT writer = new WriteResultsToOUT();
			writer.writeToFile(best);
			System.out.println("Menor custo: " + best.getBest().totalCost());
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
