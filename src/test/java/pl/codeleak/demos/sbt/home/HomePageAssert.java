package pl.codeleak.demos.sbt.home;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageAssert extends AbstractAssert<HomePageAssert, HomePage> {

    protected HomePageAssert(HomePage homePage) {
        super(homePage, HomePageAssert.class);
    }

    public HomePageAssert hasActuatorLink(String... values) {
        assertThat(getLinkNames()).contains(values);
        return this;
    }

    public HomePageAssert hasNoActuatorLink(String... values) {
        assertThat(getLinkNames()).doesNotContain(values);
        return this;
    }

    private List<String> getLinkNames() {
        List<WebElement> actuatorLinks = actual.getActuatorLinks();
        return actuatorLinks.stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

}
