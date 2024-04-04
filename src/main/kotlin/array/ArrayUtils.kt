package array

class ArrayUtils {
    // until -> means less than === <
    // ..    -> means less or equal
    fun printArray(arr: IntArray) {
        val n = arr.size
        for (i in 0..<n) {
            println("${arr[i]}   ")
        }
        println()
    }

    fun arrayDemo() {
        val myArray: IntArray = IntArray(5)
        myArray[0] = 5
        myArray[1] = 1
        myArray[2] = 8
        myArray[3] = 2
        myArray[4] = 10
        printArray(myArray)
        println(myArray.size)
        println(myArray[myArray.size - 1])
        println()

        val arr = intArrayOf(5, 1, 8, 10)
        println(arr.joinToString())


        // creating array
        //functions, such as arrayOf(), arrayOfNulls() or emptyArray().
        var riversArray = arrayOf("Nile", "Amazon", "Yangtze")
        // Using the += assignment operation creates a new riversArray,
        // copies over the original elements and adds "Mississippi"
        riversArray += "Mississippi"
        println(riversArray.joinToString())
//=========================================================================
        // Creates an array with values [1, 2, 3]
        val simpleArray = arrayOf(1, 2, 3)
        println(simpleArray.joinToString())
        // 1, 2, 3
//=========================================================================
        // Creates an array with values [null, null, null]
        val nullArray: Array<Int?> = arrayOfNulls(3)
        println(nullArray.joinToString())
        // null, null, null
//=========================================================================
        var exampleArray = emptyArray<String>()

        /**
         * var exampleArray = emptyArray<String>()
         * var exampleArray: Array<String> = emptyArray()
         * **/
//=========================================================================
        // Creates an Array<Int> that initializes with zeros [0, 0, 0]
        val initArray = Array<Int>(3) { 0 }
        println(initArray.joinToString())
        // 0, 0, 0
//=========================================================================
// Creates an Array<String> with values ["0", "1", "4", "9", "16"]
        val asc = Array(5) { i -> (i * i).toString() }
        asc.forEach { print(it) }
// 014916
//=========================================================================
// Creates a two-dimensional array
        val twoDArray = Array(2) { Array<Int>(2) { 0 } }
        println(twoDArray.contentDeepToString())
// [[0, 0], [0, 0]]

//=========================================================================

        val lettersArray = arrayOf("c", "d")
        printAllStrings("a", "b", *lettersArray)
        // abcd
//=========================================================================
        val simpleArray1 = arrayOf(1, 2, 3)
        val anotherArray1 = arrayOf(1, 2, 3)

// Compares contents of arrays
        println(simpleArray1.contentEquals(anotherArray1))
// true

//=========================================================================
// Using infix notation, compares contents of arrays after an element
// is changed
        simpleArray1[0] = 10
        println(simpleArray1 contentEquals anotherArray1)
// false

//=========================================================================


//=========================================================================

    }


    fun printAllStrings(vararg strings: String) {
        for (string in strings) {
            print(string)
        }
        println()
    }
}