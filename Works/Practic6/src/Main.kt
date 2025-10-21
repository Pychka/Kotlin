import java.time.YearMonth
import kotlin.math.pow

fun main() {
    task1()
    task2()
    task3()
    task4()
}

fun task1(){
    println("Введите радиус шара: ")
    val radius = readln().toDouble()
    println("Объём шара: ${(4.0 / 3.0) * Math.PI * radius.pow(3.0)}")
}

fun task2(){
    println("Введите число: ")
    val num = readln().toInt();
    println(num.toString().reversed().toInt())
}

fun task3(){
    println("Введите число: ")
    val num = readln().toInt();
    println("Кол-во цифр в числе = ${num.toString().length}")
}

fun task4(){
    println("Введите год: ")
    val year = readln().toInt();
    println("Введите месяц: ")
    val month = readln().toInt();
    println("Кол-вод дней в месяце: ${YearMonth.of(year, month).lengthOfMonth()}")
}