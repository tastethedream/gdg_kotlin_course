# Enhance The User Experience

## Rotating the device

If rotating the screen causes any display issues you can wrap `constraintLayout` with a `scrollView`

```
<ScrollView
   xmlns:android="http://schemas.android.com/apk/res/android"
   xmlns:app="http://schemas.android.com/apk/res-auto"
   xmlns:tools="http://schemas.android.com/tools"
   android:layout_height="match_parent"
   android:layout_width="match_parent">

   <androidx.constraintlayout.widget.ConstraintLayout
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:padding="16dp"
       tools:context=".MainActivity">

       ...
   </ConstraintLayout>

</ScrollView>
```

## Hide keyboard on enter key

- Add the folowing in `mainActivity` before the closing brace 

```
private fun handleKeyEvent(view: View, keyCode: Int): Boolean {
   if (keyCode == KeyEvent.KEYCODE_ENTER) {
       // Hide the keyboard
       val inputMethodManager =
           getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
       inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
       return true
   }
   return false
}
```
 
 - Add a listener to the `onCreate()` 

 ```
 override fun onCreate(savedInstanceState: Bundle?) {
   ...

   setContentView(binding.root)

   binding.calculateButton.setOnClickListener { calculateTip() }

   binding.costOfServiceEditText.setOnKeyListener { view, keyCode, _ -> handleKeyEvent(view, keyCode)
   }
}
```

## Using Talkback

TalkBack is the Google screen reader included on Android devices. TalkBack gives you spoken feedback so that you can use your device without looking at the screen.

With Talkback enabled, ensure that a user can complete the use case of calculating tip within your app.

1. Enable Talkback on your device by following these instructions.[acessibilty instructions](https://support.google.com/accessibility/android/answer/6007100)
2. Return to the Tip Time app.
3. Explore your app with Talkback using these instructions. Swipe right to navigate through screen elements in sequence, and swipe left to go in the opposite direction. Double-tap anywhere to select. Verify that you can reach all elements of your app with swipe gestures.
4. Ensure that a Talkback user is able to navigate to each item on the screen, enter in a cost of service, change the tip options, calculate the tip, and hear the tip announced. Remember that no spoken feedback is provided for the icons since you marked those as importantForAccessibility="no" .


## Adjust the tint of vector drawables

one of the advantages of `VectorDrawables` versus bitmap images is the ability to scale and tint them. Below we have the XML representing the bell icon. There are two specific color attributes to take notice of: `android:tint` and `android:fillColor`.

- In `ic_service.xml`

```
<vector xmlns:android="http://schemas.android.com/apk/res/android"
   android:width="24dp"
   android:height="24dp"
   android:viewportWidth="24"
   android:viewportHeight="24"
   android:tint="?attr/colorControlNormal">
 <path
     android:fillColor="@android:color/white"
     android:pathData="M2,17h20v2L2,19zM13.84,7.79c0.1,-0.24 0.16,-0.51 0.16,-0.79 0,-1.1 -0.9,-2 -2,-2s-2,0.9 -2,2c0,0.28 0.06,0.55 0.16,0.79C6.25,8.6 3.27,11.93 3,16h18c-0.27,-4.07 -3.25,-7.4 -7.16,-8.21z"/>
</vector>
```

If there is a tint present, it will override any fillColor directives for the drawable. In this case, the white color is overridden with the colorControlNormal theme attribute. colorControlNormal is the color of the "normal" (unselected/unactivated state) of a widget. Currently that's a gray color.

One visual enhancement we can make to the app is to tint the drawable based on the primary color of the app theme. For light theme, the icon will appear as @color/green, whereas in dark theme, the icon will appear as @color/green_light, which is the ?attr/colorPrimary. Tinting the drawable based on the primary color of the app theme can make the elements in the layout appear more unified and cohesive. This also saves us from having to duplicate the set of icons for light theme and dark theme. There's only 1 set of vector drawables, and the tint will change based on the colorPrimary theme attribute.

1. Change the value of the `android:tint` attribute in `ic_service.xml`

`android:tint="?attr/colorPrimary"`

2.Repeat the same for changing the tint on the other vector drawables.

`ic_store.xml` and `ic_round_up.xml`

3. Run app to test


