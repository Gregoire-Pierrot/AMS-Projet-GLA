# Projet : Application de Surveillance des marchés de Cryptomonnaies

## Description

---

**Le projet** consiste à développer une application qui collecte périodiquement des données sur les marchés des cryptomonnaies à partir d'APIs publiques (CoinCap ou autre). Il y a aura deux applications distinctes à développer.

---

**La première est une application en console** qui tournera en permanence, collectant périodiquement des données sur les marchés des cryptomonnaies à partir d’APIs publiques. Elle recueillera les informations pertinentes, tels que les prix, les volumes d'échange et d'autres indicateurs clés, et stockera ces données sur une base de données. La seconde est une application web qui analysera ces données stockées pour fournir aux utilisateurs des visualisations interactives, des alertes personnalisées et des prévisions basées sur des algorithmes simples.

**L'application web** sur laquelle les utilisateurs pourront se connecter afin de visualiser ces données sous forme de graphiques interactifs offrira une interface intuitive permettant de naviguer entre différentes cryptomonnaies, de sélectionner des plages de temps spécifiques et d'afficher divers types de graphiques tels que des courbes de prix, des graphiques en chandeliers ou des heatmaps.
L'application permettra en outre de configurer des alertes personnalisées. Les utilisateurs pourront définir des seuils de prix, des variations de pourcentage ou des
indicateurs techniques spécifiques pour être notifiés lorsque ces conditions sont remplies. Les notifications pourront être reçues via des emails.
Enfin, l'application proposera des prévisions basées sur des algorithmes simples tels que des moyennes mobiles (moyennes glissantes), des régressions linéaires ou autres. Ces prévisions aideront les utilisateurs à anticiper les tendances du marché, tout en étant informés des limites et des marges d'erreur associées à ces modèles.

---

Le développement de ce projet mettra l'accent sur les bonnes pratiques du processus de développement logiciel. Il impliquera l'application de méthodologies
agiles pour la planification et la gestion des tâches, l'intégration de techniques de test avancées comme les tests unitaires avec mocks, les tests de performance et de sécurité, ainsi que l'adoption de pratiques DevOps telles que l'intégration et le déploiement continus. L'utilisation de conteneurs Docker et l'orchestration avec
Kubernetes sera utilisée pour déployer l'application de manière efficace et scalable.

---

## Status

### Console-App
- ![Java CI with Maven](https://github.com/Gregoire-Pierrot/AMS-Projet-GLA/actions/workflows/java-test.yml/badge.svg)
- [Insérer badges SonarQube]

- Le site de la documentation est disponible ici : [Lien vers GitHub Pages](https://gregoire-pierrot.github.io/AMS-Projet-GLA/package-summary.html)

### Web-App
- [Insérer badges]

---

## Utilisation

### Console-App

L'application s'occupant de collecter des données est faites en Java. Vous avez donc deux choix possibles pour lancer cette application :
- Executer le fichier **main.java** localiser dans **console-app/src/main/java/** avec la commande :

```java
java console-app/src/main/java/main.java
```

- Executer le fichier **main.class** localiser dans **[indiquer le chemin d'acces main.class]** avec la commande :

```java
[indiquer la commande pour executer le fichier main.class]
```

L'exécution de cette application doit se faire dans un terminale à part.

### Web-App

L'application s'occupant de l'interface web est faite en python. Vous devez donc utiliser python pour lancer le seveur web.
Avant de pouvoir le faire, il vous faudra vous placer dans le dossier **web-app** puis créer un environnement python nommé **venv** à l'aide de la commande :

```python
python3 -m venv venv
```

Ensuite activer la avec la commande :

```bash
source venv/bin/activate
```

Puis installer les librairie de l'application avec la commande :

```python
pip install flask [autres librairies utilisé]
```

Vous pouvez maintenant lancer le serveur avec la commande :

```python
python3 app/main.py
```
