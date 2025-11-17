fun main() {
    val numbers = (1..100).toList()
    
    val evens = numbers.filter {it % 2 == 0}
    
    val squares = numbers.map {it * it}
    
    val sum = numbers.reduce {acc, n -> acc + n}

    println("Even: $evens\n")
    println("Square: $squares\n")
    println("Sum: $sum\n")
}
