# My City App - Baku

A modern, adaptive Android application that showcases interesting places to visit in Baku. This project was developed as a practical assignment from the **Android Basics with Compose** course (Unit 4: Navigation and app architecture - Adapting for different screen sizes).

The main goal of this project is to demonstrate how to build a dynamic UI that automatically adjusts to various screen sizes (Compact, Medium, Expanded) using Jetpack Compose.


## Visuals & Layouts

Here is how the app adapts to different window size classes and themes:
> **Note:** The demonstration highlights the system back button and the UI back button actions to showcase proper back-stack handling and seamless navigation.

### Compact Screens (Phones)
Light                                 |                                Dark |
|:--------------------------------------|------------------------------------:|
| ![Compact Light](img/CompactLight.gif) | ![Compact Dark](img/CompactDark.gif) |

### Change screen orientation from portrait to landscape
![Compact to list and details](img/CompactToListAndDetails.gif)

### Medium screen (foldable)
![Medium](img/Medium.gif)

### Large screen (Tablet)
![Large](img/Large.gif)


## 🛠 Tech Stack & Architecture

- **Language:** [Kotlin](https://kotlinlang.org/)
- **UI Framework:** [Jetpack Compose](https://developer.android.com/jetpack/compose) (Declarative UI)
- **Navigation:** Jetpack Compose Navigation (`NavHost`, `NavController`)
- **Material Design:** Material 3 implementation for themes and adaptive components.
- **Architecture:** MVVM Pattern (Model-View-ViewModel) with Unidirectional Data Flow (UDF).

## Requirements & Installation

1. Clone the repository:
    ``` bash
    git clone https://github.com/IlgarM4224/My-City-App.git 
    ```
2. Open the project in the latest version of Android Studio
3. Sync the project with Gradle files
4. Run the app on an emulator (with resizing enabled to test layouts) or a physical device
