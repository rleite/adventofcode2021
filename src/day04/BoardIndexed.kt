package day04

class BoardIndexed(input: List<String>) {
    private val numbersOrderMap: Map<Int, IndexedValue<Int>>
    val numbers: List<Int>
    val cards: List<CardIndexed>

    init {
        numbers =
            input[0].split(",")
                .map { it.toInt() }
        numbersOrderMap =
            numbers
                .withIndex()
                .associateBy { it.value }

        cards =
            input.subList(2, input.size)
                .chunked(6)
                .map { CardIndexed(it, numbersOrderMap) }
                .sortedBy { it.winningIndex }
    }
}
