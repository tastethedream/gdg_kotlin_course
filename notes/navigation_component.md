# Introduction To Navigation Component

## Fragments


A fragment is a reusable piece of UI; fragments can be reused and embedded in one or more activities. In the above screenshot, tapping on a tab doesn't trigger an intent to display the next screen. Instead, switching tabs simply swaps out the previous fragment with another fragment. All of this happens without launching another activity.

You can even show multiple fragments at once on a single screen, such as a master-detail layout for tablet devices. In the example below, both the navigation UI on the left and the content on the right can each be contained in a separate fragmen. Both fragments exist simultaneously in the same activity.

## Fragment Lifecycle

Like activities, fragments can be initialized and removed from memory, and throughout their existence, appear, disappear, and reappear onscreen. Also, just like activities, fragments have a lifecycle with several states, and provide several methods you can override to respond to transitions between them. The fragment lifecycle has five states, represented by the Lifecycle.State enum.

* INITIALIZED: A new instance of the fragment has been instantiated.
* CREATED: The first fragment lifecycle methods are called. During this state, the view associated with the fragment is also created.
* STARTED: The fragment is visible onscreen but does not have "focus", meaning it can't respond to user input.
* RESUMED: The fragment is visible and has focus.
* DESTROYED: The fragment object has been de-instantiated.

 * onCreate(): The fragment has been instantiated and is in the CREATED state. However, it's corresponding view has not been created yet.
* onCreateView(): This method is where you inflate the layout. The fragment has entered the CREATED state.
* onViewCreated(): This is called after the view is created. In this method, you would typically bind specific views to properties by calling findViewById().
* onStart(): The fragment has entered the STARTED state.
* onResume(): The fragment has entered the RESUMED state and now has focus (can respond to user input).
* onPause(): The fragment has re-entered the STARTED state. The UI is visible to the user
* onStop(): The fragment has re-entered the CREATED state. The object is instantiated but is no longer presented on screen.
* onDestroyView(): Called right before the fragment enters the DESTROYED state. The view has already been removed from memory, but the fragment object still exists.
* onDestroy(): The fragment enters the DESTROYED state.


The lifecycle states and callback methods are quite similar to those used for activities. However, keep in mind the difference with the `onCreate()` method. With activities, you would use this method to inflate the layout and bind views. However, in the fragment lifecycle, `onCreate()` is called **before** the view is created, so you can't inflate the layout here. Instead, you do this in `onCreateView()`. Then, after the view has been created, the `onViewCreated()` method is called, where you can then bind properties to specific views.

While that probably sounded like a lot of theory, you now know the basics of how fragments work, and how they're similar and different to activities. For the remainder of this codelab, you'll put that knowledge to work. First, you'll migrate the Words app you worked on previously to use a fragment based layout. Then, you'll implement navigation between fragments within a single activity.

## Jetpack Navigation Component

Android Jetpack provides the Navigation component to help you handle any navigation implementation, simple or complex, in your app. The Navigation component has three key parts which you'll use to implement navigation in the Words app.

* **Navigation Graph**: The navigation graph is an XML file that provides a visual representation of navigation in your app. The file consists of destinations which correspond to individual activities and fragments as well as actions between them which can be used in code to navigate from one destination to another. Just like with layout files, Android Studio provides a visual editor to add destinations and actions to the navigation graph.
* **NavHost**: A `NavHost` is used to display destinations form a navigation graph within an activity. When you navigate between fragments, the destination shown in the `NavHost` is updated. You'll use a built-in implementation, called `NavHostFragment`, in your `MainActivity`.
* **NavController**: The NavController object lets you control the navigation between destinations displayed in the `NavHost`. When working with intents, you had to call startActivity to navigate to a new screen. With the Navigation component, you can call the NavController's `navigate()` method to swap the fragment that's displayed. The NavController also helps you handle common tasks like responding to the system "up" button to navigate back to the previously displayed fragment.

## Using The Navigation Graph 

The Navigation Graph (or NavGraph for short) is a virtual mapping of your app's navigation. Each screen, or fragment in your case, becomes a possible "destination" that can be navigated to. A NavGraph can be represented by an XML file showing how each destination relates to one another.

Behind the scenes, this actually creates a new instance of the `NavGraph` class. However, destinations from the navigation graph are displayed to the user by the `FragmentContainerView`. All you need to do is to create an XML file and define the possible destinations. Then you can use the generated code to navigate between fragments.


