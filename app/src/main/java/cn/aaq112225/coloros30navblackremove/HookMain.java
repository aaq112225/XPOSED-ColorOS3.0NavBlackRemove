package cn.aaq112225.coloros30navblackremove;

import de.robv.android.xposed.IXposedHookInitPackageResources;
import de.robv.android.xposed.callbacks.XC_InitPackageResources;

/**
 * Created by tvtwu on 2017/3/15.
 */

public class HookMain implements IXposedHookInitPackageResources {

    @Override
    public void handleInitPackageResources(XC_InitPackageResources.InitPackageResourcesParam initPackageResourcesParam) throws Throwable {
        if (!initPackageResourcesParam.packageName.equals("com.android.systemui")) return;

        //com.android.systemui:color/navigationbarview_black_color
        initPackageResourcesParam.res.setReplacement(0x7f100020, 0x26000000);



    }

}
