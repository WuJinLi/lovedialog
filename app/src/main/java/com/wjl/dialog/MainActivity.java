package com.wjl.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    RelativeLayout rl_dialog;
    int count = 0;
    LoveActivityDialog dialog;
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog = new LoveActivityDialog(MainActivity.this,R.style.dialog);
        //给窗体设置大小
//        Window win = dialog.getWindow();
//        win.getDecorView().setPadding(0, 0, 0, 0);
//        WindowManager.LayoutParams lp = win.getAttributes();
        rl_dialog = findViewById(R.id.rl_dialog);
        findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_dialog.setVisibility(View.VISIBLE);
                count++;
                Log.e("MainActivity", count + "");
            }
        });

        findViewById(R.id.iv_cloes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rl_dialog.setVisibility(View.GONE);
            }
        });


        findViewById(R.id.btn_show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        dialog.setListener(new LoveActivityDialog.CloseListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        findViewById(R.id.btn_show_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoveDialog.class));
            }
        });

    }
}
