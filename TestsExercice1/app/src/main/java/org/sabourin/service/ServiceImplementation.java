package org.sabourin.service;

import static org.sabourin.AppContants.*;

import org.sabourin.bd.BD;
import org.sabourin.exceptions.PersonneExecption;
import org.sabourin.modele.Personne;

public class ServiceImplementation{

    private static ServiceImplementation single_instance = null;
    private BD maBD;

    private ServiceImplementation (BD maBD){
        this.maBD = maBD;
    }

    public static ServiceImplementation getInstance(BD maBD)
    {
        if (single_instance == null)
            single_instance = new ServiceImplementation(maBD);

        return single_instance;
    }

    public void ajouterPersonne(Personne personne) throws PersonneExecption {
        // Ajout
        if(personne.idPersonne != null) throw new PersonneExecption(ERREUR_ID);
        personne.idPersonne = maBD.monDao().insertPersonne(personne);
    }
}
