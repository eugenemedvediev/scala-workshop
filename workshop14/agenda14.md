### Workshop 14: zio-cli as a base for cli application

---

### **Topics**:
1. Command Line Interface application execution and parameters
2. Build the simple zio-cli project
3. Pack the project using `sbt-assembly`
4. Pack the project using `sbt-native-packager`
5. Pack the project using `sbt-scala-native`
6. Test the project

---

### **1. Command Line Interface application execution and parameters**

- **Application name (Linux)**
- **Commands and SubCommands**
- **Options**
- **Arguments**

### **2. Build the simple zio-cli project**

- [Create simple application](../workshop8/agenda8.md)
- **Add zio and zio-cli dependencies**
  Change `project/Dependencies.scala` file
  ```scala
  import sbt._

  object Dependencies {
    lazy val Zio = "dev.zio" %% "zio" % "2.0.0"
    lazy val ZioCli = "dev.zio" %% "zio-cli" % "0.4.0"
  }
  ```
  Change `build.sbt` file
  ```scala
  import Dependencies._

  // ... some code here
  
  lazy val agenda = (project in file("."))
    .settings(
      name := "agenda",
      libraryDependencies += Zio,
      libraryDependencies += ZioCli,
      libraryDependencies += Munit % Test
    )
  ```
- **extend ZIOCliDefault**
- **Create first Command**
- **Add first subcommand**
 
### **3. Pack the project using `sbt-assembly`**

- **Dependency for sbt-assembly**
  Add the following code to `project/plugins.sbt`
  ```scala
  addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "2.3.0")
  ```
- **Import Build**
- **Execute sbt**
  ```sh
  sbt
  sbt:agenda> assembly
  ```
- **Set executable permissions**
  Find `.jar` file in the `target` directory
  ```sh
  chmod +x agenda-assembly-0.1.1-SNAPSHOT.jar
  sudo mv target/scala-2.13/agenda-assembly-0.1.1-SNAPSHOT.jar /usr/bin/agenda.jar
  ```
- **Execute application**
  Create wrapper `agenda` with content:
  ```script
  #!/bin/bash
  java -jar /usr/bin/agenda.jar $@
  ```
  ```sh
  sudo chmod +x /usr/bin/agenda
  which agenda 
  ```
  
### **4. Pack the project using `sbt-native-packager`**

- **Dependency for sbt-native-packer**
  Add the following code to `project/plugins.sbt`
  ```scala
  addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.10.4")
  ```
- **Prepare build.sbt**
  Add the following lines to the `build.sbt`:
  ```scala
  enablePlugins(JavaAppPackaging)
  
  Debian / maintainer := "Scala Workshop Rasom NL <developer@scalaworkshop.rasom.nl>"
  Compile / mainClass := Some("nl.rasom.scalaworkshop.Main")
  Compile / discoveredMainClasses := Seq()
  ```
- **Import Build**
- **Execute sbt**
  ```sh
  sbt
  sbt:agenda> Debian/packageBin
  ```
- **Install deb package**
  Find `.deb` file in the `target` directory
  ```sh
  sudo dpkg -i { packageName }.deb
  ```
- **Execute application**
  ```sh
  which agenda
  ```
  
### **5. Pack the project using `sbt-scala-native`**

- **Dependency for sbt-native-packer**
  Add the following code to `project/plugins.sbt`
  ```scala
  addSbtPlugin("org.scala-native" % "sbt-scala-native" % "0.4.5")
  ```
- **Prepare build.sbt**
  Add the following lines to the `build.sbt`:
  ```scala
  enablePlugins(ScalaNativePlugin)
  ```
  Note that you need to comment enablePlugins(ScalaNativePlugin) to be able to
  run tests
- **Import Build**
- **Execute sbt**
  ```sh
  sbt
  sbt:agenda> nativeLink
  ```
- **Move to /usr/bin/...**
  Find `agenda-out` file in the `target` directory
  ```sh
  sudo mv ./target/scala-2.13/agenda-out /usr/bin/agenda-out
  ```
- **Make wrapper**
  Make wrapper script which automatically puts result to the system clipboard
  ```sh
  sudo nvim /usr/bin/agenda
  ```
  content of agenda:
  ```
  #!/bin/bash

  value=$(/usr/bin/agenda $@)
  echo $value | xclip -selection clipboard
  echo $value
  ```

- add executive rights to the wrapper script
  ```sh
  sudo chmod +x /usr/bin/agenda
  ```
  
### **6. Test the project**

- **Execute application with the parameters**
  ```sh
  agenda -- add 'Simple Task'
  ```
