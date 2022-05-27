package android.example.myapplication.Model

/**
 * Reader data class
 * the one from the Model in the backend, translated in Kotlin
 */
data class Reader(
    var id : Long,
    var firstName : String,
    var lastName : String,
    var email : String,
    var address: String,
    var telephone : String,
    var password : String
)