# Collections

A collection is a group of related items, like a list of words, or a set of employee records. The collection can have the items ordered or unordered, and the items can be unique or not. You've already learned about one type of collection, lists. Lists have an order to the items, but the items don't have to be unique.

As with lists, Kotlin distinguishes between mutable and immutable collections. Kotlin provides numerous functions for adding or deleting items, viewing, and manipulating collections.

## Create a List

```
fun main() {
      val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
          println("list:   ${numbers}")
}
```

> list:   [0, 3, 8, 4, 0, 5, 5, 8, 9, 2]

to show a the output of a list in ascending order 

```
fun main() {
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("sorted: ${numbers.sorted()}")
}
```

> sorted: [0, 0, 2, 3, 4, 5, 5, 8, 8, 9]

## Sets

Another type of collection in Kotlin is a set. It's a group of related items, but unlike a list,**there can't be any duplicates, and the order doesn't matter**. An item can be in the set or not, but if it's in the set, there is only one copy of it. This is similar to the mathematical concept of a set. For example, there is a set of books that you've read. Reading a book multiple times doesn't change the fact it is in the set of books that you've read.

```
fun main() {
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}")
    println("sorted: ${numbers.sorted()}")
    val setOfNumbers = numbers.toSet()
	println("set:    ${setOfNumbers}")
}
```

> list:   [0, 3, 8, 4, 0, 5, 5, 8, 9, 2]
> sorted: [0, 0, 2, 3, 4, 5, 5, 8, 8, 9]
> set:    [0, 3, 8, 4, 5, 9, 2]

To define a mutable and immutable set add the following 

```
fun main() {

    val set1 = setOf(1,2,3)
	val set2 = mutableSetOf(3,2,1)
    val numbers = listOf(0, 3, 8, 4, 0, 5, 5, 8, 9, 2)
    println("list:   ${numbers}")
    println("sorted: ${numbers.sorted()}")
    val setOfNumbers = numbers.toSet()
	println("set:    ${setOfNumbers}")
    println("$set1 == $set2: ${set1 == set2}")
}
```
> list:   [0, 3, 8, 4, 0, 5, 5, 8, 9, 2]
> sorted: [0, 0, 2, 3, 4, 5, 5, 8, 8, 9]
> set:    [0, 3, 8, 4, 5, 9, 2]
> [1, 2, 3] == [3, 2, 1]: true

Even though one is mutable and one isn't, and they have the items in a different order, they're considered equal because they contain exactly the same set of items.

One of the main operations you might perform on a set is checking if a particular item is in the set or not with the `contains()` function. You've seen `contains()` before, but used it on a list.

```
println("contains 7: ${setOfNumbers.contains(7)}")
```

> println("contains 7: ${setOfNumbers.contains(7)}")

## Maps

The last type of collection you'll learn about in this codelab is a map or dictionary. **A map is a set of key-value pairs, designed to make it easy to look up a value given a particular key**. Keys are unique, and each key maps to exactly one value, but the values can have duplicates. Values in a map can be strings, numbers, or objects—even another collection like a list or a set.

```
fun main() {
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    println(peopleAges)
}
```

> {Fred=30, Ann=23}

To add more entries to the map you can use `put()` function, passing in the key and the value.

`peopleAges.put("Barbara", 42)`

Using shorthand notation

`peopleAges["Joe"] = 51`

```
fun main() {
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println(peopleAges)
}
```

> {Fred=30, Ann=23, Barbara=42, Joe=51}

## Working with collections

Although they have different qualities, different types of collections have a lot of behavior in common. If they're mutable, you can add or remove items. You can enumerate all the items, find a particular item, or sometimes convert one type of collection to another. You did this earlier where you converted a `List` to a `Set` with `toSet()`. Here are some helpful functions for working with collections.

### foreach

Suppose you wanted to print the items in `peopleAges`, and include the person's name and age. For example, `"Fred is 31, Ann is 23,..."` and so on. You learned about `for` loops in an earlier codelab, so you could write a loop with `for (people in peopleAges) { ... }`.

However, enumerating all the objects in a collection is a common operation, so Kotlin provides `forEach()`, which goes through all the items for you and performs an operation on each one.

```
fun main() {
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println(peopleAges)
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
}
```
> {Fred=30, Ann=23, Barbara=42, Joe=51}
> Fred is 30, Ann is 23, Barbara is 42, Joe is 51,

### map

