** How to compile **
scala-cli compile .
** How to test **
- All tests in all Specs
scala-cli test .
- All tests in Spec with name starts on "Logic"
scala-cli test . --test-only "Logic*"
- All tests in Spec with specific name
scala-cli test . --test-only "LogicSpec"
- All tests in Spec, filtered by string
scala-cli test . --test-only "Logic*" -- -z "scenario"
scala-cli test . --test-only "Logic*" -- -z "scenario 1"
- Specific test is specific Spec
scala-cli test . --test-only "Logic*" -- -t "Logic must run scenario 2 successfully"

** How to run **
scala-cli run .
scala-cli run . -- 1 two
scala-cli run . --list-main-classes
scala-cli run . --interactive -- 1 two
scala-cli run . --main-class Main -- 1 two
scala-cli run . --main-class scala2main -- 1 two

