package com.shuhao.utilscode.utils;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;

import com.blankj.utilcode.util.Utils;

/**
 * Created by luke on 2017/9/25.
 */

public class MetaDataUtils {

    public static ActivityInfo getActivityInfo(Activity activity) {
        ActivityInfo info = null;
        try {
            info = activity.getPackageManager()
                    .getActivityInfo(activity.getComponentName(),
                            PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return info;
    }

    public static ApplicationInfo getApplicationInfo() {
        Application application = Utils.getApp();
        ApplicationInfo info = null;
        try {
            info = application.getPackageManager().getApplicationInfo(application.getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return info;
    }

    public static ServiceInfo getServicerInfo(Context context, Class<?> serviceClass) {
        ComponentName cn = new ComponentName(context, serviceClass);

        ServiceInfo info = null;
        try {
            info = Utils.getApp().getPackageManager().getServiceInfo(cn, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return info;
    }

    public static ActivityInfo activityInfo(Context context, Class<?> receiverClass) {
        ComponentName cn = new ComponentName(context, receiverClass);

        ActivityInfo info = null;
        try {
            info = context.getPackageManager().getReceiverInfo(cn, PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return info;
    }


}
