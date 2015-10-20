package com.felix.fakechat.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.felix.fakechat.R;
import com.felix.fakechat.baseclass.BaseActivity;

/**
 * Created by Administrator on 2015/10/20.
 */
public class ChatAty extends BaseActivity
{
    private static final String KEY="KEY_ChatAty";
    private int mId;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initData()
    {
        Bundle bundle=getIntent().getExtras();
        if(bundle==null||!bundle.containsKey(KEY))
        {
            logWarning("id not exits");
            finish();
        }
        else
        {
            mId=bundle.getInt(KEY);
            logInfo("key=" + mId);
            final int layoutId=getLayoutId();
            if(layoutId!=-1)
            {
                setContentView(layoutId);
            } else
            {
                logWarning("id error"+layoutId);
                this.finish();
            }
        }
    }

    public static void startActivity(Context context,int id)
    {
        final String TAG="startActivity";
        Bundle bundle=new Bundle();
        bundle.putInt(KEY, id);
        Intent intent=new Intent(context,ChatAty.class);
        intent.putExtras(bundle);
        //Log.i(TAG,"has key?"+bundle.containsKey(KEY));
        context.startActivity(intent);
        Log.i(TAG, "start success");
    }

    private int getLayoutId()
    {
        switch (mId)
        {
            case R.id.iv_wechat:return R.layout.chat_aty_wechat;
            default:
                logWarning("id="+mId+"  wechatid="+R.id.iv_wechat);
                return -1;
        }
    }
}
