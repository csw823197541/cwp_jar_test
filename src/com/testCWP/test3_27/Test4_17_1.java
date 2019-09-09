package com.testCWP.test3_27;

import com.shbtos.biz.smart.cwp.pojo.SmartScheduleIdInfo;
import com.shbtos.biz.smart.cwp.service.SmartCwpGenerator;
import com.shbtos.biz.smart.cwp.service.SmartCwpImportData;
import com.shbtos.biz.smart.cwp.service.SmartCwpResults;
import com.testCWP.jsonProcess.JsonIO;
import com.testCWP.utils.FileUtil;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by csw on 2016/12/13 15:03.
 * Explain:
 */
public class Test4_17_1 {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {

        String filePath = "data/cwpData/4.17/CWP集海之盛出口航次：0410进口航次：0410-20170417224945119/";

        String cwpInfo = FileUtil.readFileToString(new File(filePath + "cwpImportDataJson.txt")).toString();

        JsonIO jsonIO = new JsonIO();
        SmartCwpImportData smartCwpImportData = jsonIO.jsonToCwpImportData(cwpInfo);

        SmartScheduleIdInfo smartScheduleIdInfo = smartCwpImportData.getSmartScheduleIdInfoList().get(0);
//

        SmartCwpGenerator smartCwpGenerator = new SmartCwpGenerator();
        SmartCwpResults smartCwpResults = smartCwpGenerator.doPlanCwp(smartCwpImportData, null);
    }
}
