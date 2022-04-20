# xApp
Demo app in AOSP source development environment

# Usage
## HelloService
```
$ adb shell am startservice -a "aosp.app.hello.intent.action.INIT" -c "android.intent.category.DEFAULT"
Starting service: Intent { act=aosp.app.hello.intent.action.INIT cat=[android.intent.category.DEFAULT] }
```

## IPackageInstallObserver
This interface is deprecated in Android 9.0(API-28)
