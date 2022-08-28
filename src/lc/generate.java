package lc;


import com.alibaba.fastjson2.JSON;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dengchenyang.brady@bytedance.com
 * @date 2022/8/19
 **/
public class generate {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");

//获取当前时间，格式化后赋值给变量entryTime
        String entryTime = simpleDateFormat.format(new Date());
        Map<String, String> postman = new HashMap();
//设置全局变量
        postman.put("timestamp", entryTime);
        postman.put("app_id","portal");
        postman.put("biz_params", "{\"form_code\":\"b4b7d15ebb9b45a5913b30a25202352f\",\"form_data\":{\"cawwia9e8k1u5v\":\"xxxx\"}, \"submit_user_id\":\"5256137\"}");
//获取变量

        String secret = "cvfedgdfwef234324234";
//sign：进行MD5加密
        String signStr = secret + entryTime + postman.get("biz_params");
        String signmd5 = md5Encoder(signStr, "utf-8");
//signmd5设置成全局变量
        postman.put("sign",signmd5);
        System.out.println(JSON.toJSONString(postman));

    }

    public  static String md5Encoder(String s, String charset) {
        try {
            byte[] btInput = s.getBytes(charset);
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16){
                    sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {

            return null;
        }
    }
}
