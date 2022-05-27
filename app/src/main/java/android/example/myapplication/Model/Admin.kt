package android.example.myapplication.Model

/**
 * Admin data class
 * the one from the Model in the backend, translated in Kotlin
 */
data class Admin(
    val id: Long,
    var firstName: String,
    var lastName : String,
    var email: String,
    val password : String
)