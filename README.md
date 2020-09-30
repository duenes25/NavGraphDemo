# NavGraphDemo

## Simple application that demonstrates use of Navigation Graph

## This app is also using Hybrid solution of JetPack Compose. 
### Note: Once you have integrated Compose...You dont need to convert all your UI immediately.  You can choose to convert only some UI elements, or only new UI development will be in compose, or go back and rewrite all your UI in Compose

### Here are the steps to convert a regular kotlin app to JetPack Compose

1. You will need the latest Canary version of Android Studio As of 09/30/2020 this its still in Alhpa

2. Ensure you are using DataBinding for your Activities/Fragments
example:  
    val binding = DataBindingUtil.inflate<FragmentBookSearchBinding>(
        inflater, R.layout.fragment_book_search, container, false
    )

3. Ensure you are using at least kotlin version 1.4.0 

4. configure your app/build gradle

kotlinOptions {
    jvmTarget = '1.8'
    useIR = true
}

buildFeatures {
    ...
    compose true
}
composeOptions {
    kotlinCompilerVersion rootProject.kotlinVersion
    kotlinCompilerExtensionVersion rootProject.composeVersion
}

dependencies {
    ...
    // Compose
    implementation "androidx.compose.runtime:runtime:$rootProject.composeVersion"
    implementation "androidx.compose.ui:ui:$rootProject.composeVersion"
    implementation "androidx.compose.foundation:foundation:$rootProject.composeVersion"
    implementation "androidx.compose.foundation:foundation-layout:$rootProject.composeVersion"
    implementation "androidx.compose.material:material:$rootProject.composeVersion"
    implementation "androidx.compose.runtime:runtime-livedata:$rootProject.composeVersion"
    implementation "androidx.ui:ui-tooling:$rootProject.composeVersion"
    implementation "com.google.android.material:compose-theme-adapter:$rootProject.composeVersion"
    ...
}


5. In your existing layout.xml file ensure it is wrapped in a layout segment like so
<layout xmlns:android="http://schemas.android.com/apk/res/android">
...
</layout>

6. Then in that same layout.xml file remove any UI elements you want to migrate such as 
<Button
    android:id="@+id/detailsButton"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="@string/book_details"
/>


7. Add a ComposeView element into that layout.xml. like so.. This is where your elements will appear
<androidx.compose.ui.platform.ComposeView
    android:id="@+id/compose_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent"/>

8. Add a new Description Class that will include all the Compose UI components.
Example:
BookSearchDescription.kt ->
@Composable
fun BookSearchDescription(onNavClick: () -> Unit) {
    bookSearchContent(onNavClick)
}

9. In your Kotlin Activity/Fragment class, after your View Binding you will Set the content for your Compose View and leverage the Description class by adding the following. (Passing a lambda for onclick )

.apply {
    composeView.setContent {
        MaterialTheme {
            BookSearchDescription(onNavClick = {onNavClick()})
        }
    }
}

10.  Rinse n repeat as needed
