import org.junit.Test

import org.junit.Assert.*

class Task1KtTest {

    @Test
    fun comission_shouldNotAddDiscount() {
        val card = "Maestro"
        val transactionMonth = 15000
        val transaction = 30000

        val result = comission(
            card = "Maestro",
            transactionMonth = transactionMonth,
            transaction = transaction
        )
        assertEquals(00.00, result, 0.0001)
    }
    @Test
    fun masterCardCalc_shouldNotAddDiscount() {
        val card = "MasterCard"
        val transactionMonth = 12000
        val transaction = 500

        val result = comission(
            card = "MasterCard",
            transactionMonth = transactionMonth,
            transaction = transaction
        )
        assertEquals(00.00, result, 0.0001)
    }
    @Test
    fun maestroCalc_shouldNotAddDiscount() {
        val card = "Maestro"
        val transactionMonth = 10000
        val transaction = 1000

        val result = comission(
            card = "Maestro",
            transactionMonth = transactionMonth,
            transaction = transaction
        )
        assertEquals(00.00, result, 0.0001)
    }
    @Test
    fun visaCalc_shouldNotAddDiscount() {
        val card = "Visa"
        val transactionMonth = 10000
        val transaction = 10000

        val result = comission(
            card = "Visa",
            transactionMonth = transactionMonth,
            transaction = transaction
        )
        assertEquals(75.00, result, 0.0001)
    }
    @Test
    fun mirCalc_shouldNotAddDiscount() {
        val card = "Мир"
        val transactionMonth = 11000
        val transaction = 11000

        val result = comission(
            card = "Мир",
            transactionMonth = transactionMonth,
            transaction = transaction
        )
        assertEquals(82.50, result, 0.0001)
    }
}