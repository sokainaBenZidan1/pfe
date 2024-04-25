package ma.zs.stocky.integration.core.commande.commande;

import com.intuit.karate.junit5.Karate;

public class CommandeIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("CommandeHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
