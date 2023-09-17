package com.digel.interviewjari.question

/**
 * Bilangan Fibonacci adalah barisan angka di mana angka berikutnya adalah hasil pertambahan
 * 2 angka terakhir, yang dimulai dari 0 dan 1. Contoh bilangan Fibonacci adalah sebagai berikut :
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, etc.
 * Diketahui X adalah jumlah angka yang dapat diinput oleh user. Buatlah sebuah program untuk
 * menampilkan X bilangan Fibonacci pertama.
 * Contoh Input :
 * 5
 * Contoh Output :
 * 0, 1, 1, 2, 3
 * Contoh Input :
 * 10
 * Contoh Output :
 * 0, 1, 1, 2, 3, 5, 8, 13, 21, 34
 */

fun main() {
    var repeat: Boolean

    do {
        println("Masukkan jumlah bilangan Fibonacci yang ingin ditampilkan:")
        val input = readlnOrNull()

        if (input != null) {
            try {
                val n = input.toInt()
                if (n >= 0) {
                    val fibonacciNumbers = generateFibonacci(n)
                    println("Bilangan Fibonacci pertama $n adalah:")
                    println(fibonacciNumbers.joinToString(", "))
                } else {
                    println("Masukkan bilangan bulat positif atau nol.")
                }
            } catch (e: NumberFormatException) {
                println("Masukkan angka yang valid.")
            }
        } else {
            println("Input tidak valid.")
        }

        println("Apakah Anda ingin mengulang? (ya/tidak)")
        val repeatInput = readlnOrNull()
        repeat = repeatInput?.equals("ya", ignoreCase = true) == true || repeatInput?.equals("y", ignoreCase = true) == true
    } while (repeat)
}

fun generateFibonacci(n: Int): List<Int> {
    val fibonacciNumbers = mutableListOf<Int>()

    var a = 0
    var b = 1

    for (i in 0 until n) {
        fibonacciNumbers.add(a)
        val next = a + b
        a = b
        b = next
    }

    return fibonacciNumbers
}
