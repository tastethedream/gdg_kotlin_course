# Icons

Icons are symbols that can help users understand a user interface by visually communicating the intended function. They often take inspiration from objects in the physical world that a user is expected to have experienced. Icon design often reduces the level of detail to the minimum required to be familiar to a user. For example, a pencil in the physical world is used for writing so its icon counterpart usually indicates creating, adding, or editing an item.

Sometimes icons are linked to obsolete physical world objects as is the case with the floppy disk icon. This icon is the ubiquitous indication of saving a file or database record; however, while floppy disks were popularized in the 1970s, they ceased to be common after 2000. But its continual use today speaks to how a strong visual can transcend the lifetime of its physical form.

## Representing Icons In Your App

For icons in your app, instead of providing different versions of a bitmap image for different screen densities, the recommended practice is to use vector drawables. Vector drawables are represented as XML files that store the instructions on how to create an image rather than saving the actual pixels that make up that image. Vector drawables can be scaled up or down without any loss of visual quality or increase in file size.

### Provided Icons

[list of provided icons](https://fonts.google.com/icons?selected=Material+Icons)

Icons can usually be filled, outlined, rounded, two-tone and sharp.

## Adding Icons

- Add vector drawable assets 

    - open resourve manager tab on left hand of screen
    - click the +icon and select **vector Asset**
    - asset type: `clip art`
    - clip art: `to change image, you van search at the prompt`    - rename the image 
    - click `next`
    - Accept the default directory and click `finish`


## Support older versions of Android

To make your app work on these older versions of Android (known as backwards compatibility), add the vectorDrawables element to your app's build.gradle file. This enables you to use vector drawables on versions of the platform less than API 21, versus converting to PNGs when the project is built.

- Open `app > build.gradle`
- Add the following

```
android {
  defaultConfig {
    ...
    vectorDrawables.useSupportLibrary = true
   }
   ...
}
```

- Sync gradle

## Insert The Icons

- You can use `imageViews` to display icons

```
<ImageView
        android:id="@+id/icon_cost_of_service"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:importantForAccessibility="no"
        app:srcCompat="@drawable/ic_store"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="@id/cost_of_service"
        app:layout_constraintBottom_toBottomOf="@id/cost_of_service"/>
```




