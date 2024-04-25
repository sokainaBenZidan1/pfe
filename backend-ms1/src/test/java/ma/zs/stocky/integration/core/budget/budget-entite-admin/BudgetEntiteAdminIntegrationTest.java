package ma.zs.stocky.integration.core.budget.budget-entite-admin;

import com.intuit.karate.junit5.Karate;

public class BudgetEntiteAdminIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("BudgetEntiteAdminHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
