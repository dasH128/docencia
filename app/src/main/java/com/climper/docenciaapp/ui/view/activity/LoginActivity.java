package com.climper.docenciaapp.ui.view.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
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

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText user;
    private TextInputEditText pass;
    private Button btn;
    private BdHelper helper;
    private SQLiteDatabase db;
    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        helper = new BdHelper(this,BdHelper.DB_NAME,null,BdHelper.DB_SCHEME_VERSION);
        db = helper.getWritableDatabase();

        user = (TextInputEditText) findViewById(R.id.text_user_usuario);
        pass = (TextInputEditText) findViewById(R.id.text_user_password);
        btn = (Button) findViewById(R.id.btn_user_login);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user.getText().toString().equals("") && pass.getText().toString().equals("")  ){
                    Toast.makeText(LoginActivity.this,"Completar Todos Los Datos",Toast.LENGTH_SHORT).show();
                }else{
                    URL="http://www.climper.com.pe/APIv2.0/LoginDocencia.php?username="+user.getText().toString();
                    Login2();
                }
            }
        });
    }



    public void Login2(){
        RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
        final ProgressDialog progressDialog = ProgressDialog.show(LoginActivity.this, "Espere porfavor", "Estamos atendiendo su solicitud");

        JsonArrayRequest request = new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.e("TAG_LOGINACTIVITY", "onResponse: " + response.toString());
                progressDialog.cancel();

                try {
                    for (int i=0; i<response.length(); i++){
                        JSONObject JsonLoogin = (JSONObject) response.get(i);

                        String bd_id = JsonLoogin.getString("id");
                        //String bd_nombre = JsonLoogin.getString("nombres");
                        //String bd_codigo = JsonLoogin.getString("cod_ecober");;

                        ReguistrarDatosBDHelper(bd_id,"nom","cod");
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
    private void ReguistrarDatosBDHelper(String id, String nombre, String codigo){
        //helper = new BdHelper(this,BdHelper.DB_NAME,null,BdHelper.DB_SCHEME_VERSION);
        //db = helper.getWritableDatabase();
        Log.e("TAG_LOGINACTIVITY","  Registrando "+id+", "+nombre+", "+codigo);
        db.insert(BdHelper.TABLE_NAME,null,GenerarContentValues(id,nombre,codigo));
        helper.close();
        Intent i = new Intent(this,GestoActivity.class);
        startActivity(i);
    }

    private ContentValues GenerarContentValues(String id, String nombre, String codigo) {
        ContentValues valores = new ContentValues();
        valores.put(BdHelper.CN_DIA,0);
        valores.put(BdHelper.CN_MES,0);
        valores.put(BdHelper.CN_ANIO,0);
        valores.put(BdHelper.CN_IDUSER, "" + id);
        valores.put(BdHelper.CN_NOMBRE_USER,""+nombre);
        valores.put(BdHelper.CN_CODIGO,""+codigo);
        valores.put(BdHelper.CN_NOMBRE_BEBE,"");
        valores.put(BdHelper.CN_DESCRIPCION, "logueo");
        valores.put(BdHelper.CN_ESTADO, "activo");
        Log.e("id insertado: ", "id es: "+id);
        return valores;
    }

    public void goCreateAccount(View view){
        Intent intent = new Intent(this, CrearCuentaActivity.class);
        startActivity(intent);
    }
}
