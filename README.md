# Graphs
Desenvolvimento de framework para manipulação de grafos.

## Apresentação

  O objetivo deste projeto é desenvolver um *framework* que facilite a manipulação de grafos, diminuindo os custos e acelerando o processo de desenvolvimento de aplicações que façam uso dessas estruturas. Essa facilidade é causada pelos seguintes requisitos:
* disponibilizar funções para criação e edição de grafos, como: adicionar e remover vértices e arestas, e atribuir pesos;
* permitir extrair propriedades tais como o grafo ser completo, conexo ou desconexo, dentre outras;
* disponibilizar um subconjunto de algoritmos clássicos, como: Dijkstra, Floyd-Warshall, Kruskal, ordenação topológica, busca em largura e busca em profundidade;
* permitir persistir e carregar grafos.
  
Assim, o usuário deste *framework* poderá criar um grafo vazio e construí-lo a partir de primitivas de edição, as quais também fornecem mecanismos para criar vértices e para conectar dois vértices através de uma aresta. Além disso, também é possível salvar e carregar grafos a partir de arquivos.

O *framework* foi desenvolvido em linguagem **Java**, com o auxílio da IDE Eclipse.

Toda a documentação produzida ao longo do processo de desenvolvimento, que pode e deve ser usada para melhor compreensão do trabalho, estão disponíveis na pasta **documentation**. 

## Estrutura do *framework*

O *framework* é estruturado em três pacotes principais: **arc**, **java** e **res**. O pacote **arc** contém toda a implementação do *framework*, o **res** contém recursos extra que a ferramenta pode precisar e o pacote **java** é onde o programador pode criar instâncias. No processo de desenvolvimento foram implementadas três instâncias:
  
* Parnatal Online
* fsdf
* sdfs
  
## Equipe de desenvolvimento

  * Pedro Coelho (pedro_coelho_pv@hotmail.com)
  * Rubem Kalebe (rubemkalebe@gmail.com)