The `map()` function (which shouldn't be confused with a map or dictionary collection above) applies a transformation to each item in a collection. 

```
fun main() {
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println(peopleAges)
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ") )
}
```

> {Fred=30, Ann=23, Barbara=42, Joe=51}
> Fred is 30, Ann is 23, Barbara is 42, Joe is 51

* `peopleAges.map` applies a transformation to each item in `peopleAges` and creates a new collection of the transformed items
* The part in the curly braces `{}` defines the transformation to apply to each item. The transformation takes a key value pair and transforms it into a string, for example `<Fred, 31>` turns into `Fred is 31`.
* `joinToString(", ")` adds each item in the transformed collection to a string, separated by , and it knows not to add it to the last item
* all this is chained together with `.` (dot operator), like you've done with function calls and property accesses in earlier codelabs

### filter

Another common operation with collections is to find the items that match a particular condition. The `filter()` function returns the items in a collection that match, based on an expression.

```
fun main() {
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51
    println(peopleAges)
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", "))
    val filteredNames = peopleAges.filter { it.key.length < 4 }
	println(filteredNames)
}
```

> {Fred=30, Ann=23, Barbara=42, Joe=51}
> Fred is 30, Ann is 23, Barbara is 42, Joe is 51
> {Ann=23, Joe=51}

In this case, the expression gets the length of the key (a `String`) and checks if it is less than 4. Any items that match, that is, have a name with fewer than 4 characters, are added to the new collection.

The type returned when you applied the filter to a map is a new map (`LinkedHashMap`).

## Lambdas and Higher Order Functions

`peopleAges.forEach { print("${it.key} is ${it.value}") }`

There's a variable (`peopleAges`) with a function (`forEach`) being called on it. Instead of parentheses following the function name with the parameters, you see some code in curly braces `{}` following the function name. The same pattern appears in the code that uses `map` and `filter` functions above. The `forEach` function gets called on the `peopleAges` variable and uses the code in the curly braces.

It's like you wrote a small function in the curly braces, but there's no function name. This idea—a function with no name that can immediately be used as an expression—is a really useful concept called a lambda expression, or just lambda, for short.

This leads to an important topic of how you can interact with functions in a powerful way with Kotlin. You can store functions in variables and classes, pass functions as arguments, and even return functions. You can treat them like you would variables of other types like `Int` or `String`.

### Function types

To enable this type of behavior, Kotlin has something called *function types*, where you can define a specific type of function based on its input parameters and return value. It appears in the following format:

Example Function Type: `(Int) -> Int`

A function with the above function type must take in a parameter of type `Int` and return a value of type `Int`. In function type notation, the parameters are listed in parentheses (separated by commas if there are multiple parameters). Then there is an arrow `->` which is followed by the return type.

What type of function would meet this criteria? You could have a lambda expression that triples the value of an integer input, as seen below. For the syntax of a lambda expression, the parameters come first (highlighted in the red box), followed by the function arrow, and followed by the function body (highlighted in the purple box). The last expression in the lambda is the return value.

`a: Int -> a * 3`

`val triple: (Int) -> Int = { it * 3 }`

> 15

### Higher Order Functions

Now that you are starting to see the flexibility of how you can manipulate functions in Kotlin, let's talk about another really powerful idea, a higher-order function. This just means passing a function (in this case a lambda) to another function, or returning a function from another function.

It turns out that `map`, `filter`, and `forEach` functions are all examples of higher-order functions because they all took a function as a parameter. (In the lambda passed to this `filter` higher-order function, it's okay to omit the single parameter and arrow symbol, and also use the `it` parameter.)

Here's an example of a new higher-order function: `sortedWith()`.

If you want to sort a list of strings, you can use the built-in `sorted()` method or collections. However, if you wanted to sort the list by the length of the strings, you need to write some code to get the length of two strings and compare them. Kotlin lets you do this by passing a lambda to the `sortedWith()` method.

```
fun main() {
    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted())
    println(peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length })
}
```
> [Ann, Barbara, Fred, Joe]
> [Ann, Joe, Fred, Barbara]

The lambda passed to `sortedWith()` has two parameters, `str1` which is a String, and `str2` which is a String. Then you see the function arrow, followed by the function body.

Remember that the last expression in the lambda is the return value. In this case, it returns the difference between the length of the first string and the length of the second string, which is an `Int`. That matches what it is needed for sorting: if `str1` is shorter than `str2`, it will return a value less than 0. If `str1` and `str2` are the same length, it will return 0. If `str1` is longer than `str2`, it will return a value greater than 0. By doing a series of comparison between two Strings at a time, the `sortedWith()` function outputs a list where the names will be in order of increasing length.

### OnClickListener an OnKeyListener in Android

#### Long form

```
calculateButton.setOnClickListener(object: View.OnclickListener {
  override fun onClick(view: View?) {
    calculateTip()
  }
})
```

#### Short form

```
calculateButton.setOnClickListener { view -> calculateTip()}
```

Observe how the lambda has the same function type as the `onClick()` method in `OnClickListener` (takes in one `View` argument and returns `Unit`, which means no return value).

The shortened version of the code is possible because of something called **SAM (Single-Abstract-Method)** conversion in Kotlin. Kotlin converts the lambda into an `OnClickListener` object which implements the single abstract method `onClick()`. You just need to make sure the lambda function type matches the function type of the abstract function.

Since the `view` parameter is never used in the lambda, the parameter can be omitted. Then we just have the function body in the lambda.


