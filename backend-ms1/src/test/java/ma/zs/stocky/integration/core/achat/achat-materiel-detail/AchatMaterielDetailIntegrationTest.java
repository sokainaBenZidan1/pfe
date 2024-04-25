package ma.zs.stocky.integration.core.achat.achat-materiel-detail;

import com.intuit.karate.junit5.Karate;

public class AchatMaterielDetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("AchatMaterielDetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
