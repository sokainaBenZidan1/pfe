package ma.zs.stocky.integration.core.commun.entite-admin;

import com.intuit.karate.junit5.Karate;

public class EntiteAdminIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("EntiteAdminHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
