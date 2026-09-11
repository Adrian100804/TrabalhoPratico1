# Trabalho Prático 1 - Alinhamento Estratégico de Carteiras Recomendadas

## 1. Descrição do problema

O trabalho consiste em comparar duas listas de ativos recomendados por duas corretoras.

Cada corretora possui uma ordem de preferência diferente para os seus ativos. O objetivo é encontrar a maior sequência de ativos que aparece nas duas listas mantendo a mesma ordem.

Os ativos não precisam estar um ao lado do outro. O importante é que a ordem entre eles seja mantida nas duas listas.

Por exemplo, se PETR4 aparece antes de ITUB4 nas duas listas, os dois podem fazer parte da sequência de consenso, mesmo que existam outros ativos entre eles.

---

## 2. Modelagem da solução

A solução foi desenvolvida em Java.

Primeiro, os ativos das duas corretoras são armazenados em dois vetores:

- `a`: armazena os ativos da primeira corretora.
- `b`: armazena os ativos da segunda corretora.

Depois, o programa percorre os dois vetores para encontrar os ativos que aparecem nas duas listas.

Para cada ativo da lista A, o programa percorre a lista B procurando posições em que o mesmo ativo aparece.

As posições encontradas na lista B são armazenadas em uma lista chamada `posicoes`. Os respectivos ativos também são armazenados para que seja possível montar a resposta no final.

A lista B é percorrida de trás para frente durante essa etapa.

Depois de encontrar essas posições, o problema passa a ser encontrar a maior sequência de posições que esteja em ordem crescente.

Uma sequência crescente de posições representa ativos que aparecem mantendo a mesma ordem nas duas corretoras.

Para encontrar essa sequência de forma mais eficiente, é utilizada uma busca binária. A busca divide o intervalo analisado ao meio a cada passo, evitando percorrer toda a sequência em cada busca.

Durante esse processo, também são armazenadas informações sobre os elementos anteriores da sequência.

No final, o programa utiliza essas informações para reconstruir os ativos que fazem parte da maior sequência encontrada.

---

## 3. Entrada e saída

A entrada é lida utilizando `Scanner`.

Primeiro são lidos os valores `M` e `N`, que representam a quantidade de ativos das corretoras A e B.

Depois são lidos os `M` ativos da Corretora A e os `N` ativos da Corretora B.

A saída apresenta:

- Na primeira linha, a quantidade de ativos da maior sequência encontrada.
- Na segunda linha, os ativos que fazem parte dessa sequência.

Caso não exista nenhum ativo em comum, o programa imprime `0` e depois uma linha em branco.

---

## 4. Complexidade

### Complexidade de tempo

Primeiro, o programa lê os ativos das duas listas, com custo `O(M + N)`.

Depois, cada ativo da lista A é comparado com os ativos da lista B utilizando dois laços de repetição.

Essa parte possui complexidade:

`O(M * N)`

As correspondências encontradas são armazenadas para serem processadas posteriormente.

Chamando de `R` a quantidade de correspondências encontradas entre as duas listas, cada uma delas é processada utilizando uma busca binária, com custo `O(log R)`.

Dessa forma, a complexidade total pode ser representada por:

`O(M * N + R log R)`

No pior caso, a quantidade de correspondências pode chegar a `M * N`. Portanto, o limite de pior caso pode ser escrito como:

`O(M * N log(M * N))`

Quando `M` e `N` possuem tamanhos semelhantes, essa complexidade pode ser simplificada para:

`O(M * N log N)`

A solução não utiliza programação dinâmica e também não utiliza uma matriz `M x N` para armazenar resultados.

### Complexidade de espaço

Os dois vetores utilizados para armazenar as listas ocupam:

`O(M + N)`

Além disso, o programa armazena as correspondências encontradas e utiliza vetores auxiliares para encontrar e reconstruir a sequência.

Chamando de `R` a quantidade de correspondências, o espaço utilizado é:

`O(M + N + R)`

No pior caso, `R` pode chegar a `M * N`. Portanto, a complexidade de espaço no pior caso é:

`O(M * N)`

---

## 5. Uso de Inteligência Artificial

Foi utilizada uma ferramenta de Inteligência Artificial como apoio na organização e formatação deste README.

A ferramenta também foi utilizada como auxílio para compreender a análise de complexidade do algoritmo e estudar possíveis formas de melhorar a eficiência da solução.

---

## 6. Tecnologias utilizadas

- Java
- IntelliJ IDEA
- ChatGPT