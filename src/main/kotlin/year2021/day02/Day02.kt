package year2021.day02

import readInput

object Day02 {
    fun part1(input: Sequence<String>): Int {
        val actions = input.asSequence()
            .map { it.split(' ').zipWithNext().first() }
            .map { Pair(it.first, it.second.toInt()) }
            .groupBy { it.first }
            .mapValues { it.value.sumOf { value -> value.second } }

        val position = actions.getOrDefault("forward", 0)
        val depth = actions.getOrDefault("down", 0) - actions.getOrDefault("up", 0)
        return position * depth
    }

    fun part2(input: Sequence<String>): Int {
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
}
