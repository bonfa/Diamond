import kotlin.math.abs

class DiamondPrinter {
    fun printToList(c: Char): List<String>? {
        val n = c - 'A' + 1
        return (1 until 2 * n).map { diamondLine(n, it) }
    }

    private fun diamondLine(n: Int, i: Int): String {
        val leftAndRightNumberOfSpaces = abs(n - i)
        val letter = letterForLine(n, i)
        val numberOfSpacesBetweenLetters = numberOfSpacesBetweenLetters(n, letter, leftAndRightNumberOfSpaces)
        return StringBuilder()
                .append(repeatSpaces(leftAndRightNumberOfSpaces))
                .append(letter)
                .append(repeatSpaces(numberOfSpacesBetweenLetters))
                .append(emptyIf_A_OtherWise(letter))
                .append(repeatSpaces(leftAndRightNumberOfSpaces))
                .toString()
    }

    private fun numberOfSpacesBetweenLetters(n: Int,
                                             letter: Char,
                                             leftAndRightNumberOfSpaces: Int): Int {
        val numberOfCharactersPerLine = (2 * n) - 1
        val numberOfLettersPerLine = if (letter == 'A') 1 else 2
        return numberOfCharactersPerLine - numberOfLettersPerLine - 2 * leftAndRightNumberOfSpaces
    }

    private fun letterForLine(n: Int, i: Int) = 'A' + n - 1 - abs(i - n)

    private fun emptyIf_A_OtherWise(letter: Char) = if (letter != 'A') letter.toString() else ""

    private fun repeatSpaces(times: Int) = " ".repeat(times)
}
