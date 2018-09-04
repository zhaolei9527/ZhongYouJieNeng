package com.zhongyoujieneng.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * com.zhongyoujieneng.Bean
 *
 * @author 赵磊
 * @date 2018/9/3
 * 功能描述：
 */
public class BobaoBean {

    /**
     * status : 1
     * msg : 05到账79.86元
     */

    private int status;
    private String msg;

    public static List<BobaoBean> arrayBobaoBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<BobaoBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
