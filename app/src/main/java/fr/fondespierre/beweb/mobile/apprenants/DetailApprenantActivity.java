package fr.fondespierre.beweb.mobile.apprenants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespierre.beweb.mobile.apprenants.adapters.ListeApprenantAdapter;
import fr.fondespierre.beweb.mobile.apprenants.adapters.ListeProjetAdapter;
import fr.fondespierre.beweb.mobile.apprenants.adapters.ListeSkillAdapter;
import fr.fondespierre.beweb.mobile.apprenants.dal.Data;

import static fr.fondespierre.beweb.mobile.apprenants.dal.Data.apprenant;

public class DetailApprenantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_apprenant);


        try {

            // create json array and get the data of apprenant
            JSONObject apprenant = Data.apprenant;

            // Set text values in the field corresponding with the ID
            ((TextView)findViewById(R.id.da_textView_nom)).setText(apprenant.getString("nom"));
            ((TextView)findViewById(R.id.da_textView_prenom)).setText(apprenant.getString("prenom"));
            ((TextView)findViewById(R.id.da_textView_age)).setText(apprenant.getString("age"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        // set listview with the skills values in the field corresponding with the ID
        ListView listeSkills = (ListView) findViewById(R.id.da_listView_skills);
        ListView listeProjets = (ListView) findViewById(R.id.da_listView_projets);


        ListeSkillAdapter skillAdapter = null;
        ListeProjetAdapter projetAdapter = null;


        try {

            skillAdapter = new ListeSkillAdapter(this,0,apprenant);
            projetAdapter = new ListeProjetAdapter(this,0,apprenant);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        listeSkills.setAdapter(skillAdapter);
        listeProjets.setAdapter(projetAdapter);





    }
}
