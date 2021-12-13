package year2019.day03

import utils.Position

val ORIGIN = Position(0, 0)

object Day03 {

    fun part1(input: Sequence<String>): Int {
        return generateLinePoints(input)
            .map { it.distinct() }
            .flatten()
            .groupBy { it }
            .mapValues { it.value.count() }
            .filter { it.key != ORIGIN && it.value > 1 }
            .minOf { it.key.distance(ORIGIN) }
    }

    fun part2(input: Sequence<String>): Int {
        return generateLinePoints(input)
            .withIndex()
            .flatMap { (index, points) ->
                points
                    .withIndex()
                    .map { (pointIndex, point) -> point to (index to pointIndex) }
            }
            .groupBy({ it.first }) { it.second }
            .mapValues { (_, values) ->
                values.sortedBy { it.second }
                    .distinctBy { it.first }
            }
            .filter { it.key != ORIGIN && it.value.count() > 1 }
            .minOf { (_, values) -> values.sumOf { it.second } }
    }

    private fun generateLinePoints(input: Sequence<String>): Sequence<Sequence<Position>> {
        return input
            .map { it.split(',') }
            .map { actions -> actions.map { getActionToVector(it) } }
            .map { vectors ->
                sequence {
                    val itVector = vectors.iterator()
                    yield(ORIGIN)
                    var previous = ORIGIN
                    while(itVector.hasNext()) {
                        val next = previous + itVector.next()
                        for (position in previous.pointsBetween(next, true)) {
                            yield(position)
                        }
                        previous = next
                    }
                }
            }
    }

    private fun getActionToVector(action: String): Position {
        val value = action.substring(1, action.length).toInt()
        return when(action[0]) {
            'R' -> Position(value, 0)
            'L' -> Position(-value, 0)
            'U' -> Position(0, value)
            'D' -> Position(0, -value)
            else -> error("Invalid action $action")
        }
    }

    private fun printMap(map: Map<Position, Int>) {
        val maxX = map.maxOf { it.key.x }
        val minX = map.minOf { it.key.x }
        val maxY = map.maxOf { it.key.y }
        val minY = map.minOf { it.key.y }

        println((minX..(maxX+2)).joinToString(separator = "") { "." })
        for (y in (maxY downTo minY)) {
            print(".")
            for (x in (minX..maxX)) {
                val position = Position(x, y)
                print(when {
                    position == ORIGIN -> "O"
                    map[position] == null -> '.'
                    else -> map[position]
                })
            }
            println(".")
        }
        println((minX..(maxX+2)).joinToString(separator = "") { "." })
    }
}
