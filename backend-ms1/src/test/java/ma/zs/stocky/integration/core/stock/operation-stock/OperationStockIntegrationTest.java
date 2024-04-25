package ma.zs.stocky.integration.core.stock.operation-stock;

import com.intuit.karate.junit5.Karate;

public class OperationStockIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("OperationStockHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
