# dsw3_conecta-vacina
Projeto realizado na disciplina de desenvolvimento de sistema web

## Sobre o projeto
Projeto consiste em realizar registro de vacinação. O sistema web permite fazer o cadastro de profissional, cadastro de grupo de vacinação, cadastro de vacina e cadastro de paciente, além do registro de vacinação no paciente pelo profissioal de saúde cadastrado.

## Modelo conceitual
![Modelo Conceitual](https://github.com/leandromelolm/dsw3_conectavacina/blob/main/conectavacina/src/java/Diagrama-Classes-Vacina.jpg)


## Tecnologias utilizadas
- MySQL 5.7
- JSF 2.2
- PrimeFaces 5.0
- EclipseLink (JPA 2.1)
- Driver JDBC MySQL
- JSTL 1.2.1
- Java JDK: 1.8
- BootsFaces-OSP-Default-1.5.0

## Ferramentas de desenvolvimento
- NetBeans IDE 8.2 rc
- NetBeans IDE 8.2
- Servidor Apache Tomcat 8.0.27.0

## Usando Docker para criar um container MySQL 5.7
##### Passo 1 - criar volume com o comando: docker volume create {nome-do-volume}
```
docker volume create mysql-5-db
```

##### Passo 2 - criar um container 

Criando container com o nome *mysql-5-vol*, passando o volume em **-v** e mapeando a porta local 3307 com a 3306 do container com **-p**.
```
docker run -d --name mysql-5-vol -e MYSQL_ROOT_PASSWORD=root -v mysql-5-db:/tmp/mysql-5-7-volume -p 3307:3306 mysql:5.7

```

##### Outros comandos básicos do docker

`docker ps` -  Verificar o status do container ( lista container ativos)

`docker ps -a` -  Listar todos os container

`docker stop {ID or Name}` -  Parar um contêiner que esteja sendo executado

`docker start {ID or Name}` -  Subir novamente o container

`docker exec -it {Name} /bin/bash` - Entrar no container e executar o terminal

`docker inspect (ID da imagem ou container)` - Detalhes sobre a imagem ou container

`docker volume ls ` - Listar volume

`docker rm {ID or Name} ` - Remover container

`docker volume rm  {ID or Name}` - Remover volume

`docker images -a` - Listar imagens 

`docker version` - Ver versão docker (versão docker executada nesse projeto: 20.10.12)


## Autor
Leandro Melo
