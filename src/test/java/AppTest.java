import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();

  @Override
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("To Do list");
  }

  @Test
  public void taskIsCreatedTest() {
    goTo("http://localhost:4567/");
    click("a").withText("Add a new CD");
    fill("#name").with("5150");
    submit(".btn");
    click("a").withText("Add New CD");
    fill("#name").with("1984");
    submit(".btn");
    click("a").withText("Add New CD");
    fill("#name").with("The Top of The World");
    submit(".btn");
    click("a").withText("Add New CD");
    fill("#name").with("The Dance");
    submit(".btn");
    click("a").withText("Add New CD"); 

    assertThat(pageSource()).contains("Your task has been saved.");
  }



}
