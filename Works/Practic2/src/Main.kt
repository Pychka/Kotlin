import java.util.Random

fun main() {
    task1()
    task2()
    task3()
    task4()
    task5()
}

fun task1() =
    println((1..5).joinToString(", "))

fun task2(){
    var result = 1;
    while(result < 1000)
        result += result;
    println(result)
}

fun task3(){
    val n = readln().toInt()
    var max = 0;
    while (max * max < n)
        max++
    println((0..max).joinToString(", "))
}

fun task4(){
    var n = readln().toInt()
    var result = 0;
    while (n-- > 0)
        result += 3 * n - 1
    println(result)
}

fun task5(){
    var counter = 0
    var roll = 0
    do{
        roll = Random().nextInt(6)
        counter++
    }
    while(roll != 0)
    println("После $counter бросков roll = 0")
}