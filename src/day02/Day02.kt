package day02

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val actions = input.asSequence()
            .map { it.split(' ').zipWithNext().first() }
            .map { Pair(it.first, it.second.toInt()) }
            .groupBy { it.first }
            .mapValues { it.value.sumOf { value -> value.second } }

        val position = actions.getOrDefault("forward", 0)
        val depth = actions.getOrDefault("down", 0) - actions.getOrDefault("up", 0)
        return position * depth
    }

    fun part2(input: List<String>): Int {
        var depth = 0
        var position = 0
        var aim = 0

        fun action(action: String, value: Int) {
            when(action) {
                "up" -> aim-= value
                "down" -> aim+= value
                "forward" -> {
                    position+=value
                    depth+= aim * value
                }
            }
        }

        input.asSequence()
             .map { it.split(' ').zipWithNext().first() }
             .map { Pair(it.first, it.second.toInt()) }
             .forEach { action(it.first, it.second) }

        return depth*position
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/Day02_test")
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput("day02/Day02")
    println("Part 1 ${part1(input)}")
    println("Part 2 ${part2(input)}")
}
