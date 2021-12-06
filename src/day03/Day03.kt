package day03

import readInput
import kotlin.math.ceil

fun main() {

    fun getBitsCountAt(input: List<String>, index: Int): Int {
        return input.asSequence()
            .map { it[index].toString().toInt() }
            .reduce { acc, value -> if (value == 1) acc + 1 else acc }
    }

    fun getPart2Value(input: List<String>, validBitGetter: (input: List<String>, Int) -> Char): String {
        val size = input[0].length
        var validInput = input
        var index = 0
        while (validInput.size > 1 && index < size) {
            val validBit = validBitGetter(validInput, index)
            validInput = validInput.filter { it[index] == validBit }
            index++
        }
        return validInput.first()
    }

    fun mostCommonBit(onesCount: Int, majority: Int): Char {
        return if (onesCount >= majority) '1' else '0'
    }

    fun leastCommonBit(onesCount: Int, majority: Int): Char {
        return if (onesCount < majority) '1' else '0'
    }

    fun part1(input: List<String>): Int {
        val size = input.size
        val majority = ceil(size / 2.0).toInt()
        val values =
            (0 until input[0].length).associateWith { getBitsCountAt(input, it) }

        val concatString: (acc: String, Char) -> String = { acc, value -> acc + value }

        val gama = values.map { (_, value) -> mostCommonBit(value, majority) }
            .fold("", concatString)

        val epsilon = values.map { (_, value) -> leastCommonBit(value, majority) }
            .fold("", concatString)

        return gama.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {
        val oxygen = getPart2Value(input) { validInput, index ->
            mostCommonBit(getBitsCountAt(validInput, index), ceil(validInput.size / 2.0).toInt())
        }
        val co2 = getPart2Value(input) { validInput, index ->
            leastCommonBit(getBitsCountAt(validInput, index), ceil(validInput.size / 2.0).toInt())
        }

        return oxygen.toInt(2) * co2.toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/Day03_test")
    check(part1(testInput) == 198)
    check(part2(testInput) == 230)

    val input = readInput("day03/Day03")
    println("Part 1 ${part1(input)}")
    println("Part 2 ${part2(input)}")
}
