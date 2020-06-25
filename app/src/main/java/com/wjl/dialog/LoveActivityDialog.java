package com.wjl.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class LoveActivityDialog extends Dialog {
    private TextView tv_order, tv_detailed_desc, tv_thank_you_desc;
    private ImageView iv_close;
    private CloseListener listener;

    public LoveActivityDialog(@NonNull Context context) {
        super(context);
    }

    public LoveActivityDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deb_ly_dialog_love);
        initView();
        initAction();
    }

    private void initAction() {
        iv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(view);
                }
            }
        });
    }

    private void initView() {
        tv_order = findViewById(R.id.tv_order);
        tv_detailed_desc = findViewById(R.id.tv_detailed_desc);
        tv_thank_you_desc = findViewById(R.id.tv_thank_you_desc);
        iv_close = findViewById(R.id.iv_close);
    }

    public interface CloseListener {
        void onClick(View view);
    }

    public void setListener(CloseListener listener) {
        this.listener = listener;
    }
}
