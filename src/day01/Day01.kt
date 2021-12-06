package day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.asSequence().map { it.toInt() }
                    .zipWithNext()
                    .filter { it.first < it.second }
                    .count()
    }

    fun part2(input: List<String>): Int {
        return input.asSequence().map { it.toInt() }
                    .windowed(3, 1)
                    .zipWithNext()
                    .map { it.second.sum() - it.first.sum() }
                    .filter { it > 0 }
                    .count()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput) == 7)

    val input = readInput("day01/Day01")
    println("Part 1 ${part1(input)}")
    println("Part 2 ${part2(input)}")
}
