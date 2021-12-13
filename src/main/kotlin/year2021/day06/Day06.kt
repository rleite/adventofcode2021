package year2021.day06

const val NEXT_CYCLE_AGE = 6
const val NEW_BORN_AGE = 8


object Day06 {
    private data class SeedAge(val seed: Int, val age: Int)

    private fun calculatePopulationFor(seedAgeMap: MutableMap<SeedAge, Long>, seedAge: SeedAge): Long {
        if (seedAge.seed >= seedAge.age) {
            return 1L
        }

        seedAgeMap[seedAge]?.also {
            return it
        }

        val newCounter = (seedAge.seed - 1)

        return when {
            newCounter < 0 -> listOf(NEXT_CYCLE_AGE, NEW_BORN_AGE)
            else -> listOf(newCounter)
        }
            .map { calculatePopulationFor(seedAgeMap, SeedAge(it, seedAge.age - 1)) }
            .sumOf { it }
            .also { seedAgeMap[seedAge] = it }
    }

    private fun calculatePopulation(input: Sequence<String>, age: Int): Long {
        val seed = input
            .flatMap {
                it.split(",")
            }
            .map { it.toInt() }
            .toList()

        val seedAgeMap = HashMap<SeedAge, Long>()

        return seed
            .map { calculatePopulationFor(seedAgeMap, SeedAge(it, age)) }
            .sumOf { it }
    }

    fun part1(input: Sequence<String>): Long {
        return calculatePopulation(input, 80)
    }

    fun part2(input: Sequence<String>): Long {
        return calculatePopulation(input, 256)
    }
}
