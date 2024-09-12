package nl.rasom.scala.workshop.exercise

import org.scalatest.wordspec.AnyWordSpec
import org.scalatestplus.mockito.MockitoSugar
import org.scalatest.matchers.should.Matchers
import nl.rasom.scala.workshop.exercise.console.WorkshopConsole

class LogicSpec extends AnyWordSpec with MockitoSugar with Matchers {
  trait Scope {
    trait WithMessage {
      def getMessages(): Seq[String]
      def getMessagesWithInput(): Seq[(String, String)]
    }
    val console = new WorkshopConsole with WithMessage {
      var messages: Seq[String] = Nil
      var messagesWithInput:Seq[(String, String)] =Nil
      var fakeInput = List("Alex", "22", "Haarlem", "Spaarne")
      def println(message: String) /* TODO: Insert return type */ = {
        messages = messages :+ message
        Some(())
      }
      def readLine() /* TODO: Insert return type */ = {
        val pick = fakeInput.head
        fakeInput = fakeInput.tail
        messagesWithInput = messagesWithInput :+ (messages.last, pick)
        Some(pick)
      }
      def getMessages(): Seq[String] = messages
      def getMessagesWithInput(): Seq[(String, String)] = messagesWithInput
    }
  }

  "LogicSpec" should {
    "execute successfully sequentially" in new Scope {
      Logic.execute(console)
      console.getMessagesWithInput() shouldEqual List(
        ("Please enter your name:", "Alex"),
        ("Please enter your age:", "22"),
        ("Please enter your city:", "Haarlem"),
        ("Please enter your street:", "Spaarne")
      )
    }
     "execute successfully" in new Scope {
      Logic.execute(console)
      console.getMessages() shouldEqual List(
        "Please enter your name:",
        "Please enter your age:",
        "Please enter your city:",
        "Please enter your street:",
        "User Details: Name: Alex, Age: 22, City: Haarlem, Street: Spaarne"
      )
    }
  }
}
