
# Launcher Icons

An app icon is an important way to distinguish your app. It also appears in a number of places including the Home screen, All Apps screen, and the Settings app.

You may also hear the app icon referred to as a launcher icon. Launcher refers to the experience when you hit the Home button on an Android device to view and organize your apps, add widgets and shortcuts, and more.

## Explore launcher icon files

1. To see what this looks like, open up your project in Android Studio. If your app was started from a template, then you should have default launcher icons that are already provided by Android Studio.
2. In the Project window, switch to the Project view. This will show you the files in your project according to the file structure of how those files are saved on your computer.
3. Navigate to the resources directory (app > src > main > res) and expand out some of the mipmap folders. These mipmap folders are where you should put the launcher icon assets for your Android app.

`mdpi`, `hdpi`, `xhdpi`, etc.. are density qualifiers that you can append onto the name of a resource directory (like mipmap) to indicate that these are resources for devices of a certain screen density. Here's a list of density qualifiers on Android:

- `mdpi` - resources for medium-density screens (~160 dpi)
- `hdpi` - resources for high-density screens (~240 dpi)
- `xhdpi` - resources for extra-high-density screens (~320 dpi)
- `xxhdpi` - resources for extra-extra-high-density screens (~480dpi)
- `xxxhdpi` - resources for extra-extra-extra-high-density screens (~640dpi)
- `nodpi`- resources that are not meant to be scaled, regardless of the screen's pixel density
- `anydpi` - resources that scale to any density

## Adaptive Icons

### Foreground and Background Layers

As of the Android 8.0 release (API level 26), there is support for adaptive launcher icons, which allows for more flexibility and interesting visual effects when it comes to app icons. For developers, that means that your app icon is made up of two layers: a foreground and a background layer.

### Explore adaptive files

1. In **project window** look for **res > mipmap-amydpi-v26**

2. Open `ic_launcher.xml`

```
<?xml version="1.0" encoding="utf-8"?>
<adaptive-icon xmlns:android="http://schemas.android.com/apk/res/android">
    <background android:drawable="@drawable/ic_launcher_background" />
    <foreground android:drawable="@drawable/ic_launcher_foreground" />
</adaptive-icon>
```
3. The `adaptive icon` element is used to declare <background> and <foreground> by providing drawables for each.

While a vector drawable and a bitmap image both describe a graphic, there are important differences.

A bitmap image doesn't understand much about the image that it holds, except for the color information at each pixel. On the other hand, a vector graphic knows how to draw the shapes that define an image. These instructions are composed of a set of points, lines, and curves along with color information. The advantage is that a vector graphic can be scaled for any canvas size for any screen density, without losing quality.

A vector drawable is Android's implementation of vector graphics, intended to be flexible enough on mobile devices. You can define them in XML with these possible elements. Instead of providing versions of a bitmap asset for all density buckets, you only need to define the image once. Thus, reducing the size of your app and making it easier to maintain.

## Change the app icon

- Delete the existing assests from  `drawable` and `drawable-v24`

- Create a new `Image Asset` Right click `res` and choose `new > image asset`

- The **Image Asset Studio** toll opens

- Change the path to the location of your new foreground image

- Select the tab for backgroung layer and change the path

- You should be able to see the changes in the preview

When a circular mask is applied to both layers of your app icon, the result is a circular icon with a blue grid background and an Android in it (left image above). Alternatively, you could apply a square mask to produce the app icon in the above right.

Having two layers also allows for interesting visual effects because the two layers can move independently or be scaled. For some fun examples of how the visual effects can look, check out this blogpost under Design Considerations. Because you can't tell in advance what device your user will have or what mask the OEM will apply onto your icon, you need to set up your adaptive icon so important information doesn't get cut off.

When a circular mask is applied to both layers of your app icon, the result is a circular icon with a blue grid background and an Android in it (left image above). Alternatively, you could apply a square mask to produce the app icon in the above right.

- Click `next`

- Confirm the icon path. The defaults are fine do select `finish`

### Move the new drawables to a -v26 directory

Depending on the min SDK of your app, you may notice that the foreground asset is located in the drawable-v24 folder, while the background asset is in the drawable folder. The reason is because the foreground asset contains a gradient, which was available starting in the Android 7.0 release (also known as API version 24, hence the -v24 resource qualifier). The background asset doesn't contain a gradient, so that can go in the base drawable folder.

Instead of having the foreground and background assets in two separate drawable folders, move both vector drawable files into a -v26 resource directory. Since these assets are only used for adaptive icons, these two drawables are only needed on API 26 and above. This folder structure will make it easier to find and manage your adaptive icon files.

- Create new directory `drawable-anydpi_v26`. Right click `res`select `new > android resource`

- New Resource Directory dialog will appear. Select these options:
Directory name: drawable-anydpi-v26

Resource type: drawable (Select from dropdown)

Source set: main (leave default value as-is)

- Click `ok`

- Drag the new foreground and background files into the new directory

- Delete the now unused drawable and drawable-v24 directories

- Check the icon looks right on your device or emulator


