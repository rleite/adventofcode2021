package day04

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val board = BoardIndexed(input)
        return board.cards.first().let {
            it.unmarkedNumbers.sum() * board.numbers[it.winningIndex]
        }
    }

    fun part2(input: List<String>): Int {
        val board = BoardIndexed(input)
        return board.cards.last().let {
            it.unmarkedNumbers.sum() * board.numbers[it.winningIndex]
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day04/Day04_test")
    check(part1(testInput) == 4512)
    check(part2(testInput) == 1924)

    val input = readInput("day04/Day04")
    println("Part 1 ${part1(input)}")
    println("Part 2 ${part2(input)}")
}
