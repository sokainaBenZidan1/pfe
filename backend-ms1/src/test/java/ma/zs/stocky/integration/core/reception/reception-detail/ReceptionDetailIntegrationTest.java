package ma.zs.stocky.integration.core.reception.reception-detail;

import com.intuit.karate.junit5.Karate;

public class ReceptionDetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("ReceptionDetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
