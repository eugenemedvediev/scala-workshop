** How to compile **
```sh
scala-cli compile .
```

** How to test **
- All tests in all Specs
```sh
scala-cli test .
```
- All tests in Spec with name starts on "Logic"
```sh
scala-cli test . --test-only "Logic*"
```
- All tests in Spec with specific name
```sh
scala-cli test . --test-only "LogicSpec"
```
- All tests in Spec, filtered by string
```sh
scala-cli test . --test-only "Logic*" -- -z "scenario"
scala-cli test . --test-only "Logic*" -- -z "scenario 1"
```
- Specific test is specific Spec
```sh
scala-cli test . --test-only "Logic*" -- -t "Logic must run scenario 2 successfully"
```

** How to run **
```sh
scala-cli run .
```
```sh
scala-cli run . -- 1 two
```
```sh
scala-cli run . --list-main-classes
```
```sh
scala-cli run . --interactive -- 1 two
```
```sh
scala-cli run . --main-class Main -- 1 two
```
```sh
scala-cli run . --main-class scala2main -- 1 two
```

###Resources:
- [ScalaTest: Using the Runner](https://www.scalatest.org/user_guide/using_the_runner)
