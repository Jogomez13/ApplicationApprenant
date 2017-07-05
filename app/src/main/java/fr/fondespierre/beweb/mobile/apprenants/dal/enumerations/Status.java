package fr.fondespierre.beweb.mobile.apprenants.dal.enumerations;

/**
 * Created by root on 05/07/17.
 */

public enum Status {
    Chomage("chômage"),En_Poste("en poste"),Formation("en formation");
    private String name = "";

    Status(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
