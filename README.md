# Tela de Login em Java

## Introdução:
Esta é uma classe em Java denominada LoginScreen que gerencia a funcionalidade de login de usuários por meio de um banco de dados de autenticação. Ela permite a verificação do nome de usuário e senha inseridos pelos usuários em um banco de dados armazenado e oferece a capacidade de adicionar novos usuários a esse banco de dados.

## Recursos:

- Verificação de credenciais de login.
- Adição de novos usuários ao banco de dados.
- Simples e fácil de utilizar.

## Testes Implementados
Dentro do repositório, encontram-se testes JUnit específicos para validar a funcionalidade da classe LoginScreen. Esses testes foram elaborados para garantir a eficácia dos recursos de autenticação e gerenciamento de usuários. Cada cenário de teste abrange situações distintas:

- `testSuccessfulLogin`: Avalia o processo de login bem-sucedido.
- `testFailedLogin`: Aborda a verificação de uma tentativa de login sem sucesso.
- `testAddUser`: Verifica a funcionalidade de adicionar um novo usuário ao banco de dados.

Para realizar a execução desses testes, é recomendado o uso da estrutura de testes JUnit no ambiente de desenvolvimento, garantindo assim a integridade e o funcionamento correto dos recursos implementados na classe LoginScreen.

## Uso:

### Instanciando a Classe:

````java
LoginScreen loginScreen = new LoginScreen();
````
### Autenticando Usuários:

````java
// Verificação de login
boolean isAuthenticated = loginScreen.login("john","password123");
if (isAuthenticated) {
    // Executar ações após o login bem-sucedido
    System.out.println("Login bem-sucedido!");
} else {
    // Tratar caso o login falhe
    System.out.println("Login falhou. Verifique suas credenciais.");
}
````
### Adicionando Novos Usuários:

````java
// Adição de um novo usuário
loginScreen.addUser("testuser","testpassword");
Testes
````

### Para testar a funcionalidade de login e adição de usuários, é possível utilizar o seguinte exemplo:

### Teste de Login:

````java
boolean isAuthenticated = loginScreen.login("john", "password123");
// Verificação se o login foi bem-sucedido ou falhou
````

### Adição de Novo Usuário:

````java
loginScreen.addUser("testuser", "testpassword");
// Confirmação da adição de um novo usuário
````







