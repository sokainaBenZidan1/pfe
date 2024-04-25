package ma.zs.stocky.integration.core.budget.budget;

import com.intuit.karate.junit5.Karate;

public class BudgetIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("BudgetHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
