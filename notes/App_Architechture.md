# App Architecture

## Seperation Of Concerns

The separation of concerns design principle states that the app should be divided into classes, each with separate responsibilities.

### Drive UI from a model

Another important principle is that you should drive your UI from a model, preferably a persistent model. Models are components that are responsible for handling the data for an app. They're independent from the `Views` and app components in your app, so they're unaffected by the app's lifecycle and the associated concerns.

The main classes or components in Android Architecture are UI Controller (activity/fragment), `ViewModel`, `LiveData` and `Room`. These components take care of some of the complexity of the lifecycle and help you avoid lifecycle related issues. 

![viewmodel image](https://github.com/tastethedream/gdg_kotlin_course/blob/main/notes/images/viewmodel.png)

### UI controller (Activity / Fragment)

Activities and fragments are UI controllers. UI controllers control the UI by drawing views on the screen, capturing user events, and anything else related to the UI that the user interacts with. Data in the app or any decision-making logic about that data should not be in the UI controller classes.

The Android system can destroy UI controllers at any time based on certain user interactions or because of system conditions like low memory. Because these events aren't under your control, you shouldn't store any app data or state in UI controllers. Instead, the decision-making logic about the data should be added in your ViewModel.

For example, in your Unscramble app, the scrambled word, score, and word count are displayed in a fragment (UI controller). The decision-making code such as figuring out the next scrambled word, and calculations of score and word count should be in your `ViewModel`.

### ViewModel

The `ViewModel` is a model of the app data that is displayed in the views. Models are components that are responsible for handling the data for an app. They allow your app to follow the architecture principle, driving the UI from the model.

The `ViewModel` stores the app related data that isn't destroyed when activity or fragment is destroyed and recreated by the Android framework. `ViewModel` objects are automatically retained (they are not destroyed like the activity or a fragment instance) during configuration changes so that data they hold is immediately available to the next activity or fragment instance.

To implement `ViewModel` in your app, extend the `ViewModel` class, which is from the architecture components library, and store app data within that class.

## The LifeCycle of a ViewModel

The framework keeps the `ViewModel` alive as long as the scope of the activity or fragment is alive. A `ViewModel` is not destroyed if its owner is destroyed for a configuration change, such as screen rotation. The new instance of the owner reconnects to the existing ViewModel instance, as illustrated by the following diagram:

![lifecycle of a viewModel] ()
