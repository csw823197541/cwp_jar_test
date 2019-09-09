package com.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.testWI.utils.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by csw on 2017/7/7.
 * Description:
 */
public class Test {

    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static void main(String[] args) {
        String str = FileUtil.readFileToString(new File("data/TESTCrane.txt")).toString();
//        System.out.println(str);
        if (str != null) {
            String[] strAs = str.split(">>>>>");
            if (strAs.length == 3) {
                String strJson = strAs[2];
                int s = strJson.indexOf("{");
                int e = strJson.indexOf("}");
                String strJson1 = strJson.substring(s, e + 1);
                String strJson2 = strJson.substring(e + 1, strJson.length());
                //得到一个json对象，一个json对象数组
                Crane crane1 = gson.fromJson(strJson1, Crane.class);
                List<Crane> craneList = parseJsonArray(strJson2, Crane.class);
            } else {
                System.out.println("文件格式不正确！要有两个'>>>>>'字符隔开，最后一个字符串是json格式！");
            }
        } else {
            System.out.println("读取到空文件！");
        }
    }

    private static  <T> List<T> parseJsonArray(String jsonData, Class<T> type) {
        List<JsonObject> jsonObjects = gson.fromJson(jsonData, new TypeToken<List<JsonObject>>(){}.getType());
        List<T> result = new ArrayList<T>();
        for (JsonObject jsonObject : jsonObjects) {
            result.add(gson.fromJson(jsonObject, type));
        }
        return result;
    }
}
