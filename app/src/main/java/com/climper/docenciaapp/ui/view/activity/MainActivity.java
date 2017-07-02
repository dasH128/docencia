package com.climper.docenciaapp.ui.view.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.model.BdHelper;
import com.climper.docenciaapp.ui.view.fragment.course_fragment;
import com.climper.docenciaapp.ui.view.fragment.location_fragment;

public class MainActivity extends AppCompatActivity {
    BdHelper helper;
    private SQLiteDatabase db;
    private DrawerLayout drawerLayout;
    private String drawerTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        helper = new BdHelper(this, BdHelper.DB_NAME, null, BdHelper.DB_SCHEME_VERSION);
        db=helper.getReadableDatabase();
        Cursor fila = db.rawQuery("SELECT * FROM datos WHERE descripcion ='logueo'", null);

        int TipoUser=0;
        if(fila.moveToFirst()){
            TipoUser = 1;
            Log.e("DBHelper ACCESS", "!=: ya fue creado ");
        }else{
            Log.e("DBHelper ERROR", " =0: falta crear");
            TipoUser = 0;
        }
        //TipoUser = 1;
        if(TipoUser==0) {
            Log.e("abrir", " login");
            startActivity(new Intent(this, LoginActivity.class));
        }else{
            setContentView(R.layout.activity_main);
            Thread mythread = new Thread(){
                @Override
                public void run() {
                    try {
                        sleep(1500);
                        Log.e("abrir", " MEnu");
                        Intent i = new Intent(getApplicationContext(), GestoActivity.class);
                        startActivity(i);
                        finish();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    super.run();
                }
            };
            mythread.start();
        }
        /*if(TipoUser==1){
            //setContentView(R.layout.activity_main);
        }*/


        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            // Poner ícono del drawer toggle
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_alumno);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_docencia);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        drawerTitle = ""+getResources().getString(R.string.menu_course_item);
        if (savedInstanceState == null) {
            selectItem(drawerTitle);
        }*/
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    /*public void setupDrawerContent(NavigationView navigationView){
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
    }*/

    /*private void selectItem(String title) {

        if(title.equals("" + getResources().getString(R.string.menu_gestogram_item))){
            Intent i =new Intent(this, GestoActivity.class);
            startActivity(i);
        }else if(title.equals(""+getResources().getString(R.string.menu_course_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_docencia, new course_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.menu_location_item))){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_content_docencia, new location_fragment())
                    .commit();
        }else if(title.equals(""+getResources().getString(R.string.menu_web1_item))){
            Toast.makeText(getApplication(), "Bienvenido", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.ecografia4d.com.pe"));
            startActivity(intent);
        }else if(title.equals(""+getResources().getString(R.string.menu_web2_item))){
            Toast.makeText(getApplication(),"Bienvenido",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.climper.com.pe"));
            startActivity(intent);
        }else if(title.equals(""+getResources().getString(R.string.menu_logout_item))){
            ConfirmarSalida();
        }

        drawerLayout.closeDrawers(); // Cerrar drawer
        setTitle(title); // Setear título actual
    }*/

    /*private void ConfirmarSalida(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("¿Desea cerrar sesión?")
                .setTitle("Advertencia")
                .setCancelable(false)
                .setNegativeButton("Cancelar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Log.i("select ", " cancelar");
                                dialog.cancel();
                            }
                        })
                .setPositiveButton("Continuar",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Cambiar el tipBD de usuario a 0
                                BdHelper helper = new BdHelper(MainActivity.super.getApplication(), BdHelper.DB_NAME, null, BdHelper.DB_SCHEME_VERSION);
                                db = helper.getWritableDatabase();
                                db.execSQL("UPDATE datos SET tipo='0',iduser=''  WHERE descripcion='logueo'");
                                helper.close();
                                Log.i("select ", " continuar");
                                Intent datos = new Intent();
                                datos.setData(Uri.parse("3"));
                                setResult(RESULT_OK, datos);
                                finish();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }*/

}