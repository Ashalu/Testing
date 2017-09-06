package com.cpu_z.Utils;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by info3 on 06-09-2017.
 */

public class BaseData extends Application{
    public static List<String> getDeviceList() {
        return DeviceList;
    }

    public static void setDeviceList(List<String> deviceList) {
        DeviceList = deviceList;
    }

    static List<String> DeviceList = new ArrayList<String>();
}
