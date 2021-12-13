package year2021.day10

object Day10 {

    fun part1(input: Sequence<String>): Int {
        return input.map { detectError(it) }
            .filter { it.first == Result.CORRUPT }
            .sumOf { Chunk.getCorruptScore(it.second.first()) }
    }

    fun part2(input: Sequence<String>): Long {
        return input.map { detectError(it) }
            .filter { it.first != Result.CORRUPT }
            .map { result -> result.second.map { Chunk.getIncompleteScore(it) } }
            .map { scores -> computeLineScore(scores) }
            .sortedBy { it }
            .toList()
            .let { it[it.size / 2] }
    }

    private fun computeLineScore(scores: List<Int>): Long {
        return scores.fold(0L to 0) { acc, score -> ((acc.first * acc.second) + score) to 5 }.first
    }

    fun detectError(input: String): Pair<Result, List<Chunk>> {
        val inputList = input.toMutableList()

        var result = Result.NONE to emptyList<Chunk>()
        while (inputList.isNotEmpty() && result.first != Result.CORRUPT) {
            val char = inputList.removeFirst()

            val chunk = Chunk.getChunk(char)
            if (chunk.closeChar == char) {
                return Result.CORRUPT to listOf(chunk)
            }

            result = seekChunk(chunk, inputList)
        }

        return result
    }

    private fun seekChunk(previous: Chunk, input: MutableList<Char>): Pair<Result, List<Chunk>> {
        var result = Result.NONE to emptyList<Chunk>()
        while (!result.first.isError) {
            if (input.isEmpty()) {
                return Result.INCOMPLETE to listOf(previous)
            }

            val char = input.removeFirst()
            val chunk = Chunk.getChunk(char)

            if (chunk.closeChar == char) {
                if (chunk == previous) {
                    return Result.NONE to emptyList()
                }
                return Result.CORRUPT to listOf(chunk)
            }

            result = seekChunk(chunk, input)
            if (result.first == Result.INCOMPLETE) {
                return Result.INCOMPLETE to (result.second.plus(previous))
            }
        }

        return result
    }

    enum class Result(val isError: Boolean) {
        CORRUPT(true),
        INCOMPLETE(true),
        NONE(false)
    }

    sealed class Chunk(val openChar: Char, val closeChar: Char) {
        class Parentheses: Chunk('(', ')')
        class Bracket: Chunk('[', ']')
        class CurlyBraces: Chunk('{', '}')
        class Chevron: Chunk('<', '>')

        override fun toString(): String {
            return this.javaClass.simpleName
        }

        companion object {
            private val allChunks = listOf(
                Parentheses(),
                Bracket(),
                CurlyBraces(),
                Chevron(),
            )
            private val charToChunkMap =
                allChunks.flatMap { listOf(it.openChar to it, it.closeChar to it) }
                    .toMap()

            fun getChunk(char: Char): Chunk {
                return charToChunkMap[char]?: invalidChar(char)
            }

            fun getCorruptScore(chunk: Chunk): Int {
                return when (chunk) {
                    is Parentheses -> 3
                    is Bracket -> 57
                    is CurlyBraces -> 1197
                    is Chevron -> 25137
                }
            }

            fun getIncompleteScore(chunk: Chunk): Int {
                return when (chunk) {
                    is Parentheses -> 1
                    is Bracket -> 2
                    is CurlyBraces -> 3
                    is Chevron -> 4
                }
            }

            private fun invalidChar(char: Char): Nothing {
                error("Invalid character $char")
            }
        }
    }
}
