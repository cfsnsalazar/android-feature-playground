# Android Feature Playground
## A modular repository to be a boilerplate to common features in many projects

### UI Based on [Material Design System by Google](https://material.io/) and App templates from [Material UI Kit](https://materialdesignkit.com/templates/)

### Features:
- Dynamic Feature App Configuration
- Components
  - [ ] xx
- Authentication
  - [ ] Simple SignIn Screen /w Social (Optional)
  - [ ] Simple SignUp Screen /w Social (Optional)
  - [ ] Forgot Password Screen
  - [ ] Enter Code Screen
  - [ ] Biometric Authentication (Biometric Offer & Validation)
  - [ ] Receive Data on SMS Detector
- List Data (Todo List Example)
  - [ ] Swipe Refresh Layout / Push to refresh 
  - [ ] Infinite/Endless Scroll
  - [ ] Search by Text
  - [ ] Filter by Attribute
  - [ ] Swipe Right/Left Item List 
- Geolocation
  - [ ] Tracing Route between two points
- Analytics
  - [ ] Google Analytics
  - [ ] Firebase Analytics
  - [ ] Adjust
- Libraries
  - [ ] Biometric Reader
  - [ ] QRCode Reader
  - [ ] QRCode Screen
  - [ ] Document Scanner
- Quality
  - [ ] tests
  - [ ] detekt
  - [ ] ktlint
  - [ ] sonar
  - [ ] Firebase distribution to homologation
  - [ ] CI/CD using Github Actions
  - [ ] Android Studio Code Styleguide
  - [ ] Accessibility Support

### The Project 

- Using [Kotlin Programming Language](https://kotlinlang.org/)
- Using [Model-View-ViewModel - MVVM](https://www.toptal.com/android/android-apps-mvvm-with-clean-architecture) Architecture 
- Communications between View <-> ViewModel are made using LiveData.
- Avoiding lost data when configurations changes. 
- Continuos Integration using [Github Actions](https://github.com/features/actions)
- Continuos Delivery of Sample App using [Firebase App Distrition](https://firebase.google.com/docs/app-distribution)

#### Third-party Libraries
- [Android Support Library](https://developer.android.com/topic/libraries/support-library/index.html): Library for basic project structure and compatibility, used in almost any Android Project.
- [Material Design for Android](https://developer.android.com/guide/topics/ui/look-and-feel?hl=pt-BR)
- [Glide](https://github.com/bumptech/glide) library to download and cache images.
- [Retrofit](https://square.github.io/retrofit/) library to create interfaces with MarvelApi.
- [Gson](https://github.com/google/gson) library to make TMDB Api json response parse.
- [RxJava](https://github.com/ReactiveX/RxJava) and [RxAndroid](https://github.com/ReactiveX/RxAndroid): Allows the use of [reactive extensions](http://reactivex.io/) in Android applications, allowing simplified multitasking but also powerful observable chains.
- [Okhttp](https://github.com/square/okhttp) An HTTP+HTTP/2 client for Android , used to intercept requests, manage responses, create a mock web server and more .
- [junit](https://junit.org/junit5/) To create unit tests 
- [Espresso](https://developer.android.com/training/testing/espresso) To create integration tests  
- [Mockito](https://github.com/mockito/mockito) library to mock classes on tests.

### Tools and Build

This project was built using Android Studio 3.4. To edit this project, is recomended to use the *Import Project* from Android Studio.
The application can also be built using command line. In a machine with Java 8 or newer installed and configured, checkout the root project and run `./gradlew assembleDebug`. The resulting APK can be found in `project/app/build/outputs/apk/prod/debug/app-prod-debug.apk`.

#### Build variants
Use the Android Studio *Build Variants* button to choose between **prodDebug** or **prodRelease** flavors to use project consuming the real api .

If you wish run tests should choose **mockdebug** build variant . 


## Screens of Features

### Authentication

 Sign In                   |                 
:-------------------------:|
<img src="gifs/listing_movies.gif" width="180" height="320">  |




© Denis Vieira Rufino
