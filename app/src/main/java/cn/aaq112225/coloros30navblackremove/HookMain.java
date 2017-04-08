package cn.aaq112225.coloros30navblackremove;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.LOLLIPOP;

/**
 * Created by tvtwu on 2017/3/15.
 */

public class HookMain implements IXposedHookInitPackageResources ,IXposedHookLoadPackage{


    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam) throws Throwable {
        if (!initPackageResourcesParam.packageName.equals("com.android.systemui")) return;

        //com.android.systemui:color/navigationbarview_black_color
        initPackageResourcesParam.res.setReplacement(0x7f100020, 0x26000000);
    }

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equals("com.android.systemui"))return;

        if(SDK_INT == LOLLIPOP)
            XposedHelpers.findAndHookMethod("com.android.systemui.statusbar.phone.NavigationBarView",loadPackageParam.classLoader,"refreshStatusBarIcons", XC_MethodReplacement.DO_NOTHING);
    }
}
