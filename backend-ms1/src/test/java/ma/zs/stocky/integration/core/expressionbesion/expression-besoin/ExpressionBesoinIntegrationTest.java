package ma.zs.stocky.integration.core.expressionbesion.expression-besoin;

import com.intuit.karate.junit5.Karate;

public class ExpressionBesoinIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("ExpressionBesoinHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
