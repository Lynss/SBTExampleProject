abstract class Animal{
  def name:String
}

abstract class Pet extends Animal

class Dog extends Pet{
  def name="dog"
}

class Cat extends Pet{
  def name="cat"
}

class Lion extends Animal{
  def name="lion"
}

class PetContainer[A <: Pet](p:A){
  def pet= p
}

val dog = new Dog
val cat = new Cat
val lion = new Lion
val dogs:PetContainer[Dog] = new PetContainer(dog)
val cats:PetContainer[Cat] = new PetContainer(cat)
//val lions = new PetContainer(lion) compile error