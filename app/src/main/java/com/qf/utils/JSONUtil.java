package com.qf.utils;

import android.util.Log;

import com.qf.jingzhiwardrobe.MainActivity;
import com.qf.model.DapeiEntity;
import com.qf.model.mainEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.ArrayList;

/**
 * Json数据处理
 */
public class JSONUtil {
    public static List<DapeiEntity> JsonParser(String jsonStr) {
        List<DapeiEntity> datas = new ArrayList<DapeiEntity>();
        DapeiEntity dapei2 = null;
        if (jsonStr != null) {
            String[] str = jsonStr.split("\\(");
            String[] jsonStr2 = str[1].split("\\)");
            String jsonStr3 = jsonStr2[0];
            try {
                JSONObject jsonObject = new JSONObject(jsonStr3);
                JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                JSONArray jsonArray = jsonObject1.getJSONArray("dapei");
                for (int i = 0; i <= jsonArray.length(); i++) {
                    dapei2 = new DapeiEntity();
                    if (jsonArray != null) {
                        if (i == 0) {
                            dapei2.setType(0);
                            dapei2.setStrMainLogo(null);
                            dapei2.setStrTitle(null);
                        } else {
                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                            dapei2.setStrMainLogo(jsonObject2.getString("strMainLogo"));
                            dapei2.setStrTitle(jsonObject2.getString("strTitle"));
                            dapei2.setType(1);

                        }
                        datas.add(dapei2);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return datas;
    }
    public static List<mainEntity> jsonMainParser(String msg){
        List<mainEntity> datas2 = new ArrayList<mainEntity>();
        mainEntity data2 = null;
        if(msg != null){
            String[] str = msg.split("\\(");
            String[] jsonStr2 = str[1].split("\\)");
            String jsonStr3 = jsonStr2[0];
            try {
                JSONObject jsonObject  = new JSONObject(jsonStr3);
                JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                JSONArray jsonArray = jsonObject1.getJSONArray("dapei");

                for (int i = 0; i <= jsonArray.length(); i++) {
                    data2 = new mainEntity();
                    if (jsonArray != null) {
                        if (i == 0) {
                            data2.setType(0);
                            data2.setMainlogo(null);
                            data2.setTitle(null);
                        } else {
                            JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                            Log.e("println",jsonObject2.toString());
                            data2.setMainlogo(jsonObject2.getString("mainlogo"));
                            data2.setTitle(jsonObject2.getString("title"));
                            data2.setType(1);
                        }
                        datas2.add(data2);
                    }
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return datas2;
    }
}
