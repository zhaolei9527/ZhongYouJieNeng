package com.zhongyoujieneng;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.baidu.tts.client.SpeechSynthesizer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.bugly.Bugly;


/**
 * Created by 赵磊 on 2017/7/12.
 */

public class App extends MultiDexApplication {
    /**
     * 先创建一个请求队列，因为这个队列是全局的，所以在Application中声明这个队列
     */
    public static RequestQueue queues;

    public static Context context;

    protected String getAppkey() {
        return null;
    }

    protected String getAppSecret() {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.context = this;
        MultiDex.install(this);
        Bugly.init(getApplicationContext(), "76cc0407ec", false);
        queues = Volley.newRequestQueue(getApplicationContext());
        Fresco.initialize(this);

    }

    public static RequestQueue getQueues() {
        return queues;
    }
}
