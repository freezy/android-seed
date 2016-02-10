# android-seed

A fresh Android project with tests already set up.


## Features

- Loads nicely in [Android Studio][android-studio]
- [Robolectric][robolectric] tests working and debuggable in IDE (for unit testing)
- [Espresso][espresso] tests working and debuggable in IDE (for functional testing)
- Latest Marshmallow compat libs ready to use
- Test coverage enabled


## Versions

- Android 23 (6.0 Marshmallow), with compatibility back to 10 (2.3.3 Gingerbread)
- Android Studio 1.5
- Gradle 2.9
- Build Tools 23.0.2
- Appcompat-v7 23.1.1


## Included libs

- [Dagger][dagger] for dependency injections
- [Butter Knife][butterknife] for view injections


## Android Studio Setup

You choose test types by switching between "Android Instrumentation Tests" and
"Unit Tests" in the "Build Variants" panel in Android Studio (usually located
on the bottom left side).

For Robolectric, choose "Unit Tests", then open a test class and right-click on
what you want to run.

For Espresso, do the same while "Android Instrumentation Tests" is selected in
the Build Variants.


### Other Boilerplates

- [nenick/android-gradle-template](https://github.com/nenick/android-gradle-template)
- [mlidal/android-gradle-test](https://github.com/mlidal/android-gradle-test)
- [fada21/android-tdd-bootstrap](https://github.com/fada21/android-tdd-bootstrap)

[android-studio]: http://tools.android.com/download/studio
[robolectric]: http://robolectric.org/
[espresso]: https://code.google.com/p/android-test-kit/wiki/Espresso
[dagger]: http://square.github.io/dagger/
[butterknife]: http://jakewharton.github.io/butterknife/
[android-studio-unit-test-plugin]: https://github.com/evant/android-studio-unit-test-plugin
[android-studio-bug]: https://code.google.com/p/android/issues/detail?id=81364
[robolectric-1424]: https://github.com/robolectric/robolectric/issues/1424
[robolectric-1446]: https://github.com/robolectric/robolectric/issues/1446
