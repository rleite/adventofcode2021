package year2021.day04

class BoardIndexed(input: Sequence<String>) {
    val numbers: List<Int>
    private val numbersOrderMap: Map<Int, IndexedValue<Int>>
    val cards: Sequence<CardIndexed>

    init {
        numbers =
            input.first().split(",")
                .map { it.toInt() }
        numbersOrderMap =
            numbers
                .withIndex()
                .associateBy { it.value }

        cards =
            input.drop(2)
                .chunked(6)
                .map { CardIndexed(it, numbersOrderMap) }
                .sortedBy { it.winningIndex }
    }
}
