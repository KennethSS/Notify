<h1 align="center">Notify</h1></br>

<p align="center">
A Notify is simply support notificated service for android

## ⚠️Working in progress⚠️
</p>

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
</p>

### Dependency Gradle 
Add below codes to your **root** `build.gradle` file (not your module build.gradle file).
```gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

```gradle
dependencies {
  implementation 'com.github.KennethSS:notify:1.0.0'
}
```


## Usage
### Basic Example
```kotlin
val notify = Notify.with {
                iconRes { R.mipmap.ic_launcher }
                appName { "AppName" }
                content {
                    standard {
                        title = "This is title text"
                        text = "Lorem ipsum dolor sit amet, consectetur adipisicing el.."
                    }
                }

            }
            notify.build().show(this)
```
