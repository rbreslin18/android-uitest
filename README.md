## Android UI tests - Example Application

This is a **Android** example app to study purposes about UI instrumentation tests, using [Espresso](https://developer.android.com/training/testing/ui-testing/espresso-testing.html) framework.

For this example, we are using the **Login Activity** Android Studio template

 **_Screenshot_**

![First Screen](https://raw.githubusercontent.com/mfdeveloper/android-uitest/master/images/android-test-screen.png)

### Getting Started

1. Clone this repo
2. With **Android Studio**, click on `File` => `Open` and select the cloned folder
3. Open the class **`LoginBehaviorTest`** and click on green arrow beside of the method `performAuth_sameActivity()`

   Or, right-click on the test class in the projects panel, and select `Run`.
   > **Obs:** More explanation about running tests, see this link: [Running Espresso tests](http://www.vogella.com/tutorials/AndroidTestingEspresso/article.html#espresso_runningespressotests)

4. Choice a avd emulator. The UI test will run like the screen below:

![Login UI Test](https://raw.githubusercontent.com/mfdeveloper/android-uitest/master/images/android-uitest-login.gif)

### Links: tutorials and questions

The refence links below contains tutorials and helpers about Android testing.

##### Google (official documentation)

* [Testing UI for a Single App](https://developer.android.com/training/testing/ui-testing/espresso-testing.html#build)
* [Testing Support Library **(AndroidJUnitRunner, UI Automator)**](https://developer.android.com/topic/libraries/testing-support-library/index.html)
* [Espresso - google.github.io](https://google.github.io/android-testing-support-library/docs/espresso/index.html)

##### Questions - Errors, Exceptions and Doubts

* [Cannot resolve symbol 'AndroidJUnit4'](http://stackoverflow.com/questions/30603487/cannot-resolve-symbol-androidjunit4)
* [Conflict with dependency 'support-annotations'](http://stackoverflow.com/questions/33317555/conflict-with-dependency-com-android-supportsupport-annotations-resolved-ver)
* [Cannot launch AVD in emulator. Output: **sh: 1: glxinfo**](http://stackoverflow.com/questions/36258908/cannot-launch-avd-in-emulator-output-sh-1-glxinfo)
* [**AssertionFailedError:** No tests found](http://stackoverflow.com/questions/31868008/getting-junit-framework-assertionfailederror-no-tests-found-in-package-when-u)
* [Espresso test that your Activity finishes with the expected result.](https://gist.github.com/saxophone/961ceceea43f8501cbaf)

##### Tutorials
* [Android user interface testing with Espresso - Tutorial](http://www.vogella.com/tutorials/AndroidTestingEspresso/article.html)