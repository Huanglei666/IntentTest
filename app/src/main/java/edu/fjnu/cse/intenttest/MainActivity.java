package edu.fjnu.cse.intenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_toIntent = (Button) this.<View>findViewById(R.id.button_IntentView);
        button_toIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, IntentActivity.class);
                startActivity(i);
            }
        });

        Button button_toWebView = (Button) this.<View>findViewById(R.id.button_WebView);
        button_toWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WebViewActivity.class);
                //startActivity(i);
                startActivity(Intent.createChooser(i, "请选择浏览器"));
                i.setClassName("com.android.browser","com.android.browser.BrowserActivity");
                i.setClassName("edu.fjnu.cse.intenttest","com.android.browser.WebViewActivity");
            }
        });

    }
}
