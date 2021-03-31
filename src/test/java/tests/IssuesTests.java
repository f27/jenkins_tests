package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.CRITICAL;

@DisplayName("Issue tests with lambda")
public class IssuesTests extends TestBase {

    @Test
    @Owner("f27")
    @Epic("GitHub web")
    @Feature("Issues")
    @Severity(CRITICAL)
    @Description("Search for repository, go to repository's page, go to issues tab and verify that " +
            "the issue exists and has comment")
    @DisplayName("Checking issue's name and comment")
    void checkIssueTest() {

        step("Open main page", () -> open("/"));

        step("Search for " + TestData.repositoryName, (step) -> {
            step.parameter("Repository name", TestData.repositoryName);
            $(byName("q")).setValue(TestData.repositoryName).submit();
        });

        step("Click on link with text " + TestData.repositoryName, (step) -> {
            step.parameter("Link text", TestData.repositoryName);
            $(".codesearch-results").$(byLinkText(TestData.repositoryName)).click();
        });

        step("Go to issues tab", () -> $("[data-content=Issues]").click());

        step("Click on issue " + TestData.issueText, (step) -> {
            step.parameter("Issue name", TestData.issueText);
            $("div[aria-label=Issues]").$(byLinkText(TestData.issueText)).click();
        });

        step("Issue should have comment: " + TestData.issueComment, (step) -> {
            step.parameter("Issue comment", TestData.issueComment);
            $(".js-comment-body").shouldHave(text(TestData.issueComment));
        });
    }
}
