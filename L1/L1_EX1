fun getPrimes(): List<Int>{
    val primes = mutableListOf<Int>()
    
    for (num in 2..50){
        var isPrime = true
        
        var i = 2
        while (i * i <= num){
            if (num % i == 0){
                isPrime = false
                break
            }
            i++
        }
        if (isPrime){
            primes.add(num)
        }
    }
    return primes
}

fun main(){
    val primes = getPrimes().toMutableList()
    val evens = (2..100 step 2).toList()
    
    primes.addAll(evens)
    println("Combined: $primes")
}
