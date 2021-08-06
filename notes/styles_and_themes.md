# Styles And Themes

A style is a collection of view attributes values for a single type of widget. For example, a TextView style can specify font color, font size, and background color, to name a few. By extracting these attributes into a style, you can easily apply the style to multiple views in the layout and maintain it in a single place.

## Create Styles

- Create a new file `styles.xml` in `res > values` and select `new > values Resource file`

- The new file will have the following contents

```
<?xml version="1.0" encoding="utf-8"?>
<resources>
</resources>
```

- Create a new `TextView` style so that text appears consistent throughout the app. Define the style once in styles.xml and then you can apply it to all the TextViews in the layout. While you could define a style from scratch, you can extend from an existing TextView style from the MDC library.

- When styling a component, you should generally extend from a parent style of the widget type you are using. This is important for two reasons. First, it makes sure all important default values are set on your component, and secondly, your style will continue to inherit any future changes to that parent style.

- You can name your style anything you'd like, but there is a recommended convention. If you inherit from a parent Material style, then name your style in a parallel way by substituting MaterialComponents with your app's name (TipTime). This moves your changes into its own namespace which eliminates the possibility for future conflicts when Material Components introduces new styles. Example:

```
Your style name: Widget.TipTime.TextView Inherits from parent style: Widget.MaterialComponents.TextView
```

- Add the above to your styles.xml file in between the resources opening and closing tags.

- Set up your TextView

```
<style name="Widget.TipTime.TextView" parent="Widget.MaterialComponents.TextView">
    <item name="android:minHeight">48dp</item>
    <item name="android:gravity">center_vertical</item>
    <item name="android:textAppearance">?attr/textAppearanceBody1</item>
</style>
```

- Apply the `Widget.TipTime.TextView` style to which ever `TextView` by adding a style attribute on each `TextView` in `activity_main.xml`.

```
<TextView
    android:id="@+id/service_question"
    style="@style/Widget.TipTime.TextView"
    ... />
```

- You cannot set a `textView` in a `switchMaterial` widget so you have to create a seperate style for it

```
<style name="Widget.TipTime.CompoundButton.Switch" parent="Widget.MaterialComponents.CompoundButton.Switch">
   <item name="android:minHeight">48dp</item>
   <item name="android:gravity">center_vertical</item>
   <item name="android:textAppearance">?attr/textAppearanceBody1</item>
</style>
```

- Add the following to `res > values > themes.xml`

```
<item name="textInputStyle">@style/Widget.MaterialComponents.TextInputLayout.OutlinedBox</item>
<item name="radioButtonStyle">@style/Widget.TipTime.CompoundButton.RadioButton</item>
<item name="switchStyle">@style/Widget.TipTime.CompoundButton.Switch</item>

```


- Remember to change the dark themes too if you are using it






