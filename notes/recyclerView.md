# Use RecyclerView to display a scrollable list

`RecyclerView` is designed to be very efficient, even with large lists, by reusing, or recycling, the views that have scrolled off the screen. When a list item is scrolled off the screen, RecyclerView reuses that view for the next list item about to be displayed. That means, the item is filled with new content that scrolls onto the screen. This RecyclerView behavior saves a lot of processing time and helps lists scroll more smoothly.

- You can use `app > res > values > strinfs.xml` to store the calues for your list 

```
<resources>
    <string name="app_name">Affirmations</string>
    <string name="affirmation1">I am strong.</string>
    <string name="affirmation2">I believe in myself.</string>
    <string name="affirmation3">Each day is a new opportunity to grow and be a better version of myself.</string>
    <string name="affirmation4">Every challenge in my life is an opportunity to learn from.</string>
    <string name="affirmation5">I have so much to be grateful for.</string>
    <string name="affirmation6">Good things are always coming into my life.</string>
    <string name="affirmation7">New opportunities await me at every turn.</string>
    <string name="affirmation8">I have the courage to follow my heart.</string>
    <string name="affirmation9">Things will unfold at precisely the right time.</string>
    <string name="affirmation10">I will be present in all the moments that this day brings.</string>
</resources>
```

- Now that you have added string resources, you can reference them in your code as `R.string.affirmation1` or `R.string.affirmation2`.

## Create a new package

### What is a package?

- In Android Studio, in the `Project` window `(Android)`, take a look at your new project files under `app > java` for the Affirmations app. They should look similar to the screenshot below, which shows three packages, one for your code `(com.example.affirmations)`, and two for test files `(com.example.affirmations (androidTest) and com.example.affirmations (test))`.

Notice that the name of the package consists of several words separated by a period.

There are two ways in which you can make use of packages.

- Create different packages for different parts of your code. For example, developers will often separate the classes that work with data and the classes that build the UI into different packages.

- Use code from other packages in your code. In order to use the classes from other packages, you need to define them in your build system's dependencies. It's also a standard practice to import them in your code so you can use their shortened names (eg, `TextView`) instead of their fully-qualified names (eg, `android.widget.TextView`). For example, you have already used `import` statements for classes such as `sqrt` `(import kotlin.math.sqrt)` and `View (import android.view.View)`.

In the Affirmations app, in addition to importing Android and Kotlin classes, you will also organize your app into several packages. Even when you don't have a lot of classes for your app, it is a good practice to use packages to group classes by functionality.


### Naming Packages

A package name can be anything, as long as it is globally unique; no other published package anywhere can have the same name. Because there are a very large number of packages, and coming up with random unique names is hard, programmers use conventions to make it easier to create and understand package names.

- The package name is usually structured from general to specific, with each part of the name in lowercase letters and separated by a period. Important: The period is just part of the name. It does not indicate a hierarchy in code or mandate a folder structure!
- Because internet domains are globally unique, it is a convention to use a domain, usually yours or the domain of your business, as the first part of the name.
- You can choose the names of packages to indicate what's inside the package, and how packages are related to each other.
For code examples like this one, com.example followed by the name of the app is commonly used.
Here are some examples of predefined package names and their contents:

- `kotlin.math` - Mathematical functions and constants.
- `android.widget` - Views, such as `TextView`.

### Create a package

1. In Android Studio, in the Project pane, right-click `app > java > com.example.affirmations` and select `New > Package`.

2. In the `New Package` popup, notice the suggested package name prefix. The suggested first part of the package name is the name of the package you right-clicked. While package names do not create a hierarchy of packages, reusing parts of the name is used to indicate a relationship and organization of the content!

3. In the popup, append `model` to the end of the suggested package name. Developers often use model as the package name for classes that model (or represent) the data.

4. Press `Enter`. This creates a new package under the com.example.affirmations (root) package. This new package will contain any data-related classes defined in your app.

### Create the affirmation data class

1. Right-click on the `com.example.affirmations.model` package and select `New > Kotlin File/Class`.

2. In the popup, select `Class` and enter `Affirmation` as the name of the class. This creates a new file called `Affirmation.kt` in the model package.

3. Make `Affirmation` a data class by adding the `data` keyword before the class definition. This leaves you with an error, because data classes must have at least one property defined.

`Affirmation.kt`

```
package com.example.affirmations.model

data class Affirmation {
}
```

When you create an instance of `Affirmation`, you need to pass in the resource ID for the affirmation string. The resource ID is an integer.

4. Add a `val` integer parameter `stringResourceId` to the constructor of the `Affirmation` class. This gets rid of your error.

```
package com.example.affirmations.model

data class Affirmation(val stringResourceId: Int)
```
### Create a class to be a data source

Data displayed in your app may come from different sources (e.g. within your app project or from an external source that requires connecting to the internet to download data). As a result, data may not be in the exact format that you need. The rest of the app should not concern itself with where the data originates from or in what format it is originally. You can and should hide away this data preparation in a separate `Datasource` class that prepares the data for the app.

Since preparing data is a separate concern, put the`Datasource` class in a separate **data** package.

1. In Android Studio, in the `Project` window, right-click `app > java > com.example.affirmations` and select `New > Package`.

2. Enter `data` as the last part of the package name.

3. Right click on the `data` package and select `new Kotlin File/Class`.

4. Enter `Datasource` as the class name.

5. Inside the `Datasource class`, create a function called `loadAffirmations()`.

6. The `loadAffirmations()` function needs to return a list of `Affirmations`. You do this by creating a list and populating it with an `Affirmation` instance for each resource string.

7. Declare `List<Affirmation>` as the return type of the method `loadAffirmations()`.

8. In the body of `loadAffirmations()`, add a return statement.


9. After the `return` keyword, call `listOf<>()` to create a List.

10. Inside the angle brackets `<>`, specify the type of the list items as `Affirmation`. If necessary, import `com.example.affirmations.model.Affirmation`.

11. Inside the parentheses, create an `Affirmation`, passing in `R.string.affirmation1` as the resource ID as shown below.

```
package com.example.affirmations.data

import com.example.affirmations.R
import com.example.affirmations.model.Affirmation


class Datasource {

    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1),
            Affirmation(R.string.affirmation2),
            Affirmation(R.string.affirmation3),
            Affirmation(R.string.affirmation4),
            Affirmation(R.string.affirmation5),
            Affirmation(R.string.affirmation6),
            Affirmation(R.string.affirmation7),
            Affirmation(R.string.affirmation8),
            Affirmation(R.string.affirmation9),
            Affirmation(R.string.affirmation10)
        )
    }
}
```

### Display the size of the Affirmations list in a TextView

To verify that you can create a list of affirmations, you can call `loadAffirmations()` and display the size of the returned list of affirmations in the `TextView` that comes with your Empty Activity app template.

1. In `layouts/activity_main.xml`, give the `TextView` that comes with your template an `id` of `textview`.


2. In `MainActivity` in the `onCreate()` method after the existing code, get a reference to `textview`.

```
val textView: TextView = findViewById(R.id.textview)
```

3. Then add code to create and display the size of the affirmations list. Create a Datasource, call `loadAffirmations()`, get the size of the returned list, convert it to a string, and assign it as the text of textView.


```
textView.text = Datasource().loadAffirmations().size.toString()
```



