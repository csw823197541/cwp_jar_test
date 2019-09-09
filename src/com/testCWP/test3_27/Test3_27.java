package com.testCWP.test3_27;

import com.shbtos.biz.smart.cwp.pojo.SmartCranePoolInfo;
import com.shbtos.biz.smart.cwp.pojo.SmartVesselCranePoolInfo;
import com.shbtos.biz.smart.cwp.service.SmartCwpGenerator;
import com.shbtos.biz.smart.cwp.service.SmartCwpImportData;
import com.shbtos.biz.smart.cwp.service.SmartCwpResults;
import com.testCWP.jsonProcess.JsonIO;
import com.testCWP.utils.FileUtil;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by csw on 2016/12/13 15:03.
 * Explain:
 */
public class Test3_27 {

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {

        String filePath = "data/cwpData/3.27/";

        String cwpInfo = FileUtil.readFileToString(new File(filePath + "cwpdata.txt")).toString();

        JsonIO jsonIO = new JsonIO();
        SmartCwpImportData smartCwpImportData = jsonIO.jsonToCwpImportData(cwpInfo);

        SmartVesselCranePoolInfo smartVesselCranePoolInfo = new SmartVesselCranePoolInfo();
        smartVesselCranePoolInfo.setBerthId(197388L);
        smartVesselCranePoolInfo.setPoolId(1L);
//        smartVesselCranePoolInfo.setDelCraneDate(sdf.parse("2017-03-27 16:40:00"));
//        smartVesselCranePoolInfo.setDelCraneNumber(2L);
//        smartVesselCranePoolInfo.setAddCraneDate(sdf.parse("2017-02-04 20:00:00"));
//        smartVesselCranePoolInfo.setAddCraneNumber(1L);
        smartCwpImportData.getSmartVesselCranePoolInfoList().add(smartVesselCranePoolInfo);

        List<SmartCranePoolInfo> smartCranePoolInfoList = new ArrayList<>();
        SmartCranePoolInfo smartCranePoolInfo1 = new SmartCranePoolInfo();
        smartCranePoolInfo1.setPoolId(1L);
        smartCranePoolInfo1.setCraneNo("101");
        SmartCranePoolInfo smartCranePoolInfo2 = new SmartCranePoolInfo();
        smartCranePoolInfo2.setPoolId(1L);
        smartCranePoolInfo2.setCraneNo("102");
        SmartCranePoolInfo smartCranePoolInfo3 = new SmartCranePoolInfo();
        smartCranePoolInfo3.setPoolId(1L);
        smartCranePoolInfo3.setCraneNo("103");
        SmartCranePoolInfo smartCranePoolInfo4 = new SmartCranePoolInfo();
        smartCranePoolInfo4.setPoolId(1L);
        smartCranePoolInfo4.setCraneNo("104");
        SmartCranePoolInfo smartCranePoolInfo5 = new SmartCranePoolInfo();
        smartCranePoolInfo5.setPoolId(1L);
        smartCranePoolInfo5.setCraneNo("105");
        SmartCranePoolInfo smartCranePoolInfo6 = new SmartCranePoolInfo();
        smartCranePoolInfo6.setPoolId(1L);
        smartCranePoolInfo6.setCraneNo("106");
        SmartCranePoolInfo smartCranePoolInfo7 = new SmartCranePoolInfo();
        smartCranePoolInfo7.setPoolId(1L);
        smartCranePoolInfo7.setCraneNo("107");
        smartCranePoolInfoList.add(smartCranePoolInfo1);
        smartCranePoolInfoList.add(smartCranePoolInfo2);
        smartCranePoolInfoList.add(smartCranePoolInfo3);
        smartCranePoolInfoList.add(smartCranePoolInfo4);
        smartCranePoolInfoList.add(smartCranePoolInfo5);
        smartCranePoolInfoList.add(smartCranePoolInfo6);
        smartCranePoolInfoList.add(smartCranePoolInfo7);
        smartCwpImportData.setSmartCranePoolInfoList(smartCranePoolInfoList);

        SmartCwpGenerator smartCwpGenerator = new SmartCwpGenerator();
        SmartCwpResults smartCwpResults = smartCwpGenerator.doPlanCwp(smartCwpImportData, null);

        System.out.println(smartCwpResults.getSmartReCwpWorkOrderInfoList().size());

//        ImportDataFrame importDataFrame = new ImportDataFrame(smartCwpImportData);
//        importDataFrame.setVisible(true);
    }
}
