# Desafio para Back-End Junior - Guilherme José

## Índice

- [Execução](#execução)
- [Execução dos Testes](#execução-testes)
- [Pilha de Tecnologias](#pilha-de-tecnologias)
- [Documentação da API](#documentação-da-api)

### Ambiente de Desenvolvimento

1. Verifique se o Java - versão 8, já encontra-se instalado em sua máquina:

	```
	$ java -version
	```

1. Caso não esteja instalado, baixe o JDK - versão 8, na url:

	<https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html>
	  
1. Baixe a ultima versão do IntelliJ na url:

	<https://plugins.jetbrains.com/marketplace>
	

### Execução

1. No IntelliJ, clique com o botão direito do mouse em cima do projeto, navegue até **Run As** e clique em **Spring Boot App**.

2. Executamos o passo anterior somente para facilitar a criação do script de execução da aplicação, 
   já que ocorrerá um erro de banco de dados (esperado) porque ainda não há configuração 
   para ele.

    - Para configurar o banco, navegue até o diretório docker-composer e execute o seguinte comando:
     
     ```
     docker-compose up
     ```

    - Em seguida, execute o sql encontrado no diretório database.
    
    - Agora, execute a main do projeto como SpringBoot.

### Execução dos Testes

1. Basta navegar até o diretório de test e executa-los.


### Pilha de Tecnologias
    
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [JUnit](https://junit.org)

### Documentação da API

GET /employee
	/employee/{id}
	/sector (param "include" value = "employee")
	
POST /employee

{
    "cpf": "99999999999",
    "name": "Guilherme",
    "telephone": "21999586465",
    "email": "gui_guifonseca@hotmail.com",
    "dt_birth": "1998-05-05",
    "id_sector": 1
}

DELETE /employee/{id}

