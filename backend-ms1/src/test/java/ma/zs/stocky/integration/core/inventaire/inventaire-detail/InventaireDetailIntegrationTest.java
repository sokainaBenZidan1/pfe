package ma.zs.stocky.integration.core.inventaire.inventaire-detail;

import com.intuit.karate.junit5.Karate;

public class InventaireDetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("InventaireDetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
