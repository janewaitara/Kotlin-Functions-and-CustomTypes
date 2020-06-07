package classInheritanceandInterfaces

// 3-06 Challenge - Classes - Starter

/*
Challenge 1 - Building a Class Hierarchy
Create a class named `Animal` that has…
1. a method named `speak()` that does nothing.

Create two `Animal` subclasses...
1. `WildAnimal` that...
  - has an `isPoisonous` property, that is a `Boolean`
2. `Pet` that...
  - has a stored property named `name`, that is a `String`
  - has a `play()` method that prints out a message
  - overrides `speak()` - It should print out a message

Create one subclass of your choice of `WildAnimal` or `Pet`. It should do at least one of the following:
 - override `speak()`
 - override `play()`
 - Add a new property with custom accessor
 - Add a new method
*/


open class Animal{

    open fun speak(){

    }
}
class WildAnimal(val isPoisonous: Boolean): Animal()
open class Pet : Animal {

    val name: String

    constructor(name: String){
        this.name = name
    }


    open fun play(){
        println("Hello $name, lets play")
    }

    override fun speak() {
        println("I am $name in  method speak")
    }

}

class Cat(name:  String): Pet(name){

      override fun speak() {
            println("Hello I am cat")
    }

}

/*
Challenge 2 - Overriding & Polymorphism
- Write a function that takes an `Animal` and does something different depending on what subclass it is.
  You'll need to do some safe casting and null checks!
- Create at least one instance of each class from the first challenge.
- Create an array that contains all of the instances.
- Call the function with each of your instances using a loop or whatever other method you'd like!
*/

fun main() {

    fun performAction(animal: Animal){
        when{
            animal is Cat -> println("Its a kitty named ${animal.name}!")

            (animal as? WildAnimal) != null -> {
                println(
                    if (animal.isPoisonous)
                    "It's is a Poisonous animal"
                    else  "It's is not a poisonous animal"
                )
            }

            (animal as? Pet) != null -> animal.play()
            else -> println("It's an animal!!You know, the Muppet?")
        }
    }

    val smallCat = Cat("small Cat")
    val doggie = Pet("Doggie")
    val elephant = WildAnimal(false)
    val snake = WildAnimal(true)
    val cow = Animal()

    val animalArray = arrayOf(smallCat, doggie, elephant, snake, cow)

    animalArray.forEach { animal ->
        performAction(animal)
    }

}