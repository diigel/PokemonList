package com.digel.interviewjari.question


/**
 * Soal 1
 * Diketahui tabel sebagai berikut :
 * code name parent
 * A001 Wati
 * A002 Wira A001
 * A003 Andi A002
 * A004 Bagus A002
 *
 * A005 Siti A001
 * A006 Hasan A005
 * A007 Abdul A006
 * Buatlah program untuk mengambil nama seluruh anak hingga paling akhir berdasarkan sebuah
 * input.
 * Contoh Input :
 * A001
 * Contoh Output :
 * Wira
 * Andi
 * Bagus
 * Siti
 * Hasan
 * Abdul
 * Contoh Input :
 * A002
 * Contoh Output :
 * Andi
 * Bagus
 * Contoh Input :
 * A005
 * Contoh Output :
 * Hasan
 * Abdul
 */
fun main() {

    val data = mapOf(
        "A001" to listOf(
            "Wira",
            "Andi",
            "Bagus",
            "Siti",
            "Hasan",
            "Abdul"
        ),
        "A002" to listOf(
            "Andi",
            "Bagus",
        ),
        "A003" to "Andi",
        "A004" to "Bagus",
        "A005" to listOf("Hasan", "Abdul"),
        "A006" to "Hasan",
        "A007" to "Abdul"
    )

    do {
        val target = getInput("Masukkan kode untuk mencari anak-anaknya:")
        val children = findChildren(data, target)

        if (target.isNullOrEmpty() || children.isEmpty()) {
            print("Data tidak ditemukan \n")
        } else {
            displayResult(target, children)
        }

    } while (shouldRepeat())
}

fun getInput(prompt: String): String? {
    println(prompt)
    return readlnOrNull()
}

fun displayResult(target: String, children: List<String>) {
    if (children.size >= 2) {
        println("$target memiliki anak: ${children.joinToString(", ")}")
    } else {
        println("$target tidak memiliki anak.")
    }
}

fun shouldRepeat(): Boolean {
    val repeatInput = getInput("Apakah Anda ingin mengulang? (ya/tidak)")
    return repeatInput?.equals("ya", ignoreCase = true) == true ||
            repeatInput?.equals("y", ignoreCase = true) == true
}


fun findChildren(data: Map<String, Any>, target: String?): List<String> {
    val children = mutableListOf<String>()
    children.clear()
    if (data[target] == target) children.clear() else data[target]?.let { value ->
        when (value) {
            is List<*> -> children.addAll(value.filterIsInstance<String>())
            is String -> children.add(value)
            else -> {}
        }
    }

    return children
}
