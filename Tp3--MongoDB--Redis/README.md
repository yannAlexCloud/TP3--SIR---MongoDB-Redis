# TP3--SIR-- MongoDB/Redis
### Description
Dans le cadre de l'unité d'enseignement système d'informations repartis, nous devons réaliser un travail pratique dont les objectifs sont les suivants:
* Comprendre les bénéfices et les limites des bases nosql
* Comprendre les différents types de bases nosql
* Réaliser une application en utilisant une API comme Morphia proche de JPA en se plaçant dans un cadre classique de développement au dessus d’une base orientée document comme Mongo.
* Comparer avec une base de données clé valeur haute performance comme Redis
### Limites des bases de données oreintées documents

#### Rédondence d'informations
Le modèle basé sur les documents comporte un document individuel pour chaque objet qu'on veut représenter.
Chaque document contient les mêmes types d'informations pour une donnée spécifique.

#### Absence de normalisation
Les données ne sont pas normalisées . cela signifie qu'on ne peux pas décomposer les données en tables plus petites et liées.

Ainsi, avec une BD orientée document, deux documents quelconques peuvent contenir une structure et un type de données différents. Par exemple, si un utilisateur choisit de ne pas fournir sa date de naissance, ce ne serait même pas un champ du document. Si un autre utilisateur fournit sa date de naissance, il s'agira d'un champ dans ce document.

#### Les jointures
les BD orientées document ne prennent pas en charge les jointures(Cas de MongoDB). Pourtant, on peut utiliser la fonctionnalité de jointure en la codant manuellement. Mais cela peut ralentir l'exécution et affecter les performances.

MongoDB stocke les noms de clé pour chaque paire de valeurs. De plus, en raison de l’absence de fonctionnalité de jointure, il existe une redondance des données. Cela se traduit par une utilisation accrue inutile de la mémoire.

#### Taille de données limitée

Par exemple pour MongoDB,on ne peut avoir une taille de document dépassant 16 Mo.
On ne peux pas imbriquer des documents pour plus de 100 niveaux.               


Sources:

https://database.guide/what-is-a-document-store-database/

https://data-flair.training/blogs/advantages-of-mongodb/

#### Documentation et installation de MongoDB:
https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/

# Les tyes de dnnées et requetes dans Redis

Redis permet princialement d'effectuer les meme requetes qu'une base de donnée classique: la consultation,la création, et la suppression.
Chaque structure de données présentes dans redis a ses commandes pour effecuer ces opérations,et bien d'autres encore.  

Les types de données et requetes Redis sont les suivants :

* Chaînes (String) : données de texte ou binaires jusqu’à 512 Mo
###### SET:  les commandes pour stocker,récupérer et supprimer très simplement une valeur au moyen d’une clé sont: SET,GET,DEL 
```
SET ma:clé "ma valeur"
GET ma:clé
"ma valeur"
DEL ma:clé
```


* Listes (List) : une collection de chaînes dans l’ordre où elles sont ajoutées

###### RPUSH:  Créer une liste 
```
RPUSH ma:liste  "Citron"
RPUSH ma:liste  "Orange"
RPUSH ma:liste  "Pomme"

````

###### LRANGE:suivi de la clé et des indices de début et de fin permet d'accéder aux valeurs de la liste
```
LRANGE ma:liste  0 -1
1) "Fraise"
```
###### LPOP et RPOP:  Permettent respectivement de supprimer le premier ou le dernier élémeent de la liste 
```
LPOP ma:liste
"Fraise"
RPOP ma:liste
"Pomme"
```

* Ensembles (Set) : une collection non ordonnée de chaînes avec la possibilité de croiser, unifier et différencier d’autres types d’ensembles

###### Les commandes principales pour ajouter et supprimer des valeurs dans un set sont SADD et SREM :
```
SADD mon:set "Fourchette"
SREM mon:set "Fourchette"
```

* Ensembles ordonnés (Sorted Set) : ensembles ordonnés selon une valeur

* Hachages(Hash) : une structure de données pour le stockage de listes de champs et de valeurs
###### Les commandes des Hash ressemblent à celle des données simples. Il suffit de rajouter un "H" au début de chaque commande. Par exemple: 
```
HSET utilisateur:1 nom "Thomas Bourgier"
```

* Bitmaps : un type de données permettant des opérations au niveau du bit

* HyperLogLogs : une structure de données basée sur la probabilité permettant d’estimer les éléments uniques d’un ensemble de données

Sources:

http://www.barreverte.fr/une-courte-introduction-a-redis/

http://b3d.bdpedia.fr/redis.html
#### Insallation et courte introduction à Redis:
https://www.digitalocean.com/community/tutorials/how-to-install-and-secure-redis-on-ubuntu-18-04

http://www.barreverte.fr/une-courte-introduction-a-redis/

Documentation complète ici: https://redis.io/documentation
