package ma.zs.stocky.integration.core.commande.commande-detail;

import com.intuit.karate.junit5.Karate;

public class CommandeDetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("CommandeDetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
