package com.testCWP.test3_27;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shbtos.biz.smart.cwp.service.SmartCraneAllocationResults;
import com.shbtos.biz.smart.cwp.service.SmartCwpGenerator;
import com.shbtos.biz.smart.cwp.service.SmartCwpImportData;
import com.testCWP.utils.FileUtil;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by csw on 2018/5/30.
 * Description:
 */
public class Test9_21 {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {

        String filePath = "data/多船数据/";

        String cwpInfo = FileUtil.readFileToString(new File(filePath + "cwpImportDataJson3.txt")).toString();

        Gson gson = new GsonBuilder().create();
        SmartCwpImportData smartCwpImportData = gson.fromJson(cwpInfo, SmartCwpImportData.class);

        SmartCwpGenerator smartCwpGenerator = new SmartCwpGenerator();
        SmartCraneAllocationResults smartCraneAllocationResults = smartCwpGenerator.doCraneAllocation(smartCwpImportData);

        System.out.println(smartCraneAllocationResults.getSmartReCraneWorkPlanInfoList().size());
        System.out.println(smartCraneAllocationResults.getSmartReMessageInfo().getErrorLog());
    }
}
