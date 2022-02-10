package dev.rmedina.cursokotlinprincipiantes

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

// Added this ::: just for getting easier the search in the logs
// Since it's a constant --> The way to declare it is with "val"
val TAG = ":::TAG"
// TAG = "..." // We get an error in code time, if we try to change its value

class MainActivity : AppCompatActivity() {

    // First method executed when the application starts up
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        dataType()
//        operators()
//        nullSafety()
//        paramFunctionsAndReturning("Alfredo", 29)
//        inferringTheTypeToReturn()
//        innerClass()
//        interfaces()
//        checkFunctionChallenge()
//        condicionalesIf()
//        condicionalesWhen()
//        listados()
//        bucleFor()
//        bucleWhile()
//        bucleDoWhile()
//        controlDeErrores()

//        botDeSeguridad()
    }

    private fun dataType() {
        // Text chain
        var string = "It's a string" // Type is inferred
        Log.d(TAG, string + " has got type " + string::class.simpleName.toString())

        // Integer numerics
        var numberInt: Int = 10
        Log.d(TAG, numberInt.toString() + " has got type " + numberInt::class.simpleName.toString()) // Necessary to convert to string manually. 1) Via .toString(), 2) As literal template ${}
        var numberShort: Short = 10
        Log.d(TAG, " $numberShort has got type " + numberShort::class.simpleName.toString())
        var numberLong: Long = 10
        Log.d(TAG, " ${numberLong} has got type " + numberLong::class.simpleName.toString())
        var numberByte: Byte = numberInt.toByte()
        Log.d(TAG, " ${numberByte} has got type " + numberByte::class.simpleName.toString())

        // Floating point numbers
        var numberDouble: Double = 2.5
        Log.d(TAG, " ${numberDouble} has got type " + numberDouble::class.simpleName.toString())
        var numberFloat: Float = 2.5F // Declare float can be done adding either "F" or "f"
        Log.d(TAG, " ${numberFloat} has got type " + numberFloat::class.simpleName.toString())
        var numberFloatTwo: Float = 2.5f
        Log.d(TAG, " ${numberFloatTwo} has got type " +numberFloatTwo::class.simpleName.toString())

        // Boolean data
        var boolean = true
        Log.d(TAG, boolean::class.simpleName.toString())
        var booleanTwo = false
        Log.d(TAG, booleanTwo::class.simpleName.toString())

    }

    private fun operators() {
        val firstValue = 5
        val firstValueDouble = 5.0
        val secondValue = 2
        val secondValueDouble = 2.0

        // Arithmetical operators
        val addition = firstValue + secondValue
        Log.d(TAG, " $addition")
        val substraction = firstValue - secondValue
        Log.d(TAG, " $substraction")
        val multiplication = firstValue * secondValue
        Log.d(TAG, " $multiplication")
        val division = firstValue / secondValue // It's an int value because firstValue and secondValue are int
        val divisionDoubleDividend = firstValueDouble / secondValue // If some of the numbers is float --> The result is decimal
        val divisionDoubleDivider = firstValue / secondValueDouble
        val divisionBothDouble = firstValueDouble / secondValueDouble
        Log.d(TAG, " $division")
        Log.d(TAG, " $divisionDoubleDividend")
        Log.d(TAG, " $divisionDoubleDivider")
        Log.d(TAG, " $divisionBothDouble")
        val remainder = 5%2
        Log.d(TAG, " $remainder")

    }

    private fun nullSafety() {

        // Not possible to assign to a strict primitive data a null value
//        val nullString: String = null
        // ?  --> If a variable can be null
        val perhapsIsNull: String? = null

//        1) Since it's not a strict string primitive data, because it can be null --> It doesn't work
//        Log.d(TAG, perhapsIsNull)
//        2) If you check previously that it's not null --> You don't get an error in code time
        if (perhapsIsNull !=null) {
            Log.d(TAG, perhapsIsNull)
        }
//        3) Using template literal
        Log.d(TAG, " $perhapsIsNull")
//        4) ?.let
        perhapsIsNull?.let { Log.d(TAG, "In case the variable isn't null: " + perhapsIsNull) } // This is the block in case that it's not null
            ?: run {
//                Log.d(TAG, perhapsIsNull)  // Not valid, because in this case perhapsIsNull
//                Log.d(TAG, perhapsIsNull!!)  // !! allows continuing without getting an error in code time, and in this case, we will get an error
                Log.d(TAG, "In case the variable is null: $perhapsIsNull")
            } // Code executed in case that perhapsIsNull is null

    }

    private fun paramFunctionsAndReturning(name: String, age: Int): Int {
        Log.d(TAG, name)
        Log.d(TAG, "$age")
        return age
    }

    // Inferring the type to return, and since it's just 1! line --> Not necessary {}
    private fun inferringTheTypeToReturn() = 29

    private fun innerClass() {
//        val alfredo = Person() // When the class didn't have argument
        val alfredo = Person("Alfredo")
        alfredo.presentation()
//        alfredo.privateFunction() // Not possible to access because it's private
    }

    //Inner classes
