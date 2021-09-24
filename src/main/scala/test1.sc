

val arr = Array(
  Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
  Array(6, 7, 2, 1, 9, 5, 3, 4, 8),
  Array(1, 9, 8, 3, 4, 2, 5, 6, 7),
  Array(8, 5, 9, 7, 6, 1, 4, 2, 3),
  Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
  Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
  Array(9, 6, 1, 5, 3, 7, 2, 8, 4),
  Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
  Array(3, 4, 5, 2, 8, 6, 1, 7, 9)
)

val invalidArr =  Array(
  Array(5, 3, 4, 6, 7, 8, 9, 1, 2),
  Array(6, 7, 2, 1, 9, 0, 3, 4, 9),
  Array(1, 0, 0, 3, 4, 2, 5, 6, 0),
  Array(8, 5, 9, 7, 6, 1, 0, 2, 0),
  Array(4, 2, 6, 8, 5, 3, 7, 9, 1),
  Array(7, 1, 3, 9, 2, 4, 8, 5, 6),
  Array(9, 0, 1, 5, 3, 7, 2, 1, 4),
  Array(2, 8, 7, 4, 1, 9, 6, 3, 5),
  Array(3, 0, 0, 4, 8, 1, 1, 7, 9)
)




def check(arr: Array[Array[Int]]): Boolean = {
  val bar = for {
    i <- arr
    foo = if(i.sorted.containsSlice(1 to 9)) true else false
  } yield foo
  !bar.contains(false)
}
check(arr)
check(invalidArr)


//arr(0) sameElements arr(1)
//val f = arr.map(x => x.head)
//val g = arr.map(x => x.tail)
//val f = g.map(x => x.head)
//f

//def turnArray(arr: Array[Array[Int]], acc: Array[Array[Int]]): Array[Array[Int]] = {
//  if(arr.isEmpty) acc
//  else {
//    println(arr.map(x => x.head).mkString("Array(", ", ", ")"))
//    turnArray(arr.map(x => x.tail), acc :+ arr.map(x => x.head))
//  }
//}
//println(turnArray(arr, Array.empty))

//try {
//  turnArray(arr.map(x => x.tail), acc :+ arr.map(x => x.head))
//} catch {
//  case e: UnsupportedOperationException => acc
//}

def change(arr: Array[Int], acc: Array[Int]): Array[Int] = {
  if (arr.isEmpty) acc
  else change(arr.slice(0, arr.length - 1), acc :+ arr.last)
}
change(Array(1, 2, 3, 4, 5, 6), Array.empty)

for {
  i <- arr
} yield i.head