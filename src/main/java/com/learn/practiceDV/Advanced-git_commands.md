* Git commit amend is a function in git that enables you to change or modify the last commit to a new commit.
* The **git amend commit –m "message"** option permits you to modify a commit message either written wrongly or has an unclear message. 
* **git commit --amend** is used to modify the most recent commit. It combines changes in the staging environment with the latest commit, and creates a new commit. 
* The **git rebase -i HEAD~n** n is position of commit from the top most commit. used to modify the required commit.
* The **git log --oneline** used to see the list of commits commited.
* The **squash** in place of **pick** to merge many into one. ex: 2 commits into 1, 3 commits into 1.
* If there are 3 commits and you replaced pick with squach for third commit then 3rd + above 2 will altogether convert to single commit that we chnaged to.
* The **reword** in place of **pick** to change the required commit.

## fixes for the issues that might arise while using above git commands
* If **:**  then type **wq** to continue
* If **-- INSERT --**  then type **Ctrl c** and enter **:wq**
* If you get file is set to **read-only** then enter **Ctrl c** then **:qa!** or **:qa** as suggested on the terminal 
* If it's gives swap file issue with **E325: ATTENTION** then press **Ctrl c** then enter **D** out of the 4 options among EDIT, READ, DELETE, QUIT. 

