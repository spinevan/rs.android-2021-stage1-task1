package subtask1

@Suppress("UNCHECKED_CAST")
class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {

        var res: ArrayList<Int> = ArrayList()
        res.addAll( sadArray.asIterable() )

        var resChek: MutableMap<String, Any> = checkBadArray( res )

        while ( resChek["hasBad"] == true ) {

            resChek = checkBadArray(resChek["array"] as ArrayList<Int>)

        }

        res = resChek["array"] as ArrayList<Int>

        return res.toIntArray()

    }

    fun checkBadArray(sadArray: ArrayList<Int>): MutableMap<String, Any> {
        val res: MutableMap<String, Any> = mutableMapOf("hasBad" to false, "array" to sadArray)

        val resArray: ArrayList<Int> = ArrayList()

        for ( index in sadArray.indices ) {
            if ( index == 0 ) {
                resArray.add(sadArray[index])
                continue
            }
            if ( index == sadArray.size-1 ) {
                resArray.add(sadArray[index])
                break
            }

            val prevElem: Int = sadArray[index-1]
            val nextElem: Int = sadArray[index+1]
            val curElem: Int = sadArray[index]
            if ( curElem < prevElem + nextElem ) {
                resArray.add(curElem)
            } else {
                res["hasBad"] = true
            }
        }

        res["array"] = resArray
        return res
    }

}
