import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)

    println(
        "Введите тип карты MasterCard / Maestro / VkPay / Visa / Мир [нажите 'enter'], сумму предыдущих переводов в " +
                "этом месяце [нажите 'enter'], текущую сумму перевода [нажите 'enter']:"
    )
    val card = scanner.nextLine()
    val transactionMonth = scanner.nextLine().toInt()
    val transaction = scanner.nextLine().toInt()

    if (transaction > 150000) {
        println("Превышен максимальный суточный лимит - до 150 000 руб\nЖдем Вас завтра!")
        return
    } else if (transactionMonth > 600000) {
        println("Превышен максимальный месячный лимит - до 600 000 руб\nЖдем Вас в следующем месяце!")
        return
    } else {
        println("Выполняется операция...")
    }

    val resultToDouble = comission(card, transactionMonth, transaction)
    val result = String.format("%.2f", resultToDouble)
    println("Сумма перевода $transaction руб, комиссия $result руб")
}

fun comission(card: String = "VkPay", transactionMonth: Int = 0, transaction: Int): Double {

    return when (card) {
        "MasterCard" -> masterCardCalc(card, transactionMonth, transaction)
        "Maestro" -> maestroCalc(card, transactionMonth, transaction)
        "VkPay" -> 0.00
        "Visa" -> visaCalc(card, transactionMonth, transaction)
        "Мир" -> mirCalc(card, transactionMonth, transaction)
        else -> throw  Exception ("Не верное значение!")
    }
}

fun masterCardCalc(card: String, transactionMonth: Int = 0, transaction: Int): Double {
    val transCop = transaction * 100 // коп
    val comisCalc = (transCop / 100) * 0.6 + 2000
    if (transCop in 30000..7500000) {
        println(
            "В рамках акции с 1.05 - 31.05, при переводе от 300р - 75000, " +
                    "комиссия при переводе с карт MasterCard и Maestro - 0 руб."
        )
        return 0.0
    } else {
        comisCalc
    }
    return comisCalc / 100
}

fun maestroCalc(card: String, transactionMonth: Int = 0, transaction: Int): Double {
    val transCop = transaction * 100 // коп
    val comisCalc = (transCop / 100) * 0.6 + 2000
    if (transCop in 30000..7500000) {
        println(
            "В рамках акции с 1.05 - 31.05, при переводе от 300р - 75000р, " +
                    "комиссия при переводе с карт MasterCard и Maestro - 0 руб."
        )
        return 0.0
    } else {
        comisCalc / 100
    }
    return comisCalc
}

fun visaCalc(card: String, transactionMonth: Int = 0, transaction: Int): Double {
    val transCop = transaction * 100 // коп
    var comisCalc = (transCop / 100) * 0.75
    if (comisCalc < 3500) {
        comisCalc = 3500.00
    } else {
        comisCalc
    }
    return comisCalc / 100
}

fun mirCalc(card: String, transactionMonth: Int = 0, transaction: Int): Double {
    val transCop = transaction * 100 // коп
    var comisCalc = (transCop / 100) * 0.75
    if (comisCalc < 3500) {
        comisCalc = 3500.00
    } else {
        comisCalc
    }
    return comisCalc / 100
}

