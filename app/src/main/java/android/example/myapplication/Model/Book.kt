package android.example.myapplication.Model

/**
 * Book data class
 * the one from the Model in the backend, translated in Kotlin
 */
data class Book (
    val id:Long,
    var title:String,
    var author: String,
    var publisher : String,
    var isbn : String,
    var year : Int,
    var genre : String,
    var isBorrowed : Boolean
)