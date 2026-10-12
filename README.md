# Test sur les fonctionnalités de Git

## Description

Application de l'exercice sur les fonctionnalités de Git.

**Réalisé par :** Harry Francis

Ce dépôt est utilisé pour apprendre et pratiquer les principales commandes de Git et GitHub.

## Prérequis

Aucun.

## Installation

### 1. Créer un dossier de travail

```cmd
mkdir Git_test1
```

### 2. Entrer dans le dossier

```cmd
cd Git_test1
```

### 3. Cloner le dépôt GitHub

```cmd
git clone https://github.com/gilles-poulet/testingGit.git
```

### 4. Entrer dans le dépôt cloné

```cmd
cd testingGit
```

### 5. Créer une branche personnelle

```cmd
git switch -c harry-francis
```

### 6. Ouvrir le projet dans VS Code

```cmd
code .
```

## Vérification de la branche

Afficher les branches locales :

```cmd
git branch
```

Exemple de résultat attendu :

```text
* harry-francis
  main
```

L'astérisque (`*`) indique la branche actuellement utilisée.

## Enregistrement des modifications

Après avoir modifié le fichier `README.md`, vérifier les changements :

```cmd
git status
```

Ajouter le fichier à l'index Git :

```cmd
git add README.md
```

Créer un commit :

```cmd
git commit -m "Mise a jour du README.md"
```

Envoyer la branche vers le dépôt distant :

```cmd
git push -u origin harry-francis
```

**Remarque :** cette dernière commande nécessite les droits d'écriture sur le dépôt distant.

## Exemples

N/A

## Contributions

Voir la documentation officielle de GitHub :

[Contribuer à un projet sur GitHub](https://docs.github.com/fr/get-started/exploring-projects-on-github/contributing-to-a-project)

## Licence

Voir la licence GNU GPL v3.0 :

[GNU General Public License v3.0](https://choosealicense.com/licenses/gpl-3.0/)