package com.rootup.friendzoo.friendzoo.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.rootup.friendzoo.friendzoo.R;


public class BaseDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static DrawerLayout drawer;

    void initToolbar(String title){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        toolbar.setTitle(title);
        toolbar.setTitleTextColor(getResources().getColor(R.color.color_primary));


        setSupportActionBar(toolbar);


        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);



        toggle.syncState();
        toolbar.setNavigationIcon(R.drawable.toolbar_nav_icon);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        headerView.findViewById(R.id.btn_beauty).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, BeautyActivity.class));
            }
        });

        headerView.findViewById(R.id.btn_shop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, ShopActivity.class));
            }
        });

        headerView.findViewById(R.id.btn_walk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, WalkActivity.class));
            }
        });

        headerView.findViewById(R.id.btn_education).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, EducationActivity.class));
            }
        });

        headerView.findViewById(R.id.btn_adopt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, AdoptActivity.class));
            }
        });


        headerView.findViewById(R.id.btn_sell).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, SellActivity.class));
            }
        });


        headerView.findViewById(R.id.btn_hospital).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, HospitalActivity.class));
            }
        });

        headerView.findViewById(R.id.btn_memories_album).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, MemoriesAlbumActivity.class));
            }
        });

        headerView.findViewById(R.id.btn_community).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, CommunityActivity.class));
            }
        });

        headerView.findViewById(R.id.btn_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        headerView.findViewById(R.id.btn_webtoon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BaseDrawerActivity.this, WebtoonActivity.class));
            }
        });

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
        MenuInflater inflater = BaseDrawerActivity.this.getMenuInflater();
        inflater.inflate(R.menu.toolbar_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                startActivity(new Intent(BaseDrawerActivity.this, SearchActivity.class));

                return true;
            case R.id.action_alarm:
                startActivity(new Intent(BaseDrawerActivity.this, AlarmActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

//        if (id == R.id.btn_beauty) {
//            // Handle the camera action
//            startActivity(new Intent(BaseDrawerActivity.this, BeautyActivity.class));
//        }
//        else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
