package ma.zs.stocky.integration.core.achat.achat-materiel;

import com.intuit.karate.junit5.Karate;

public class AchatMaterielIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("AchatMaterielHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
