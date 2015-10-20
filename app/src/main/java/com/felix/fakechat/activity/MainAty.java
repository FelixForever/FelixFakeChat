package com.felix.fakechat.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.felix.fakechat.R;
import com.felix.fakechat.baseclass.BaseActivity;
import com.felix.fakechat.baseclass.annotation.ViewInject;

public class MainAty extends BaseActivity
{

    /*
    use inject view to bind the id and enent instead of findviewbyid
     */
    @ViewInject(id = R.id.iv_wechat, click = "itemClick")
    private ImageView mImgViewWechat;
    @ViewInject(id = R.id.iv_qq, click = "itemClick")
    private ImageView mImgViewQQ;
    @ViewInject(id = R.id.iv_red_paper, click = "itemClick")
    private ImageView mImgViewRedPaper;
    @ViewInject(id = R.id.iv_ms, click = "itemClick")
    private ImageView mImgViewMS;
    @ViewInject(id = R.id.iv_line, click = "itemClick")
    private ImageView mImgViewLine;
    @ViewInject(id = R.id.iv_more, click = "itemClick")
    private ImageView mImgViewMore;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData()
    {
        setContentView(R.layout.main_aty);
    }

    public void itemClick(View view)
    {
        final int id=view.getId();
        switch (id)
        {
            case R.id.iv_wechat:
            case R.id.iv_qq:
            case R.id.iv_ms:
            case R.id.iv_line:
                ChatAty.startActivity(this, id);
                //this.startActivity(new Intent(this,ChatAty.class));
                logInfo("start success ");
                break;
            case R.id.iv_red_paper:
                break;
            case R.id.iv_more:
                break;
            default:
                break;
        }
    }

}
