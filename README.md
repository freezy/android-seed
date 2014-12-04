# android-seed

A fresh Android project with tests already set up.


## Features

- Loads nicely in [Android Studio][android-studio]
- [Robolectric][robolectric] tests working and debuggable in IDE (for unit testing)
- [Espresso][espresso] tests working and debuggable in IDE (for functional testing)
- Latest Lollipop compat libs ready to use
- Test coverage enabled


## Versions

- Android 21 (5.0 Lollipop), with compatiblity back to 10 (2.3.3 Gingerbread)
- Android Studio 1.0-RC2
- Gradle 2.2


## Included libs

- [Dagger][dagger] for dependency injections
- [Butter Knife][butterknife] for view injections


## Notes

Obviously stuff doesn't work out of the box (hence this project). Explanations
see below.

### Robolectric

Since Robolectric is not part of the official tool chain, a Gradle plugin is
needed in order to make it part of the build. There are several:

- [robolectric/robolectric-gradle-plugin](https://github.com/robolectric/robolectric-gradle-plugin) -
  A plugin by the Robolectric team.
- [novoda/gradle-android-test-plugin](https://github.com/novoda/gradle-android-test-plugin)
- **[JCAndKSolutions/android-unit-test](https://github.com/JCAndKSolutions/android-unit-test)** -
  The one used by this seed.

The [problem](https://github.com/robolectric/robolectric-gradle-plugin/issues/107)
with the offical plugin is that it uses the existing `androidTest` source
folder, which makes separation between unit tests and functional tests
impossible. The last plugin has the advantage of [better Android Studio
Integration](https://github.com/evant/android-studio-unit-test-plugin) as well.

However, [a bug in Android Studio RC2](https://code.google.com/p/android/issues/detail?id=81364)
results in tests sources not being marked as such anymore (fixed in RC3).

### Espresso

The Espresso stack has a few advantages over other tools (Robotium, Selendroid, UIAutomator...),
namely:

- Gradle support
- Android Studio support
- Works well with [Spoon](http://square.github.io/spoon/)
- Fluent API
- Well synchronized with app's UI thread (no `Thread.sleep()` necessary)

Currently, Espresso needs to be patched to [work well with Lollipop](https://code.google.com/p/android-test-kit/issues/detail?id=84).
For this reason, the Espresso reference points to my [patched version](https://github.com/freezy/double-espresso).


## References

- [almozavr/deckard-gradle](https://github.com/almozavr/deckard-gradle) (a fork
  from robolectric/deckard-gradle) - Main inspiration for this project. This
  fork replaced the official `robolectric-gradle-plugin` by `android-unit-test`
  from *JCAndKSolutions*.

### Other Boilerplates

- [nenick/android-gradle-template](https://github.com/nenick/android-gradle-template)
- [mlidal/android-gradle-test](https://github.com/mlidal/android-gradle-test)
- [fada21/android-tdd-bootstrap](https://github.com/fada21/android-tdd-bootstrap)

[android-studio]: http://tools.android.com/download/studio/canary/latest
[robolectric]: http://robolectric.org/
[espresso]: https://code.google.com/p/android-test-kit/wiki/Espresso
[dagger]: http://square.github.io/dagger/
[butterknife]: http://jakewharton.github.io/butterknife/