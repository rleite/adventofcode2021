package day05

import readInput
import kotlin.math.abs
import kotlin.math.max

fun main() {
    data class Position(val x: Int, val y: Int)
    data class Vector(val p1: Position, val p2: Position)

    fun parseVectors(input: List<String>): Sequence<Vector> {
        return input.asSequence()
            .map { inputRow ->
                val positions = inputRow.split(" -> ")
                    .map { it.split(',') }
                    .map { Position(it[0].toInt(), it[1].toInt()) }

                Vector(positions[0], positions[1])
            }
    }

    fun getAxisRange(p1: Int, p2: Int, fullRange: Int): List<Int> {
        val range = p2 - p1
        return when {
            range > 0 -> (p1..p2).toList()
            range < 0 -> (p1 downTo p2).toList()
            else -> (0..fullRange).map { p1 }
        }
    }

    fun isDiagonal(vector: Vector): Boolean {
        return vector.p1.x != vector.p2.x && vector.p1.y != vector.p2.y
    }

    fun getAllPositions(vector: Vector, skipDiagonals: Boolean = false): Sequence<Position> {
        if (skipDiagonals && isDiagonal(vector)) {
            return sequenceOf()
        }

        val fullRange = max(
            abs(vector.p1.x - vector.p2.x),
            abs(vector.p1.y - vector.p2.y)
        )

        return getAxisRange(vector.p1.x, vector.p2.x, fullRange)
            .zip(getAxisRange(vector.p1.y, vector.p2.y, fullRange))
            .asSequence()
            .map { (x, y) -> Position(x, y) }
    }

    fun getOverlappingPositions(input: List<String>, skipDiagonals: Boolean = false): Int {
        return parseVectors(input)
            .flatMap { getAllPositions(it, skipDiagonals) }
            .groupBy { it }
            .map { it.value.count() }
            .count { it > 1 }
    }

    fun part1(input: List<String>): Int {
        return getOverlappingPositions(input, true)
    }

    fun part2(input: List<String>): Int {
        return getOverlappingPositions(input)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day05/Day05_test")
    check(part1(testInput) == 5)
    check(part2(testInput) == 12)

    val input = readInput("day05/Day05")
    println("Part 1 ${part1(input)}")
    println("Part 2 ${part2(input)}")
}
