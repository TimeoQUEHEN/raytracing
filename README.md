# Rapport

---

## Répartition des tâches
### Nicolas :
- #3, Création de la classe Light
- #5, Création de la classe Scene
- #7, Création de la classe Main
- #12, Création de la classe Plane
- #16, Aide la Création de la classe Parser
- #20, Création de la classe RayTracing
- #21, Complète la classe Main pour implémenter la classe RayTracing
- #23, Complète la classe RayTracing pour détecter tout les objets présent sur la scène
- #26, Implémente le model Lambert dans la classe RayTracing
- #33, Implémente le patron de conception pour les ombres
- #34, Implémente l’approche permettant d’identifier une ombre potentielle
- #35, Complète la classe RayTracing pour les ombres
- #36, Ajoute l'option shadows dans le Parser
- #40, Complète la classe Raytracing pour permettre la lumière réflective
- #41, Complète la classe Parser pour accepter le mot-clé maxDepth
- #42, Permettre l'utilisation de maxDepth dans la classe RayTracing
- #54, Remodeler la structure de la classe RayTracing pour permettre l'utilisation de l'ensemble des fonctionnalités implémentées
- #56, Aider dans la création de la classe Checker
- #57, Réparer la classe Shadow
- #58, Gérer les exceptions dans le Parser


### Timéo : 
- #1, Créer la classe Triplet
- #2, Créer les classes Point, Vecteur et Couleur
- #13, Corriger les classes Sphere et Triangle
- #14, Ajouter un cas d'exception au constructeur de la classe Color
- #15, Vérifier le fonctionnement des classes Point, Vector et Coulor
- #18, Ajouter une méthode toString aux classes Point, Vector et Coulor
- #22, Ajouter une méthode à la classe Sphere pour trouver l'intersection
- #27, Développer le patron de conception pour la classe RayTracing pour choisir entre le model de base ou le model de Lambert
- #28, Développer le patron de conception pour la colorisation de base
- #32, Tester la génération de triangle et plan
- #37, Ajouter le model Blinn-Phong pour la classe Raytracing
- #38, Développer le patron de conception pour la lumière
- #39, Développer le patron de conception pour éviter la duplication de couleur
- #43, Ajouter la possibilité de calculer la couleur d'une case de damier
- #44, Développer la colorisation d'un damier
- #45, Ajouter le mot-clé checker dans le Parser
- #53, Aider dans la réalisation du calcul de couleurs réfléchies
- #59; Corriger le rapport


### Jules : 
- #8, Créer le diagramme UML
- #11, Résolution des problèmes d'encapsulation
- #17, Implémente le patron de conception "builder" pour la création de scène
- #19, Nettoyage, embellissement du code
- #24, Teste la création des images avec des formes 2D
- #29, Teste la création des images avec des formes "3D"
- #31, Ajoute la méthode qui permet de déterminer la distance avec un point dans la classe Triangle
- #55, Créer un script de lancement de l'application utilisable dans le shell


### Thomas :
- #4, Créer les classes Sphere et Triangle
- #6, Créer le Parser
- #25, Compléter les classes Sphere, Triangle et Plane pour implémenter les getters
- #30, Ajoute la méthode qui permet de déterminer la distance avec un point dans la classe Plane
- #52, Ecrire le rapport


---

## Justification des Implémentations

__Quel patron de conception vous permet de créer progressivement une scène, en lui fournissant les éléments qui la constitue au fur et à mesure ?__

Builder
On désire construire au fur et à mesure une Scene. Une fois tout les prérequis (attributs) affectés, nous construisons l'objet demandé.
Le Builder est le seul Model proposant cette logique d'implémentation : en effet, un Builder récupère un ensemble d'arguments, les utilise pour créer une instance d'une clase, et renvois cette instance. Dans le cas de notre scène; c'est bel et bien notre volonté !


__(Les couleurs dans votre lanceur de rayons) Quel patron de conception pourrait permettre de choisir entre utiliser ce modèle, ou uniquement celui de base ?__

L'objectif est de pouvoir choisir le modèle de colorisation à utiliser selon les mots-clés donnés dans le fichier d'exécution. Il faut alors que l'ensemble des modèles soient prêts, et que le code n'est qu'à donner le chemin à parcourir pour accéder au modèle le plus adapté. Ici, l'implémentation d'une stratégie définissant l'ensemble des modèles présents et futurs permettra au code de la classe principal d'utiliser un champs acceptant n'importe lequel des modèle.


__Quel patron de conception pourrait vous permettre d’éviter de dupliquer la détermination de la couleur de base dans le modèle de Lambert ?__

Décorateur parce que on rajoute une nouvelle fonctionnalité au dessus de la classe de base. Il suffira alors de "décorer" la classe de Lambert avec la méthode appelant le modèle de base.


__Quel patron de conception vous permet de pouvoir activer ou non la recherche d’une ombre sur le point d’intersection ?__

On veut pouvoir afficher ou non une ombre. Quand on veut afficher les ombres, l'objectif est de calculer, pour une lumière et un point d'intersection, si on trouve un autre point d'intersection entre les deux sinon on applique la stratégie qui nous est donnée sinon. Un décorateur dans la stratégie pour choisir quel modèle utiliser pour choisir les couleurs semble être parfait pour ces raisons.


__(Illumination de BlinnPhong) Quel patron de conception devez vous compléter pour tenir compte de ce modèle ?__

Une stratégie permettra de choisir entre les deux méthodes de colorisation précédemment implémentées (le modèle de Base et celui de Lambert) et le modèle de BlinnPhong. Il suffira alors de compléter cette dernière.


__Quel patron de conception pourrait vous permettre d’éviter de dupliquer la détermination de la couleur de base ou celle du modèle de Lambder dans le modèle de Blinn-Phong ?__

Ici, le décorateur permettra d'implémenter les fonctions de la stratégie inférieure dans la stratégie la nécessitant, ce qui empêchera la duplication de code. Par exemple, la stratégie de BlinnPhong ajoute à son calcul le résultat de la stratégie de Lambert; on peut donc décorer la la classe implémentant la stratégie de BlinnPhong avec l'appel de la méthode de Lambert. On pourra faire de même avec la classe de Lambert; dont le modèle additionne à son calcul l'ambiance de la scène.


__Quel patron de conception vous permet de calculer la couleur d’un point sur un objet, que celui soit d’une couleur unie ou comporte un damier ?__

Une Stratégie sera le patron le plus adapté à cette situation. Il suffira alors de définir une ,méthode unique à la colorisation d'un damier. Dans le RayTracing, faire un switch "if" permettra de diriger le code vers la bonne méthode, selon s'il pointe un pixel sur le damier ou sur n'importe quel autre élément.


__Quel patron de conception vous permet de facilement choisir une technique d’échantillonnage
parmi les trois proposées ?__

Il s'agira d'un patron Stratégie, puisqu'il permettra la définition des trois ,méthodes de sampling et de choisir parmi les trois la plus adaptée, selon la situation. La stratégie pourra être définie dans un champ pour ensuite être accessible a travers la classe plus tard. Par ailleurs; il faudra définir ces ,méthodes dans des classes à leur nom.
Comme il s'agit d'une méthode de colorisation, on pourra compléter la stratégie appelant les différent modèles de colorisation.

(Ce patron de développement n' a pas pu être implémenté.)
