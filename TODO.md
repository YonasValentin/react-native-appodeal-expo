# Copilot Fix Instructions for react-native-appodeal-expo

1. **Podspec Adjustments**

   - Remove or update any references that conflict with new-architecture React Native (e.g. remove Flipper references if present).
   - Ensure the podspec does not pin an older `React` version that conflicts with Expo’s pods.
   - Confirm or update iOS deployment target to `'15.1'` if needed.

2. **Check for `use_frameworks!` Conflicts**

   - The Appodeal SDK requires `use_frameworks!`, but Expo might use `use_frameworks! :linkage => :static`. Make sure there are no direct or conflicting lines forcing dynamic frameworks.
   - If there's a line forcing dynamic frameworks, update it to `use_frameworks! :linkage => :static` to match Expo Build Properties.

3. **Remove or Adapt Old Architecture Workarounds**

   - Remove references to older bridging code that might conflict with the new architecture’s codegen approach.
   - Remove or replace direct references to `React`-internal headers that are now changed in RN 0.70+.

4. **Ensure `ReactAppDependencyProvider` Is Available**

   - If the code or podspec references `ReactAppDependencyProvider` incorrectly, remove or align it with the modern approach.
   - If needed, add `source 'https://github.com/expo/expo.git'` to the podspec’s `spec.source` or readme notes so that CocoaPods can find all necessary specs for Expo.

5. **Gradle Updates**

   - In `android/build.gradle` and `android/settings.gradle`, remove or update any references that conflict with an Expo-managed Gradle setup, especially if the plugin references JCenter (deprecated). Use Maven Central or the Appodeal artifactory.
   - Ensure the plugin does not conflict with the versions in `gradle.properties` or the default Gradle version that Expo uses.

6. **Check Example Code and Native Modules**

   - If the repository has an example project, confirm it works with an Expo 52 app using the new architecture.
   - Adjust any native module registration code that references the old `createNativeModules` approach if new codegen is required.

7. **Update Documentation**
   - Make it clear that this fork is designed for Expo 52+ and the new architecture.
   - Provide instructions for `expo prebuild` to ensure users see how to integrate properly.
