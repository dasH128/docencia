package com.climper.docenciaapp.ui.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.view.fragment.course_fragment;
import com.climper.docenciaapp.ui.view.fragment.gesto_eg1_fragment;
import com.climper.docenciaapp.ui.view.fragment.gesto_eg2_fragment;
import com.climper.docenciaapp.ui.view.fragment.gesto_inform_fragment;
import com.climper.docenciaapp.ui.view.fragment.location_fragment;
import com.climper.docenciaapp.ui.view.fragment.tabla_acm_fragment;
import com.climper.docenciaapp.ui.view.fragment.tabla_peso_fragment;
import com.climper.docenciaapp.ui.view.fragment.tabla_umbilical_fragment;
import com.climper.docenciaapp.ui.view.fragment.tabla_uterina_fragment;

public class GestoActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private String drawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesto);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_gesto);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_gesto);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        drawerTitle = getResources().getString(R.string.menu_course_item);
        if (savedInstanceState == null) {
            selectItem(drawerTitle);
        }



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {

                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Marcar item presionado
                        menuItem.setChecked(true);
                        // Crear nuevo fragmento
                        String title = menuItem.getTitle().toString();

                        selectItem(title);
                        return true;
                    }
                }
        );
    }

    private void selectItem(String title) {
        // Enviar título como arguemento del fragmento

        if(title.equals(""+getResources().getString(R.string.name_item))){
            /*getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_gesto, new G_Name_Fragment())
                    .commit();*/
        }else if(title.equals(""+getResources().getString(R.string.week_item))){

        }else if(title.equals(""+getResources().getString(R.string.info_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_gesto, new gesto_inform_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.menu_course_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_gesto, new course_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.EG_1_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_gesto, new gesto_eg1_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.EG_2_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_gesto, new gesto_eg2_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.uterinas_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_gesto, new tabla_uterina_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.umbilical_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_gesto, new tabla_umbilical_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.acm_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_gesto, new tabla_acm_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.menu_web1_item))){
            Toast.makeText(getApplication(), "Bienvenido", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.climper.com.pe"));
            startActivity(intent);
        }else if(title.equals(""+getResources().getString(R.string.menu_web2_item))){
            Toast.makeText(getApplication(),"Bienvenido",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.ecografia4d.com.pe"));
            startActivity(intent);
        }else if(title.equals(""+getResources().getString(R.string.peso_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_gesto, new tabla_peso_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.back_item))){

            finish();
        }
        drawerLayout.closeDrawers(); // Cerrar drawer
        setTitle(title); // Setear título actual
    }
}