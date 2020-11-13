package com.example.elbazar.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dvinfosys.model.ChildModel;
import com.dvinfosys.model.HeaderModel;
import com.dvinfosys.ui.NavigationListView;
import com.example.elbazar.Fragment.Fragment_alimentation;
import com.example.elbazar.Fragment.Fragment_electronique;
import com.example.elbazar.Fragment.Fragment_hygiene;
import com.example.elbazar.Fragment.Fragment_promo;
import com.example.elbazar.Fragment_Buttom.Fragment_Compte;
import com.example.elbazar.Fragment_Buttom.Fragment_Home;
import com.example.elbazar.Fragment_Buttom.Fragment_Prametre;
import com.example.elbazar.R;
import com.example.elbazar.Utils.Common;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class Menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ChipNavigationBar bottomNav ;
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private FragmentManager fragmentManager ;

    private NavigationListView listView , listView2;
    private Context context;
    int pendingNotifications = 1 ;
    MenuItem menuItem;
    TextView badgeCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       // toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);






/*

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);



        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new Fragment_alimentation()).commit();
            navigationView.setCheckedItem(R.id.Alimentation);
        }
*/

//////////////////////////////////////////////////////////////////////////////////

       Toolbar toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);

        context = Menu.this;

      //  FloatingActionButton fab = findViewById(R.id.fab);
        /*fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/

        listView = findViewById(R.id.expandable_navigation);
        listView2 = findViewById(R.id.expandable);

        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listView.init(this)
                .addHeaderModel(new HeaderModel("Alimentation" , R.drawable.ic_store ,true )
                        .addChildModel(new ChildModel("Petit déjeuner"))
                        .addChildModel(new ChildModel("Boison"))
                        .addChildModel(new ChildModel("Epicerie"))
                        .addChildModel(new ChildModel("Patisserie ")))
                .addHeaderModel(new HeaderModel("Hygiène",  R.drawable.ic_baseline_sanitizer_24, true,true, false))
                .addHeaderModel(new HeaderModel("Electronique" , R.drawable.ic_baseline_phonelink_24 ,true )
                        .addChildModel(new ChildModel("Smartphone"))
                        .addChildModel(new ChildModel("Ordinateur"))
                        .addChildModel(new ChildModel("Electromenager ")))
                .addHeaderModel(new HeaderModel("Promo" , R.drawable.ic_baseline_point_of_sale_24 ))
                .build()
                .addOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        listView.setSelected(groupPosition);

                        //drawer.closeDrawer(GravityCompat.START);
                     /*  if (id == 0) {
                            //Home Menu
                            Common.showToast(context, "Home Select");

                            drawer.closeDrawer(GravityCompat.START);
                        } else */
                            if (id == 3) {
                            //Cart Menu
                            Common.showToast(context, "Cart Select");
                            drawer.closeDrawer(GravityCompat.START);
                        } /*else if (id == 2) {
                            //Categories Menu
                            Common.showToast(context, "Categories  Select");
                        } else if (id == 3) {
                            //Orders Menu
                            Common.showToast(context, "Orders");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 4) {
                            //Wishlist Menu
                            Common.showToast(context, "Wishlist Selected");
                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 5) {
                            //Notifications Menu
                            Common.showToast(context, "Notifications");
                            drawer.closeDrawer(GravityCompat.START);
                        }*/
                        return false;
                    }
                })
                .addOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        listView.setSelected(groupPosition, childPosition);
                        if (groupPosition == 0 && childPosition == 0) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new Fragment_alimentation()).commit();
                            Common.showToast(context, "0000000");
                            Log.d("//////////////////", String.valueOf(groupPosition)+ "     ************" + childPosition);
                        }
                        else if (groupPosition == 0 && childPosition == 1) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new Fragment_hygiene()).commit();
                            Common.showToast(context, "1111111111111");
                            Log.d("//////////////////", String.valueOf(groupPosition)+ "     ************" + childPosition);
                        } else if (groupPosition == 0 && childPosition == 2) {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    new Fragment_electronique()).commit();
                            Common.showToast(context, "22222222222");
                            Log.d("//////////////////", String.valueOf(groupPosition)+ "     ************" + childPosition);
                        } else if (groupPosition == 0 && childPosition == 3) {
                            Common.showToast(context, "33333333333  Patisserie");
                            Log.d("//////////////////", String.valueOf(groupPosition)+ "     ************" + childPosition);
                        } else if (groupPosition == 2 && childPosition == 0) {
                            Common.showToast(context, "4444444444444   Smartphone ");
                            Log.d("//////////////////", String.valueOf(groupPosition)+ "     ************" + childPosition);
                        } else if (groupPosition == 2 && childPosition == 1) {
                            Common.showToast(context, "55555555555");
                            Log.d("//////////////////", String.valueOf(groupPosition)+ "     ************" + childPosition);
                        } else if (groupPosition == 2 && childPosition == 2) {
                            Common.showToast(context, "6666666666");
                        }

                        drawer.closeDrawer(GravityCompat.START);
                        return false;
                    }
                });
       // listView.expandGroup(2);


        listView2.init(this)
                .addHeaderModel(new HeaderModel("Settings" ,R.drawable.ic_baseline_local_post_office_24))
                .addHeaderModel(new HeaderModel("Log Out",R.drawable.ic_baseline_power_settings_new_24))

                .build()
                .addOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
                    @Override
                    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                        listView2.setSelected(groupPosition);

                        //drawer.closeDrawer(GravityCompat.START);
                        if (id == 0) {
                            //Home Menu
                            Common.showToast(context, "Home Select");

                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 1) {
                            //Cart Menu
                            Common.showToast(context, "Cart Select");
                            drawer.closeDrawer(GravityCompat.START);
                        }
                        return false;
                    }
                })
                .addOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        listView2.setSelected(groupPosition, childPosition);

                        drawer.closeDrawer(GravityCompat.START);
                        return false;
                    }
                });

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Fragment_Home()).commit();
        navigationView.setCheckedItem(R.id.Alimentation);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
/*
        switch (item.getItemId()) {
            case R.id.Alimentation:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_alimentation()).commit();
                break;
            case R.id.hygiene:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_hygiene()).commit();
                break;
            case R.id.electronique:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_electronique()).commit();
                break;
            case R.id.Promo:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new Fragment_promo()).commit();
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;


        }
        */

        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);



      //  drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu, menu);
       // getMenuInflater().inflate(R.menu.main, menu);


        MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {

            // recherche
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                // recherche
                return true;
            }
        };
        menu.findItem(R.id.search).setOnActionExpandListener(onActionExpandListener);




        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setQueryHint("data ....");


        menuItem = menu.findItem(R.id.shop);




        if (pendingNotifications == 0) {
            // if no pending notification remove badge
            menuItem.setActionView(null);
        } else {

            // if notification than set the badge icon layout
            menuItem.setActionView(R.layout.notification_badge);
            // get the view from the nav item
            View view = menuItem.getActionView();
            // get the text view of the action view for the nav item
            badgeCounter = view.findViewById(R.id.badge_counter);
            // set the pending notifications value
            badgeCounter.setText(String.valueOf(pendingNotifications));
            badgeCounter.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("il n y a pas de loi ici", "*****: ");
                }
            });
        }





        return true;
    }

    //////////////////////////////////////////////////////////////////////////////

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

           int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.shop) {
            return true;
        }

        return super.onOptionsItemSelected(item);


    }


}