# Cahier des Charges - Projet de Collecte et d'Analyse de Données Cryptomonnaies

---

### **1. Contexte et Objectifs du Projet**

#### 1.1. Contexte  
Le projet répond à une demande croissante pour des outils permettant une meilleure compréhension des marchés des cryptomonnaies. Actuellement, les investisseurs et analystes utilisent diverses plateformes fragmentées pour accéder aux données de marché, les rendant peu intuitives et parfois incomplètes.  

#### 1.2. Objectifs  
- **Collecte automatisée des données** : développer une application console en Java pour récupérer et stocker des informations clés sur les cryptomonnaies.  
- **Visualisation interactive et alertes** : concevoir une application web intuitive en Python avec Flask pour analyser et présenter les données.  
- **Prévisions basées sur des algorithmes simples** : offrir des outils d’analyse prévisionnelle pour mieux anticiper les tendances du marché.  
- **Assurance qualité et DevOps** : garantir un développement robuste grâce aux tests automatisés et aux bonnes pratiques CI/CD.

---

### **2. Périmètre du Projet**

#### 2.1. Fonctionnalités attendues  
- Application console :  
  - Collecte périodique de données via une API publique (ex. : CoinCap).  
  - Stockage des données (prix, volumes, indicateurs techniques) dans une base de données.  

- Application web :  
  - Interface utilisateur intuitive avec visualisations interactives (graphiques, courbes, chandeliers, heatmaps).  
  - Système d’alertes personnalisées via email.  
  - Prévisions basées sur des algorithmes simples (moyennes mobiles, régressions).  

#### 2.2. Technologies utilisées  
- **Java** : pour la collecte des données, avec tests automatisés via JUnit, Jacoco et Mockito.  
- **Python/Flask** : pour le serveur web et la présentation des données.
- **SQLite** : pour créer et enregistrer les données de l'API : CoinCap API dans une base de données.
- **Docker & Kubernetes** : pour le déploiement scalable.  
- **GitHub Actions** : pour l’automatisation des tests.
- **Codecov** : pour suivre la qualité et la couverture des tests.
- **Locust** : pour les tests de performance.
- **GitHub Pages** : pour la visibilité de la documentation.
- **Snyk** : pour la sécurité des versions utilisées.

---

### **3. Public Cible**

#### 3.1. Profil des utilisateurs  
- **Âge** : 25-50 ans.  
- **Profession** : Traders, analystes financiers, passionnés de cryptomonnaies.  
- **Compétences techniques** : Modérées (interface utilisateur intuitive attendue).  

#### 3.2. Nombre d’utilisateurs pour les tests  
- Phase initiale : 2 utilisateurs (retours qualitatifs).  
- Phase avancée : 10 utilisateurs (tests grandeur nature).  

---

### **4. Scénarios de Tests Utilisateurs**

#### 4.1. Objectifs des tests utilisateurs  
- Valider l'intuitivité de l'interface web.
- Tester la fiabilité des requettes sur la base de données.
- Tester la fiabilité des alertes et des prévisions.  
- S’assurer de la performance et de la rapidité des visualisations.  

#### 4.2. Méthodologie de tests  
- Tests modérés (présence d’un facilitateur).
- Tests non modérés.
- Collecte de feedback par questionnaires et interviews.  

#### 4.3. Scénarios de tests  
- Ajouter une cryptomonnaie aux favoris.  
- Configurer une alerte de seuil de prix.  
- Visualiser un graphique en chandeliers pour une plage temporelle spécifique.  

---

### **5. Critères de Réussite et Évaluations**

#### 5.1. Indicateurs de performance (KPI)  
- Fiabilité des données collectées (>99 % de disponibilité).  
- Temps de chargement des graphiques (<5 secondes).  
- Satisfaction des utilisateurs (notation >4/5).

#### 5.2. Feedback des utilisateurs  
- Collecte via formulaires en ligne après chaque session de tests.  
- Analyse des retours pour ajustements.  

---

### **6. Contraintes et Risques**

#### 6.1. Contraintes techniques  
- Compatibilité avec des API publiques sujettes à des limites de taux (rate-limiting).  
- Gestion efficace des volumes de données croissants.  

#### 6.2. Risques potentiels  
- Instabilité des APIs externes.  
- Difficultés dans l'orchestration Kubernetes pour un déploiement efficace.  

---

### **7. Planning Prévisionnel**

#### 7.1. Phases du projet
- Temps global impartie : 53 jours.
- Conception et spécifications : [non définie].  
- Développement de l’application console : [non définie].  
- Développement de l’application web : [non définie].  
- Intégration CI/CD et tests : [non définie].  
- Tests utilisateurs et ajustements : [non définie].  

#### 7.2. Livrables  
- Application console fonctionnelle avec documentation.  
- Interface web avec graphiques interactifs.  
- Rapport des tests utilisateurs.  

---

### **8. Équipe du Projet**

- **Grégoire Pierrot** : Développeur et chef de projet (responsable de l’ensemble des tâches).  

---

### **9. Annexes**  
- Lien vers la [documentation](Documentation.md).  
