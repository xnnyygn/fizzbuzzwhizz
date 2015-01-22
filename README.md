# fizzbuzzwhizz

a simple solution written in scala

## rule

* if n % 3 == 0, say Fizz, if n % 5 == 0, say Buzz, if n % 7 == 0, say Whizz
* if n % 5 and n % 7, say BuzzWhizz and so on
* if n has 3 in digits, just say Fizz

## requirement

 1. [Scala](http://www.scala-lang.org/)
 2. [SBT](http://www.scala-sbt.org/)


## how to run

	$ sbt 'run 3,5,7'
	
or

	$ scala FizzBuzzWhizz.scala 3,5,7

## how to test

	$ sbt test