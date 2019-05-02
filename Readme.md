curs link: https://coursehunters.net/course/appium-android-prostoe-rukovodstvo-po-avtomatizacii-testirovaniya

1. Intall Android Studio and androidSDK(SDK is when install Android Studio)
2. Write Environmental variable "ANDROID_HOME", it is path to androidSdk folder (C:\UsersUser\AppData\Local\Android\Sdk)
2.1. Write Path:
	a.%ANDROID_HOME%\emulator		|| it is for emulator
	b.%ANDROID_HOME%\platform-tools         || it is for adb command? o see which devices is connected
	c.%ANDROID_HOME%\tools			||
	d.%ANDROID_HOME%\tools\bin		||
2.2 Verfy if all settings are done, types in console next:
	a.sdkmanager --verbose
	b.where uiautomatorviewer
	c.uiautomatorviewer

3.Connect cellPhone to PC via USB
3.1 Switch on "Developer mode"
3.2 Allow "USB debugging" in the "Developer options" menu
3.3 In cmd run next command: adb devices

4. run emulator 
	a. emulator -list-avds     || list of available emulators(an emulator is created in Android Studio in AVD manager) 
	b. emulator @nameOfVirtualDevices     || run emulator(don'5 forget about "@")

5. Find out path to runable native application, need to switch on it in the emulator and init next commands in CMD.
	a. adb shell , dumpsys window windows | grep mCurrentFocus         - if don't use this command then do not work UIAutomatorViewer
	then should be next text: mCurrentFocus=Window{c931f6c u0 com.android.calculator2/com.android.calculator2.Calculator}

6. Find out locators, need to run "uiautomatorviewer".

