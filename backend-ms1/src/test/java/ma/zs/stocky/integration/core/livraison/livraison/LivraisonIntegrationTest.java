package ma.zs.stocky.integration.core.livraison.livraison;

import com.intuit.karate.junit5.Karate;

public class LivraisonIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("LivraisonHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
