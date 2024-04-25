package ma.zs.stocky.integration.core.stock.stock;

import com.intuit.karate.junit5.Karate;

public class StockIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("StockHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
