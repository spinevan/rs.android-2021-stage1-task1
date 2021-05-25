package subtask2

class BillCounter {

    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {

        val  paiedBill: IntArray = bill.clone()
        paiedBill.set(k, 0)

        val summ: Int = paiedBill.sum() / 2

        if ( summ == b ) {
            return "Bon Appetit"
        }

        val res: Int = b - summ
        return res.toString()

    }
}
