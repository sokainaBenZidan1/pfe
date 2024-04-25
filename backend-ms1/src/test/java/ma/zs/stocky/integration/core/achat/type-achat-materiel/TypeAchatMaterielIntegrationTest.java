package ma.zs.stocky.integration.core.achat.type-achat-materiel;

import com.intuit.karate.junit5.Karate;

public class TypeAchatMaterielIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("TypeAchatMaterielHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
