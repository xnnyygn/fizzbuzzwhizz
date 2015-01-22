import org.scalatest._

class FizzBuzzWhizzSpec extends FlatSpec with Matchers {

  val fbw = FizzBuzzWhizz

  "FizzBuzzWhizz" should "reject 0 digit, require 3 digits" in {
    a [IllegalArgumentException] should be thrownBy {
      fbw.run("")
    }
  }

  it should "reject 2 digits, require 3 digits" in {
    a [IllegalArgumentException] should be thrownBy {
      fbw.run("1,2")
    }
  }

  it should "reject 4 digits, require 3 digits" in {
    a [IllegalArgumentException] should be thrownBy {
      fbw.run("1,2,3,4")
    }
  }

  it should "require 3 digits, not alphabet" in {
    a [IllegalArgumentException] should be thrownBy {
      fbw.run("a,2,3")
    }
  }

  it should "require 3 digits, length < 2" in {
    a [IllegalArgumentException] should be thrownBy {
      fbw.run("11,2,3")
    }
  }

  it should "require 3 digits, length > 0" in {
    a [IllegalArgumentException] should be thrownBy {
      fbw.run(",2,3")
    }
  }

  it should "require 3 different digits" in {
    a [IllegalArgumentException] should be thrownBy {
      fbw.run("2,2,3")
    }
  }

  it should "require 3 digits, reject 0" in {
    a [IllegalArgumentException] should be thrownBy {
      fbw.run("2,0,3")
    }
  }

  it should "say 1 when (3,5,7) 1" in {
    fbw.run("3,5,7", 1) should be (Seq("1"))
  }

  it should "say Fizz when (3,5,7) 13" in {
    fbw.run("3,5,7", 13) should be (Seq("Fizz"))
  }

  it should "say Fizz when (3,5,7) 35" in {
    fbw.run("3,5,7", 35) should be (Seq("Fizz"))
  }

  it should "say Fizz when (3,5,7) 3" in {
    fbw.run("3,5,7", 3) should be (Seq("Fizz"))
  }

  it should "say Buzz when (3,5,7) 5" in {
    fbw.run("3,5,7", 5) should be (Seq("Buzz"))
  }

  it should "say Whizz when (3,5,7) 7" in {
    fbw.run("3,5,7", 7) should be (Seq("Whizz"))
  }

  it should "say FizzBuzz when (3,5,7) 15" in {
    fbw.run("3,5,7", 15) should be (Seq("FizzBuzz"))
  }

  it should "say FizzWhizz when (3,5,7) 21" in {
    fbw.run("3,5,7", 21) should be (Seq("FizzWhizz"))
  }

  it should "say BuzzWhizz when (3,5,7) 70" in {
    fbw.run("3,5,7", 70) should be (Seq("BuzzWhizz"))
  }

  it should "say FizzBuzzWhizz when (3,5,7) 105" in {
    fbw.run("3,5,7", 105) should be (Seq("FizzBuzzWhizz"))
  }

}
