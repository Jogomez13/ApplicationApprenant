package fr.fondespierre.beweb.mobile.apprenants.adapters;

import android.app.Activity;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespierre.beweb.mobile.apprenants.R;

/**
 * Created by root on 06/07/17.
 */

public class ListeSkillAdapter extends ArrayAdapter {
    private final Activity act;
    private final int resource = R.layout.skills_item;
    private final JSONObject apprenant;
    private final JSONArray skills;



    public ListeSkillAdapter(@NonNull Activity activity, @LayoutRes int resource,JSONObject liste) throws JSONException {
        super(activity.getApplicationContext(), resource);
        this.act = activity;
        this.apprenant = liste;
        this.skills = apprenant.getJSONArray("skills");

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final int index = position;
        LayoutInflater inflater = act.getLayoutInflater();
        convertView = inflater.inflate(resource,null);

        TextView name = (TextView)convertView.findViewById(R.id.sItem_textView_nom);
        RatingBar level = (RatingBar)convertView.findViewById(R.id.sItem_ratingBar_niveau);

        try {
            name.setText(skills.getJSONObject(position).getString("name"));
            int niveau = skills.getJSONObject(position).getInt("level") * 5;
            level.setNumStars(3);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return convertView;
    }

    @Override
    public int getCount() {
        return skills.length();
    }
}

