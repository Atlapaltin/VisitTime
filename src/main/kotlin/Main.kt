val minute = 60
val hour = 60 * minute
val day = 24 * hour

fun main() {
    println(agoToText(minute))
    println(agoToText(20 * minute))
    println(agoToText(5 * hour))
}

private fun agoToText(secondSum: Int): String {
    return when {
        secondSum <= minute -> "был(а) только что"
        secondSum <= hour -> minutesToText(secondSum)
        secondSum <= day -> hoursToText(secondSum)
        secondSum <= 2 * day -> "был(а) в сети сегодня"
        secondSum <= 3 * day -> "был(а) в сети вчера"
        else -> "был(а) в сети давно"
    }
}

private fun minutesToText(secondSum: Int): String {
    val minuteSum = secondSum / minute
    val divisionBy10Remainder = minuteSum % 10
    val minutesText = when {
        (minuteSum in 5..20) || divisionBy10Remainder >= 5 || divisionBy10Remainder == 0 -> "минут"
        divisionBy10Remainder >= 2 -> "минуты"
        else -> "минуту"
    }
    return "был(а) $minuteSum $minutesText назад"
}

private fun hoursToText(secondSum: Int): String {
    val hourSum = secondSum / hour
    val divisionBy10Remainder = hourSum % 10
    val hoursText = when {
        (hourSum in 5..20) || divisionBy10Remainder == 0 -> "часов"
        divisionBy10Remainder >= 2 -> "часа"
        else -> "час"
    }
    return "был(а) в сети $hourSum $hoursText назад"
}