object MainOption extends App {

  case class Workshop(level: String, duration: Int)

  val workshop1: Option[Workshop] = Some(
    Workshop(level = "Basic", duration = 2)
  )
  val workshop2: Option[Workshop] = Some(
    Workshop(level = "Advanced", duration = 3)
  )
  val workshop3: Option[Workshop] = Some(
    Workshop(level = "Mega", duration = 5)
  )

  // for-comprehension
  val resultFlatMap =
    workshop1.flatMap(w1 =>
      workshop2.flatMap(w2 =>
        workshop3.map { w3 =>
          s"flatmap:Common duration: ${w1.duration + w2.duration + w3.duration}"
        }
      )
    )
  println(s"Result: $result")

  val result: Option[String] = for {
    one <- workshop1
    second <- workshop2
    third <- workshop3
  } yield s"Common duration: ${one.duration + second.duration + third.duration}"
  println(s"Result: $result")

}
