# Test sur les fonctionnalités de Git

## Description

Application de l'exercice sur les fonctionnalités de Git.

**Réalisé par :** Harry Francis

Ce dépôt est utilisé pour apprendre et pratiquer les principales commandes de Git et GitHub.

## Prérequis

Aucun.

Pour exécuter les commandes présentées ci-dessous, Git doit être installé sur l'ordinateur. Visual Studio Code est facultatif.

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

### 6. Ouvrir le projet dans Visual Studio Code

```cmd
code .
```

## Vérification de la branche

Afficher les branches locales :

```cmd
git branch
```

Résultat obtenu :

```text
* harry-francis
  main
```

L'astérisque (`*`) indique la branche actuellement utilisée.

## Enregistrement des modifications

### 1. Vérifier les modifications

Après avoir modifié et enregistré le fichier `README.md` :

```cmd
git status
```

Exemple de résultat :

```text
On branch harry-francis
Changes not staged for commit:
    modified: README.md
```

### 2. Ajouter le fichier à l'index Git

```cmd
git add README.md
```

### 3. Créer un commit

```cmd
git commit -m "Mise a jour du README.md"
```

Résultat obtenu lors du premier commit :

```text
[harry-francis c039acd] Mise a jour du README.md
1 file changed, 112 insertions(+), 2 deletions(-)
```

## Envoi des modifications sur GitHub

### 1. Vérifier les autorisations

Pour pouvoir envoyer les modifications sur le dépôt du professeur, il faut disposer des droits d'écriture.

Dans cet exercice, le professeur avait envoyé une invitation de collaboration sur GitHub.

Cette invitation devait être acceptée avant de pouvoir effectuer le `push`.

Sans cette autorisation, GitHub renvoie une erreur :

```text
remote: Permission to gilles-poulet/testingGit.git denied to documentHarry.
fatal: unable to access repository: The requested URL returned error: 403
```

**Solution :** accepter l'invitation GitHub du propriétaire du dépôt, puis relancer la commande `git push`.

### 2. Pousser la branche vers le dépôt distant

```cmd
git push -u origin harry-francis
```

Cette commande envoie la branche locale `harry-francis` vers le dépôt distant `origin`.

L'option `-u` établit le suivi entre la branche locale et la branche distante.

Après acceptation de l'invitation, le résultat obtenu est :

```text
To https://github.com/gilles-poulet/testingGit.git
 * [new branch] harry-francis -> harry-francis
branch 'harry-francis' set up to track 'origin/harry-francis'.
```

### 3. Consulter la branche sur GitHub

[Voir la branche harry-francis](https://github.com/gilles-poulet/testingGit/tree/harry-francis)

### 4. Envoyer les prochaines modifications

Une fois le suivi de la branche configuré, les prochains envois peuvent être effectués avec :

```cmd
git add README.md
git commit -m "Mise a jour de la documentation"
git push
```

## Vérifications finales

Vérifier l'état du dépôt :

```cmd
git status
```

Consulter l'historique des commits :

```cmd
git log --oneline -3
```

Afficher les branches locales et distantes :

```cmd
git branch -a
```

Vérifier l'adresse du dépôt distant :

```cmd
git remote -v
```

## Exemples

N/A

## Contributions

Voir la documentation officielle de GitHub :

[Contribuer à un projet sur GitHub](https://docs.github.com/fr/get-started/exploring-projects-on-github/contributing-to-a-project)

## Licence

Voir la licence GNU GPL v3.0 :

[GNU General Public License v3.0](https://choosealicense.com/licenses/gpl-3.0/)