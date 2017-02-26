/*
 * PURPOSE
 * The purpose of this program is to simulate a machine that prints out tickets
 * for a state lottery. The program will start by asking the user how many
 * tickets will be purchased. The user must then input an integer from 1 to 5,
 * inclusive. Each lottery ticket contains 5 integers and a special integer.
 * The first 5 integers are randomly generated from the range 1-56, inclusive.
 * The special integer is randomly generated from the range 1-46, inclusive.
 * The first 5 integers will be sorted in non decreasing order. The tickets
 * are then compared to insure there are no duplicates. The tickets are then
 * printed to the screen.
 */
package main.kotlin

import java.util.*

fun main(args: Array<String>) {
    println("Welcome to the State Lottery")

    var numberOfTickets = 0
    var appropriateInput = false

    val userInput = Scanner(System.`in`)
    do {
        println()
        println("How many tickets are to be purchased?")

        println("Tickets purchased must be at least 1 and no more than 5")

        try {
            val input = userInput.nextInt()
            when (input) {
                1, 2, 3, 4, 5 -> {
                    //breaks while loop
                    appropriateInput = true
                    numberOfTickets = input
                }
                else -> throw Exception() //exception thrown with undesired input
            }
        } catch (e: Exception) {
            println("Please re-enter an integer from 1 to 5")
        }

    } while (!appropriateInput) //loop breaks when appropriateInput is true

    val tickets = Array(numberOfTickets) { Ticket() }

    // TODO: Check for duplicates
//    var duplicate = false
//    do {
//        for (ticket in tickets)
//            for (i in 0..3)
//                if (ticket[i] == ticket[i + 1]) {
//                    ticket[i] = generator.nextInt(56) + 1
//                    Arrays.sort(ticket, 0, 5)
//                }
//
//        for (i in 0..numberOfTickets - 1)
//            for (j in i + 1..numberOfTickets - 1)
//                if (Arrays.equals(tickets[i], tickets[j])) {
//                    duplicate = true
//                    for (k in 0..4)
//                        tickets[j][k] = generator.nextInt(56) + 1
//                    tickets[j][5] = generator.nextInt(46) + 1
//                }
//    } while (duplicate)

    println()
    println("Printing lottery tickets")
    for (ticket in tickets) {
        for (number in ticket.numbers)
            print("%3d".format(number))
        println(" |%3d".format(ticket.bonus))
    }
}
