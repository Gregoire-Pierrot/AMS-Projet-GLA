# Documentation

Chacune des applications décrite ci-dessous, fonctionne dans un conteneur propre et interagissant avec les autres via un volume et un réseau.

## Console-App

**Technologies utilisé** : Java, SQLite, JUnit, Mockito, json, jacoco, maven, javadoc

Cette partie consistait à faire une application qui utilisais une l'API `coincap` pour récupérer et stocker dans une base de données, des informations sur des cryptomonnaies.
Dans l'application développé, les requettes de récupérations de données se font toutes les 1.5 seconde en moyenne et sont limités à 1 requette par seconde. Grâce à l'API `coincap`, 100 cryptomonnaies sont récupéré en même temps (les 100 meilleurs cryptomonnaies d'après coincap). Elles sont ensuite enregistré dans une base de données comportant 3 tables :
- time : représentant le temps corespondant à des valeurs pour une cryptomonnaie permettant de créer un historique des ses valeurs.
- cryptocurrency : représentant une cryptomonnaie sans ces données. Facilitant le listage des différentes cryptomonnnaies enregistrer.
- cryptocurrencydata : représentant les données d'une cryptomonnaie à un temps précis.

## Web-App

**Technologies utilisé** : Python, Flask, HTML, CSS, JavaScript, SQLite, Locust, Snyk

Cette partie consistait à faire un site web utilisant la base de données décrite plus haut. Il devait permettre à l'utilisateur de s'enregistrer et de se connecter, de voir la listes des cryptomonnaies et de voir des graphes relatifs à chacun d'entre eux.

Ce serveur contien donc 6 pages différentes dont 5 pour une fonctionnalité différentes :
- La page de garde : `/` décrivant le site.
- La page d'enregistrement : `/register`.
- La page de connexion : `/login`.
- La page de visualisation d'information et modification utilisateur : `/account`.
- La page de résumé des 100 premières cryptomonnaies : `/cryptohome`.
- La page de visualisation des courbes d'une cryptomonnaie : `/cryptovision`.

Les graphes de la page `cryptovision` est générer par l'utilisateur en JavaScript pour limiter la puissance utilisé par le serveur. Ce code JavaScript fait une requette sur l'API  du site pour récupérer les données brutes à traiter sous forme de json.
