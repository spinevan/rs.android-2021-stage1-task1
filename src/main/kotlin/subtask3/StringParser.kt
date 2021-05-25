package subtask3

import kotlin.collections.ArrayList

class StringParser {

    private val myTest = sortedMapOf<Int, IntArray>()

    fun getResult(inputString: String): Array<String> {

        val res: ArrayList<String> = ArrayList()

        parseString(inputString)

        for ( (key, value) in myTest ) {
            for (item in value) {
                res.add(inputString.substring(startIndex = key, endIndex = item))
            }
        }

        return res.toTypedArray()

    }


    fun parseString(inputString: String) {

        val openers = "<[("

        val mapClosers = mapOf<Char, Char>('<' to '>', '[' to ']', '(' to ')')

        var index = 0

        for (char in inputString) {

            if ( openers.contains(char) ) {

                var y = index + 1
                val endsArray = ArrayList<Int>()
                var deep = 1

                while ( y < inputString.length ) {

                    val curChar = inputString[y]

                    if (openers.contains(curChar)) {
                        deep++
                    }

                    if (  curChar == mapClosers[char] ) {
                        endsArray.add(y)
                        deep--

                        if (deep == 0) break

                    }
                    y++
                }

                if (index > 0 && endsArray.size > 0 ) {
                    myTest[index+1] = endsArray.toIntArray()
                }

            }

            index++

        }


    }
}
