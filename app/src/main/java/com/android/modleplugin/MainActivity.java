package com.android.modleplugin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.basic.base.BaseModule;
import com.android.modleinterface.IModleAPlugin;
import com.android.modleinterface.IModleBPlugin;

public class MainActivity extends AppCompatActivity {
    private Button newActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newActivity=findViewById(R.id.start);
        newActivity.setText("newActivity"+MyApplication.index++);
        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainActivity.class));
            }
        });
        IModleAPlugin iModleAPlugin= BaseModule.getModule(IModleAPlugin.TAG);
        iModleAPlugin.initModleA();
        IModleBPlugin iModleBPlugin= BaseModule.getModule(IModleBPlugin.TAG);
        iModleBPlugin.initModleB();
    }
}
