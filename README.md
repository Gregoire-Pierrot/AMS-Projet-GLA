# Projet : Application de Surveillance des marchés de Cryptomonnaies

## Description

---

**Le projet** consiste à développer une application qui collecte périodiquement des données sur les marchés des cryptomonnaies à partir d'APIs publiques (CoinCap ou autre) et à les exploité sur un site web. Il y a aura deux applications distinctes à développer.

---

**La première est une application en console** qui tournera en permanence, collectant périodiquement des données sur les marchés des cryptomonnaies à partir d’APIs publiques. Elle recueillera les informations pertinentes, tels que les prix, les volumes d'échange et d'autres indicateurs clés, et stockera ces données sur une base de données. La seconde est une application web qui analysera ces données stockées pour fournir aux utilisateurs des visualisations interactives, des alertes personnalisées et des prévisions basées sur des algorithmes simples.

**L'application web** sur laquelle les utilisateurs pourront se connecter afin de visualiser ces données sous forme de graphiques interactifs et offrira une interface intuitive permettant de naviguer entre différentes cryptomonnaies, de sélectionner des plages de temps spécifiques et d'afficher divers types de graphiques tels que la courbes de prix ou la courbe de pourcentage de changement en 24 heures.
L'application permettra en outre de configurer des alertes personnalisées. Les utilisateurs pourront définir des seuils de prix, des variations de pourcentage ou des indicateurs techniques spécifiques pour être notifiés lorsque ces conditions sont remplies. Les notifications pourront être reçues via des emails.
Enfin, l'application proposera des prévisions basées sur des algorithmes simples tels que des moyennes mobiles (moyennes glissantes), des régressions linéaires ou autres. Ces prévisions aideront les utilisateurs à anticiper les tendances du marché, tout en étant informés des limites et des marges d'erreur associées à ces modèles.

---

Le développement de ce projet mettra l'accent sur les bonnes pratiques du processus de développement logiciel. Il impliquera l'application de méthodologies
agiles pour la planification et la gestion des tâches, l'intégration de techniques de test avancées comme les tests unitaires avec mocks, les tests de performance et de sécurité, ainsi que l'adoption de pratiques DevOps telles que l'intégration et le déploiement continus. L'utilisation de conteneurs Docker et l'orchestration avec Kubernetes sera utilisée pour déployer l'application de manière efficace et scalable.

---

## Status

### Console-App
- ![Java CI with Maven](https://github.com/Gregoire-Pierrot/AMS-Projet-GLA/actions/workflows/java-test.yml/badge.svg)
- [![codecov](https://codecov.io/gh/Gregoire-Pierrot/AMS-Projet-GLA/graph/badge.svg?token=YQXJBEZXOH)](https://codecov.io/gh/Gregoire-Pierrot/AMS-Projet-GLA)

### Web-App

---

## Utilisation

Ces deux applications s'utilise ensemble et doivent donc être démarrer ensemble. Elle fonctionnent dans des conteneurs docker séparer en communiquant avec un volume et un réseau propre. La base de données contenant les informations sur les cryptomonnaies à son propre conteneur qui mappe sa base de donnée avec les deux autres conteneurs.

Pour pouvoir les démarrer il suffit d'utiliser la commande suivante :
```bash
docker compose up --build
```

Ou démarrer le script shell `start.sh`.
