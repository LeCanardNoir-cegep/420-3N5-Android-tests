package org.sabourin.testsexercice3;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(AndroidJUnit4.class)
public class TestsTesteMoi {
    private TesteMoi testeMoi;

    @Before
    public void init(){
        testeMoi = new TesteMoi();
    }

    @Test
    public void comparerDixPlusPetitOK(){
        String txt = testeMoi.comparerDix(5);
        Assert.assertEquals("notre 5 est plus petit que 10", txt);
    }
    @Test
    public void comparerDixEgalOK(){
        String txt = testeMoi.comparerDix(10);
        Assert.assertEquals("notre 10 est égal à 10", txt);
    }
    @Test
    public void comparerDixPlusGrandOK(){
        String txt = testeMoi.comparerDix(11);
        Assert.assertEquals("notre 11 est plus grand que 10", txt);
    }

    @Test
    public void comparerDixKO(){
        //testeMoi.comparerDix();
    }

    @Test
    public void rochePapierGnocchiNotNull(){
        String txt = testeMoi.rochePapierGnocchi("papier", "roche");
        Assert.assertNotNull(txt);
    }

    @Test(expected = Exception.class)
    public void rochePapierGnocchiKO(){
        testeMoi.rochePapierGnocchi("chat", "roche");
        Assert.fail();
    }

    @Test
    public void rochePapierGnocchiJoueur1Gagne(){
        String txt = testeMoi.rochePapierGnocchi("chat", "roche");
        Assert.assertEquals("Joueur 1 gagne", txt);
    }
}
