# Projeto de Conta Bancária

## Introdução
Este projeto simula um sistema simples de conta bancária que permite realizar saques para clientes especiais e comuns. Ele utiliza Java como linguagem de programação e a ferramenta Cucumber para testes de comportamento e validação das funcionalidades.

## Recursos
- **Linguagem de programação:** Java
- **Framework de teste:** Cucumber
- **Funcionalidades:** Realização de saques para clientes especiais e comuns, atualização de saldo e verificação de limites.

## Testes Implementados
O projeto conta com os seguintes testes implementados:

### 1. Um cliente (especial|comum) com saldo atual de -(\\d+) reais
Este teste verifica se um cliente especial ou comum é criado com um saldo inicial específico. Ele ajuda a garantir que os diferentes tipos de clientes sejam inicializados corretamente com saldos esperados.

### 2. for solicitado um saque no valor de (\\d+) reais
Neste teste, é verificado se a solicitação de um saque para um cliente específico é realizada corretamente. Isso inclui a confirmação de que o saque é efetuado sem erros.

### 3. deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais
Esse teste valida se o saldo da conta é atualizado corretamente após a realização de um saque. Além disso, verifica se o saldo é ajustado para o valor esperado após o saque.

### 4. check more outcomes
Este é um espaço reservado para possíveis extensões ou adições de verificações adicionais.

## Cenários
Os cenários de teste incluem:

- Criação de cliente especial com saldo específico.
- Criação de cliente comum com saldo específico.
- Realização de saque para cliente especial.
- Realização de saque para cliente comum.

## Uso
Para utilizar este projeto, siga as instruções abaixo:

1. Clone o repositório para o seu ambiente local.
2. Certifique-se de ter configurado um ambiente Java.
3. Abra o projeto em sua IDE preferida.
4. Execute os testes utilizando a ferramenta Cucumber.

## Uso dos Cenários
Os cenários implementados podem ser utilizados para:

1. **Um cliente (especial|comum) com saldo atual de -(\\d+) reais**
   - Criar um cliente especial ou comum com um saldo inicial específico para testes.

2. **for solicitado um saque no valor de (\\d+) reais**
   - Testar a solicitação de saques para clientes, verificando se o saque é realizado corretamente.

3. **deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais**
   - Verificar se o saldo da conta é atualizado corretamente após o saque.

## Todos os Testes
Todos os testes implementados são automatizados e podem ser executados por meio da ferramenta Cucumber. Eles visam garantir o funcionamento adequado das funcionalidades da conta bancária, incluindo a criação de clientes, realização de saques e atualização de saldos.


Este é um exemplo expandido do README para um projeto de conta bancária com testes implementados utilizando Cucumber e Java. Personalize-o conforme necessário para o seu projeto, adicionando informações específicas, instruções de instalação, configuração ou qualquer outro detalhe relevante.
