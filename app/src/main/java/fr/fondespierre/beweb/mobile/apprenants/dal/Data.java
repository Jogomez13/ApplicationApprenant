package fr.fondespierre.beweb.mobile.apprenants.dal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.fondespierre.beweb.mobile.apprenants.dal.enumerations.Status;
import fr.fondespierre.beweb.mobile.apprenants.dal.enumerations.Ville;

/**
 * Created by root on 05/07/17.
 */

public class Data {

    public static JSONObject apprenant;
    public static JSONArray getApprenants() throws JSONException {
        JSONArray apprenants = new JSONArray();
        JSONObject alex = new JSONObject();
        JSONObject jc = new JSONObject();
        JSONObject marie = new JSONObject();

        alex.putOpt("id",1);
        alex.putOpt("nom","Leforestier");
        alex.putOpt("prenom","Alex");
        alex.putOpt("age",30);
        alex.putOpt("promotion",1);
        alex.putOpt("session",1);
        alex.putOpt("status", Status.Chomage);
        alex.putOpt("email", "alex@gmail.com");
        alex.putOpt("tel", "0000000000");


        jc.putOpt("id",2);
        jc.putOpt("nom","Petetin");
        jc.putOpt("prenom","JC");
        jc.putOpt("age",30);
        jc.putOpt("promotion",1);
        jc.putOpt("session",2);
        jc.putOpt("status",Status.Formation);
        jc.putOpt("email", "jc@gmail.com");
        jc.putOpt("tel", "1111111111");

        marie.putOpt("id",3);
        marie.putOpt("nom","Urbano");
        marie.putOpt("prenom","Marie");
        marie.putOpt("age",30);
        marie.putOpt("promotion",2);
        marie.putOpt("session",1);
        marie.putOpt("status",Status.Formation);
        marie.putOpt("email", "marie@gmail.com");
        marie.putOpt("tel", "2222222222");

        apprenants.put(alex);
        apprenants.put(jc);
        apprenants.put(marie);

        return apprenants;
    }

    public static JSONObject getApprenant(int id) throws JSONException {
        JSONObject apprenant = new JSONObject();
        JSONArray apprenants = Data.getApprenants();

        for(int i=0 ; i<apprenants.length() ; i++) {
            if(apprenants.getJSONObject(i).getInt("id") == id){

                // skills and projects list by id
                JSONArray skills = Data.getSkills(id);
                JSONArray projects = Data.getProjects(id);

                // affectation de l'object à l'apprenant final
                apprenant = apprenants.getJSONObject(i);

                // add skills and projects to apprenants
                apprenant.putOpt("skills",skills);
                apprenant.putOpt("projects",projects);
            }
        }
        return apprenant;
    }

    public static JSONArray getPromotions() throws JSONException {
        JSONArray promotions = new JSONArray();

        JSONObject lunel1 = new JSONObject();
        JSONObject lunel2 = new JSONObject();
        JSONObject beziers1 = new JSONObject();

        lunel1.putOpt("id", 1);
        lunel1.putOpt("session", 1);
        lunel1.putOpt("ville", Ville.lunel);
        lunel1.putOpt("debut", "2016");
        lunel1.putOpt("fin", "2017");

        lunel2.putOpt("id", 2);
        lunel2.putOpt("session", 2);
        lunel2.putOpt("ville", Ville.lunel);
        lunel2.putOpt("debut", "2015");
        lunel2.putOpt("fin", "2016");

        beziers1.putOpt("id", 3);
        beziers1.putOpt("session", 2);
        beziers1.putOpt("ville", Ville.beziers);
        beziers1.putOpt("debut", "2016");
        beziers1.putOpt("fin", "2017");

        promotions.put(lunel1);
        promotions.put(lunel2);
        promotions.put(beziers1);

        return promotions;
    }

