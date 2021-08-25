# Word game Excercise code

```
fun main() {
    val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
    // get a collection of words that begin with the letter b
    val filteredWords = words.filter { it.startsWith("b", ignoreCase = true) }
	// shuffle the results to create a random list
    .shuffled()
    // specify the number of results to output
    .take(2)
    // sort the list
    .sorted()
    println(filteredWords)

}
```


