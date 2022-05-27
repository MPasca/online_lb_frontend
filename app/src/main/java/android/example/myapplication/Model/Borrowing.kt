package android.example.myapplication.Model

import java.time.LocalDate

/**
 * Borrowings data class
 * the one from the Model in the backend, translated in Kotlin
 */
class Borrowing (
    val id:Long,
    var readerId : Long,
    var bookId: Long,
    var borrowDate : LocalDate,
    var returnDate : LocalDate,
    var isReturned : Boolean
    )