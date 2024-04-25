package ma.zs.stocky.integration.core.inventaire.inventaire;

import com.intuit.karate.junit5.Karate;

public class InventaireIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("InventaireHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
