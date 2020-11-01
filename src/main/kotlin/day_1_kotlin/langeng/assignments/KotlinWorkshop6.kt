package day_1_kotlin.langeng.assignments

// Workshop #6 - special classes, objects, data classes

/* Exercise area */

// TODO 1: Add 2-4 properties to the data class
data class VideoGame(
    val name: String,
    val year: Int,
    val genre: Genre,
    val rate: Int = 5
)

// TODO 2: Create on object that will be used to test the games, call it "VideoGamesTest".
object VideoGamesTest {
      // Uncomment after declaring an object.
    @JvmStatic
    fun main(args: Array<String>)  {
        // TODO 3: Create an instance of VideoGame.
        //  Make a copy via .copy() method and store the copy to another variable.
        val game = VideoGame("Gothica", 2000, Genre.RPG)
        val copy = game.copy()

        // TODO 4: Print out if those data class objects are equal.
        //  Use "==" to compare. Should be true.
        val equal = game == copy
        println("Objects are equal $equal")

        // TODO 5: Put several data class objects into an array and print them out.
        val games = arrayOf(game, game.copy("Warcraft", 1999, Genre.STRATEGY), VideoGame("Mario", 1996, Genre.ACTION))
        games.forEach {
             println(it)
        }

        val quake = VideoGame(
            name = "Quake 3 Arena",
            year = 1995,
            genre = Genre.ACTION
        )
        println(quake)
    }
}



/* Exercise bonus area */

// TODO 6: Create an enum class Genre with a few values, and add it as a field to the VideoGame.
//  Fix created video game instances in the main() function and run main().
enum class Genre {
    STRATEGY,
    ACTION,
    RPG
}


// TODO 7: Add a new property to the VideoGame class with default value.
//  As you can see, you don't have to fix already created instances.
//  But you have to remember that this can change a behaviour of instances in some cases.
//  Run program and see new print results.