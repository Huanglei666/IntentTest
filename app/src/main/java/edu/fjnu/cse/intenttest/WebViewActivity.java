package edu.fjnu.cse.intenttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Button button_toWebView = (Button) this.<View>findViewById(R.id.button_tobrowse);
        button_toWebView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editText_URL);
                String uri = editText.getText().toString();

                if (Patterns.WEB_URL.matcher(uri).matches()) {
                    WebView webView = (WebView) findViewById(R.id.webView);
                    webView.getSettings().setJavaScriptEnabled(true);
                    webView.setWebViewClient(new WebViewClient());
                    webView.loadUrl(uri);

                } else {
                    Toast.makeText(WebViewActivity.this, "uri地址不合法", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}