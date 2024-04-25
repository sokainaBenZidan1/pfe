package ma.zs.stocky.integration.core.budget.budget-compte-budgetaire;

import com.intuit.karate.junit5.Karate;

public class BudgetCompteBudgetaireIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("BudgetCompteBudgetaireHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
