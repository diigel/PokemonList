package com.digel.interviewjari.question

/**
 * Diketahui sebuah string str, cari substring terpanjang yang tidak memiliki karakter berulang.
 * Contoh Input :
 * abcabcbb
 * Contoh Output :
 * 3
 * Penjelasan :
 * Substring terpanjang adalah “abc” dengan panjang 3
 * Contoh Input :
 * bbbbbb
 * Contoh Output :
 * 1
 * Penjelasan :
 * Substring terpanjang adalah “b” dengan panjang 1
 * Contoh Input :
 * pwwkew
 * Contoh Output :
 * 3
 * Penjelasan :
 * Substring terpanjang adalah “wke” dengan panjang
 */
fun main() {
    var repeat: Boolean

    do {
        println("Masukkan string:")
        val input = readlnOrNull()

        if (input != null) {
            val maxLength = lengthOfLongestSubstring(input)
            println("Panjang substring terpanjang tanpa karakter berulang adalah: $maxLength")
        } else {
            println("Input tidak valid.")
        }

        println("Apakah Anda ingin mengulang? (ya/tidak)")
        val repeatInput = readlnOrNull()
        repeat = repeatInput?.equals("ya", ignoreCase = true) == true || repeatInput?.equals("y", ignoreCase = true) == true
    } while (repeat)
}

fun lengthOfLongestSubstring(s: String): Int {
    val n = s.length
    var maxLen = 0
    val charIndexMap = mutableMapOf<Char, Int>()
    var start = 0

    for (end in 0 until n) {
        val char = s[end]

        if (charIndexMap.containsKey(char)) {
            start = maxOf(start, charIndexMap[char]!! + 1)
        }

        charIndexMap[char] = end
        maxLen = maxOf(maxLen, end - start + 1)
    }

    return maxLen
}


