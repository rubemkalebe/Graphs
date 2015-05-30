package main.java.parnatalOnline.src;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Essa classe é responsável por ler as informações contidas em um arquivo.
 * 
 */

public class FileLoader {

	// Caminho do arquivo de entrada
	private String path;
	
	/**
	 * Construtor da classe de leitura de arquivo.
	 * @param path Caminho do arquivo a ser lido
	 */
	public FileLoader(String path) {
		this.path = path;
	}
	
	/**
	 * Lê a quantidade máxima de vértices (casas) e grau máximo a partir do arquivo.
	 * @throws java.util.NoSuchElementException Caso o arquivo esteja incompleto
	 */
	public void readNetworkInfo() {
		try {
			Scanner scan = new Scanner(new FileReader(path));
			if(scan.hasNextInt()) {
				Network.setVertexMax(scan.nextInt());
				if(scan.hasNextInt()) {
					Network.setDegreeMax(scan.nextInt());
					scan.close();
					return;
				}
			}
			System.err.println("Problema na leitura do arquivo \'" 
					+ path + "\'");
			scan.close();
			throw new NoSuchElementException("Estão faltando informações" +
					"sobre as restrinções da rede");
		} catch(FileNotFoundException e) {
			System.err.println("Erro ao abrir arquivo \'" + path + "\'");
		}
	}
	
	/**
	 * Método que preenche a matriz a partir dos dados do arquivo de entrada.
	 * @param matrix Matriz de custo a ser preenchida
	 * @throws java.util.NoSuchElementException Caso o arquivo esteja incompleto 
	 */
	@SuppressWarnings("unused")
	public void readCostMatrix(CostMatrix matrix) {
		try {
			int cX;
			Scanner scan = new Scanner(new FileReader(path));
			for(int i = 0; i < 2; i++) {
				// Ignorar 'n' e 'd' que não interessam a matriz
				if(scan.hasNextInt()) {
					int tmp = scan.nextInt();
				} else {
					System.err.println("Problema na leitura do arquivo \'" 
							+ path + "\'");
					scan.close();
					throw new NoSuchElementException("Estão faltando informações" +
							" sobre as restrinções da rede");
				}
			}
			for(int i = 0; i < matrix.size(); i++) {
				for(int j = i; j < matrix.size(); j++) {
					if(i == j) {
						matrix.setElement(i, j, 0);;
					} else {
						if(scan.hasNextInt()) {
							cX = scan.nextInt();
							matrix.setElement(i, j, cX);
							matrix.setElement(j, i, cX); // Vai espelhando a matriz
						} else {
							System.err.println("Problema na leitura do arquivo \'" 
									+ path + "\'");
							scan.close();
							throw new NoSuchElementException("Estão faltando células" +
									" na matriz! Verifique o arquivo.");
						}
					}
				}
			}
			scan.close();
		} catch(FileNotFoundException e) {
			System.err.println("Erro ao abrir arquivo \'" + path + "\'");
		}
	}

	/**
	 * 
	 * @return Caminho do arquivo de entrada
	 */
	public String getPath() {
		return path;
	}

	/**
	 * Altera o caminho do arquivo de entrada
	 * @param path Novo caminho do arquivo de entrada
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
}
