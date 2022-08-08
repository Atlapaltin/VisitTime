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
        secondSum <= minute -> "���(�) ������ ���"
        secondSum <= hour -> minutesToText(secondSum)
        secondSum <= day -> hoursToText(secondSum)
        secondSum <= 2 * day -> "���(�) � ���� �������"
        secondSum <= 3 * day -> "���(�) � ���� �����"
        else -> "���(�) � ���� �����"
    }
}

private fun minutesToText(secondSum: Int): String {
    val minuteSum = secondSum / minute
    val divisionBy10Remainder = minuteSum % 10
    val minutesText = when {
        (minuteSum in 5..20) || divisionBy10Remainder >= 5 || divisionBy10Remainder == 0 -> "�����"
        divisionBy10Remainder >= 2 -> "������"
        else -> "������"
    }
    return "���(�) $minuteSum $minutesText �����"
}

private fun hoursToText(secondSum: Int): String {
    val hourSum = secondSum / hour
    val divisionBy10Remainder = hourSum % 10
    val hoursText = when {
        (hourSum in 5..20) || divisionBy10Remainder == 0 -> "�����"
        divisionBy10Remainder >= 2 -> "����"
        else -> "���"
    }
    return "���(�) � ���� $hourSum $hoursText �����"
}