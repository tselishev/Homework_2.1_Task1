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

}