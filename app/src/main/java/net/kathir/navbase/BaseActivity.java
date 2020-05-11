package net.kathir.navbase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class BaseActivity extends AppCompatActivity  implements BottomNavigationView.OnNavigationItemSelectedListener{

    private static final String TAG = BaseActivity.class.getSimpleName();
    private DrawerLayout dl;
    private ActionBarDrawerToggle t;
    private NavigationView nv;
    public Context mContext;
    Menu nav_Menu;
    protected BottomNavigationView bottomNavigationView;
    FloatingActionButton floatingActionButton;
    TextView header_title;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dl = (DrawerLayout) findViewById(R.id.drawer_layout);

        t = new ActionBarDrawerToggle(this, dl, toolbar, R.string.open, R.string.close);
        dl.setDrawerListener(t);

        nv = (NavigationView) findViewById(R.id.nav_drawer);
        dl.setScrimColor(Color.TRANSPARENT);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_home:
                        Intent intent1 = new Intent(BaseActivity.this,MainActivity.class);
                        intent1.putExtra("page_from","base_nav");
                        startActivity(intent1);
                        finish();
                        break;
                    case R.id.page1:

                        Intent intent2 = new Intent(BaseActivity.this,PageOneActivity.class);
                        intent2.putExtra("page_from","base_nav");
                        startActivity(intent2);
                        finish();
                        break;

                    case R.id.page2:

                        Intent intent3 = new Intent(BaseActivity.this,PageTwoActivity.class);
                        intent3.putExtra("page_from","base_nav");
                        startActivity(intent3);
                        finish();
                        break;
                    case R.id.page3:
                        Intent intent4 = new Intent(BaseActivity.this,PageThreeActivity.class);
                        intent4.putExtra("page_from","base_nav");
                        startActivity(intent4);
                        finish();
                        break;
                    case R.id.page4:
                        Intent intent5 = new Intent(BaseActivity.this,PageFourActivity.class);
                        intent5.putExtra("page_from","base_nav");
                        startActivity(intent5);
                        finish();
                        break;

                    default:
                        return true;
                }

                dl.closeDrawer(GravityCompat.START);
                return true;

            }
        });


        bottomNavigationView= (BottomNavigationView) findViewById(R.id.bottomNav);
        floatingActionButton=findViewById(R.id.fab);
        nv=findViewById(R.id.nav_drawer);

        bottomNavigationView.getMenu().findItem(R.id.base1).setChecked(true);



        bottomNavigationView.clearAnimation();
        bottomNavigationView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setItemIconTintList(null);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // SOSBtnClicked();
                //startActivity(new Intent(this, SecondActivity.class));
            }
        });

        header_title=nv.getHeaderView(0).findViewById(R.id.header_title);

        String styleText="<big><font color='#ffcc00'>NavBase</font></big>";
        header_title.setText(Html.fromHtml(styleText), TextView.BufferType.SPANNABLE);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.base1:

                Intent intent = new Intent(BaseActivity.this,PageOneActivity.class);
                intent.putExtra("page_from","base_activity");
                startActivity(intent);
                finish();
                break;
            case R.id.base2:

                Intent intent1 = new Intent(BaseActivity.this,PageTwoActivity.class);
                intent1.putExtra("page_from","base_activity");
                startActivity(intent1);
                finish();
                break;

            case R.id.base3:

                Intent intent2 = new Intent(BaseActivity.this,PageThreeActivity.class);
                intent2.putExtra("page_from","base_activity");
                startActivity(intent2);
                finish();
                break;

            case R.id.base4:

                Intent intent3 = new Intent(BaseActivity.this,PageFourActivity.class);
                intent3.putExtra("page_from","base_activity");
                startActivity(intent3);
                finish();
                break;

        }

        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        t.syncState();

    }

    @Override
    protected void onResume() {
        super.onResume();
        nav_Menu = nv.getMenu();

    }
}
