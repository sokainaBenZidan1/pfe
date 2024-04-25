package ma.zs.stocky.integration.core.reception.reception;

import com.intuit.karate.junit5.Karate;

public class ReceptionIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("ReceptionHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
