## Exemples

Cette section présente les commandes Git exécutées dans l'invite de commandes Windows 11 (CMD), ainsi que les résultats obtenus pendant l'exercice.

### 1. Ajouter le fichier README.md

Après avoir modifié le fichier `README.md`, l'ajouter à l'index Git :

```cmd
git add README.md
```

Cette commande prépare le fichier pour son prochain commit.

### 2. Créer le premier commit

```cmd
git commit -m "Mise a jour du README.md"
```

Résultat obtenu :

```text
[harry-francis c039acd] Mise a jour du README.md
 1 file changed, 112 insertions(+), 2 deletions(-)
```

**Explication :**

- `harry-francis` : branche sur laquelle le commit a été créé.
- `c039acd` : identifiant abrégé du commit.
- `112 insertions(+)` : 112 lignes ajoutées.
- `2 deletions(-)` : 2 lignes supprimées.

### 3. Premier push : erreur d'autorisation

Commande exécutée :

```cmd
git push -u origin harry-francis
```

Résultat obtenu :

```text
remote: Permission to gilles-poulet/testingGit.git denied to documentHarry.
fatal: unable to access 'https://github.com/gilles-poulet/testingGit.git/': The requested URL returned error: 403
```

**Explication :**

L'erreur HTTP `403` indique que GitHub a refusé l'opération faute d'autorisation.

Dans cet exercice, le problème venait d'une invitation de collaboration envoyée par le professeur qui n'avait pas encore été acceptée.

**Solution :** accepter l'invitation sur GitHub, puis relancer la commande.

### 4. Deuxième push : envoi réussi

Après avoir accepté l'invitation GitHub :

```cmd
git push -u origin harry-francis
```

Résultat obtenu :

```text
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 32 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 1.08 KiB | 1.08 MiB/s, done.
Total 3 (delta 0), reused 0 (delta 0), pack-reused 0 (from 0)

remote:
remote: Create a pull request for 'harry-francis' on GitHub by visiting:
remote: https://github.com/gilles-poulet/testingGit/pull/new/harry-francis

To https://github.com/gilles-poulet/testingGit.git
 * [new branch] harry-francis -> harry-francis
branch 'harry-francis' set up to track 'origin/harry-francis'.
```

**Explication :**

- Les objets Git ont été envoyés correctement.
- La branche distante `harry-francis` a été créée.
- Le suivi entre la branche locale et la branche distante a été configuré.
- GitHub propose de créer une Pull Request.

[Créer une Pull Request](https://github.com/gilles-poulet/testingGit/pull/new/harry-francis)

### 5. Effectuer un deuxième commit

Après une nouvelle modification du README :

```cmd
git add README.md
git commit -m "Mise a jour de la documentation"
```

Résultat obtenu :

```text
[harry-francis 8cdd9da] Mise a jour de la documentation
 1 file changed, 95 insertions(+), 7 deletions(-)
```

Un deuxième commit a été créé sur la même branche.

### 6. Envoyer les nouvelles modifications

```cmd
git push
```

Résultat obtenu :

```text
Enumerating objects: 5, done.
Counting objects: 100% (5/5), done.
Delta compression using up to 32 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 1.78 KiB | 1.78 MiB/s, done.
Total 3 (delta 0), reused 0, pack-reused 0 (from 0)

To https://github.com/gilles-poulet/testingGit.git
   c039acd..8cdd9da  harry-francis -> harry-francis
```

**Explication :**

Le commit `8cdd9da` a été envoyé sur GitHub.

La commande `git push` suffit désormais, car le suivi distant a été configuré lors du premier envoi réussi avec l'option `-u`.

### 7. Vérifier l'état du dépôt

```cmd
git status
```

Résultat obtenu :

```text
On branch harry-francis
Your branch is up to date with 'origin/harry-francis'.

Untracked files:
  (use "git add <file>..." to include in what will be committed)
        .vscode/

nothing added to commit but untracked files present (use "git add" to track)
```

**Explication :**

- La branche locale est synchronisée avec la branche distante.
- Le dossier `.vscode/` est présent localement, mais n'est pas suivi par Git.
- Aucun fichier suivi ne contient de modification en attente.

Le dossier `.vscode/` contient généralement des paramètres propres à Visual Studio Code.

Il n'est pas nécessaire de l'ajouter pour cet exercice.

Pour l'ignorer définitivement, il est possible d'ajouter la ligne suivante dans un fichier `.gitignore` :

```gitignore
.vscode/
```

### 8. Consulter l'historique des commits

```cmd
git log --oneline -3
```

Résultat obtenu :

```text
8cdd9da (HEAD -> harry-francis, origin/harry-francis) Mise a jour de la documentation
c039acd Mise a jour du README.md
0c7c8f6 (origin/main, origin/JonathanKasap, origin/HEAD, main) Initial commit
```

**Explication :**

- `8cdd9da` : dernier commit effectué.
- `c039acd` : premier commit du README.
- `0c7c8f6` : commit initial du dépôt.
- `HEAD` : indique le commit actuellement utilisé.
- `origin/harry-francis` : branche distante suivie.

### 9. Afficher les branches locales et distantes

```cmd
git branch -a
```

Extrait du résultat obtenu :

```text
* harry-francis
  main
  remotes/origin/HEAD -> origin/main
  remotes/origin/harry-francis
  remotes/origin/main
```

**Explication :**

- `harry-francis` : branche locale active.
- `main` : branche principale locale.
- `remotes/origin/harry-francis` : référence locale de la branche distante personnelle.
- `remotes/origin/main` : référence locale de la branche principale distante.

La commande affiche également les branches des autres étudiants présentes sur le dépôt distant.

### 10. Vérifier l'adresse du dépôt distant

```cmd
git remote -v
```

Résultat obtenu :

```text
origin  https://github.com/gilles-poulet/testingGit.git (fetch)
origin  https://github.com/gilles-poulet/testingGit.git (push)
```

**Explication :**

- `origin` : nom du dépôt distant.
- `fetch` : adresse utilisée pour récupérer les modifications.
- `push` : adresse utilisée pour envoyer les modifications.

Le dépôt distant correspond bien à celui du professeur.

### 11. Résultat final

L'exercice a permis de :

- Cloner un dépôt GitHub.
- Créer une branche personnelle.
- Modifier le fichier `README.md`.
- Ajouter les modifications à l'index Git.
- Créer plusieurs commits.
- Résoudre une erreur d'autorisation GitHub.
- Envoyer une branche vers le dépôt distant.
- Synchroniser les modifications locales et distantes.
- Vérifier l'historique et les branches Git.

**Branche créée :** `harry-francis`

**Dépôt GitHub :** [gilles-poulet/testingGit](https://github.com/gilles-poulet/testingGit)

**Branche personnelle :** [harry-francis](https://github.com/gilles-poulet/testingGit/tree/harry-francis)