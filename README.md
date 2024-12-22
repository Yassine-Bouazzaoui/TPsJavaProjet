# Projet Maven : TP Java

## Description
Ce projet Maven a pour objectif de travailler sur trois concepts fondamentaux en Java : le tri, l'utilisation des itérateurs, et les filtres avec Java 8. Chaque partie est développée et testée conformément aux consignes fournies.

## Structure du Projet

Le projet est organisé selon les conventions standard de Maven :

```
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── com.bouazzaoui.filter
│   │   │   │   └── PersonService.java
│   │   │   ├── com.bouazzaoui.iterator
│   │   │   │   └── Person.java
│   │   │   └── com.bouazzaoui.tri
│   │   │       └── Person.java
│   ├── test
│   │   ├── java
│   │   │   ├── com.bouazzaoui.filtertest
│   │   │   │   └── PersonFilterTest.java
│   │   │   ├── com.bouazzaoui.iteratortest
│   │   │   │   ├── TestPersonWithIterator.java
│   │   │   │   └── TestPersonWithoutIterator.java
│   │   │   └── com.bouazzaoui.tritest
│   │   │       └── SortPersonsTest.java
```

## Fonctionnalités
### 1. Tri (Package `tri`)
- Implémentation d'une classe `Person` avec les attributs `lastName` et `firstName`.
- Tri d'une liste de personnes par nom de famille et par prénom en cas d'égalité.
- Tests unitaires pour valider le tri.

### 2. Iterators (Package `iterator`)
- Manipulation d'un `Set` de personnes pour comprendre les exceptions lors de modifications pendant une itération.
- Utilisation de `Iterator` pour éviter les exceptions.
- Tests unitaires démontrant les comportements avec et sans iterator.

### 3. Filtrage (Package `filter`)
- Utilisation de `Predicate` pour filtrer une liste de personnes selon des conditions :
  - Par adresse.
  - Par âge (adultes uniquement).
  - Par conditions personnalisées (par exemple, prénom commençant par "A").
- Tests unitaires validant les différents filtres.

## Technologies Utilisées
- **Langage** : Java 8
- **Build Tool** : Maven
- **Tests** : JUnit 5 et AssertJ

## Instructions pour Exécuter
1. Cloner le dépôt GitHub :
   ```bash
   git clone https://github.com/Yassine-Bouazzaoui/TPsJavaProjet.git
   cd TPsJavaProjet
   ```

2. Exécuter les tests :
   ```bash
   mvn clean test
   ```
   Tous les tests doivent passer avec succès (indicateur vert).

3. Analyser le code :
   - Les classes principales sont dans `src/main/java`.
   - Les classes de test sont dans `src/test/java`.

## Auteur
- **Nom** : Bouazzaoui Yassine
- **Email** : yassinebouazzaoui2003@gmail.com

## Remarques
- Respect des consignes pour l'organisation du projet.
- Tests unitaires complets couvrant les différents cas d'utilisation.

## Licence
Ce projet est sous licence MIT. Vous êtes libre de l'utiliser, de le modifier, et de le distribuer, à condition de mentionner l'auteur original.

