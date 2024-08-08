object MainOption extends App {

  case class Workshop(level: String, duration: Int)

  val workshop1: Option[Workshop] = Some(
    Workshop(level = "Basic", duration = 2)
  )

  val workshop2: Option[Workshop] = // None
    Some(
      Workshop(level = "Advanced", duration = 3)
    )

  val workshop2a: Option[Workshop] = Some(
    Workshop(level = "Advanced Alternative", duration = 4)
  )

  val workshop3: Option[Workshop] = Some(
    Workshop(level = "Professional", duration = 5)
  )

  private def printlnMessage(w1: Workshop, w2: Workshop, w3: Workshop): String =
    s"\n'${w1.level} and ${w2.level} and ${w3.level}'; Duration: ${w1.duration + w2.duration + w3.duration}\n"

  // flatMap.{flatMap ...}.map
  val resultFlatMap =
    workshop1
      .flatMap(w1 =>
        workshop2
          .flatMap(w2 =>
            workshop3.map { w3 =>
              "flatMap.flatMap.map =" + printlnMessage(w1, w2, w3)
            }
          )
      )
    // .getOrElse("Some of workshops is/are missing")
  println(s"Result: $resultFlatMap\n")

  // for-comprehension
  val result = for {
    w1 <- workshop1
    w2 <- workshop2
    w3 <- workshop3
  } yield s"for-comprehension =" + printlnMessage(w1, w2, w3)
  // ).getOrElse("Some of workshops is/are missing")
  println(s"Result: $result")

}
