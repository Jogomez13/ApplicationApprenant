package fr.fondespierre.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.w3c.dom.Text;

import fr.fondespierre.beweb.mobile.apprenants.DetailApprenantActivity;
import fr.fondespierre.beweb.mobile.apprenants.R;

/**
 * Created by root on 05/07/17.
 */

public class ListeApprenantAdapter extends ArrayAdapter {


    private final Activity act;
    private final int resource = R.layout.liste_apprenant_item;
    private final JSONArray apprenants;


    public ListeApprenantAdapter(@NonNull Activity activity, @LayoutRes int resource, JSONArray liste) {
        super(activity.getApplicationContext(), resource);
        this.act = activity;
        this.apprenants = liste;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final int index = position;
        LayoutInflater inflater = act.getLayoutInflater();
        convertView = inflater.inflate(resource,null);

        TextView firstName = (TextView)convertView.findViewById(R.id.laItem_textView_prenom);
        TextView lastName = (TextView)convertView.findViewById(R.id.laItem_textView_nom);

        ImageView detail = (ImageView)convertView.findViewById(R.id.laItem_imageButton_detail);
        detail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(act.getApplicationContext(), DetailApprenantActivity.class);
                    intent.putExtra("id",apprenants.getJSONObject(index).getInt("id"));
                    act.startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        try {
            firstName.setText(apprenants.getJSONObject(position).getString("prenom"));
            lastName.setText(apprenants.getJSONObject(position).getString("nom"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        /*TextView mainSkill = (TextView)convertView.findViewById(R.id.laItem_textView_skill);
        firstName.setText(.optString("skill"));*/

        return convertView;
    }

    @Override
    public int getCount() {
        return apprenants.length();
    }
}
