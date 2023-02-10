// This code implements the Factory Method design pattern in Kotlin.
// The Factory Method design pattern provides a way to create objects without specifying the exact class of object that will be created.

interface Shape {
    fun draw()
}

class Circle : Shape {
    override fun draw() {
        println("Drawing a Circle")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Drawing a Rectangle")
    }
}

class Square : Shape {
    override fun draw() {
        println("Drawing a Square")
    }
}

class ShapeFactory {
    companion object {
        fun getShape(shapeType: String): Shape? {
            return when (shapeType) {
                "CIRCLE" -> Circle()
                "RECTANGLE" -> Rectangle()
                "SQUARE" -> Square()
                else -> null
            }
        }
    }
}

fun main(args: Array<String>) {
    val shapeFactory = ShapeFactory.getShape("CIRCLE")
    shapeFactory?.draw() // Output: Drawing a Circle
}

// The Shape interface defines the draw() method.
// The Circle, Rectangle, and Square classes implement the Shape interface and provide their own implementation of the draw() method.
// The ShapeFactory class is used to create objects of concrete classes (Circle, Rectangle, Square) based on the type specified.
// The getShape() method of the ShapeFactory class returns an instance of the specified concrete class.
// In the main function, the ShapeFactory class is used to create a Circle object, which is then drawn.
kotlin
Copy code
// This code implements the Observer design pattern in Kotlin.
// The Observer design pattern defines a one-to-many dependency between objects, such that when one object changes state,
// all its dependants are notified and updated automatically.

interface Observer {
    fun update()
}

class ConcreteObserver : Observer {
    override fun update() {
        println("Observer has been updated")
    }
}

interface Subject {
    fun registerObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyObservers()
}

class ConcreteSubject : Subject {
    private val observers: MutableList<Observer> = mutableListOf()

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update()
        }
    }

    fun changeValue() {
        println("Value has changed")
        notifyObservers()
    }
}

fun main(args: Array<String>) {
    val subject = ConcreteSubject()
    val observer = ConcreteObserver()

    subject.registerObserver(observer)
    subject.changeValue() // Output: Value has changed, Observer has been updated
}

// The Observer interface defines the update() method.
// The ConcreteObserver class implements the Observer interface and provides its own implementation of the update() method.
// The Subject interface defines the registerObserver(), removeObserver(),
