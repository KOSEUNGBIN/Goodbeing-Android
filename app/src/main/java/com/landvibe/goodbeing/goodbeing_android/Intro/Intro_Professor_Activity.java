package com.landvibe.goodbeing.goodbeing_android.Intro;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;

/**
 * Created by user on 2017-07-17.
 */

public class Intro_Professor_Activity extends IntroActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private String story;
    private String link;

    private TextView intro_professor_text_1;
    private TextView intro_text_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introprofessor);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        story = "대표 양미희: 전 서울대 예방의학교실 조교수;현 숙대 약대 독성학, 미국 독성학전문가보드보유(D. ABT),   교수20여년 유해물질 분석, 환경호르몬  bisphenol A에 대한 한국인에서 인체노출과 독성에 관한 다수의 국제 우수논문발표\n" +
                "도와주시는 분들: " +
                "호흡기전문의사, 소화기암전문의사, 소아과의사, 약사, 사상의학 한의사, 인체시료에 관한 윤리법 전문가, 영양학 교수, 사회심리전문가, IT과 교수 및 IT전문회사, \n";

        link = "web : www.naver.com \nemail : ajtnlaka456@naver.com\n" +
                "phone : 010-8873-9215 \nmap : 서울특별시 송파구 법원로11길 7 문정현대지식산업센터 C동 1107호";

        intro_professor_text_1 = (TextView) findViewById(R.id.intro_professor_text_1);
        intro_text_link = (TextView) findViewById(R.id.intro_text_link);

        intro_professor_text_1.setText(story);
        intro_text_link.setText(link);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_intro) {

        } else if (id == R.id.nav_history) {

        } else if (id == R.id.nav_surveyWrite) {

        } else if (id == R.id.nav_measure) {

        } else if (id == R.id.nav_consulting) {

        } else if (id == R.id.nav_faq) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }
}
