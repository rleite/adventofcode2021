package year2021.day04


object Day04 {

    fun part1(input: Sequence<String>): Int {
        val board = BoardIndexed(input)
        return board.cards.first().let {
            it.unmarkedNumbers.sum() * board.numbers[it.winningIndex]
        }
    }

    fun part2(input: Sequence<String>): Int {
        val board = BoardIndexed(input)
        return board.cards.last().let {
            it.unmarkedNumbers.sum() * board.numbers[it.winningIndex]
        }
    }
}
