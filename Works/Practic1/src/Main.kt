import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    task1()
    task2()
    task3()
    task4()
    task5()
    task6()
}

fun task1(){
    val firstName = getString("Введите вашу фамилию:")
    val lastName = getString("Введите ваше имя:")
    val patronymic = getString("Введите ваше отчество:")
    val group = getString("Введите вашу группу:")
    val curatorFirstName = getString("Введите фамилию вашего куратора:")
    val curatorLastName = getString("Введите имя вашего куратора:")
    val curatorPatronymic = getString("Введите отчество вашего куратора:")
    println("Ваше ФИО: $firstName $lastName $patronymic\nВаша группа: $group\nФИО вашего куратора: $curatorFirstName $curatorLastName $curatorPatronymic")
}

fun task2(){
    val a = getString("Первое число: ").toInt()
    val b = getString("Второе число: ").toInt()
    println(min(a, b))
}

fun task3(){
    val a = getString("Первое число: ").toInt()
    val b = getString("Второе число: ").toInt()
    val c = getString("Третье число: ").toInt()
    println((a + b + c) / 3)
}

fun task4(){
    val list = mutableMapOf("09.02.07" to "Информационные системы и программирование", "09.02.01" to "Системное администрирование", "09.02.03" to "Программное обеспечение вычислительной техники и автоматизированных систем", "09.02.04" to "Информационные системы")
    val key = getString("Введите код специальности: ")
    println(list.getOrDefault(key, "Неверный код!"))
}

fun task5(){
    val a = getString("Первое число: ").toDouble()
    val b = getString("Второе число: ").toDouble()
    val c = getString("Третье число: ").toDouble()
    val d = b * b - 4 * a * c
    if(d > 0)
        println("2 корня")
    if(d == 0.0)
        println("1 корень")
    if(d < 0)
        println("Нет корней")
}

fun task6(){
    val a = getString("a: ").toDouble()
    val b = getString("b: ").toDouble()
    val c = getString("c: ").toDouble()

    if (a == 0.0) {
        if (b == 0.0) {
            println("Нет решений")
        } else if (-c / b < 0) {
            println("Нет решений")
        } else {
            val x = -sqrt(-c / b)
            println("Минимальный корень: $x")
        }
    } else {
        val d = b * b - 4 * a * c
        if (d < 0) {
            println("Нет решений")
        } else {
            val y1 = (-b + sqrt(d)) / (2 * a)
            val y2 = (-b - sqrt(d)) / (2 * a)
            val y3 = max(y1, y2)

            if (y3 < 0) {
                println("Нет решений")
            } else {
                val x = -sqrt(y3)
                println("Минимальный корень: $x")
            }
        }
    }
}

fun getString(message: String) : String{
    println(message)
    return readln()
}