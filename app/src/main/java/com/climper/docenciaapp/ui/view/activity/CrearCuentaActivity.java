package com.climper.docenciaapp.ui.view.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.climper.docenciaapp.R;
import com.climper.docenciaapp.ui.model.BdHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CrearCuentaActivity extends Activity {
    private TextInputEditText name,ape, dni, mail,tel;
    private Button btn;
    private BdHelper helper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
        name = (TextInputEditText) findViewById(R.id.cuenta_nombre);
        ape = (TextInputEditText) findViewById(R.id.cuenta_apellido);
        dni = (TextInputEditText) findViewById(R.id.cuenta_dni);
        mail = (TextInputEditText) findViewById(R.id.cuenta_correo);
        tel = (TextInputEditText) findViewById(R.id.cuenta_celular);
        btn = (Button) findViewById(R.id.btn_user_crear);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean val= true;
                if (name.getText().toString().equals("")){ val=false;}
                if (ape.getText().toString().equals("")){val=false;}
                if (dni.getText().toString().equals("")){val=false;}
                if (mail.getText().toString().equals("")){val=false;}
                if (tel.getText().toString().equals("")){val=false;}
                if( val==false){
                    Toast.makeText(CrearCuentaActivity.this,"Completar Todos Los Datos",Toast.LENGTH_SHORT).show();
                }else{
                    ValidarDNI(dni.getText().toString());
                }
            }
        });
    }

    void ValidarDNI(String dni){
        Log.i("izi", "validar dni");
        final ProgressDialog progressDialog = ProgressDialog.show(CrearCuentaActivity.this, "Espere porfavor", "Estamos atendiendo su solicitud");
        String URL = "http://www.climper.com.pe/APIv2.0/DocenteValidar.php?dni="+dni;
        Log.i("ruta", "url: "+URL);
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i("Validar DNI", "onResponse: "+response);
                progressDialog.cancel();
                try {
                    for (int i=0; i<response.length(); i++){
                        JSONObject JsonValidarDni = (JSONObject) response.get(i);

                        String bd_status = JsonValidarDni.getString("status");
                        if(bd_status.equals("libre")){
                            Registrar();// registrar el usuario
                        }else{
                            Toast.makeText(CrearCuentaActivity.this,"Este usuario ya Existe",Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Validar DNI", "onErrorResponse: "+error);
                progressDialog.cancel();
            }
        });

        queue.add(request);

    }

    void Registrar(){


        String URL = "http://www.climper.com.pe/APIv2.0/DocenteNew.php?name="+name.getText().toString()+"&ape="+ape.getText().toString()+"&dni="+dni.getText().toString()+"&mail="+mail.getText().toString()+"&tel="+tel.getText().toString();
        Log.i("izi", "registrar "+URL);
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i("CreateAccount", "onResponse: "+response);
                AlmacenarPacieente();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("CreateAccount", "onErrorResponse: "+error);
            }
        });

        queue.add(request);

    }

    void AlmacenarPacieente(){
        Log.i("izi", " AlmacenarPacieente xD");
        RequestQueue queue = Volley.newRequestQueue(CrearCuentaActivity.this);
        final ProgressDialog progressDialog = ProgressDialog.show(CrearCuentaActivity.this, "Espere porfavor", "Estamos atendiendo su solicitud");
        String URL="http://www.climper.com.pe/APIv2.0/LoginDocencia.php?username="+tel.getText().toString();
        JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("TAG_CreateAccount", "onResponse: " + response.toString());
                progressDialog.cancel();

                try {
                    for (int i=0; i<response.length(); i++){
                        JSONObject JsonLoogin = (JSONObject) response.get(i);

                        String bd_id = JsonLoogin.getString("id");


                        ReguistrarDatosBDHelper(bd_id);
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG_LOGINACTIVITY",error.toString());
                progressDialog.cancel();
            }
        });

        queue.add(request);


    }

    private void ReguistrarDatosBDHelper(String id){
        helper = new BdHelper(this,BdHelper.DB_NAME,null,BdHelper.DB_SCHEME_VERSION);
        db = helper.getWritableDatabase();
        Log.e("Ubicacion","  Registrando "+id);
        db.insert(BdHelper.TABLE_NAME,null,GenerarContentValues(id));
        helper.close();
        Intent i = new Intent(this,GestoActivity.class);
        startActivity(i);
    }

    private ContentValues GenerarContentValues(String id) {
        ContentValues valores = new ContentValues();
        valores.put(BdHelper.CN_DIA,0);
        valores.put(BdHelper.CN_MES,0);
        valores.put(BdHelper.CN_ANIO,0);
        valores.put(BdHelper.CN_IDUSER, "" + id);
        valores.put(BdHelper.CN_NOMBRE_USER,""+name);
        valores.put(BdHelper.CN_CODIGO," ");
        valores.put(BdHelper.CN_NOMBRE_BEBE,"");
        valores.put(BdHelper.CN_DESCRIPCION, "logueo");
        valores.put(BdHelper.CN_ESTADO, "activo");
        Log.e("id insertado: ", "id es: "+id);
        return valores;
    }
}
