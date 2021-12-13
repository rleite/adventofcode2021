package year2021.day09

import utils.Position
import kotlin.collections.HashMap

object Day09 {
    data class AdjacentValues(val value: Pair<Position, Int>, val adjacent: List<Pair<Position, Int>>) {
        val isLowPoint = adjacent.all { maybeValue -> maybeValue.second > value.second }
    }

    data class DepthMap(val map: List<List<Int>>) {
        private val valuesWithAdjacent =
            map.withIndex().flatMap { row ->
                row.value.withIndex().map { col -> Position(row.index, col.index) to col.value }
            }.map { getAdjacentValues(it) }

        private fun getAdjacentValues(value: Pair<Position, Int>): AdjacentValues {
            return AdjacentValues(value, value.first.adjacent().mapNotNull { getValue(it) })
        }

        private fun getBasin(value: Pair<Position, Int>): List<Pair<Position, Int>> {
            val visitedPositions: MutableMap<Position, Boolean> = HashMap()
            visitedPositions[value.first] = true

            return generateSequence(listOf(getAdjacentValues(value))) { candidates ->
                candidates.flatMap { (value, adjacent) ->
                    adjacent
                        .filter { (pos, basin) ->
                            !(visitedPositions[pos]?: false) && isBasin(value.second, basin)
                        }
                        .map { (pos, basin) ->
                            visitedPositions[pos] = true
                            getAdjacentValues(pos to basin)
                        }
                }.ifEmpty { null }
            }.flatten().toList().map { it.value }
        }

        private fun getValue(pos: Position): Pair<Position, Int>? {
            return map.getOrNull(pos.x)?.getOrNull(pos.y)?.let {
                pos to it
            }
        }

        val lowPoints = valuesWithAdjacent.filter { it.isLowPoint }.map { it.value }
        val basinPointsList = lowPoints.map { getBasin(it) }


        companion object {
            fun parse(input: Sequence<String>): DepthMap {
                return DepthMap(input.toList().map { it.map { char -> char.digitToInt() } })
            }

            private fun isBasin(value: Int, basin: Int): Boolean {
                return basin > value && basin != 9
            }
        }
    }

    fun part1(input: Sequence<String>): Int {
        return DepthMap.parse(input).lowPoints.sumOf { it.second + 1 }
    }

    fun part2(input: Sequence<String>): Int {
        return DepthMap.parse(input).basinPointsList
            .map { it.count() }
            .sorted()
            .takeLast(3)
            .reduce { acc, value -> acc * value }
    }
}
