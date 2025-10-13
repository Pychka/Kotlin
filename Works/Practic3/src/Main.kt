import kotlin.random.Random

fun main() {
    task1()
    task2()
    task3()
    task4()
    task5()
    task6()
}

fun task1(){
    val list = Array(10){"#$it"}
    println("${list[5]} ${list[7]}")
}

fun task2(){
    println(('а'..'я').joinToString(", "))
}

fun task3(){
    println((Array(Random.nextInt(1000)){}).size)
}

fun task4(){
    println(listOf(
        "Понедельник", "Вторник", "Среда", "Четверг",
        "Пятница", "Суббота", "Воскресенье"
    ).joinToString(", "))
}

fun task5(){
    println(if(listOf(
        "Понедельник", "Вторник", "Среда", "Четверг",
        "Пятница", "Суббота", "Воскресенье"
    ).contains("Понедельник")) "да" else "нет")
}

fun task6(){
    val size = readln().toInt()
    val list = Array(size){ 0 }
    var index = 0
    while(index < size)
    {
        list[index] = readln().toInt()
        index++
    }
    println(list.joinToString(", "))
}