//  class Person{ // Class without argument
//  class Person(name: String){ // Required declare as variable or constant
    class Person(val name: String){ // Class with an argument
        // By default the functions are public
        fun presentation() {
            Log.d(TAG, "Presentation function with name $name")
        }
        private fun privateFunction() {
            Log.d(TAG, "Privated function")
        }
    }

    private fun interfaces() {
        val alfredoData = Persona("Alfredo", 29, arrayListOf())
        val alfredo = SecondPerson(alfredoData)

        alfredo.presentation()
        var age = alfredo.returnAge(1992)
        Log.d(TAG, "My age is $age")
    }

    // Class extending it's functionality via an Interface
    class SecondPerson(private val data: Persona) : PersonInterface {
        fun presentation() {
            Log.d(TAG, "Presentation function with name ${data.name}")
        }

        override fun returnAge(birthYear: Int): Int {
            return 2022 - birthYear
        }
    }

    // Declare an interface purely abstract === Not body into the function
    interface  PersonInterface {
        fun returnAge(birthYear: Int): Int
    }

    private fun condicionalesIf() {
        //Declare constants
        val firstNumber = 10
        val secondNumber = 5
        val booleanValue = false

        if (firstNumber < secondNumber) {
            // First argument: Tag
            // Second argument: Message
            Log.d(TAG, "Primera opcion")

            if (secondNumber == 4) {
            } else {
            }
        } else if (booleanValue) {
            Log.d(TAG, "Segunda opcion")
        } else if (booleanValue) {
            Log.d(TAG, "Segunda opcion")
        } else if (booleanValue) {
            Log.d(TAG, "Segunda opcion")
        } else {
            Log.d(TAG, "Tercera opcion")
        }

        val edad: Int = if (!booleanValue) {
            17
        } else {
            26
        }

        Log.d(TAG, edad.toString())
    }

    private fun condicionalesWhen() {
//        val language = "Scala"
//
//        when (language) {
//            "Kotlin", "Scala" -> {
//                Log.d(TAG, "Se ha seleccionado Kotlin")
//            }
//            "Java" -> Log.d(TAG, "Se ha seleccionado Java")
//            "Python" -> Log.d(TAG, "Se ha seleccionado Python")
//            "Ruby" -> Log.d(TAG, "Se ha seleccionado Ruby")
//            else -> Log.d(TAG, "Se ha seleccionado otro lenguaje")
//        }

        val myNumber = 94
        when (myNumber) {
            in 0..10 -> {
                Log.d(TAG, "Se ha seleccionado Kotlin")
            }
            40 -> {
                Log.d(TAG, "Se ha seleccionado Java")
            }
            in 80..119 -> {
                Log.d(TAG, "Se ha seleccionado Python")
            }
            120 -> {
                Log.d(TAG, "Se ha seleccionado Ruby")
            }
            else -> Log.d(TAG, "Se ha seleccionado otro lenguaje")
        }
    }

    private fun listados() {
        val myList = listOf("Rodrigo", "Raquel", "David", "Lorena", "Allison")
        val myArrayList = arrayListOf("Rodrigo", "Raquel", "David", "Lorena", "Allison")

        val listItem = myList[2]

        myArrayList[2] = "Sandra"
        val arrayListItem = myArrayList[2]

        myArrayList.removeAt(3)

        Log.d(TAG, myArrayList.toString())
    }

    private fun bucleFor() {
        val myArrayList = arrayListOf("Rodrigo", "Raquel", "David", "Lorena", "Allison")

//        for (persona in myArrayList) {
//            Log.d(TAG, persona)
//        }

//        for (position in 0 until 5) {
//            Log.d(TAG, position.toString())
//        }

//        for (position in 0..10 step 3) {
//            Log.d(TAG, position.toString())
//        }

        for (position in 10 downTo 3 step 2) {
            Log.d(TAG, position.toString())
        }
    }

    private fun bucleWhile() {
        // Define a variable, whose value can be changed --> var
        var myNumber = 0
        // Typed because we can't change it's type
        // myNumber = "Hello"

        while (myNumber <= 10) {
            Log.d(TAG, myNumber.toString())
            myNumber += 3
        }
    }

    private fun bucleDoWhile() {
        var myNumber = 1

        do {
            Log.d(TAG, myNumber.toString())
            myNumber++
        } while (myNumber <= 10)
    }

    private fun controlDeErrores() {
        val myArrayList = arrayListOf(1, 2, 3, 4, 5)
        val myString: String = "Hola"

        try {
            for (position in 0..myArrayList.size) {
                Log.d(TAG, myString)
            }
        } catch (exception: Exception) {
            exception.printStackTrace()
            Log.d(TAG, "Catch")
        } finally {
            Log.d(TAG, "Finally")
        }
    }


