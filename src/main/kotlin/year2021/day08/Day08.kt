package year2021.day08


//        0:      1:      2:      3:      4:
//        aaaa    ....    aaaa    aaaa    ....
//        b    c  .    c  .    c  .    c  b    c
//        b    c  .    c  .    c  .    c  b    c
//        ....    ....    dddd    dddd    dddd
//        e    f  .    f  e    .  .    f  .    f
//        e    f  .    f  e    .  .    f  .    f
//        gggg    ....    gggg    gggg    ....
//
//        5:      6:      7:      8:      9:
//        aaaa    aaaa    aaaa    aaaa    aaaa
//        b    .  b    .  .    c  b    c  b    c
//        b    .  b    .  .    c  b    c  b    c
//        dddd    dddd    ....    dddd    dddd
//        .    f  e    f  .    f  e    f  .    f
//        .    f  e    f  .    f  e    f  .    f
//        gggg    gggg    ....    gggg    gggg



object Day08 {

    fun part1(input: Sequence<String>): Int {
        return SegmentData.parse(input)
            .sumOf { it.countKnownNumbersBySegmentCount() }
    }

    fun part2(input: Sequence<String>): Int {
        return SegmentData.parse(input)
            .sumOf { it.decodeUsingAlphabet() }
    }
}

data class SegmentData(val alphabet: List<String>, val digits: List<String>) {

    fun countKnownNumbersBySegmentCount(): Int {
        return digits.map {
            decodeBySegmentCount(it)
        }.count { it != -1 }
    }

    fun decodeUsingAlphabet(): Int {
        val segmentCountToDigitMap =
            alphabet
                .map { it.length to it }
                .groupBy({ it.first }) { it.second }

        val digit1 = segmentCountToDigitMap[2]!!.first()
        val digit4 = segmentCountToDigitMap[4]!!.first()
        val digit7 = segmentCountToDigitMap[3]!!.first()
        val digit8 = segmentCountToDigitMap[7]!!.first()

        val digitsWith6Segments = segmentCountToDigitMap[6]!!

        val digit6 = digitsWith6Segments.first { !it.toSet().containsAll(digit1.toList()) }

        val segmentF = digit6.toList().intersect(digit1.toSet()).first()
        val segmentC = digit1.toList().minus(setOf(segmentF)).first()

        val digitsWith5Segments = segmentCountToDigitMap[5]!!

        val digit5 = digitsWith5Segments.first { !it.contains(segmentC) }

        val digits2Or3 = digitsWith5Segments.minus(digit5)
        val digit3 = digits2Or3.first { it.contains(segmentF) }
        val digit2 = digits2Or3.first { it != digit3 }
        val digit9 = plusSegment(digit5, segmentC)
        val digit0 = digitsWith6Segments.minus(digit9).minus(digit6).first()

        val digitToNumberMap = listOf(
            digit0 to 0,
            digit1 to 1,
            digit2 to 2,
            digit3 to 3,
            digit4 to 4,
            digit5 to 5,
            digit6 to 6,
            digit7 to 7,
            digit8 to 8,
            digit9 to 9,
        ).toMap()

        return digits.joinToString("") { decode(it, digitToNumberMap).toString() }.toInt()
    }

    companion object {

        fun parse(input: Sequence<String>): Sequence<SegmentData> {
            return input.map { inputLine ->
                inputLine.split(" | ")
                    .map { it.split(' ') }
                    .let { split ->
                        val alphabet = split[0].map { toDigit(it) }
                        val digits = split[1].map { toDigit(it) }
                        SegmentData(alphabet, digits)
                    }
            }
        }

        // segmentCountToNumberMap look like:
        // {6=[0, 6, 9], 2=[1], 5=[2, 3, 5], 4=[4], 3=[7], 7=[8]}
        private fun decodeBySegmentCount(digit: String): Int {
            return when(digit.length) {
                2 -> 1
                4 -> 4
                3 -> 7
                7 -> 8
                // Value unknown just with segment count
                else -> -1
            }
        }

        private fun decode(digit: String, digitToNumberMap:  Map<String, Int>): Int {
            return digitToNumberMap[digit]!!
        }

        private fun plusSegment(digit: String, segment: Char): String {
            return toDigit(digit.toList().plus(segment))
        }

        private fun toDigit(digit: String): String {
            return digit.toList().toSortedSet().joinToString("")
        }

        private fun toDigit(digitList: List<Char>): String {
            return digitList.toSortedSet().joinToString("")
        }
    }
}
