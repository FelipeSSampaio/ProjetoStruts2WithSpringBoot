# ProjetoStruts2WithSpringBoot
Projeto Spring Boot integrado ao Struts2 usando JDBC e um serviço SOAP

- [X] Spring Boot
- [X] Struts2
- [X] JDBC
- [X] SOAP service
- [X] Client
- [X] BootStrap

Para acessar o wsdl basta acessar: http://localhost:8080/ws/exames.wsdl

----------------------
Observações
----------------------

Para acessar a tela inicial da aplicação: http://localhost:8080/

Apesar dos jsps estarem na pasta ```src/main/resource/static```, foi somente uma opção minha de backup das páginas dentro da própria aplicação.
As JSPs que rodam na aplicação estão dentro de ```src/main/webapp```.

Adicionei em ```src/main/resource```:

1 - wsdl gerado pela aplicação
2 - data.sql com as queries de create table e sequence

As classes do client são geradas ao realizar um ```Update > Maven``` ou com Maven ```clean``` e ```install```.
