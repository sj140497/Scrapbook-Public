package uk.ac.tees.p4136175.scrapbook;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ListView;

public class HelpPage extends AppCompatActivity {

    Toolbar myToolbar;

    NavigationView nv;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    // This class
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_page);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar4);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nv = (NavigationView) findViewById(R.id.nv4);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_help_page);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_adventures:
                        Intent intent3 = new Intent(context, HomeScreen.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_Atlas:
                        Intent intent = new Intent(context, AtlastActivity.class);
                        startActivity(intent);
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.nav_calendar:
                        mDrawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.nav_images:
                        Intent intent4 = new Intent(context, AdventureList.class);
                        startActivity(intent4);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;

        }
        return super.onOptionsItemSelected(item);
    }
}