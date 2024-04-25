package ma.zs.stocky.integration.core.expressionbesion.expression-besoin-detail;

import com.intuit.karate.junit5.Karate;

public class ExpressionBesoinDetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("ExpressionBesoinDetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
