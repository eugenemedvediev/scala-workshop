case class Book(title: String, author: String, year: Int) {
    def titleAndAuthor(times: Int): String = (title + author)*times
}
class NoString(title: String)

object BookDemo extends App {
  val book = Book("1984", "George Orwell", 1949)
  val book2 = Book("1984", "George Orwell", 1949)
  val noString = new NoString(title = "no string")
  val noString2 = new NoString(title = "no string")
  println(s"Title: ${book.title}, Author: ${book.author}, Year: ${book.year}")
  println(book)
  println(noString)
  println(book == book2)
  println(book.equals(book2))
  println(noString == noString2)
  println(noString.equals(noString2))
  println(book.titleAndAuthor(times = 1))
  println(book2.titleAndAuthor(times = 2))
}

