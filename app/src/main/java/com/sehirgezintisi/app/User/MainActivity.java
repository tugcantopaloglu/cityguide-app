package com.sehirgezintisi.app.User;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.sehirgezintisi.app.Common.LoginSignUp.LoginActivity;
import com.sehirgezintisi.app.R;

import java.util.Locale;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final float END_SCALE = 0.7f;

    //Drawer menu
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ConstraintLayout contentLayout;

    ImageView menuIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        contentLayout = findViewById(R.id.contentLayout);

        //Menu
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        menuIcon = findViewById(R.id.menu_icon);

        navigationDrawer();

        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                    new MapsFragment()).commit();

            navigationView.setCheckedItem(R.id.nav_explore);

        }
    }


    //navigation drawer functions
    private void navigationDrawer() {
        //navigation drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_explore);

        menuIcon.setOnClickListener(view -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();
    }


    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.blue_gray_700));

        drawerLayout.addDrawerListener(new DrawerLayout.SimpleDrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                //Scale the view
                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentLayout.setScaleX(offsetScale);
                contentLayout.setScaleY(offsetScale);

                //Translate the View
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentLayout.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentLayout.setTranslationX(xTranslation);

            }
        });
    }

    @Override
    public void onBackPressed() {

        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_explore:

                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                        new MapsFragment()).commit();
                break;


            case R.id.nav_profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,
                        new ProfileFragment()).commit();
                break;
            //BURADA ??ALI??MAYAN FONKS??YONLAR YAPILACAK
            case R.id.nav_share:
                Toast.makeText(this, "Bu fonksiyon hen??z i??levsel de??il", Toast.LENGTH_SHORT).show();
                break;

            case R.id.generate_route:
                Toast.makeText(this, "Bu fonksiyon hen??z i??levsel de??il", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_location_to_route:
                Toast.makeText(this, "Bu fonksiyon hen??z i??levsel de??il", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rent_guide:
                Toast.makeText(this, "Bu fonksiyon hen??z i??levsel de??il", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_subscripton:
                Toast.makeText(this, "Bu fonksiyon hen??z i??levsel de??il", Toast.LENGTH_SHORT).show();
                break;
            case R.id.terminate_subscription:
                Toast.makeText(this, "Bu fonksiyon hen??z i??levsel de??il", Toast.LENGTH_SHORT).show();
                break;
            case R.id.transport:
                Toast.makeText(this, "Bu fonksiyon hen??z i??levsel de??il", Toast.LENGTH_SHORT).show();
                break;
            case R.id.get_weather:
                Toast.makeText(this, "Bu fonksiyon hen??z i??levsel de??il", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void addUser(View view) {
        startActivity(new Intent(this, LoginActivity.class));
    }

}