import java.util.Scanner

open class Person(age: Int, FIO: String, number: String) {
    private var age: Int = age
    public var FIO: String = FIO
    public var number: String = number
    fun getAge(): Int {
        return age
    }
}

class Student(age: Int, FIO: String, number: String, var course: Int, var faculty: String, private var date: Int) :
    Person(age, FIO, number) {
    fun getDate(): Int {
        return date
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val students = arrayOf(
        Student(18, "Солиев Данила Денисович", "79872436587", 3, "ИТ", 2024),
        Student(17, "Рашевский Даниил Юрьевич", "71237658732", 2, "Экономика", 2025),
        Student(16, "Шкабаров Данила Андреевич", "79128766324", 1, "ИТ", 2026)
    )

    println("а) ФИО и возраст:")
    for (student in students) {
        println("ФИО: " + student.FIO + ", возраст: " + student.getAge())
    }

    println("Введите факультет: ")
    val enterfac: String = scanner.nextLine()
    println("б) Студенты факультета $enterfac:")
    for (student in students) {
        if (student.faculty.equals(enterfac, ignoreCase = true)) {
            println("ФИО: " + student.FIO + ", курс: " + student.course)
        }
    }

    println("Введите год: ")
    val enteryear = scanner.nextInt()
    println("в) Поступили после $enteryear года:")
    var check : Boolean = false
    for (student in students) {
        if (student.getDate() > enteryear) {
            println("ФИО: " + student.FIO + ", год поступления: " + student.getDate())
            check = true
        }
    }
    if (!check) {
        println("Нет таких студентов")
    }
}