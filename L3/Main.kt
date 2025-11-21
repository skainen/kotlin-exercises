/*Create a base class Employee that includes:

A protected property name (employee's name).
A protected property baseSalary (fixed base salary).
An open function calculateSalary() that returns the base salary.
Create two subclasses that inherit from Employee:

FullTimeEmployee: Has an additional bonus that is added to the base salary.
PartTimeEmployee: Earns based on hourly rate and hours worked, which are used in the salary calculation.
Use mapOf to store multiple employees and their salary calculations.

Loop through the map and display each employee’s salary.*/


open class Employee(protected val name: String, protected val baseSalary: Int){
    open fun calculateSalary(): Int{
        return baseSalary
    }

    open fun getInfo(): String{
        return "$name: ${calculateSalary()}€"
    }
}

class FullTimeEmployee(
    name: String,
    baseSalary: Int,
    private val bonus: Int
    ) : Employee(name, baseSalary){

        override fun calculateSalary(): Int{
            return baseSalary + bonus
        }
}

class PartTimeEmployee(
    name: String,
    private val hourlyRate: Int,
    private val hoursWorked: Int
) : Employee(name, 0){
    
    override fun calculateSalary(): Int{
        return hourlyRate * hoursWorked
    }
}
    

fun main(){
    val employees = mapOf(
        "employee1" to FullTimeEmployee("A", 2500, 500),
        "employee2" to FullTimeEmployee("B", 2000, 300),
        "employee3" to PartTimeEmployee("C", 30, 80),
        "employee4" to PartTimeEmployee("D", 28, 40),
    )

    employees.forEach{(id, employee) -> println("$id - ${employee.getInfo()}")}
}
