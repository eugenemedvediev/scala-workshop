object CaseClassApply extends App {
  case class Cat(name: String, age: Int, kind: String)
  object Cat {
    def apply(name: String, age: Int): Cat =
      Cat(name = name, age = age, kind = "unknown")
  }
  val pus2 = Cat(name = "Pus2", age = 3, kind = "british")
  val pus = Cat(name = "Pus", age = 2)
  println(s"My cat $pus")
  println(s"My cat2 $pus2")
  println(s"My cat2 $pus2")


//[{"data":{"measureGroups":true}}, {"data":{"measureItems":true}}]
  case class DataDto(
      mesureItems: Option[Boolean],
      mesureGroups: Option[Boolean]
  ){
    def hasItems: Boolean = mesureItems.size > 0
    private def hasGroups: Boolean = mesureGroups.size > 0
  }
  object DataDto{
    def hasData(dataDto: DataDto): Boolean = dataDto.hasItems && dataDto.hasGroups
  }
  val hasItems = DataDto(mesureGroups = None, mesureItems = None).hasItems
  //val hasGroups = DataDto(mesureGroups = None, mesureItems = None).hasGroups

  case class BolComDto(datas: List[DataDto])
  object BolComDto {}

}
