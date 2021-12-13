package year2019.day04


object Day04 {
    fun parseValues(input: String): Pair<Int, Int> {
        return input.split('-')
            .map { it.toInt() }
            .zipWithNext()
            .first()
    }

    fun part1(input: String): Int {
        val range = parseValues(input)
        return range.range().filter {
            if (it < 10) {
                return@filter false;
            }
            val digits = it.toString().map { char -> char.digitToInt() }
            digits.windowed(2).let { windowed ->
                windowed.all { (a, b) -> a <= b } && windowed.any { (a, b) -> a == b }
            }
        }
//            .also { println(it) }
            .count()
    }

    fun part2(input: String): Int {
        val range = parseValues(input)
        return range.range().filter {
            if (it < 100) {
                return@filter false
            }
            val digits = it.toString().map { char -> char.digitToInt() }
            digits.windowed(2).let { windowed ->
                windowed.all { (a, b) -> a <= b } && windowed.any { (a, b) -> a == b }
            } &&
            !digits.windowed(3).any { (a, b, c) -> a == b && b == c }
        }
//            .also { println(it) }
            .count()
    }
}

private fun Pair<Int, Int>.range(): IntRange {
    return (this.first..this.second)
}
