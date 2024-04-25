package ma.zs.stocky.integration.core.mandat.responsabilite;

import com.intuit.karate.junit5.Karate;

public class ResponsabiliteIntegrationTest {

 @Karate.Test
    Karate saveHappyTest() {
        return Karate.run("ResponsabiliteHappyTest")
                .tags("save")
                .relativeTo(getClass());
    }


}
