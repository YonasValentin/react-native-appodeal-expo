package com.appodeal.rnappodeal;

import androidx.annotation.NonNull;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class RNAppodealPackage implements ReactPackage {
    @NonNull
    @Override
    public List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactContext) {
        // TODO: For Expo 52+ and new architecture, migrate to TurboModules/codegen and avoid using createNativeModules.
        // See https://reactnative.dev/docs/the-new-architecture-intro for migration steps.
        return Collections.singletonList(new RNAppodealModule(reactContext));
    }

    // Deprecated from RN 0.47
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @NonNull
    @Override
    public List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactContext) {
        return Arrays.asList(new RNAppodealBannerManager(), new RNAppodealMrecManager());
    }
}