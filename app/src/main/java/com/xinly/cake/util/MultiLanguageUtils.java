package com.xinly.cake.util;

/**
 * Created by zm on 2019-12-10.
 */

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;

import androidx.core.os.ConfigurationCompat;
import androidx.core.os.LocaleListCompat;

import com.xinly.cake.model.constans.Constans;

import java.util.Locale;


    /**
     * 使用步骤：
     * 1、Application中onCreate添加registerActivityLifecycleCallbacks(MultiLanguageUtils.callbacks);
     @Override
     protected void attachBaseContext(Context base) {
     //系统语言等设置发生改变时会调用此方法，需要要重置app语言
     super.attachBaseContext(MultiLanguageUtils.attachBaseContext(base));
     }
      * 2、改变应用语言调用MultiLanguageUtils.changeLanguage(activity,type,type);
     */
    public class MultiLanguageUtils {
        /**
         * @param language    语言  zh/en
         */
        public static void changeLanguage(Context context,String language) {
            if (TextUtils.isEmpty(language) ) {
                //如果语言和地区都是空，那么跟随系统s
                PrefsUtils.putString(Constans.SP_SETTINGS_LANGUAGE,"");
            } else {
                //不为空，那么修改app语言，并true是把语言信息保存到sp中，false是不保存到sp中
                Locale newLocale = new Locale(language);
                changeAppLanguage(context, newLocale, true);
            }
            // 重启应用
//        AppManager.getAppManager().finishAllActivity();
//        IntentUtils.toActivity(context,MainActivity.Class,true);
        }

        /**
         * @param locale      语言地区
         * @param persistence 是否持久化
         */
        public static void changeAppLanguage(Context context, Locale locale, boolean persistence) {
            Resources resources = context.getResources();
            DisplayMetrics metrics = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            setLanguage(context, locale, configuration);
            resources.updateConfiguration(configuration, metrics);
            if (persistence) {
                saveLanguageSetting(locale);
            }
        }

        private static void setLanguage(Context context, Locale locale, Configuration configuration) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                configuration.setLocale(locale);
                configuration.setLocales(new LocaleList(locale));
                context.createConfigurationContext(configuration);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                configuration.setLocale(locale);
            } else {
                configuration.locale = locale;
            }
        }

        /**
         * 跟随系统语言
         */
        public static Context attachBaseContext(Context context) {
            String spLanguage = PrefsUtils.getString(Constans.SP_SETTINGS_LANGUAGE);
            Resources resources = context.getResources();
            DisplayMetrics dm = resources.getDisplayMetrics();
            Configuration configuration = resources.getConfiguration();
            Locale appLocale = getAppLocale(context);
            //如果本地有语言信息，以本地为主，如果本地没有使用默认Locale
            Locale locale = null;
            if (!TextUtils.isEmpty(spLanguage)) {
                if (isSameLocal(appLocale, spLanguage)) {
                    locale = appLocale;
                } else {
                    locale = new Locale(spLanguage);
                }
            } else {
                locale = appLocale;
            }
            setLanguage(context, locale, configuration);
            resources.updateConfiguration(configuration, dm);
            return context;
        }

        /**
         * 判断sp中和app中的多语言信息是否相同
         */
        public static boolean isSameWithSetting(Context context) {
            Locale locale = getAppLocale(context);
            String language = locale.getLanguage();
            String sp_language = PrefsUtils.getString(Constans.SP_SETTINGS_LANGUAGE);
            if (language.equals(sp_language)) {
                return true;
            } else {
                return false;
            }
        }

        /**
         * 判断应用于系统语言是否相同
         */
        public static boolean isSameLocal(Locale appLocale, String sp_language) {
            String appLanguage = appLocale.getLanguage();
            if (appLanguage.equals(sp_language)) {
                return true;
            } else {
                return false;
            }
        }
        /**
         * 保存多语言信息到sp中
         */
        public static void saveLanguageSetting(Locale locale) {
            PrefsUtils.putString(Constans.SP_SETTINGS_LANGUAGE, locale.getLanguage());
        }

        /**
         * 获取应用语言
         */
        public static Locale getAppLocale(Context context){
            Locale local;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                local =context.getResources().getConfiguration().getLocales().get(0);
            } else {
                local =context.getResources().getConfiguration().locale;
            }
            return local;
        }

        /**
         * 获取系统语言
         */
        public static LocaleListCompat getSystemLanguage(){
            Configuration configuration = Resources.getSystem().getConfiguration();
            LocaleListCompat locales = ConfigurationCompat.getLocales(configuration);
            return locales;
        }

        //注册Activity生命周期监听回调，此部分一定加上，因为有些版本不加的话多语言切换不回来
        //registerActivityLifecycleCallbacks(callbacks);
        public static  Application.ActivityLifecycleCallbacks callbacks = new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                String language = PrefsUtils.getString(Constans.SP_SETTINGS_LANGUAGE);
                if (!TextUtils.isEmpty(language)) {
                    //强制修改应用语言
                    if (!isSameWithSetting(activity)) {
                        Locale locale = new Locale(language);
                        changeAppLanguage(activity, locale, false);
                    }
                }
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        };

}
