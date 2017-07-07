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
import fr.fondespierre.beweb.mobile.apprenants.dal.Data;

/**
 * Created by root on 05/07/17.
 */

public class ListeApprenantAdapter extends ArrayAdapter {


    private final Activity act;

    // c'est la vue qui affiche l'objet
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

        /* L'inflater, c'est un objet qui va construire tous les éléments contenus dans un layout
        pour afficher l'objet à la position spécifiée.*/

        LayoutInflater inflater = act.getLayoutInflater();
        convertView = inflater.inflate(resource,null);


        // set listview with the text values in the field corresponding with the ID
        TextView firstName = (TextView)convertView.findViewById(R.id.laItem_textView_prenom);
        TextView lastName = (TextView)convertView.findViewById(R.id.laItem_textView_nom);


        // redirection grâce à l'id que nous avons attribué
        ImageView detail = (ImageView)convertView.findViewById(R.id.laItem_imageButton_detail);
        detail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(act.getApplicationContext(), DetailApprenantActivity.class);
                    Data.apprenant = apprenants.getJSONObject(index);
                    act.startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        });
        try {

            // on attribue dans le texte dans le champs correspondant
            firstName.setText(apprenants.getJSONObject(position).getString("prenom"));
            lastName.setText(apprenants.getJSONObject(position).getString("nom"));
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return convertView;
    }

    @Override
    public int getCount() {
        return apprenants.length();
    }
}
