### Workshop 2: Git basics and project preparation

---

### **Topics**:
1. Clone repository
2. Hard reset to origin main branch
3. Get latest changes from the remote server


---

### **1. Clone repository**

- **Ssh clone**
  ```sh
  git clone git@github.com:eugenemedvediev/scala-workshop.git
  ```
- **Https clone**
  ```sh
  git clone https://github.com/eugenemedvediev/scala-workshop.git
  ```

### **2. Hard reset to origin main branch**

- **Hard reset**
  ```sh
  git reset --hard origin/main
  ```
  
### **3. Get latest changes from the remote server**

- **Fetch the new code for all branches from the remote server**
  ```sh
  git fetch
  ```
- **Pull the changes into local main branch**
  ```sh
  git pull origin main
  ```
- **In case of any errors execute command from step 2: Hard reset**
