import org.scalatest.*
import org.scalatest.matchers.*
import org.scalatest.matchers.should.Matchers.shouldEqual
import org.scalatest.wordspec.AnyWordSpec

class LogicSpec extends AnyWordSpec {
  "Logic" must {
    "run scenario 1 successfully" in {
      Logic.run("a") shouldEqual "'a' is running"
    }
    "run scenario 2 successfully" in {
      Logic.run("b") shouldEqual "'b' is running"
    }
  }
}
