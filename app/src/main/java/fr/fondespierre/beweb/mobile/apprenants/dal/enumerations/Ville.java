package fr.fondespierre.beweb.mobile.apprenants.dal.enumerations;

/**
 * Created by root on 05/07/17.
 */

public enum Ville {
    lunel("Lunel"),beziers("Beziers");
    private String name = "";

    Ville(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
