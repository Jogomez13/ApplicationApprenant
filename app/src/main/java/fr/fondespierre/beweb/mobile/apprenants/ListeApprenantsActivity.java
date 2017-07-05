package fr.fondespierre.beweb.mobile.apprenants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

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

        ListView listeApprenant = (ListView) findViewById(R.id.la_listView_apprenants);

        JSONArray listeData = null;

        try {
            listeData = Data.getApprenants();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ListeApprenantAdapter adapter = new ListeApprenantAdapter(this,0,listeData);

        listeApprenant.setAdapter(adapter);


    }
}