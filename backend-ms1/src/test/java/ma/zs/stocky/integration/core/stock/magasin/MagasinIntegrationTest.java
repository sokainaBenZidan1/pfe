package ma.zs.stocky.integration.core.stock.magasin;

import com.intuit.karate.junit5.Karate;

public class MagasinIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("MagasinHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
