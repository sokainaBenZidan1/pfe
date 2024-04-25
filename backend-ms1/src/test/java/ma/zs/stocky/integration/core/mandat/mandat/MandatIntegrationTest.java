package ma.zs.stocky.integration.core.mandat.mandat;

import com.intuit.karate.junit5.Karate;

public class MandatIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("MandatHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
