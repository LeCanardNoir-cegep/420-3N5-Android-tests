package org.sabourin;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.sabourin.service.ServiceCodePostal;

@RunWith(AndroidJUnit4.class)
public class TestsCodePostal {
    private ServiceCodePostal cpServ;

    @Before
    public void init(){
        cpServ = new ServiceCodePostal();
    }

    @Test(expected = IllegalArgumentException.class)
    public void doNotMatchCodePostalKO(){
        // Ko "H1Y   1E1" "H1Y_1E1" "h3Y 1TO"
        String badCode1 = "098034902u34ih35i bk3";
        cpServ.isMatchCodePostal(badCode1);
        Assert.fail();
    }

}
