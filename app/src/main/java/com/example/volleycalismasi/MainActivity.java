package com.example.volleycalismasi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText ad,tel;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ad=findViewById(R.id.editTextAd);
        tel=findViewById(R.id.editTextTel);

        button=findViewById(R.id.button);

        //kisiGuncelle();
        //kisiSil();
        //tumKisiler();
        kisiArama();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kisiEkle();
            }
        });


    }

    public void kisiEkle(){
        String url="http://mxbinteractive.com/QR/insert_kisiler.php";

        StringRequest istek=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("kisi_ad",ad.getText().toString());
                params.put("kisi_tel",tel.getText().toString());

                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);
        Toast.makeText(this, "Eklendi..", Toast.LENGTH_SHORT).show();

    }




    public void kisiGuncelle(){
        String url="http://mxbinteractive.com/QR/update_kisiler.php";

        StringRequest istek=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("kisi_id","13");
                params.put("kisi_ad","KamilLLLLLLL");
                params.put("kisi_tel","21474836471111111111");

                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);
    }
    public void kisiSil(){
        String url="http://mxbinteractive.com/QR/delete_kisiler.php";

        StringRequest istek=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap",response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();
                params.put("kisi_id","13");

                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);
    }

    public void tumKisiler(){
        String url="http://mxbinteractive.com/QR/tum_kisiler.php";

        StringRequest istek=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap",response);

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray kisilerListe=jsonObject.getJSONArray("kisiler");

                    for (int i=0;i<kisilerListe.length();i++){
                        JSONObject k =kisilerListe.getJSONObject(i);

                        int kisi_id=k.getInt("kisi_id");
                        String kisi_ad=k.getString("kisi_ad");
                        String kisi_tel=k.getString("kisi_tel");

                        Log.e("kisi_id",String.valueOf(kisi_id));
                        Log.e("kisi_ad",kisi_ad);
                        Log.e("kisi_tel",kisi_tel);
                        Log.e("*******","********");
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        Volley.newRequestQueue(this).add(istek);
    }


    public void kisiArama(){
        String url="http://mxbinteractive.com/QR/tum_kisiler_arama.php";

        StringRequest istek=new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Cevap",response);

                try {
                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray kisilerListe=jsonObject.getJSONArray("kisiler");

                    for (int i=0;i<kisilerListe.length();i++){
                        JSONObject k =kisilerListe.getJSONObject(i);

                        int kisi_id=k.getInt("kisi_id");
                        String kisi_ad=k.getString("kisi_ad");
                        String kisi_tel=k.getString("kisi_tel");

                        Log.e("kisi_id",String.valueOf(kisi_id));
                        Log.e("kisi_ad",kisi_ad);
                        Log.e("kisi_tel",kisi_tel);
                        Log.e("*******","********");
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<>();

                params.put("kisi_ad","e");

                return params;
            }
        };

        Volley.newRequestQueue(this).add(istek);
    }



}