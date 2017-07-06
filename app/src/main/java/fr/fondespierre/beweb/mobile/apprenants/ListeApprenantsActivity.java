package fr.fondespierre.beweb.mobile.apprenants;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import fr.fondespierre.beweb.mobile.apprenants.adapters.ListeApprenantAdapter;
import fr.fondespierre.beweb.mobile.apprenants.dal.Data;

public class ListeApprenantsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liste_apprenants);

        final ListView listeApprenant = (ListView) findViewById(R.id.la_listView_apprenants);
        final JSONArray listeData = null;
        final Activity activity = this;


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="http://192.168.1.48/beweb_api/index.php/";

        // Request a string response from the provided URL.
        JsonArrayRequest jaRequest = new JsonArrayRequest(Request.Method.GET, url+"apprenants",listeData,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ListeApprenantAdapter adapter = new ListeApprenantAdapter(activity,R.layout.liste_apprenant_item,response);

                        listeApprenant.setAdapter(adapter);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        // Add the request to the RequestQueue.
        queue.add(jaRequest);
    }
}