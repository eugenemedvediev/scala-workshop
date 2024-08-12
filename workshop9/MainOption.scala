import scala.collection.immutable.Range.Inclusive
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
object Main2 extends App {

  case class User(name: String, age: Int)

  val maybeUser: Option[User] = None // Some(User(name = "Tom", age = 25))

  val mapped: Option[String] = maybeUser.map {
    case User("Tom", 23) => "Young Tom"
    case User("Tom", 25) => "Tom today"
    case User("Tom", _)  => "Tom other"
  }
  println(s"mapped: $mapped")

  val maybeUser2: Option[User] = None // Some(User(name = "Tom", age = 25))
  val maybeAge = maybeUser2.map(x => {
    println(s"I am inside map with value ${x.age}")
    x.age
  })
  println(s"Age = ${maybeAge.getOrElse(0)}")

}

object Main3 extends App {
  val conditionWeather = None // Some("Wind")
  val conditionWeatherAlternative = Some("Rain")
  val conditionTime = Some("Tuesday")
  val conditionTemperature: Some[Inclusive] = Some(20 to 25)

  val result =
    conditionTemperature.flatMap(temp =>
      conditionTime.flatMap(day =>
        Some(
          println(s"FlatMap: today is $day")
        ).flatMap(_ =>
          conditionWeather
            .orElse(conditionWeatherAlternative)
            .map(weather => s"Blowing $weather on $day with temp $temp")
        )
      )
    )
  println(s"result: $result")

  val result2: Option[String] = for {
    temp <- conditionTemperature
    day <- conditionTime if (temp.contains(21))
    _ <- Some(println(s"FlatMap: today is $day"))
    _ <- Some(println(s"FlatMap: tomorrow is ${day + 1}"))
    weather <- conditionWeather.orElse(conditionWeatherAlternative)

  } yield s"Blowing $weather on $day with temp $temp"
  println(s"result2: $result2")
}
