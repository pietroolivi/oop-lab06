# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository



2. Ci si assicuri di avere localmente entrambi i branch remoti

>>git checkout -b imported-feat origin/feature

branch 'imported-feat' set up to track 'origin/feature'.
Si è passati a un nuovo branch 'imported-feat'



3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

>>git checkout master

>>git merge imported-feat

Merge automatico di HelloWorld.java in corso
CONFLITTO (contenuto): conflitto di merge in HelloWorld.java
Merge automatico fallito; risolvi i conflitti ed esegui il commit
del risultato.



4. Si noti che viene generato un **merge conflict**!



5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)

>|Accept Both Changes|

>git commit -m “Merged imported-feat into master”

>git log --all --oneline --graph  

*   37ac07f (HEAD -> master) Merged imported-feat into master
|\  
| * bed943f (origin/feature, imported-feat) Print author information
* | 8e0f29c (origin/master, origin/HEAD) Change HelloWorld to print the number of available processors
|/  
* d956df6 Create .gitignore
* 700ee0b Create HelloWorld



6. Si crei un nuovo repository nel proprio github personale



7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

>git remote add a-remote git@github.com:pietroolivi/es61-lab06.git

>git remote -v

a-remote        git@github.com:pietroolivi/es61-lab06.git (fetch)
a-remote        git@github.com:pietroolivi/es61-lab06.git (push)
origin  git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin  git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (push)



8. Si faccia push del branch `master` sul proprio repository

>>git push a-remote

Enumerazione degli oggetti in corso: 15, fatto.
Conteggio degli oggetti in corso: 100% (15/15), fatto.
Compressione delta in corso, uso fino a 8 thread
Compressione oggetti in corso: 100% (11/11), fatto.
Scrittura degli oggetti in corso: 100% (15/15), 1.61 KiB | 1.61 MiB/s, fatto.
15 oggetti totali (4 delta), 10 riutilizzati (2 delta), 0 riutilizzati nel file pack
remote: Resolving deltas: 100% (4/4), done.
To github.com:pietroolivi/es61-lab06.git
 * [new branch]      master -> master



9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

>git branch --set-upstream-to=a-rem

  imported-feat
* master
  remotes/a-remote/master
  remotes/origin/HEAD -> origin/master
  remotes/origin/feature
  remotes/origin/master