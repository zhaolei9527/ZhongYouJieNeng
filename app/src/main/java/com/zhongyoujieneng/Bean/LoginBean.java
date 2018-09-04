package com.zhongyoujieneng.Bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * sakura.liangdinvshen.Bean
 *
 * @author 赵磊
 * @date 2017/11/29
 * 功能描述：
 */
public class LoginBean {

    /**
     * status : 211
     * msg : 登录成功
     * user : {"id":"96","work_id":"083","name":"段婷婷","zid":"1","tel":"15038011325","erweima":"/Public/hecheng/1-083.png","status":"1","add_time":"1504065499","openid":"o5-OJuKp0le5DXqWSTQIII4MxMsI","is_del":"-1","type":"2","password":"c56d0e9a7ccec67b4ea131655038d604"}
     */

    private String status;
    private String msg;
    private UserBean user;

    public static List<LoginBean> arrayLoginBeanFromData(String str) {

        Type listType = new TypeToken<ArrayList<LoginBean>>() {
        }.getType();

        return new Gson().fromJson(str, listType);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        /**
         * id : 96
         * work_id : 083
         * name : 段婷婷
         * zid : 1
         * tel : 15038011325
         * erweima : /Public/hecheng/1-083.png
         * status : 1
         * add_time : 1504065499
         * openid : o5-OJuKp0le5DXqWSTQIII4MxMsI
         * is_del : -1
         * type : 2
         * password : c56d0e9a7ccec67b4ea131655038d604
         */

        private String id;
        private String work_id;
        private String name;
        private String zid;
        private String tel;
        private String erweima;
        private String status;
        private String add_time;
        private String openid;
        private String is_del;
        private String type;
        private String password;

        public static List<UserBean> arrayUserBeanFromData(String str) {

            Type listType = new TypeToken<ArrayList<UserBean>>() {
            }.getType();

            return new Gson().fromJson(str, listType);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getWork_id() {
            return work_id;
        }

        public void setWork_id(String work_id) {
            this.work_id = work_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getZid() {
            return zid;
        }

        public void setZid(String zid) {
            this.zid = zid;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getErweima() {
            return erweima;
        }

        public void setErweima(String erweima) {
            this.erweima = erweima;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getOpenid() {
            return openid;
        }

        public void setOpenid(String openid) {
            this.openid = openid;
        }

        public String getIs_del() {
            return is_del;
        }

        public void setIs_del(String is_del) {
            this.is_del = is_del;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
