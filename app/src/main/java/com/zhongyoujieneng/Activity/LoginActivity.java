package com.zhongyoujieneng.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.zhongyoujieneng.App;
import com.zhongyoujieneng.Bean.LoginBean;
import com.zhongyoujieneng.R;
import com.zhongyoujieneng.Utils.EasyToast;
import com.zhongyoujieneng.Utils.SpUtil;
import com.zhongyoujieneng.Utils.UrlUtils;
import com.zhongyoujieneng.Utils.Utils;
import com.zhongyoujieneng.Volley.VolleyInterface;
import com.zhongyoujieneng.Volley.VolleyRequest;

import java.util.HashMap;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * sakura.printersakura.Activity
 *
 * @author 赵磊
 * @date 2017/11/22
 * 功能描述：
 */
public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    private Dialog dialog;

    @Override
    protected void ready() {
        super.ready();
        fullScreen(this);
    }

    @Override
    protected int setthislayout() {
        return R.layout.activcity_login;
    }

    @Override
    protected void initview() {

    }

    @Override
    protected void initListener() {
    }

    @OnClick(R.id.btn_login)
    void submit() {

        if (TextUtils.isEmpty(etAccount.getText().toString())) {
            Toast.makeText(context, etAccount.getHint().toString(), Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            Toast.makeText(context, etPassword.getHint().toString(), Toast.LENGTH_SHORT).show();
            return;
        }
        if (Utils.isConnected(context)) {
            dialog = Utils.showLoadingDialog(context);
            if (!dialog.isShowing()) {
                dialog.show();
                login(etAccount.getText().toString().trim(), etPassword.getText().toString().trim(), context);
            }
        }
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getQueues().cancelAll("login");
        System.gc();
    }

    @BindString(R.string.Abnormalserver)
    String Abnormalserver;

    /**
     * 登录
     */
    public void login(String uname, String upassword, final Context context) {
        HashMap<String, String> params = new HashMap<>(2);
        params.put("tel", uname);
        params.put("password", upassword);
        VolleyRequest.RequestPost(context, UrlUtils.BASE_URL + "login/login", "login", params, new VolleyInterface(context) {
            @Override
            public void onMySuccess(String result) {
                Log.e("RegisterActivity", result);
                try {
                    dialog.dismiss();
                    LoginBean loginBean = new Gson().fromJson(result, LoginBean.class);
                    if ("211".equals(loginBean.getStatus())) {
                        SpUtil.putAndApply(context, "zid", loginBean.getUser().getZid());
                        SpUtil.putAndApply(context, "username", loginBean.getUser().getName());
                        SpUtil.putAndApply(context, "phone", loginBean.getUser().getTel());
                        startActivity(new Intent(context, MainActivity.class));
                        finish();
                    } else {
                        EasyToast.showShort(context, "帐号异常，请联系管理员");
                    }
                    loginBean = null;
                    result = null;
                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMyError(VolleyError error) {
                dialog.dismiss();
                error.printStackTrace();
                Toast.makeText(context, Abnormalserver, Toast.LENGTH_SHORT).show();
            }
        });
    }


}



