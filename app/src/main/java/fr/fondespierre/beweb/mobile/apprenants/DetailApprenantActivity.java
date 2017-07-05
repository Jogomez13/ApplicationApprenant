package fr.fondespierre.beweb.mobile.apprenants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespierre.beweb.mobile.apprenants.dal.Data;

public class DetailApprenantActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_apprenant);

        try {
            JSONObject apprenant = Data.getApprenant(getIntent().getIntExtra("id",0));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
