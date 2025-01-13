# BackLogs

---

Ce fichier servira de backlog, un outil essentiel pour structurer et suivre l'avancement du projet. J'y listerai de manière détaillée toutes les tâches à réaliser, ce qui permettra d'avoir une vision claire des étapes nécessaires pour atteindre les objectifs fixés. Chaque tâche sera organisée selon l'ordre logique de réalisation, facilitant ainsi la priorisation et la planification.

Pour assurer un suivi précis, chaque tâche sera accompagnée d'une case permettant de marquer son statut (réalisée (✅), en cours (🕐) ou non réalisée (❌)), ainsi que des informations sur la date de création et de finalisation. Cette approche garantit une traçabilité complète et une meilleure gestion du temps, tout en simplifiant les ajustements éventuels en cours de projet.

---

---

## Projet

- 🕐 **Création du projet [18/11/24 - --/--/--] :**

    | Tâches                                                        | Date de création  | Date d'implémentation | Description                                                                                   | Réalisée  | 
    |:-------------------------------------------------------------:|:-----------------:|:---------------------:|:---------------------------------------------------------------------------------------------:|:---------:|
    | Création des dossiers                                         | 18 novembre 2024  | 18 novembre 2024      | Instantiation de tout les dossiers du projet                                                  |    ✅     |
    | Rédaction du [Cahier des charges](Cahier_des_charges.md)      | 18 novembre 2024  | 18 novembre 2024      | Fichier du cahier des charges (peut subire des modification tout au long du projet)           |    ✅     |
    | Création du [README](README.md)                               | 18 novembre 2024  | 18 novembre 2024      | Fichier pour la page d'acceuil [GitHub](https://github.com/Gregoire-Pierrot/AMS-Projet-GLA)   |    ✅     |
    | Création du [BackLog](BackLog.md)                             | 18 novembre 2024  | 18 novembre 2024      | Fichier répertoriant toutes les tâches à réaliser                                             |    ✅     |
    | Ajout de [M.Rouvier](https://github.com/mrouvier) au GitHub   | 18 novembre 2024  | 18 novembre 2024      | Ajout du responsable d'UE au projet GitHub                                                    |    ✅     |
    | Réalisation du Backlogs de [Console-App](#console-app)        | 20 novembre 2024  | 23 novembre 2024      | Détaille des tâches à réaliser pour la partie [Console-App](Documentation.md/#console-app)    |    ✅     |
    | Réalisation du Backlogs de [Web-App](#web-app)                | 20 novembre 2024  | --------------------- | Détaille des tâches à réaliser pour la partie [Web-App](Documentation.md/#web-app)            |    ✅     |
    | Réalisation de la [Documentation](Documention.md)             | 20 novembre 2024  | --------------------- | Création et rédaction de la [documentation](Documentation.md)                                 |    ❌     |
    | Dockerisation et déploiement des applications                 | 9 janvier 2025    | --------------------- | Dockerisation des application + déploiement avec Kubertnet                                    |    🕐     |

---

## Console-App

- ✅ **Configuration du fichier [pom.xml](console-app/pom.xml) [18/11/24 - 06/12/24]:**

    | Tâches                                                                | Date de création  | Date d'implémentation | Description                                                               | Réalisée  |
    |:---------------------------------------------------------------------:|:-----------------:|:---------------------:|:-------------------------------------------------------------------------:|:---------:|
    | Création du [pom.xml](console-app/pom.xml)                            | 18 novembre 2024  | 18 novemnbre 2024     | Fichier contenant toutes les dépendances liés au projet maven             |    ✅     |
    | Ajout des dépendances dans le fichier [pom.xml](console-app/pom.xml)  | 20 novembre 2024  |  6 décembre 2024      | json, sqlite-jdbc, JUnit 5.11.3, Maven 17, Mockito 5.14.2, Jacoco 0.8.12  |    ✅     |


- ✅ **Choix de l'écosystème [20/11/24 - 20/11/24]:**

    | Tâches                                                                            | Date de création  | Date d'implémentation | Description                               | Réalisée  | 
    |:---------------------------------------------------------------------------------:|:-----------------:|:---------------------:|:-----------------------------------------:|:---------:|
    | Choisir les données à enregistrer dans la base de donée                           | 20 novembre 2024  | 20 novembre 2024      | Choix des données à stocker               |    ✅     |
    | Choisir l'API à utilisé                                                           | 20 novembre 2024  | 20 novembre 2024      | API utilisé pour la récolte des données   |    ✅     |


- ✅ **Architecture et implémentation du code [20/11/24 - 13/01/25]:**

    | Tâches                                                                            | Date de création  | Date d'implémentation | Description                                                                                       | Réalisée  | 
    |:---------------------------------------------------------------------------------:|:-----------------:|:---------------------:|:-------------------------------------------------------------------------------------------------:|:---------:|
    | Différentiation des fonctionnalitées à implémenter                                | 20 novembre 2024  | 20 novembre 2024      | Répartition en groupes des différentes parties du code                                            |    ✅     |
    | Réalisation des classes                                                           | 20 novembre 2024  | 6 janvier 2025        | Implémentation du code de l'application [Cosole-App](Documentation.md/#console-app)               |    ✅     |
    | Rédiger la documentation du programme dans la [documentation](Documentation.md)   | 20 novembre 2024  | 13 janvier 2025       | Documentation du programme dans la [documentation](Documentation.md)                              |    ✅     |

    - ✅ **Classes de cryptomonnaies [20/11/24 - 06/01/25]:**

        | Tâches                                                                                                | Date de création  | Date d'implémentation | Description                                                                                                                                   | Réalisée  |
        |:-----------------------------------------------------------------------------------------------------:|:-----------------:|:---------------------:|:---------------------------------------------------------------------------------------------------------------------------------------------:|:---------:|
        | Réalisation de l'interface [ICryptocurrency](console-app/src/main/java/ICryptocurrency.java)          | 20 novembre 2024  | 16 décembre 2024      | Interface d'une cryptomonnaie                                                                                                                 |    ✅     |
        | Réalisation de la classe [Cryptocurrency](console-app/src/main/java/Cryptocurrency.java)              | 20 novembre 2024  | 16 décembre 2024      | Classe d'une cryptomonnaie                                                                                                                    |    ✅     |
        | Réalisation des tests unitaire et des mocks                                                           | 23 novembre 2024  | 6 janvier 2025        | Tests unitaires et mocks de l'interface [ICryptocurrency](console-app/src/main/java/ICryptocurrency.java) et des classes de cryptomonnaies    |    ✅     |


    - ✅ **Classe de requettes à l'API [20/11/24 - 06/01/25]:**

        | Tâches                                        | Date de création  | Date d'implémentation | Description                                                                                                                       | Réalisée  |
        |:---------------------------------------------:|:-----------------:|:---------------------:|:---------------------------------------------------------------------------------------------------------------------------------:|:---------:|
        | Réalisation de la classe de requettes à l'API | 20 novembre 2024  | 15 decembre 2024      | Classe permettant les différentes requettes à l'API                                                                               |    ✅     |
        | Réalisation des tests unitaires               | 23 novembre 2024  | 6 janvier 2025        | Tests unitaires des requettes à l'API (utilisation du retour donné dans la [documentation](https://docs.coincap.io/) de l'API.)   |    ✅     |


    - 🕐 **Classe de gestion du format JSON [20/11/24 - --/--/--]:**

        | Tâches                                                | Date de création  | Date d'implémentation | Description                                   | Réalisée  |
        |:-----------------------------------------------------:|:-----------------:|:---------------------:|:---------------------------------------------:|:---------:|
        | Réalisation de la classe de traitement des données    | 20 novembre 2024  | 16 décembre 2024      | Classe traitant les données reçus via l'API   |    ✅     |
        | Réalisation des test unitaires                        | 23 novembre 2024  | --------------------- | Tests unitaires du traitements des données    |    🕐     |


    - 🕐 **Classes de création et d'enregistrement dans la base de données [20/11/24 - --/--/--]:**

        | Tâches                                                        | Date de création  | Date d'implémentation | Description                                                           | Réalisée  |
        |:-------------------------------------------------------------:|:-----------------:|:---------------------:|:---------------------------------------------------------------------:|:---------:|
        | Réalisation de la classe de création de la base de données    | 20 novembre 2024  | 15 decembre 2024      | Classe créant la base de données                                      |    ✅     |
        | Réalisation de la classe d'enregistrement des données         | 20 novembre 2024  | 16 décembre 2024      | Classe enregistrant les données reçu dans la base de donnée           |    ✅     |
        | Réalisation des tests unitaires                               | 23 novembre 2024  | --------------------- | Tests unitaires de la création des données dans la base de données    |    🕐     |


    - ✅ **Classe appelant de manière périodique l'API [20/11/24 - 04/01/25]:**

        | Tâches                                    | Date de création  | Date d'implémentation | Description                                                                       | Réalisée  |
        |:-----------------------------------------:|:-----------------:|:---------------------:|:---------------------------------------------------------------------------------:|:---------:|
        | Réalisation de la classe appelant l'API   | 20 novembre 2024  | 4 janvier 2025        | Classe [Main.java](src/main/java/Main.java) appelant l'API de manière périodique  |    ✅     |


- ✅ **Tests [18/11/24 - 10/01/25]:**
    
    | Tâches                                                                                                		| Date de création  | Date d'implémentation | Description            				    		                    | Réalisée  | 
    |:-------------------------------------------------------------------------------------------------------------:|:-----------------:|:---------------------:|:---------------------------------------------------------------------:|:---------:|
    | Automatisation des tests avec [GitHub Actions](https://github.com/Gregoire-Pierrot/AMS-Projet-GLA/actions/)   | 18 novembre 2024  | 9 janvier 2025        | Mise en place des tests unitaires automatique avec GitHub Actions     |    ✅     |
    | Gestion de qualité de code avec [CodeCov](https://app.codecov.io/)								            | 18 novembre 2024  | 10 janvier 2025       | Utilisation de l'outil de gestion et de qualité de code SunarQube     |    ✅     |
    | Ajouter les badges GitHub Actions et SonarQube au [README](README.md)								            | 18 novembre 2024  | 10 janvier 2025       | Bagdes indiquant la réussite des testes ainsi que le couvrage du code |    ✅     |


- ✅ **Ajout d'une page de documentation Java avec javadoc de Maven [20/11/24 - 09/01/25]:**

    | Tâches                                        | Date de création  | Date d'implémentation | Description                                                                                       | Réalisée  |
    |:---------------------------------------------:|:-----------------:|:---------------------:|:-------------------------------------------------------------------------------------------------:|:---------:|
    | Commenter les différentes méthodes et classes | 20 novembre 2024  | 6 janvier 2025        | Mettre des commentaires sur chaque classe et méthodes avec la synthaxe du plugin javadoc de Maven |    ✅     |
    | Ajout du workflow                             | 20 novembre 2024  | 9 janvier 2025        | Ajout d uworkflow utilisant le plugin javadoc de Maven                                            |    ✅     |

- ✅ **Contneurisation de l'application [09/01/25 - 10/01/25]**
    
    | Tâches                                       | Date de création  | Date d'implémentation | Description                                       | Réalisée  |
    |:--------------------------------------------:|:-----------------:|:---------------------:|:-------------------------------------------------:|:---------:|
    | Création d'un conteneur pour l'applicaction  | 9 janvier 2025    | 10 janvier 2025       | Réalisation d'un contneur pour cette application  |    ✅     |

---

## Web-App

- ✅ **Initialisation du serveur flask [09/01/25 - 09/01/25]**

    | Tâches                                | Date de création  | Date d'implémentation | Description                   | Réalisée  |
    |:-------------------------------------:|:-----------------:|:---------------------:|:-----------------------------:|:---------:|
    | Création de l'environnement python    | 9 janvier 2025    | 9 janvier 2025        | Création de l'environnement   |    ✅     |
    | Création du serveur flask             | 9 janvier 2025    | 9 janvier 2025        | Création du serveur           |    ✅     |

- ✅ **Création de la base de données utilisateur [09/01/25 - 09/01/25]**

    | Tâches                                    | Date de création  | Date d'implémentation | Description                       | Réalisée      |
    |:-----------------------------------------:|:-----------------:|:---------------------:|:---------------------------------:|:-------------:|
    | Création de la base de donée utilisateur  | 9 janvier 2025    | 9 janvier 2025        | Création de la base de données    |       ✅      |

- 🕐 **Ajout des différentes pages du site [09/01/25 - --/--/--]**

    | Tâches                                                                    | Date de création  | Date d'implémentation | Description                                                                                                                                                                           | Réalisée      |
    |:-------------------------------------------------------------------------:|:-----------------:|:---------------------:|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:-------------:|
    | Création de la page de garde                                              | 9 janvier 2025    | 9 janvier 2025        | Réalisation de la page de garde (/) du site                                                                                                                                           |       ✅      |
    | Création des page d'enregistrement et de connexion                        | 9 janvier 2025    | 9 janvier 2025        | Réalisation des pages de connexion et d'enregistrement des utilisateurs                                                                                                               |       ✅      |
    | Création de la page de modification d'information utilisateur             | 9 janvier 2025    | 9 janvier 2025        | Réalisation de la page de modifiaction des données utilisateurs                                                                                                                       |       ✅      |
    | Création de la page de visualisation des cryptomonnaies                   | 9 janvier 2025    | 10 janvier 2025       | Réalisation des pages de visualisation des cryptommonaies sous forme de courbe de prix, graphique en chandelier et heatmap. Elle comportera aussi un algorithme de prévision de prix  |       ✅      |
    | Création de la page d'ajout d'alertes                                     | 9 janvier 2025    | --------------------- | Réalisation de la page de création d'alerte de prix ou de variation de pourcentage                                                                                                    |       🕐     |