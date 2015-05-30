# Parnatal Online #

Este arquivo descreve os passos necessários para executar a aplicação Parnatal Online.

### Apresentação ###

A tarefa principal do projeto é, a partir de uma matriz *n x n*, contendo o custo de se criar uma conexão entre duas casas quaisquer em um bairro fictício e um valor *d*, encontrar uma estrutura de conexão de menor custo (em forma de árvore) entre as *n* residências desse bairro, de maneira que nenhuma residência tenha mais que *d* conexões diretas com outras residências. Esses dados serão informados através de um arquivo que deve seguir o seguinte padrão:

        <valor de n> <valor de d>
        <custo c1--c2> <custo c1--c3> <custo c1--c4> ... <custo c1--cn>
        <custo c2--c3> <custo c2--c4> ... <custo c2--cn>
        <custo c3--c4> ... <custo c3--cn>
        ...
        <custo c<n-1>--cn>

Veja um exemplo de arquivo válido:

        5 2
        5 10 15 2
        21 2 45
        53 12
        13

É possível encontrar vários arquivos de entrada válidos na pasta **tests**.

### Como executar? ###

1. [Baixe aqui](https://bitbucket.org/rubemkalebe/parnatal-projdetsoft/downloads) este repositório.
2. Extraia o arquivo .zip que foi baixado anteriormente.
IMPORTANTE: Você pode usar qualquer IDE (ou fazer tudo na mão), mas as instruções serão destinadas a IDE Eclipse.
3. Abra a IDE Eclipse.
4. Vá em 'File' e em seguida seleciona a opção 'Import'. Lá você deverá importar um projeto e escolher a pasta que foi descompactada.
5. Com o projeto aberto no *workspace* vá em 'Run Configurations' e insira um argumento válido para o programa (você pode usar 'tests/in2.in').
6. Clique em 'Run' e execute o programa.

IMPORTANTE: O programa gera um arquivo contendo a melhor solução. Esse arquivo é salvo na pasta corrente do projeto e leva o nome de 'BestSolution.out'.

### Equipe de desenvolvimento ###

* Lilian Ketlyn (lili_ketlyn@hotmail.com)
* Rubem Kalebe (rubemkalebe@gmail.com)