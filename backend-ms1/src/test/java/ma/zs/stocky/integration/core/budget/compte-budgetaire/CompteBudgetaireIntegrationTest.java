package ma.zs.stocky.integration.core.budget.compte-budgetaire;

import com.intuit.karate.junit5.Karate;

public class CompteBudgetaireIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("CompteBudgetaireHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
