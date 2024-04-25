package ma.zs.stocky.integration.core.commun.employe;

import com.intuit.karate.junit5.Karate;

public class EmployeIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("EmployeHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
