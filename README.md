Storage Chooser
===================


A pretty and simple storage/directory chooser library for 4.4+ devices. This library was created to be included in [OpenGApps App](https://play.google.com/store/apps/details?id=org.opengapps.app). There are too many storage chooser out there but this one is too materially :stuck_out_tongue: . Easy to implement and does not take a lot of your valueable time in setting-up all the other necessary things that every developer seeks, like 

- saving path to sharedPreference
- event when path is selected and act upon that path
- and much more.

There is also some really nice features that I thought would come in handy:

- You show a quick overview of the storages present and their memory available before choosing so that users know which storage to choose.
- you can choose between _sheet and sleek_ layouts.
- Inline create folder view _(not another dialog to handle)_
- Full localization. I mean literally every strings can be localized to your desired language.
- and more will be added soon.

**TODO**:

- Implement memory thresholding - a restriction or a toast that it shows when user's memory is less than your defined memory for operations.
- File picker - storage - **chooser** I think file picker is necessary now.

----------

Preview
-------------

![SC Features](http://i.imgur.com/nmqPJok.gif)

----------

Installation
-------------

Add this to your root build.gradle file under repositories:

    allprojects {
		repositories {
			maven { url "https://jitpack.io" }
		}
	}

Add this to your app level build.gradle as dependency:

    com.github.codekidX:storage-chooser:1.0.20

----------
Notes
-------------

Before you implement this library here are some notes that you can follow to avoid errors.

> **Confirm:**

> - You have asked for **Runtime Permission** from the user in the past to avoid read errors.
> - Permissions with "READ_EXTERNAL_STORAGE" and "WRITE_EXTERNAL_STORAGE" is enough for this library to work.
> - This library follows same color scheme as that of the parent app to maintain the aesthetic of the parent app. _See the color scheme section below_

----------

 Implementation
-------------

### Simple Type

- Let's you toggle between inernal/external root directory.

```
// ~

// Initialize Builder
StorageChooser chooser = new StorageChooser.Builder()
.withActivity(MainActivity.this)
.withFragmentManager(getSupportFragmentManager())
.withMemoryBar(true) 
.build();

// Show dialog whenever you want by
chooser.show();

// get path that the user has chosen
chooser.setOnSelectListener(new StorageChooser.OnSelectListener() {
    @Override
    public void onSelect(String path) {
        Log.e("SELECTED_PATH", path);
    }
});
```

> OUTPUT: **/storage/emulated/0**

### Pre-defined Type

- Let's you append a specific path to the root of internal or external directory.

```
// --- ADD --
.withPredefinedPath(STATIC_PATH)
```

> 
> A pre-defined path gets appended after the selection of internal/external root directory. 
> OUTPUT: **/storage/emulated/0/Downloads/CodekidLabs**

### Custom Type

- Let's user choose their own directory of their liking

```
// --- ADD ---
.allowCustomPath(true)
```

### Save directly to preference

```
// --- ADD ---
.actionSave(true)
.withPreference(sharedPreferences)
```

### Get path from preference

```
String path = sharedPreferences.getString(DiskUtil.SC_PREFERENCE_KEY,"");
```

## Localization

A seperate localization wiki is posted [here](https://github.com/codekidX/storage-chooser/wiki/Localizing-your-Chooser)


## Color Scheme

> - Overview header color ->  @colorPrimary
> - Memory bar color -> @colorAccent
> - Memory available text -> @colorPrimaryDark
> - Address bar background -> @colorPrimary
> - Select button label color -> @colorPrimaryDark

LICENSE
-------------

This project is licensed with the Mozilla Public License v2.

In practice, you can use this library as-is, with a notification of it being used. If you make any changes, you are required to publish your changes under a compatible license.


### Support Storage Chooser

This is a community based project so help fixing bugs by adding your fixes to it by clicking [Create pull request](https://github.com/codekidX/storage-chooser/pull/new/master)
