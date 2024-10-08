# DESAFIO: Publicando Sua API REST na Nuvem Usando Spring Boot 3.3.4, Java 23 e Railway

    Este projeto simula a API de uma reserva de salas de reunião.

    O Diagrama UML abaixo foi construido utilizando [Mermaid](https://mermaid.js.org/).


```mermaid
---
title: Diagrama de Classes
---
classDiagram
    direction RL
    class Room {
        - Integer id 
        - String name 
        - Integer capacity 
        - String location 
        - List~String~ equipment          
    }
     
    class Reserve {
        - Integer id
        - String date
        - Instant startTime
        - Instant endTime
        - String description        
    }
    
    
     class User {
        - Integer id
        - String name
        - String email
        - String department        
    }
    Room "1" -- "0..*" Reserve
    Reserve "0..*" -- "1" User : request
```
---
Devido incompatibilidade de versão do **Java 23** no Railway, a versão no modo produção foi ajustada para **Java 17**. Outra mudança no **Railway** foi a exclusão do projeto energetic-insight - web para criação de um novo projeto spirited-reprieve - Booker.
