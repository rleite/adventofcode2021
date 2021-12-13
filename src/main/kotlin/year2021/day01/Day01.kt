package year2021.day01

object Day01 {
    fun part1(input: Sequence<String>): Int {
        return input.asSequence().map { it.toInt() }
            .zipWithNext()
            .filter { it.first < it.second }
            .count()
    }

    fun part2(input: Sequence<String>): Int {
        return input.asSequence().map { it.toInt() }
            .windowed(3, 1)
            .zipWithNext()
            .map { it.second.sum() - it.first.sum() }
            .filter { it > 0 }
            .count()
    }
}
