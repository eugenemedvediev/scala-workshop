package nl.rasom.scala.workshop
import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar
import org.scalatest.matchers.should.Matchers

class LogicSpec extends AnyWordSpec with MockitoSugar with Matchers {
  trait Scope {
    trait WithMessage {
      def getMessages(): Seq[String]
    }
    val console = new CustomConsole with WithMessage {
      var messages: Seq[String] = Nil
      var fakeInput = List("1", "2", "3")
      def println(message: String): Option[Unit] = {
        messages = messages :+ message
        Some(())
      }
      def readLine(): Option[String] = {
        val pick = fakeInput.head
        fakeInput = fakeInput.tail
        Some(pick)
      }
      def getMessages(): Seq[String] = messages
    }
  }

  "LogicSpec" should {
    "execute successfully" in new Scope {
      Logic.execute(console)
      console.getMessages() shouldEqual List(
        "Please enter your name:",
        "Please enter your age:",
        "Please enter your city:",
        "User Details: Name: 1, Age: 2, City: 3"
      )
    }
  }
}
