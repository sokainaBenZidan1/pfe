package ma.zs.stocky.integration.core.produit.categorie-produit;

import com.intuit.karate.junit5.Karate;

public class CategorieProduitIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("CategorieProduitHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
