package day04

import kotlin.math.min

class CardIndexed(input: List<String>, numbersOrderMap: Map<Int, IndexedValue<Int>>) {
    private val matrix: List<List<IndexedValue<Int>>>
    val winningIndex: Int
    val unmarkedNumbers: List<Int>
        get() =
            matrix.flatten()
                .filter { it.index > winningIndex }
                .map{ it.value }

    init {
        matrix =
            input.map { inputRow ->
                inputRow.split(" ")
                    .filter { it != "" }
                    .map { numbersOrderMap[it.toInt()]!! }
            }
                .filter { it.isNotEmpty() }

        val rowWinningIndexes =
            matrix
                .asSequence()
                .map { row -> row.map{ it.index }.maxOf { it } }

        val colWinningIndexes =
            matrix.asSequence()
                .flatMap { row -> row.asSequence().map{ it.index }.withIndex() }
                .groupBy({ it.index }, { it.value })
                .asSequence()
                .map { it.value }
                .map { col -> col.maxOf { it } }

        winningIndex = min(rowWinningIndexes.minOf { it }, colWinningIndexes.minOf { it })
    }
}
