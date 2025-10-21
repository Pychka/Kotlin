class Person(var firstName:String, var lastName:String, var patronymic:String, var age: Int = 25) {
    override fun toString(): String {
        return "ФИО: ${firstName} ${lastName} ${patronymic}; Возраст:${age}"
    }
}