package org.sabourin.service;

import static org.sabourin.AppContants.*;

import java.util.Locale;

public class ServiceCodePostal {
    public void isMatchCodePostal(String cp){
        if( !cp.matches("[ABCEGHJ-NPRSTVXY]\\d[ABCEGHJ-NPRSTV-Z][ \\-]?\\d[ABCEGHJ-NPRSTV-Z]\\d") )
            throw new IllegalArgumentException(ERREUR_CODEPOSTAL);
    }
}
