# Sample News App
This is a sample News App built using Kotlin Multiplatform to target both Android and iOS platforms. The project demonstrates the usage of modern development practices and frameworks like Jetpack Compose, SwiftUI, Koin, and Ktor to create a maintainable and scalable codebase.

# Tech Stack
## Languages
- Kotlin (Multiplatform)
- Swift (iOS-specific)

## UI
- Android: Jetpack Compose – a modern toolkit for building native Android UIs.
- iOS: SwiftUI – declarative framework for building native iOS interfaces.

## Architecture
- MVVM: To separate concerns between UI, business logic, and data.
- Clean Architecture: Layers of separation ensuring business rules are independent of UI and platform.

## Reactive Programming
- Kotlin Flow: Used for managing and observing asynchronous streams of data.

## Networking
- Ktor: A Kotlin-based asynchronous framework for making HTTP requests.
- Kotlin Serialization: To handle serialization and deserialization of data.

## Storage
- Android: SharedPreferences for lightweight local data storage.
- iOS: UserDefaults for local data storage.

## Dependency Injection
- Koin: A Kotlin dependency injection framework used to manage dependencies and provide ViewModels.

## Screenshot
<div style="display: flex; justify-content: space-around; align-items: center;">
  <div style="text-align: center; margin-right: 20px;">
    <h3>Android App - Front Page</h3>
    <img src="https://github.com/Wildanafian/Kotlin-Multi-Platform-News-App/blob/master/screenshot/Screenshot_20241025_084456.png" alt="Android Front Page" width="400"/>
  </div>

  <div style="text-align: center; margin-left: 20px;">
    <h3>iOS App - Front Page</h3>
    <img src="https://github.com/Wildanafian/News-App-SwiftUI---iOS/blob/main/screenshot/Simulator%20Screen%20Recording.gif" alt="iOS Front Page" width="400"/>
  </div>
</div>

