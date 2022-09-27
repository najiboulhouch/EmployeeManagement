package net.najiboulhouch.gestionpersonnel.enums;



public enum EtatCivil {

    MARRIED(0),
    SINGLE(1),
    DIVORCE(2);

    private int code;
    EtatCivil(Integer code) {
        this.code = code;
    }
}
