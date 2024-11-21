# GYH Repaginado Language

## Gerar o parser

```bash
java -jar lib/antlr-4.7.2-complete.jar GyhRepaginadoLanguage.g4 -o src/
```

## Vídeo de demonstração

![Vídeo de demonstração](https://youtu.be/LWLG-V5Xzto)

## Compilador

Este projeto é um compilador para a linguagem Gyh Repaginado feito na disciplina de Compiladores. Ele foi feito em Java e utiliza a ferramenta ANTLR para gerar o parser da linguagem gyh para a linguagem Java.

O ANTLR gera toda a análise léxica já montando os tokens e as regras de produção da gramática. O compilador faz a análise semântica e gera o código em C.

A logica para o desenvolvimento do compilador foi a seguinte:
1 - Uma pilha de uma lista de comandos é criada e cada comando é adicionado a lista.
2 - Cada bloco de comandos (if, else e while) tem sua própria lista de comandos.
3 - Uma pilha de condições é criada para cada bloco de comandos.
4 - Tabela Hash para armazenar as variáveis e seus valores.

A lista de comandos serve para resetar a pilha de comandos toda vez que um novo bloco é aberto, por exemplo, um if é encontrado então reiniciamos a lista de comandos e colocamos ela na pilha, logo em seguida adicionamos essa lista de comandos da pilha na lista de comandos do if pelo pop da pilha. Dessa forma conseguimos manter a ordem dos comandos e a ordem dos blocos pois cada comando dentro de um bloco é adicionado a lista de comandos do bloco e porteriormente adicionado a pilha de comandos geral. O mesmo é feito para as condições, cada bloco tem sua própria pilha de condições.

Após a análise de todos os comandos do código, espera-se que a pilha de comandos tenha apenas um item, que é a lista de comandos do programa principal, todos os outros comandos devem ter sido adicionados a essa lista e suas respectivas classes já possuem as respectivas variáveis (ou listas de comandos) necessárias para montar todo código em C.

## Detecção de erros

Para a detecção de erros, o ANTLR já detecta erros léxicos na linguagem, como por exemplo, caracteres inválidos. Para erros semânticos, o compilador faz a verificação de atribuições de tipos diferentes, uso de variáveis não declaradas, uso de variáveis não inicializadas, entre outros.

Para isso, foi criado uma regra de produção a mais na gramática para verificar uso de variáveis, sempre que uma variável é usada em uma expressão essa regra é chamada para poder identificar qual variável está sendo usada. Também foi criado um listener para os erros que é chamado ao final de toda regra de produção, para verificar se as ações que a regra tomou estão corretas, a partir dele e da regra do uso das variáveis conseguimos determinar se o uso delas está correto ou não.

## Geração do código

O gerador de código foi feito em Java, ele percorre a árvore sintática gerada pelo ANTLR e gera o código em C. Para isso, foi criado um listener que é chamado a cada regra de produção da gramática, e a partir dele é gerado o código em C.