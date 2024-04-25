package ma.zs.stocky.integration.core.produit.produit;

import com.intuit.karate.junit5.Karate;

public class ProduitIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("ProduitHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
