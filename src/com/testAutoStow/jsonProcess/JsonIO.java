package com.testAutoStow.jsonProcess;

import com.google.gson.Gson;
import com.shbtos.biz.smart.cwp.pojo.inputs.SmartStowImportData;

/**
 * Created by lekoxnfx on 2017/2/14.
 */
public class JsonIO {
    Gson gson = new Gson();

    public String smartStowImportDataToJson(SmartStowImportData smartStowImportData) {
        return gson.toJson(smartStowImportData);
    }

    public SmartStowImportData jsonToSmartStowImportData(String inJsonStr) {
        return gson.fromJson(inJsonStr, SmartStowImportData.class);
    }

}
