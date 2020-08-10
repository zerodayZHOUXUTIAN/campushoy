package com.ahnu.app.dao;


import com.ahnu.app.common.UserConstant;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 发送HTTP请求的工具类
 *
 * @author DamonCheng@ssw.com.au
 * @date 8/4/2020 3:42 PM
 */
public class RequestDao {


    /**
     * @param location 请求地址
     * @param param    参数
     * @return 返回请求的json
     * @throws IOException
     */
    public static JSONObject request(String location, String param) {
        String post = httpsRequest(location, "POST", param);
        return JSONObject.parseObject(post);
    }


    /**
     * http请求
     *
     * @param requestUrl    请求路劲
     * @param requestMethod 请求方法
     * @param outputStr     请求数据
     * @return 请求返回结果
     */
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            // 设置请求方式（GET/POST）
            conn.setRequestMethod(requestMethod);
            conn.setRequestProperty("Connection", "keep-alive");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 4.4.4; VOG-AL00 Build/KTU84P) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/33.0.0.0 Safari/537.36 okhttp/3.8.1");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Cookie", UserConstant.COOKIE);
            conn.setRequestProperty("Host", "ahnu.cpdaily.com");
            conn.setRequestProperty("Accept-Encoding", "gzip,deflate");
            conn.setRequestProperty("x-requested-with", "XMLHttpRequest");
            conn.setRequestProperty("accept", "application/json, text/plain, */*");
            conn.setRequestProperty("Cpdaily-Extension", UserConstant.CPDAILY_EXTENSION);
            // 当outputStr不为null时向输出流写数据
            if (null != outputStr) {
                OutputStream outputStream = conn.getOutputStream();
                // 注意编码格式
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuilder buffer = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            conn.disconnect();
            return buffer.toString();
        } catch (ConnectException ce) {
            System.out.println("连接超时：{}" + ce);
        } catch (Exception e) {
            System.out.println("https请求异常：{}" + e);
        }
        return null;
    }


}
