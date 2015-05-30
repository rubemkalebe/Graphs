package main.java.parnatalOnline.src;

/**
 * A classe Matrix é responsável por armazenar a matriz de custos necessária para a
 * criação de conexões entre as casas de Parnatal.
 * 
 */

public class CostMatrix {

	// Matriz de custos
	private int[][] matrix;
	
	/**
	 * Construtor para a matriz de custos.
	 * @param n Tamanho da matriz
	 * @throws java.lang.IllegalArgumentException se n < 0
	 */
	public CostMatrix(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("Tamanho inválido para a matriz!");
		}
		matrix = new int[n][n];
	}
	
	/**
	 * 
	 * @return Retorna a matriz de custos
	 */
	public int[][] getMatrix() {
		return matrix;
	}
	
	/**
	 * Retorna o custo na posição (i,j).
	 * @param i Linha da matriz
	 * @param j Coluna da matriz
	 * @return Custo na posição (i, j)
	 */
	public int getElement(int i, int j) {
		return matrix[i][j];
	}
	
	/**
	 * Altera a matriz de custos.
	 * @param matrix Nova matriz de custos
	 */
	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}
	
	/**
	 * Insere um elemento em uma célula específica da matriz.
	 * @param i Linha da matriz (0...n-1)
	 * @param j Coluna da matriz (0...n-1)
	 * @param x Elemento a ser inserido
	 */
	public void setElement(int i, int j, int x) {
		matrix[i][j] = x;
	}
	
	/**
	 * 
	 * @return Retorna o tamanho da matriz
	 */
	public int size() {
		return matrix.length;
	}

}