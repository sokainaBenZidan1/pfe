package ma.zs.stocky.integration.core.stock.operation-stock-detail;

import com.intuit.karate.junit5.Karate;

public class OperationStockDetailIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("OperationStockDetailHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
