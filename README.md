AndroidSampleCodingProject

Description:

AndroidSampleCodingProject is a sample Android application that demonstrates modern Android development practices and patterns, such as MVVVM architecture, Jetpack Compose, Hilt for dependency injection, coroutines, and more. The app showcases how to fetch, display, and manage data effectively with a clean architecture approach.

Features

* Jetpack Compose for modern UI components

* Hilt for Dependency Injection

* Coroutines for managing background tasks

* Unit Testing and UI Testing coverage for critical features

* Navigation using NavGraph for seamless screen transitions

Prerequisites

Before running the project, ensure you have the following installed:

Android Studio (latest stable version)

JDK 11 or higher

Internet connection for dependencies (if not already cached)

Getting Started

To get started with this project, clone the repository and open it in Android Studio.

Clone the repository:

bash Copy code

git clone https://github.com/cjsaranya/AndroidSampleCodingProject.git

Open in Android Studio:

Open Android Studio.

Select Open an existing project.

Navigate to the folder where you cloned the repository and select it.

Sync the Project:

After opening the project in Android Studio, make sure you sync the project with Gradle by clicking on the Sync Now button that appears at the top of the IDE.

Run the App:

To run the app, follow these steps:

Connect an Android device or start an Android emulator.

Click on the Run button in Android Studio or use the shortcut Shift + F10 to launch the app.

Folder Structure

markdown

Copy code
- app/
    - src/
        - main/
            - java/com/example/codingtestsample/
                - data/
                    - RemoteDataSource.kt
                    - ItemRepository.kt
                - domain/
                    - Item.kt
                - presentation/
                    - ui/
                        - ItemListScreen.kt
                        - ItemDetailsScreen.kt
                        - SplashScreen.kt
                    - viewmodel/
                        - ItemListViewModel.kt
                        - ItemDetailsViewModel.kt
                        - SplashViewModel.kt
                    - intents/
                        - ItemDetailsIntent.kt
                        - SplashIntent.kt
                    - state/
                        - ItemDetailsState.kt
                        - SplashState.kt
                - di/
                    - AppModule.kt
            - res/
                - layout/
                - drawable/
                - values/
                - mipmap/
        - test/
            - java/com/example/codingtestsample/
                - viewmodel/
                    - ItemListViewModelTest.kt
                    - ItemDetailsViewModelTest.kt
                - data/
                    - ItemRepositoryTest.kt
Dependencies

Jetpack Compose for UI development.

Hilt for dependency injection.

Kotlin Coroutines for managing background tasks.

Mockk and JUnit for unit testing.

Turbine for testing flows.

Dependencies are defined in the build.gradle files.

Usage

The app has the following key features and screens:


Splash Screen: The initial screen that appears when the app starts, followed by a timeout before navigating to the next screen.

Item List Screen: Displays a list of items fetched from a remote data source.

Item Details Screen: Displays details of a selected item.

Navigation

The app uses Jetpack Navigation Component (via NavGraph) to manage screen transitions:


Splash Screen → Item List Screen

Item List Screen → Item Details Screen

ViewModel & MVI Architecture

ViewModel manages UI-related data in a lifecycle-conscious way.

MVVM is implemented to handle the flow of data through three main components:
Model: Represents the data layer and state.
View: Represents the UI.
ViewModel: Represents user actions and triggers.

Data Flow

The ItemListViewModel fetches a list of items from the repository and updates the UI with the fetched items.
The ItemDetailsViewModel fetches the details of a single item when the user selects an item from the list.

Testing

Unit tests and UI tests are written using JUnit, Mockk, and Turbine.

Running Unit Tests:

To run the unit tests, follow these steps:

Open Android Studio.

Go to Run > Run 'tests' or right-click on the test file and select Run.

UI Tests:

UI tests are written to validate the UI components and user interactions. They can be executed as instrumentation tests.
