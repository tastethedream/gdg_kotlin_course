# Intents

An *intent* is an object representing some action to be performed. The most common, but certainly not only, use for an intent is to **launch an activity**. There are two types of intents—**implicit** and **explicit**. An **explicit intent** is highly specific, where you know the exact activity to be launched, often a screen in your own app.

An **implicit intent** is a bit more abstract, where you tell the system the type of action, such as opening a link, composing an email, or making a phone call, and the system is responsible for figuring out how to fulfill the request. You've probably seen both kinds of intents in action without knowing it. Generally, when showing an activity in your own app, you use an explicit intent.

You use an explicit intent for actions or presenting screens in your own app and are responsible for the entire process. You commonly use implicit intents for performing actions involving other apps and rely on the system to determine the end result.

![intents diagram](https://github.com/tastethedream/gdg_kotlin_course/blob/main/notes/images/intent.png)

## What is an extra?


`intent.putExtra("letter", holder.button.text.toString())`

What's an extra? Remember that an intent is simply a set of instructions—there's no instance of the destination activity just yet. Instead, an extra is a piece of data, such as a number or string, that is given a name to be retrieved later. This is similar to passing an argument when you call a function. Because a `DetailActivity` can be shown for any letter, you need to tell it which letter to present.

Also, why do you think it's necessary to call `toString()`? The button's text is already a string, right?

Sort of. It's actually of type `CharSequence`, which is something called an interface. You don't need to know anything about Kotlin interfaces for now, other than it's a way to ensure a type, such as String, implements specific functions and properties. You can think of a CharSequence as a more generic representation of a string-like class. A button's text property could be a string, or it could be any object that is also a CharSequence. The `putExtra()` method, however, accepts a String, not just any CharSequence, hence the need to call `toString()`.


## Set Up Explicit Intent
```
    /**
     * Replaces the content of an existing view with new data
     */
    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text = item.toString()
        holder.button.setOnClickListener {
            val context = holder.view.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("letter", holder.button.text.toString())
            context.startActivity(intent)

        }
    }

```



This code will allow the navigation to a generic screen 

## Set Up DetailActivity

`val letterId = intent?.extras?.getString("letter").toString()`

First, where does the `intent` property come from? It's not a property of `DetailActivity`, but rather, a property of any activity. It keeps a reference to the intent used to launch the activity.

The extras property is of type `Bundle`, and as you might have guessed, provides a way to access all extras passed into the intent.

Both of these properties are marked with a question mark. Why is this? The reason is that the `intent` and `extras` properties are nullable, meaning they may or may not have a value. Sometimes you may want a variable to be `null`. The intent property might not actually be an Intent (if the activity wasn't launched from an intent) and the extras property might not actually be a `Bundle`, but rather a value called `null`. In Kotlin, null means the absence of a value. The object may exist or it may be null. If your app tries to access a property or call a function on a null object, the app will crash.To safely access this value, you put a `?` after the name. If intent is null, your app won't even attempt to access the extras property, and if extras is null, your code won't even attempt to call `getString()`.

## Companion Objects

 A `companion object` is similar to other objects, such as instances of a class. However, only a single instance of a companion object will exist for the duration of your program, which is why this is sometimes called the `singleton pattern`. While there are numerous use cases for singletons beyond the scope of this codelab, for now, you'll use a companion object as a way to organize constants and make them accessible outside of the `DetailActivity`. 

```
   companion object {
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }
```
## Set Up Implicit Intent

`ACTION_VIEW` is a generic intent that takes a `URI`, in your case, a web address. The system then knows to process this intent by opening the URI in the user's web browser. Some other intent types include:

* CATEGORY_APP_MAPS – launching the maps app
* CATEGORY_APP_EMAIL – launching the email app
* CATEGORY_APP_GALLERY – launching the gallery (photos) app
* ACTION_SET_ALARM – setting an alarm in the background
* ACTION_DIAL – initiating a phone call

```
   // Assigns a [OnClickListener] to the button contained in the [ViewHolder]
        holder.button.setOnClickListener {
            val queryUrl: Uri = Uri.parse("${DetailActivity.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            context.startActivity(intent)
        }
```


