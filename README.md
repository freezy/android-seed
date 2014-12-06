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
- Android Studio 1.0-RC4
- Gradle 2.2


## Included libs

- [Dagger][dagger] for dependency injections
- [Butter Knife][butterknife] for view injections


## Android Studio Setup

1. Open *Settings*, *Plugins*, *Browse Repositories* and install *Android Studio Unit Test*
2. Import the project as a Gradle project. This can take a while. Specially downloading 30 megs of
   Gradle binaries usually takes 30 minutes (Gradle, CDN, please!). Once that's done, it downloads
   all the deps on first run. This is usually faster.
3. Open *Run Configurations*, click on *Defaults*, *Android Tests* and put `com.google.android.apps.common.testing.testrunner.GoogleInstrumentationTestRunner`
   as the instrumentation runner (pro tip: click browse and type *GITR*). This makes Android Studio
   use the Espresso runner instead of the default one.
4. For the Robolectric tests, create a new **JUnit** configuration, name it *Robolectric* and put the
   following:

   - Test kind: *All in package*
   - Package: `com.example.tests.unit`
   - Search for tests: *In single module*
   - Working directory: `$MODULE_DIR$`

   Also create a new *Gradle Configuration* that runs `testDebug` and reference it under the *Before
   launch* section (also a `testClasses` is automatically added by the Android Studio plugin, but it
   only compiles test classes and not the resources).

You should now be able to run tests by right-clicking on the test method. Be sure to choose JUnit
for the Robolectric tests and Android test for the instrumentation tests. You can also run the tests
from the console.

For Robolectric/unit tests, type:

	./gradlew test

For Espresso/instrumentation tests, type (at least one device/emulator should be connected via ADB):

	./gradlew connectedAndroidTest

### Notes

- Make sure you use Java 1.7 (x64), and that your `JAVA_HOME` is set to that folder. I had problems
  with Java 8.
- If Android Studio doesn't put your Robolectric tests on a greenish background in the project view,
  that means it didn't recognize it as test source and you can't select the right package when
  creating the JUnit run configuration. This can happen if:

    - You didn't install the [plugin][android-studio-unit-test-plugin] mentioned above.
    - You're using Android Studio RC2 which has [this bug][android-studio-bug].
    - You haven't run any Gradle build yet. Open the Gradle panel and click on the refresh icon.

- Also if it complains about JUnit 3.8, that means that the class path is screwed up (JUnit 4.11
  should have come first), something the plugin above is supposed to take care of.
- If you're getting an exception about your test class not being found, verify it's a Robolectric
  tests class and not an Espresso test. Fix the package of the JUnit run configuration if that's the
  case.
- There's no need for an additional `testClasses` pre-launch when running Robolectric tests, that's
  already configured in the Gradle file.

## Tests

Obviously stuff didn't work out of the box (hence this project). Explanations see below.

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
Integration][android-studio-unit-test-plugin] as well.

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
[android-studio-unit-test-plugin]: https://github.com/evant/android-studio-unit-test-plugin
[android-studio-bug]: https://code.google.com/p/android/issues/detail?id=81364