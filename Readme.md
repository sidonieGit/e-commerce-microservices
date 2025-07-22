# Projet E-commerce en Microservices avec Spring Boot

Ce projet est une démonstration d'une architecture de microservices pour une application e-commerce simple, construite avec Spring Boot et Spring Cloud.

## Architecture

Le projet est composé des microservices suivants :

*   **`eureka-server` (Port `8761`)**: Le serveur de découverte (annuaire) qui permet aux services de se trouver dynamiquement.
*   **`gateway-service` (Port `8888`)**: La passerelle d'API (API Gateway). C'est le point d'entrée unique pour toutes les requêtes externes. Elle redirige le trafic vers les microservices appropriés.
*   **`customer-service` (Port `8083`)**: Gère les informations des clients.
*   **`inventory-service` (Port `8084`)**: Gère l'inventaire des produits.

## Technologies utilisées

- Java 21
- Spring Boot 3
- Spring Cloud
    - Spring Cloud Gateway (Routage dynamique)
    - Netflix Eureka (Découverte de services)
- Spring Data JPA
- Base de données H2 (en mémoire pour le développement)
- Maven

## Prérequis

- JDK 21 ou supérieur
- Apache Maven
- Un client Git

## Installation et Lancement

1.  **Cloner le dépôt**
    ```bash
    git clone https://github.com/sidonieGit/e-commerce-microservices.git
    cd ecommerce-app
    ```

2.  **Compiler le projet**
    À la racine du projet, lancez la commande Maven pour construire tous les modules :
    ```bash
    mvn clean install
    ```

3.  **Lancer les microservices (l'ordre est important !)**

    Vous devez lancer chaque service dans son propre terminal.

    *   **1. Lancer le Serveur Eureka :**
        ```bash
        java -jar eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar
        ```
        Attendez qu'il soit démarré. Vous pouvez vérifier son tableau de bord sur `http://localhost:8761`.

    *   **2. Lancer les services métiers :**
        ```bash
        # Dans un nouveau terminal
        java -jar customer-service/target/customer-service-0.0.1-SNAPSHOT.jar
        
        # Dans un autre nouveau terminal
        java -jar inventory-service/target/inventory-service-0.0.1-SNAPSHOT.jar
        ```
        Vérifiez sur le tableau de bord d'Eureka qu'ils sont bien enregistrés.

    *   **3. Lancer la Gateway :**
        ```bash
        # Dans un dernier terminal
        java -jar gateway-service/target/gateway-service-0.0.1-SNAPSHOT.jar
        ```

4.  **Le projet est prêt !**
    L'application est maintenant accessible via la Gateway sur `http://localhost:8888`.

## Endpoints disponibles

Toutes les requêtes doivent passer par la Gateway sur le port `8888`.

*   **Lister tous les clients :**
    `GET http://localhost:8888/customers`
*   **Lister tous les produits :**
    `GET http://localhost:8888/products` ou `GET http://localhost:8888/INVENTORY-SERVICE/products`
*   **Voir le tableau de bord Eureka :**
    `http://localhost:8761`