package net.kathir.navbase;
import android.os.Bundle;
import android.widget.FrameLayout;


public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.activity_content); //Remember this is the FrameLayout area within your activity_main.xml
        getLayoutInflater().inflate(R.layout.activity_main, contentFrameLayout);

//        ActionBar actionBar=getSupportActionBar();
//        actionBar.setTitle(Html.fromHtml("<big><font color='#ffcc00'>all</font><font color='#25a3d6'>Geo</font></big>"));

       //setContentView(R.layout.activity_main);
    }
}
