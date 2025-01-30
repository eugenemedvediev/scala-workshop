# Workshop 2: Git basics and project preparation
---

## Topics:
1. Clone repository
2. Get latest changes from the remote server
3. Hard reset to origin main branch
4. Check the current git branch
5. Create new working branch

---

### 1. Clone repository
- make working folder
  ```
  cd ~
  pwd
  mkdir projects
  cd projects
  ```
- ssh clone
  ```sh
  git clone git@github.com:eugenemedvediev/scala-workshop.git
  ```
- Optionally you can clone using https url: https clone
  ```sh
  git clone https://github.com/eugenemedvediev/scala-workshop.git
  ```

### 2. Get latest changes from the remote server

- Fetch the new code for all branches from the remote server
  ```sh
  git fetch
  ```
- Pull the changes into local main branch
  ```sh
  git pull origin main
  ```
- In case of any errors execute command from the step 3: Hard reset to origin main branch
 
### 3. Hard reset to origin main branch

- Hard reset
  ```sh
  git reset --hard origin/main
  ```

### 4. Check the current git branch
- Show the current git branch
  ```
  git branch
  ```

### 5. Create new working branch
- Create new git branch and navigate to it
  ```
  git checkout -b my-first-new-branch
  git branch
  ```
  