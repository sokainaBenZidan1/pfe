package ma.zs.stocky.integration.core.inventaire.responsable-inventaire;

import com.intuit.karate.junit5.Karate;

public class ResponsableInventaireIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("ResponsableInventaireHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
