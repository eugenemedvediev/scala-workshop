Not tested
### Workshop 12: Creating a GitHub Repository and Setting Up SSH Keys

**Objective**: By the end of this workshop, students will know how to create a GitHub repository, set up SSH keys for secure communication with GitHub, and push their first project to the repository.

---

### **Topics**:
1. Introduction to GitHub
2. Creating a GitHub Repository
3. Generating and Adding SSH Keys
4. Cloning the Repository Locally
5. Pushing a Project to GitHub

### **Activities**:
- Creating a new GitHub repository.
- Setting up SSH keys for secure communication.
- Cloning the repository and pushing an initial project.

---

### **1. Introduction to GitHub**

**a. What is GitHub?**

- **Definition**: GitHub is a platform for version control and collaboration, allowing you to manage and share your code with others.
- **Key Features**:
  - Hosting Git repositories.
  - Collaboration through pull requests and issues.
  - Continuous integration and deployment.

---

### **2. Creating a GitHub Repository**

**a. Steps to Create a Repository**

1. **Log in to GitHub**:
   - Go to [GitHub](https://github.com/) and log in to your account.

2. **Create a New Repository**:
   - Click on the **+** icon at the top right of the GitHub page and select **New repository**.

3. **Fill in the Repository Details**:
   - **Repository Name**: Choose a name for your repository (e.g., `MyFirstRepo`).
   - **Description**: Optionally add a description.
   - **Visibility**: Choose between Public or Private.
   - **Initialize**: Optionally add a `README.md` file (recommended).

4. **Click "Create repository"**:
   - Your new repository is now created and ready to use.

**Activities:**
1. **Create Your First Repository**
   - Follow the steps above to create your own repository on GitHub.

---

### **3. Generating and Adding SSH Keys**

**a. Why Use SSH Keys?**

- **Definition**: SSH keys provide a secure way to authenticate with GitHub without needing to enter your password each time.
- **Benefits**:
  - Enhanced security.
  - Convenience for frequent Git users.

**b. Generate SSH Keys**

1. **Open a Terminal**:
   - On Linux/Mac:
     ```sh
     ssh-keygen -t ed25519 -C "your_email@example.com"
     ```
   - On Windows (using Git Bash):
     ```sh
     ssh-keygen -t ed25519 -C "your_email@example.com"
     ```

2. **Follow the Prompts**:
   - When prompted to "Enter a file in which to save the key", press Enter to accept the default location.
   - Optionally, add a passphrase for additional security.

3. **Copy the SSH Key to Your Clipboard**:
   - Run the following command to copy the SSH key:
     ```sh
     cat ~/.ssh/id_ed25519.pub | pbcopy
     ```
   - On Linux:
     ```sh
     cat ~/.ssh/id_ed25519.pub | xclip -selection clipboard
     ```
   - On Windows:
     ```sh
     cat ~/.ssh/id_ed25519.pub | clip
     ```

**c. Add SSH Key to GitHub**

1. **Go to GitHub Settings**:
   - Click on your profile picture in the top right corner and select **Settings**.

2. **Navigate to SSH and GPG Keys**:
   - In the left sidebar, click on **SSH and GPG keys**.

3. **Add a New SSH Key**:
   - Click on **New SSH key**.
   - **Title**: Enter a descriptive name (e.g., `My Laptop Key`).
   - **Key**: Paste the SSH key from your clipboard.
   - Click **Add SSH key**.

4. **Test the SSH Connection**:
   - Run the following command in your terminal:
     ```sh
     ssh -T git@github.com
     ```
   - You should see a message like "Hi `username`! You've successfully authenticated."

**Activities:**
1. **Generate and Add SSH Keys**
   - Follow the instructions to generate an SSH key and add it to your GitHub account.

---

### **4. Cloning the Repository Locally**

**a. Clone Your Repository**

1. **Get the Repository URL**:
   - Navigate to your GitHub repository and click the green **Code** button.
   - Select the **SSH** tab and copy the repository URL.

2. **Clone the Repository Using SSH**:
   - In your terminal, navigate to the directory where you want to clone your repository:
     ```sh
     cd /path/to/your/directory
     ```
   - Run the `git clone` command:
     ```sh
     git clone git@github.com:username/MyFirstRepo.git
     ```

**Activities:**
1. **Clone Your Repository**
   - Use the steps above to clone your newly created GitHub repository to your local machine.

---

### **5. Pushing a Project to GitHub**

**a. Create a Simple Scala Project**

1. **Navigate to Your Cloned Repository**:
   - Go to the directory where your repository was cloned:
     ```sh
     cd MyFirstRepo
     ```

2. **Create a Simple Scala Script**:
   - Create a new file named `Main.scala` inside a `src` directory:
     ```sh
     mkdir -p src/main/scala
     touch src/main/scala/Main.scala
     ```
   - Open `Main.scala` and add a simple Scala program:
     ```scala
     object Main extends App {
       println("Hello, GitHub!")
     }
     ```

**b. Add, Commit, and Push the Project**

1. **Add the Files to Git**:
   - Stage the new files for commit:
     ```sh
     git add .
     ```

2. **Commit the Changes**:
   - Commit the staged files with a message:
     ```sh
     git commit -m "Initial commit with Hello, GitHub!"
     ```

3. **Push the Changes to GitHub**:
   - Push the committed changes to your GitHub repository:
     ```sh
     git push origin main
     ```

**Activities:**
1. **Push Your First Project**
   - Follow the steps to add, commit, and push your simple Scala project to GitHub.

---

### **Additional Resources**
- **GitHub Documentation:** [GitHub Docs](https://docs.github.com/en)
- **Learn Git:** [Atlassian Git Tutorial](https://www.atlassian.com/git/tutorials)
- **Git Handbook:** [Git Handbook](https://guides.github.com/introduction/git-handbook/)

---

By the end of this workshop, students will have successfully created a GitHub repository, set up SSH keys for secure communication, cloned the repository to their local machine, and pushed their first Scala project to GitHub. This foundation will be critical for managing and sharing their future Scala projects effectively.
