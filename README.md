# MealZ App

Brief description of your app.

## Architecture
This project follows the principles of Clean Architecture.

### Layers
1. **App Layer**: Contains UI components, ViewModels, and navigation logic.
2. **Domain Layer**: Contains business logic and use cases.
3. **Data Layer**: Responsible for interacting with external data sources such as a remote server or local database.

### Dependency Injection
Dagger Hilt is used for dependency injection throughout the app.

### Network
Retrofit is used for making OkHTTP requests to the backend server.

### Database
Room is used for local data storage and caching.

## Technologies Used
- Kotlin
- Android SDK
- Dagger Hilt
- Retrofit
- Room

