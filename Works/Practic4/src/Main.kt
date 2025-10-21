fun main() {
    task1()
    task2()
    task3()
}

val disciplines = mapOf(
    "МДК 1.01" to "Магистраль дорожных колоний 1",
    "МДК 2.02" to "Магистраль дорожных колоний 2",
    "МДК 3.03" to "Магистраль дорожных колоний 3",
    "МДК 4.04" to "Магистраль дорожных колоний 4",
    "ОП 2.02" to "Основы производства 1",
    "ОП 3.03" to "Основы производства 2",
    "ОП 1.01" to "Основы производства 3",
    "ОП 4.04" to "Основы производства 4",
)

val teachers = mutableListOf(
    Person("FirstName 1", "LastName 1", "Patronymic 1"),
    Person("FirstName 2", "LastName 2", "Patronymic 2"),
    Person("FirstName 3", "LastName 3", "Patronymic 3"),
    Person("FirstName 4", "LastName 4", "Patronymic 4"),
    Person("FirstName 5", "LastName 5", "Patronymic 5"),
    Person("FirstName 6", "LastName 6", "Patronymic 6"),
    Person("FirstName 7", "LastName 7", "Patronymic 7"),
)

val students = mutableListOf(
    Person("FirstName 1", "LastName 1", "Patronymic 1", 16),
    Person("FirstName 2", "LastName 2", "Patronymic 2", 15),
    Person("FirstName 3", "LastName 3", "Patronymic 3", 19),
    Person("FirstName 4", "LastName 4", "Patronymic 4", 18),
    Person("FirstName 5", "LastName 5", "Patronymic 5", 18),
    Person("SecondFirstName 6", "LastName 6", "Patronymic 6", 17),
    Person("FirstName 7", "LastName 7", "Patronymic 7", 16),
)


fun task1(){
    println(disciplines.filter { it.key.startsWith("МДК") }.values.joinToString(", "))
    println("Кол-во дисциплин: ${disciplines.size}")
}

fun task2(){
    println("Фамилии совершенолетних студентов:")
    students.filter{it.age >= 18}.forEach { println(it.firstName) }
    println("Фамилии студентов младше 18:")
    students.filter{it.age < 18}.forEach { println(it.firstName) }
    println("Фамилии студентов начинающиеся на 'F':")
    students.filter{it.firstName.startsWith('F')}.forEach { println(it.firstName) }
    println("Студенты по порядку:")
    students.sortedBy{it.firstName}.sortedBy{it.lastName}.sortedBy{it.patronymic}.sortedBy { it.age }.forEach { println(it.toString()) }
}

fun task3(){
    if(teachers.removeIf { it.firstName == "FirstName 2" })
        println("Преподователь с фамилией: FirstName 2 был удалён")
    val teacher = teachers.firstOrNull { it.firstName == "FirstName 3" }
    teacher?.firstName = "FirstName 7"
}