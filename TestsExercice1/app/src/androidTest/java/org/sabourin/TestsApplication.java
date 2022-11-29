package org.sabourin;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sabourin.bd.BD;
import org.sabourin.exceptions.PersonneExecption;
import org.sabourin.modele.Personne;

import org.sabourin.service.ServiceImplementation;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.sabourin.AppContants.*;

@RunWith(AndroidJUnit4.class)
public class TestsApplication {

    private BD bd;
    private ServiceImplementation service;

    // S'exécute avant chacun des tests. Crée une BD en mémoire
    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        bd = Room.inMemoryDatabaseBuilder(context, BD.class).build();
        service = ServiceImplementation.getInstance(bd);
    }


    @Test
    public void ajoutPersonneOKBD(){
        Personne personne = new Personne();
        personne.idPersonne = 1L;
        personne.nomPersonne = "Maudie";
        personne.agePersonne = 24;
        personne.adressePersonne = "1234 De la Mortagne MTL CA";
        bd.monDao().insertPersonne(personne);
    }


    @Test
    public void ajoutPersonneKOService() {
        Personne personne = new Personne();
        personne.idPersonne = 2L;
        personne.nomPersonne = "Maudie";
        personne.agePersonne = 24;
        personne.adressePersonne = "1234 De la Mortagne MTL CA";
        try {
            service.ajouterPersonne(personne);
            Assert.fail();
        } catch (PersonneExecption e) {
            Assert.assertEquals(ERREUR_ID, e.getMessage());
        }
    }

    @Test
    public void ajoutPersonneOKService() throws PersonneExecption {
        Personne personne = new Personne();
        personne.nomPersonne = "Maudie";
        personne.agePersonne = 24;
        personne.adressePersonne = "1234 De la Mortagne MTL CA";
        service.ajouterPersonne(personne);
    }

    @Test
    public void ajoutPersonneIdNonNullOKService() throws PersonneExecption {
        Personne personne = new Personne();
        personne.nomPersonne = "Maudie";
        personne.agePersonne = 24;
        personne.adressePersonne = "1234 De la Mortagne MTL CA";
        service.ajouterPersonne(personne);
        Assert.assertNotNull(personne.idPersonne);
    }

    @Test
    public void ajoutPersonneIDOKService() throws PersonneExecption {
        Personne personne = new Personne();
        personne.nomPersonne = "Maudie";
        personne.agePersonne = 24;
        personne.adressePersonne = "1234 De la Mortagne MTL CA";
        service.ajouterPersonne(personne);

        Personne personne2 = new Personne();
        personne2.nomPersonne = "Maudie";
        personne2.agePersonne = 24;
        personne2.adressePersonne = "1234 De la Mortagne MTL CA";
        service.ajouterPersonne(personne2);

        Assert.assertTrue(personne.idPersonne < personne2.idPersonne);
    }

}