/**
 * Finds each prime number lower than or equal to a given
 * input number
 */
fun get_primes(maxNumber: Int): List<Int>
{
    val primes: MutableList<Int> = mutableListOf()

    for(value in 2 .. maxNumber) 
    {
        var is_prime = true

        for(prime in primes)
        {
            if (value % prime == 0)
            {
                is_prime = false
                break
            }
        }

        if(is_prime == true) 
        {
            primes.add(value)
        }
    }

    return primes
}

/**
 * finds each pair of goldbach numbers that equal a given number and provides 
 * them as an list of tuples
 */
fun find_goldbach_pairs(goldbachNumber: Int) : List<Pair<Int, Int>>
{
    var goldbachPairs: List<Pair<Int, Int>> = mutableListOf()

    if(goldbachNumber >= 4 && goldbachNumber % 2 == 0)
    {
        val primeNumbers = get_primes(goldbachNumber)

        for(index in 0 .. primeNumbers.size)
        {
            if(primeNumbers[index] > goldbachNumber / 2)
            {
                break
            }

            val difference = goldbachNumber - primeNumbers[index]

            if(difference in primeNumbers)
            {
                goldbachPairs += Pair(primeNumbers[index], difference)
            }
        }
    }
    return goldbachPairs
}


/**
 * this is the main class where the goldbach program begins (use doc comments like this on any
 * functions or classes your create). currently the program only finds a single 
 * goldbach number and finds its pairs, using main to print its values. a good 
 * improvement might be make an original printing function, along with looking 
 * for ways to improve efficency of methods (note you can use tools to measure
 * the time it takes for the script to run and find what works best) the 
 * program will also need to compute pairs for a significant amount of numbers
 */
fun main()
{
    val goldbachNumber = 100
    var goldbachPairs = find_goldbach_pairs(goldbachNumber)

    for(i in 0 .. goldbachPairs.size - 1)
    {
        println("$goldbachNumber ${goldbachPairs[i].first} ${goldbachPairs[i].second}")
    }
}