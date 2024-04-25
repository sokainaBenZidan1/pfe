package ma.zs.stocky.integration.core.livraison.livraison-detail;

import com.intuit.karate.junit5.Karate;

public class LivraisonDetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("LivraisonDetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
