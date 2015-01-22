object FizzBuzzWhizz {

  // an extractor for digit
  object Digit {

    private val DIGIT = "^([1-9])$".r
    
    def unapply(s: String): Option[Int] = s match {
      case DIGIT(d) => Some(d.toInt)
      case _ => None
    }

  }

  // test if number contains specified digit
  private def hasDigit(n: Int, d: Int): Boolean = n match {
    case 0 => false
    case x if x % 10 == d => true
    case _ => hasDigit(n / 10, d)
  }

  private def sayNum(n: Int, rules: List[(Int, String)]): String = {
    val (a, fizz) = rules.head 
    // if number contains fizz number, just say fizz
    if(hasDigit(n, a)) return fizz
    rules.flatMap { 
      case (m, code) if n % m == 0 => Some(code)
      case _ => None
    } match {
      case Nil => n.toString // n % a != 0 && n % b != 0 && n % c != 0
      case cs => cs.mkString
    }
  }

  /* a simple version of say number
  private def sayNumSimple(n: Int, a: Int, b: Int, c: Int): String = {
    (hasDigit(n, a), n % a, n % b, n % c) match {
      case (true, _, _, _) => "Fizz"
      case (_, 0, 0, 0) => "FizzBuzzWhizz"
      case (_, 0, 0, _) => "FizzBuzz"
      case (_, 0, _, 0) => "FizzWhizz"
      case (_, _, 0, 0) => "BuzzWhizz"
      case (_, 0, _, _) => "Fizz"
      case (_, _, 0, _) => "Buzz"
      case (_, _, _, 0) => "Whizz"
      case _ => n.toString
    }
  } */

  def run(ds: String): Seq[String] = run(ds, 1 to 100)

  def run(ds: String, n: Int): Seq[String] = run(ds, List(n))

  def run(ds: String, ns: Seq[Int]): Seq[String] = {
    // 3,5,7
    // separate by commma
    // filter empty string
    ds.split(',').filterNot(_.isEmpty) match {
      // a = 3, b = 5, c = 7
      // try to match digit
      case Array(Digit(a), Digit(b), Digit(c)) if a != b && b != c && a != c => ns.map { 
        sayNum(_, List((a, "Fizz"), (b, "Buzz"), (c, "Whizz")))
      }
      case _ => throw new IllegalArgumentException("expect three different digits (1-9)")
    }
  }

  def main(args: Array[String]): Unit = try {
    run(args.headOption.getOrElse(""), 1 to 100).foreach(println)
  } catch {
    // throw when encounter illegal input
    case e: IllegalArgumentException => println("usage: <a,b,c>\n%s".format(e.getMessage))
  }

}
