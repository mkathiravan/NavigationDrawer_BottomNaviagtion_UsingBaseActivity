package net.kathir.navbase;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

public class PageTwoActivity extends BaseActivity {

    TextView textView;
    String page_from;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.activity_content); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);

        //setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.text_view);

        try {
            Intent intent = getIntent();
            page_from = intent.getStringExtra("page_from");

            if(page_from.equals("base_activity"))
            {
                textView.setText("Base Two Activity");
            }
            else if(page_from.equals("base_nav"))
            {
                textView.setText("Page Two Activity");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