/*
1.- Crear una funcion que se llame botDeSeguridad() y llamarla desde nuestro metodo onCreate()
2.- Crear una clase de datos llamada Persona

Reglas:
1.- La clase de datos debe incluir tres constantes llamadas name, age y hobbies (que es un listado de strings)
2.- Creamos una variable de tipo Persona con nuestra información (nombre, edad y un listado de hobbies)
3.- Mediante el uso de condicionales nuestro bot debe:
    - Mostrarnos un mensaje de error en caso de que el nombre que tenga la clase Persona no sea el nuestro y
    no dejarnos acceder, o de lo contrario, mostrar el mensaje de éxito y continuar
    - Manejar los siguientes rangos de edad:
        - En caso de que tengamos entre 0 y 17 años, el bot nos dirá que somos menores de edad, y que por tanto
        acceso denegado, en caso de tener entre 65 y 100 nos diría lo mismo pero por ser demasiado mayores y si
        tenemos entre 18 y 64 años dejarnos pasar y mostrar un mensaje de éxito.
    - Por último, recorrer con un bucle nuestros hobbies y mostrarlos por pantalla
*/

    private fun botDeSeguridad() {
        val persona = Persona("Rodrigo", 63, arrayListOf("Programar", "TV", "Deportes"))

        if (persona.name == "Rodrigo") {
            Log.d(TAG, "Bienvenido ${persona.name}")

            when (persona.age) {
                in 0..17 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres demasiado joven para acceder.")
                }
                in 18..64 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres mayor de edad, bienvenido.")

                    for (hobby in persona.hobbies) {
                        Log.d(TAG, "Te gusta $hobby")
                    }
                }
                in 65..100 -> {
                    Log.d(TAG, "Tienes ${persona.age} años, eres demasiado mayor para acceder.")
                }
            }
        } else {
            Log.d(TAG, "Largo de aquí ${persona.name}!")
        }
    }

    // Data class. It hasn't got methods
    data class Persona(
//            private val name: String, // If it's indicated as private --> Not possible to get access to the value
            val name: String,
            val age: Int,
            val hobbies: ArrayList<String>
    )

    /*
  1.- Create a class "Programmer"
  2.- Create an interface "ProgrammerInterface"
  3.- Create a data class "ProgrammerData"

  Rules:
  1.- "ProgrammerData" should have 3 constants: name, age and language
  2.- "ProgrammerInterface" should have the method "getProgrammerData()" which returns ProgrammerData
  3.- "Programmer" must implement the interface and:
      - Create 3 private functions which returns some name, age, program language
      - "getProgrammerData()" must return a "ProgrammerData" object with the information returned by the previous functions
  4.- Creating an object of Programmer --> Just be able to invoke getProgrammerData()
  */

    class Programmer() : ProgrammerInterface{
        private fun returnName() = "Alfredo"
        private fun returnAge() = 29
        private fun returnProgramLanguage() = "Kotlin"
        override fun getProgrammerData(): ProgrammerData {
            return ProgrammerData(returnName(), returnAge(), returnProgramLanguage())
        }
    }

    interface ProgrammerInterface {
        fun getProgrammerData(): ProgrammerData
//        fun getProgrammerData(val name: String, val age: Int, val language: String): ProgrammerData // Not possible to define a variable as argument of a function
    }

    data class ProgrammerData(
        val name: String,
        val age: Int,
        val language: String
    )

    private fun checkFunctionChallenge() {
        var alfredo = Programmer()
        val alfredoData = alfredo.getProgrammerData()
        Log.d(TAG, "Programmer with name ${alfredoData.name} who is ${alfredoData.age} years old, is learning ${alfredoData.language}")

    }

}