# Trabalho Prático 1 - Alinhamento Estratégico de Carteiras Recomendadas

## 1. Descrição do problema

O trabalho consiste em comparar duas listas de ativos recomendados por duas corretoras.

Cada corretora possui sua própria ordem de preferência dos ativos. O objetivo é encontrar a maior sequência de ativos que aparece nas duas listas mantendo a mesma ordem relativa.

Os ativos não precisam estar em posições consecutivas. O importante é que a ordem entre eles seja mantida nas duas listas.

Por exemplo, se PETR4 aparece antes de ITUB4 nas duas listas, os dois ativos podem fazer parte da sequência de consenso, mesmo que existam outros ativos entre eles.

---

## 2. Modelagem da solução

A solução foi desenvolvida em Java utilizando recursão.

Foram utilizados dois vetores de `String`:

- `corretoraA`: armazena os ativos recomendados pela primeira corretora.
- `corretoraB`: armazena os ativos recomendados pela segunda corretora.

A busca pela maior sequência em comum é feita através da função recursiva `encontrarConsenso`.

Essa função utiliza dois índices:

- `i`: posição atual na lista da Corretora A.
- `j`: posição atual na lista da Corretora B.

A comparação funciona da seguinte forma:

### Caso 1 - Os ativos são iguais

Quando:

`a[i] == b[j]`

o ativo faz parte do consenso.

Nesse caso, o ativo é adicionado à resposta e a busca continua avançando uma posição nas duas listas:

`i + 1` e `j + 1`

Como os índices somente avançam, a ordem dos ativos nas duas listas é preservada.

### Caso 2 - Os ativos são diferentes

Quando os ativos são diferentes, não é possível saber diretamente qual deles deve ser ignorado.

Por isso, são testadas duas possibilidades:

1. Ignorar o ativo atual da Corretora A, avançando para `i + 1`.
2. Ignorar o ativo atual da Corretora B, avançando para `j + 1`.

Depois de calcular os dois caminhos, o programa compara o tamanho das sequências encontradas e retorna a maior delas.

### Caso base

A recursão termina quando uma das duas listas chega ao final.

Ou seja:

`i == M` ou `j == N`

Nesse momento não existem mais ativos para comparar e uma sequência vazia é retornada.

---

## 3. Entrada e saída

A entrada é lida pela entrada padrão utilizando `Scanner`.

Primeiro são lidos os valores `M` e `N`, que representam a quantidade de ativos das corretoras A e B.

Depois são lidos os `M` ativos da Corretora A e os `N` ativos da Corretora B.

A saída possui:

- Na primeira linha, o tamanho `K` da maior sequência encontrada.
- Na segunda linha, os ativos que fazem parte dessa sequência.

Caso não exista nenhum ativo em comum, o programa imprime `0` e uma linha em branco.

---

## 4. Complexidade

### Complexidade de tempo

A solução utiliza recursão sem armazenar os resultados já calculados.

Quando dois ativos são diferentes, podem ser feitas duas novas chamadas recursivas:

- `(i + 1, j)`
- `(i, j + 1)`

Com isso, vários subproblemas podem acabar sendo calculados novamente.

No pior caso, o número de chamadas cresce de forma exponencial em relação aos tamanhos `M` e `N`.

Uma cota superior para a complexidade de tempo é:

`O(2^(M+N))`

Essa solução não busca ter o melhor tempo de execução possível. A ideia foi utilizar uma implementação mais simples e direta, sem utilizar programação dinâmica e sem utilizar uma matriz `M x N`.

### Complexidade de espaço

Os dois vetores utilizados para armazenar as entradas ocupam:

`O(M + N)`

A pilha de chamadas recursivas também pode chegar a uma profundidade de:

`O(M + N)`

Além disso, durante a execução são criadas listas temporárias para armazenar as sequências encontradas pelas chamadas recursivas.

Portanto, além do espaço utilizado pelos vetores e pela pilha de recursão, existe também o espaço utilizado por essas listas temporárias.

---

## 5. Uso de Inteligência Artificial

Foi utilizada uma ferramenta de Inteligência Artificial como apoio na formatação e organização deste README, com o objetivo de deixar o documento mais organizado e facilitar a apresentação das informações.

Também foi utilizada como auxílio para determinar e compreender a complexidade do algoritmo no pior caso.

---

## 6. Tecnologias utilizadas

- Java
- IntelliJ IDEA
- Maven
- Git/GitHub