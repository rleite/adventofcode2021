package year2021.day11

import utils.Position

object Day11 {

    fun part1(input: Sequence<String>): Int {
        val values = parse(input)
        return (0 until 100).sumOf { computeFlashes(values) }
    }

    fun part2(input: Sequence<String>): Int {
        val values = parse(input)
        val size = values.flatten().size

        var i = 1
        while (computeFlashes(values) != size) {
            i++
        }
        return i
    }

    fun computeFlashes(values: List<MutableList<Int>>): Int {
        val flashedMap = mutableMapOf<Position, Boolean>()

        val positions = values.withIndex().map { row ->
            row.value.withIndex().map { col ->
                Position(row.index, col.index)
            }
        }.flatten()

        return positions.onEach { addEnergy(values, it, flashedMap) }
                .filter { values[it.x][it.y] > 9 }
                .onEach { values[it.x][it.y] = 0 }
                .count()
    }

    private fun addEnergy(values: List<MutableList<Int>>, pos: Position, flashedMap: MutableMap<Position, Boolean>) {
        values[pos.x][pos.y]++
        if (values[pos.x][pos.y] > 9) {
            flash(values, pos, flashedMap)
        }
    }

    private fun flash(values: List<MutableList<Int>>, pos: Position, flashedMap: MutableMap<Position, Boolean>) {
        if (flashedMap[pos] == true) {
            return
        }
        flashedMap[pos] = true
        getNeighbours(pos)
            .filter { values.getOrNull(it.x)?.getOrNull(it.y) != null }
            .onEach { addEnergy(values, it, flashedMap) }
    }

    private fun getNeighbours(pos: Position): List<Position> {
        return (-1..1).flatMap { x->
            val step = if (x == 0) 2 else 1
            (-1..1 step step).map { y->
                pos + Position(x, y)
            }
        }
    }

    fun parse(input: Sequence<String>): List<MutableList<Int>> {
        return input.map { row -> row.toList().map { it.digitToInt() }.toMutableList() }
            .toList()
    }
}
