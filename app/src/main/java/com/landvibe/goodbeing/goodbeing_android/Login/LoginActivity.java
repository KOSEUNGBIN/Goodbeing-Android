package com.landvibe.goodbeing.goodbeing_android.Login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.landvibe.goodbeing.goodbeing_android.FAQ.FaqActivity;
import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.Main.MainActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

public class LoginActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener{

    private Intent intent;
    private EditText LoginActivity_id_et;
    private EditText LoginActivity_pw_et;
    private Button LoginActivity_ok_btn;
    private Button LoginActivity_cancle_btn;
    private SharedPreferences msharedpreferences;
    private SharedPreferences.Editor speditor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        LoginActivity_id_et = (EditText) findViewById(R.id.id_et);
         LoginActivity_pw_et = (EditText) findViewById(R.id.pw_et);
         LoginActivity_ok_btn =  (Button) findViewById(R.id.ok_btn);
         LoginActivity_cancle_btn = (Button) findViewById(R.id.cancle_btn);

        LoginActivity_ok_btn.setOnClickListener(this);
        LoginActivity_cancle_btn.setOnClickListener(this);

        msharedpreferences = getSharedPreferences("msharedpreferences",MODE_PRIVATE);
        speditor = msharedpreferences.edit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        intent = new Intent();

        if (id == R.id.nav_intro) {
            intent.setClassName(this , IntroActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_history) {
            intent.setClassName(this , HistoryActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_surveyWrite) {
            intent.setClassName(this , SurveySearchActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_sample) {
            intent.setClassName(this , SampleMainActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_consulting) {
            intent.setClassName(this , LoginActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_faq) {
            intent.setClassName(this , FaqActivity.class.getName());
            startActivity(intent);
        }
        else if(id == R.id.nav_login)
        {
            intent.setClassName(this , LoginActivity.class.getName());
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        int idx = 0;
        intent = new Intent();
        if(view.getId() == R.id.ok_btn)
        {
            String mID = LoginActivity_id_et.getText().toString();
            String mPW = LoginActivity_pw_et.getText().toString();

            LoginConnectServer LCS = new LoginConnectServer();
            idx =  LCS.requestLogin(mID,mPW);

            //idx cookie 로그인 유지//
            if(idx==0)
            {
            speditor.putInt("IDX",idx);
            speditor.commit();
            }
            else
            {
                //IDX를 불러오고 해당값이 없을경우 리턴 0
                idx = msharedpreferences.getInt("IDX",0);
            }
            //shared 데이터 삭제
//            speditor.remove("IDX");
//            speditor.commit();

            Intent intent = new Intent(this , MainActivity.class);
            intent.putExtra("IDX",idx);
            startActivity(intent);
        }
        else if(view.getId() == R.id.cancle_btn)
        {
            Intent intent = new Intent(this , MainActivity.class);
            startActivity(intent);
        }
    }




}