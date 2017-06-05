package funsets

object Main extends App {

  import FunSets._

 // println(contains(singletonSet(2), 2))
 // println(contains(diff(union(singletonSet(1), singletonSet(3)), singletonSet(2)), 2))
  val unionThree = (union(singletonSet(1), union(singletonSet(2), singletonSet(3))));
 //   println(FunSets.toString(filter(unionThree, x => x < 7)))

  println(exists(unionThree,x=>x>5))
  val single=singletonSet(2)
  printSet(map(single,x=>(x+3)))
}
