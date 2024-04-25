package ma.zs.stocky.integration.core.expressionbesion.etat;

import com.intuit.karate.junit5.Karate;

public class EtatIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("EtatHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
