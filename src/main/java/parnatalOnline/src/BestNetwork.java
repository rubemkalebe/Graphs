package main.java.parnatalOnline.src;

/**
 * A classe BestNetwork é responsável por procurar a melhor solução, armazenando
 * dados sobre essa solução, como quantidade de soluções geradas e tempo gasto.
 * 
 */

public class BestNetwork {

	// Melhor árvore
	private Network bestTree;
	
	// Quantidade de soluções válidas geradas
	private int solutions;
	
	// Tempo gasto para encontrar solução
	private long executionTime;
	
	// Matriz de custos para o problema dado
	private CostMatrix costMatrix;
	
	/**
	 * Costrutor da classe; Inicializa campos e faz a leitura/preenchimento
	 * da matriz de custos para o problema dado.
	 * @param inputFilePath Caminho/Nome+extensão do arquivo
	 */
	public BestNetwork(CostMatrix costMatrix) {
		bestTree = new Network();
		solutions = 0;
		executionTime = 0;
		this.costMatrix = costMatrix;
	}
	
	/**
	 * Método responsável por procurar a melhor rede de distribuição.
	 *  
	 */
	public void findBest() {
		Connection[] link = new Connection[
		                           edges(Network.getVertexMax())]; // Número de rotas possíveis
																			// equivalente ao somatório de 1...n
		Network tree = new Network();
		Chronometer.start();
		initializeLinkVector(link);
		combinations(link, Network.getVertexMax()-1, 0, tree); // Computa as combinações de arestas possíveis
		Chronometer.stop();
		executionTime = Chronometer.elapsedTime();
	}
	
	/**
	 * Calcula o número de arestas
	 * @param n Número de vértice/casas
	 * @return Número de arestas/ligações/conexões diferentes na rede
	 */
	private int edges(int n) {
	    return (n * (n - 1)) / 2;
	}

	/**
	 * Inicializa vetor de conexões com todas as possíveis conexões entre as residências.
	 * @param link Vetor de conexões
	 */
	private void initializeLinkVector(Connection[] link) {
		int countEdges = 0; // Índice da aresta
		for(int i = 0; i < Network.getVertexMax(); i++) {
			for(int j = i; j < Network.getVertexMax(); j++) {
				if(i != j) {
					link[countEdges++] = new Connection(new Residence(i+1), 
							new Residence(j+1), countEdges, costMatrix.getElement(i, j));
				}
			}
		}
	}
	
	/**
	 * Método que computa as combinações de arestas possíveis.
	 * @param link Vetor de conexões/arestas
	 * @param size Número de arestas na árvore
	 * @param startPosition Posição de início no vetor link
	 * @param tree Objeto para armazenar a árvore que está sendo verificada
	 */
	private void combinations(Connection[] link, int size, int startPosition,
			Network tree) {
		if(size == 0) {
			if((solutions == 0) || (tree.totalCost() < bestTree.totalCost())) {			
				bestTree.changeNetwork(tree);
			}
			solutions++;
			return;
		}
		for(int i = startPosition; i <= link.length - size; i++) {
			if(tree.addConnection(link[i])) {
				combinations(link, size-1, i+1, tree);
				tree.removeConnection();
			} else {
				combinations(link, size, i+1, tree);
				return;
			}
		}
	}
	
	/**
	 * 
	 * @return Melhor árvore
	 */
	public Network getBest() {
		return bestTree;
	}
	
	/**
	 * 
	 * @return Quantidade de soluções válidas geradas
	 */
	public int getSolutions() {
		return solutions;
	}
	
	/**
	 * 
	 * @return Tempo gasto para encontrar solução
	 */
	public long getExecutionTime() {
		return executionTime;
	}
	
}