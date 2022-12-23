package com.sehirgezintisi.app.Common.LoginSignUp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.sehirgezintisi.app.HelperClasses.Adapters.LoginAdapter;
import com.sehirgezintisi.app.R;
import com.sehirgezintisi.app.User.MainActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TabLayout tabLayout;
    ViewPager2 viewPager;
    RelativeLayout layout1, layout2, layout3;
    ImageView google;
    Button close;

    Animation fab_anim;

    SharedPreferences showSkip;

    boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        layout1 = findViewById(R.id.fb_layout);
        layout2 = findViewById(R.id.google_layout);
        layout3 = findViewById(R.id.twi_layout);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        google = findViewById(R.id.fab_google);
        close = findViewById(R.id.login_close);

        tabLayout.addTab(tabLayout.newTab().setText("Giriş Yap"));
        tabLayout.addTab(tabLayout.newTab().setText("Kayıt Ol"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //animation
        fab_anim = AnimationUtils.loadAnimation(this, R.anim.social_media_fab_anim);
        layout1.setAnimation(fab_anim);
        layout2.setAnimation(fab_anim);
        layout3.setAnimation(fab_anim);
        tabLayout.setAnimation(fab_anim);

        //adapter
        LoginAdapter adapter = new LoginAdapter(this);
        viewPager.setAdapter(adapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        showSkip = getSharedPreferences("showSkip", MODE_PRIVATE);
        firstTime = showSkip.getBoolean("firstTime", true);

        close.setOnClickListener(this);

        if (firstTime) {
            showSkip.edit().putBoolean("firstTime", false).apply();
            close.setText(getResources().getString(R.string.skip_btn));
        }

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onClick(View v) {
        if (v == close){
            if (firstTime){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
            finish();
        }
    }
}