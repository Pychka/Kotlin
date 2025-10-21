fun main() {
    task1()
    task2()
    task3()
}

fun  task1(){
    val phrase1 = "по МДК 03.01"
    val phrase2 = "выполнить контрольную работу"
    println("$phrase1 $phrase2")
}

fun task2(){
    val text = "В 3 семестре по МДК 03.01 Разработка мобильных приложений нужно выполнить контрольную работу"
    val result = text.substringAfter("приложений ").substringBefore(" работу") + " работу"
    println(result)
}

fun task3(){
    val text = "Россия — священная наша держава, Россия — любимая наша страна. Могучая воля, великая слава — Твое достоянье на все времена!"
    val chunkSize = 30

    text.chunked(chunkSize).forEach { println(it) }
}