    private static JSONArray getProjects() throws JSONException {
        JSONArray projects = new JSONArray();

        JSONObject p1 = new JSONObject();
        JSONObject p2 = new JSONObject();
        JSONObject p3 = new JSONObject();
        JSONObject p4 = new JSONObject();
        JSONObject p5 = new JSONObject();
        JSONObject p6 = new JSONObject();
        JSONObject p7 = new JSONObject();
        JSONObject p8 = new JSONObject();
        JSONObject p9 = new JSONObject();
        JSONObject p10 = new JSONObject();
        JSONObject p11 = new JSONObject();
        JSONObject p12 = new JSONObject();

        p1.putOpt("id",1);
        p1.putOpt("nom","Pizza1");
        p1.putOpt("apprenant", 1);

        p2.putOpt("id",2);
        p2.putOpt("nom","Pizza2");
        p2.putOpt("apprenant", 1);

        p3.putOpt("id",3);
        p3.putOpt("nom","Pizza3");
        p3.putOpt("apprenant", 1);

        p4.putOpt("id",4);
        p4.putOpt("nom","Pizza4");
        p4.putOpt("apprenant", 1);

        p5.putOpt("id",1);
        p5.putOpt("nom","Pizza5");
        p5.putOpt("apprenant", 2);

        p6.putOpt("id",1);
        p6.putOpt("nom","Pizza6");
        p6.putOpt("apprenant", 2);

        p7.putOpt("id",1);
        p7.putOpt("nom","Pizza7");
        p7.putOpt("apprenant", 2);

        p8.putOpt("id",1);
        p8.putOpt("nom","Pizza8");
        p8.putOpt("apprenant", 2);

        p9.putOpt("id",9);
        p9.putOpt("nom","Pikcio");
        p9.putOpt("apprenant", 3);

        p10.putOpt("id",10);
        p10.putOpt("nom","PtiCoin");
        p10.putOpt("apprenant", 3);

        p11.putOpt("id",11);
        p11.putOpt("nom","FMC");
        p11.putOpt("apprenant", 3);

        p12.putOpt("id",12);
        p12.putOpt("nom","42");
        p12.putOpt("apprenant", 3);

        projects.put(p1);
        projects.put(p2);
        projects.put(p3);
        projects.put(p4);
        projects.put(p5);
        projects.put(p6);
        projects.put(p7);
        projects.put(p8);
        projects.put(p9);
        projects.put(p10);
        projects.put(p11);
        projects.put(p12);

        return projects;
    }

    private static JSONArray getProjects(int apprenantID) throws JSONException {
        JSONArray projects = Data.getProjects();
        JSONArray projectsApprenant = new JSONArray();
        for(int i=0 ; i<projects.length() ; i++) {
            if(projects.getJSONObject(i).getInt("apprenant") == apprenantID){
                projectsApprenant.put(projects.getJSONObject(i));
            }
        }

        return projectsApprenant;
    }

    private static JSONArray getSkills() throws JSONException {
        JSONArray skills = new JSONArray();

        JSONObject java = new JSONObject();
        JSONObject php = new JSONObject();
        JSONObject python = new JSONObject();

        java.putOpt("id", 1);
        java.putOpt("nom", "java");
        java.putOpt("niveau", 0.3);
        java.putOpt("apprenant", 1);

        php.putOpt("id", 2);
        php.putOpt("nom", "php");
        php.putOpt("niveau", 0.5);
        php.putOpt("apprenant", 2);

        python.putOpt("id", 3);
        python.putOpt("nom", "python");
        python.putOpt("niveau", 0.7);
        python.putOpt("apprenant", 3);

        skills.put(java);
        skills.put(php);
        skills.put(python);

        return skills;
    }

    private static JSONArray getSkills(int apprenantID) throws JSONException {
        JSONArray skills = Data.getSkills();
        JSONArray skillsApprenant = new JSONArray();
        for(int i=0 ; i<skills.length() ; i++) {
            if(skills.getJSONObject(i).getInt("apprenant") == apprenantID){
                skillsApprenant.put(skills.getJSONObject(i));
            }
        }

        return skillsApprenant;
    }

}
