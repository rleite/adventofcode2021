package utils

import java.math.BigInteger
import kotlin.math.abs

data class Position(val x: Int, val y: Int) {

    fun distance(other: Position): Int = abs(other.x - x) + abs(other.y - y)

    fun pointsBetween(other: Position, skipFirst: Boolean = false): Sequence<Position> {
        val moveVector = (other - this).normalise()
        val start = if(skipFirst) this + moveVector else this
        return generateSequence(start) { current ->
            when(current) {
                other -> null
                else -> current + moveVector
            }
        }
    }

    fun adjacent(): List<Position> {
        return listOf(
            this + Position(1, 0),
            this + Position(-1, 0),
            this + Position(0, 1),
            this + Position(0, -1),
        )
    }

    operator fun plus(other: Position): Position {
        return Position(x + other.x, y + other.y)
    }

    operator fun minus(other: Position): Position {
        return Position(x - other.x, y - other.y)
    }

    fun normalise(): Position {
        val bigX = BigInteger.valueOf(x.toLong()).abs()
        val bigY = BigInteger.valueOf(y.toLong()).abs()
        val gcd = bigX.gcd(bigY).toInt()
        return when {
            gcd != 0 -> {
                Position(x / gcd, y / gcd)
            }
            this.x == 0 -> {
                Position(x, 1)
            }
            else -> {
                Position(1, y)
            }
        }
    }

}
