package main.kotlin

import java.util.*

class Ticket {
    private val generator = Random()
    val numbers: Set<Int>
    val bonus: Int = generator.nextInt(46) + 1

    init {
        val numbers_: MutableSet<Int> = mutableSetOf()
        while (numbers_.size < 5) {
            numbers_.add(generator.nextInt(56) + 1)
        }
        numbers = numbers_.toSortedSet()
    }
}
