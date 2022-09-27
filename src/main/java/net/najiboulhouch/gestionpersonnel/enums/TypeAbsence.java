package net.najiboulhouch.gestionpersonnel.enums;

public enum TypeAbsence {
    SICKNESS(0),
    ADMINISTRATIVE_LEAVE(1),
    UNJUSTIFIED_LEAVE(2),
    DELAY(3);

    private int code;
    TypeAbsence(Integer code) {
        this.code = code;
    }
}
