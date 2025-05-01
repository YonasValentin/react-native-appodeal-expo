[![Buy Me a Coffee](https://img.shields.io/badge/Buy%20me%20a%20coffee-yellow?logo=buy-me-a-coffee&style=flat-square)](https://buymeacoffee.com/yonasvalentin)

# react-native-appodeal-expo

A modern, Expo-compatible React Native wrapper for the Appodeal SDK, supporting both iOS and Android. This project is maintained by [Yonas Valentin](https://github.com/yonasvalentin) and is based on the excellent work of the original [react-native-appodeal](https://github.com/appodeal/react-native-appodeal) maintainers. All credit for the core native implementation goes to them—this fork adapts and extends their work for Expo 52+ and the new React Native architecture.

---

## Features

- Easy integration of Appodeal ads (Banner, Interstitial, Rewarded, MREC) in React Native/Expo apps
- Full support for iOS and Android
- GDPR/CCPA consent management
- Ad revenue and event tracking
- Expo 52+ and new architecture ready

## Table of Contents

- [Installation](#installation)
- [iOS Setup](#ios-setup)
- [Android Setup](#android-setup)
- [Usage](#usage)
- [Consent & Privacy](#consent--privacy)
- [Banner & MREC Components](#banner--mrec-components)
- [Changelog](#changelog)
- [Credits](#credits)

---

## Installation

```sh
npm install react-native-appodeal --save
```

> For beta versions, use:
>
> ```sh
> npm install react-native-appodeal@beta --save
> ```

If you use React Native < 0.60:

```sh
react-native link react-native-appodeal
```

---

## iOS Setup

1. **Podfile**: In your `ios/Podfile`, add the required Appodeal pods. Example:

```ruby
use_frameworks! :linkage => :static # Required for Expo 52+
pod 'Appodeal', '3.5.0'
# ...add mediation/adapters as needed
```

2. **Install pods**:

```sh
cd ios && pod install
```

3. **Info.plist**: Configure SKAdNetworkIds, App Transport Security, and any ad network keys (AdMob, Facebook, Firebase, etc). See [Appodeal iOS docs](https://docs.appodeal.com/ios/get-started).

4. **Open** `.xcworkspace` and run your app.

---

## Android Setup

1. **Add Appodeal SDK**: In your app-level `build.gradle`:

```groovy
dependencies {
    implementation 'com.appodeal.ads:sdk:3.5.0.0'
    // ...other adapters as needed
}
```

2. **Add Appodeal Maven repo**: In your project-level `build.gradle`:

```groovy
allprojects {
    repositories {
        maven { url "https://artifactory.appodeal.com/appodeal" }
    }
}
```

3. **Configure AdMob, Facebook, Firebase, etc** in your `AndroidManifest.xml` as needed. See [Appodeal Android docs](https://docs.appodeal.com/android/get-started).

4. **Run your app**.

---

## Usage

### Initialization

```js
import { Appodeal, AppodealAdType } from 'react-native-appodeal';

Appodeal.initialize(
  'YOUR_APPODEAL_KEY',
  AppodealAdType.INTERSTITIAL |
    AppodealAdType.REWARDED_VIDEO |
    AppodealAdType.BANNER
);
```

### Configuration

- Enable/disable autocache:
  ```js
  Appodeal.setAutoCache(AppodealAdType.INTERSTITIAL, false);
  ```
- Set test mode:
  ```js
  Appodeal.setTesting(true);
  ```
- Set log level:
  ```js
  Appodeal.setLogLevel(AppodealLogLevel.DEBUG);
  ```
- Set user targeting:
  ```js
  Appodeal.setUserId('user-id');
  Appodeal.setCustomStateValue(25, 'user_age');
  Appodeal.setCustomStateValue(AppodealGender.FEMALE, 'user_gender');
  ```

### Event Listeners

```js
Appodeal.addEventListener(AppodealSdkEvent.INITIALIZED, () => {
  console.log('Appodeal SDK initialized');
});
Appodeal.addEventListener(AppodealSdkEvent.AD_REVENUE, (revenue) => {
  console.log('Ad revenue:', revenue);
});
```

### Showing Ads

```js
Appodeal.show(AppodealAdType.BANNER_TOP);
Appodeal.show(AppodealAdType.INTERSTITIAL, 'placement');
```

### Hiding Ads

```js
Appodeal.hide(AppodealAdType.BANNER_TOP);
```

---

## Consent & Privacy (GDPR/CCPA)

Appodeal handles consent automatically, but you can manage it manually:

```js
import { Appodeal, AppodealConsentStatus } from 'react-native-appodeal';

// Get consent status
const status = Appodeal.consentStatus();

// Request consent update
Appodeal.requestConsentInfoUpdate('YOUR_APPODEAL_KEY').then((status) =>
  console.log(status)
);

// Show consent form if needed
Appodeal.showConsentFormIfNeeded();

// Force show consent form
Appodeal.showConsentForm();

// Revoke consent
Appodeal.revokeConsent();
```

---

## Banner & MREC Components

### Banner

```js
import { AppodealBanner } from 'react-native-appodeal';

<AppodealBanner
  style={{ height: 50, width: '100%' }}
  adSize='phone'
  usesSmartSizing
  onAdLoaded={() => console.log('Banner loaded')}
  onAdFailedToLoad={() => console.log('Banner failed')}
/>;
```

### MREC

```js
import { AppodealMrec } from 'react-native-appodeal';

<AppodealMrec
  style={{ height: 250, width: 300 }}
  onAdLoaded={() => console.log('MREC loaded')}
  onAdFailedToLoad={() => console.log('MREC failed')}
/>;
```

---

## Changelog

See [CHANGELOG](./CHANGELOG.md) or the bottom of this README for version history.

---

## Credits

This project is a fork of [appodeal/react-native-appodeal](https://github.com/appodeal/react-native-appodeal).

Huge thanks to Appodeal and the original authors and contributors for their work on the native modules and initial React Native integration. Appodeal is a registered trademark of Appodeal, Inc. This project is not officially affiliated with or endorsed by Appodeal.

---

For questions, issues, or contributions, please open an issue or PR on GitHub.

[![Buy Me a Coffee](https://img.shields.io/badge/Buy%20me%20a%20coffee-yellow?logo=buy-me-a-coffee&style=flat-square)](https://buymeacoffee.com/yonasvalentin)
