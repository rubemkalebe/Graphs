package main.java.parnatalOnline.src;

/**
 * A classe UnionFind representa a estrutura de dados homônima, também conhecida como
 * Conjuntos Disjuntos.
 * 
 * Suporta as operações: find_set(), same_component() e union(). Vale destacar que a
 * operação conhecida como make_set está incluída no construtor da classe.
 * 
 * Referências:
 * 	- http://algs4.cs.princeton.edu/15uf/UF.java.html
 * 	- http://marathoncode.blogspot.com.br/2013/01/conjuntos-disjuntos.html
 * 
 */

public class UnionFind {

	// Representa o líder do conjunto disjunto
	private int[] id;
	
	// Limite superior para a altura do nó
	private int[] rank;
	
	// Quantidade de componentes
	private int size;
	 
	/**
	 * Inicializa um union-find de tamanho N+1 (já faz o make_set).
	 * @param n Número de componentes
	 * @throws java.lang.IllegalArgumentException se n < 0
	 */
	public UnionFind(int n) {
		if(n < 0) {
			throw new IllegalArgumentException("Número de conjuntos inválido!");
		}
		size = n+1;
		id = new int[n+1];
		rank = new int[n+1];

		// Make set
		for(int i = 0; i < n+1; i++) {
			id[i] = i;
			rank[i] = 0;
		}
	}
	 
	/**
	 * Encontra o conjunto de um dado elemento x.
	 * @param x Elemento a ser pesquisado
	 * @return O identificador para o elemento pesquisado
	 * @throws java.lang.IndexOutOfBoundsException caso x não esteja no intervalo 1...n
	 */
	public int find_set(int x) {
	    if((x < 1) || (x >= id.length)) {
	    	throw new IndexOutOfBoundsException("O elemento procurado não se encontra no" +
	    			" intervalo [1...n]");
	    }
	    while(x != id[x]) {
	    	id[x] = id[id[x]];  // Path compression by halving (reduz a altura para metade)
	    	x = id[x];
	    }
	    return x;
	}
	
	/**
	 * Verifica se os elementos pertecem ao mesmo conjunto.
	 * @param x Representa um dos elementos a ser pesquisado
	 * @param y Representa o outro elemento a ser pesquisado
	 * @return true se os elementos estão no mesmo conjunto e false, caso contrário
	 */
	public boolean same_component(int x, int y) {
		return find_set(x) == find_set(y);
	} 
	 
	/**
	 * Mescla o conjunto de x com o conjunto de y.
	 * @param x Representa um dos elementos a ser pesquisado
	 * @param y Representa um dos elementos a ser pesquisado
	 */
	public void union(int x, int y) {
		int i = find_set(x);
	    int j = find_set(y);
	    if(i == j) {
	    	return;
	    }
	    /* Faz a raiz da árvore com menor número de elementos apontar para a raiz da
	       árvore com maior número de elementos. */
	    if (rank[i] < rank[j]) {
	    	id[i] = j;
	    } else if (rank[i] > rank[j]) {
	    	id[j] = i;
	    } else {
	    	id[j] = i;
	    	rank[i]++;
		}
	    size--;
	}	
	
	/**
	 * Retorna o número de componentes
	 * @return O número de componentes
	 */
	public int size() {
		return size;
	}

}