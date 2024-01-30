package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;

public class SearchAndroidTests extends TestBase {
    @Test
    void successfulSearchTest() {
        step("Открываем строку поиска", () ->
                $(accessibilityId("Search Wikipedia")).click());

        step("Вводим значение для поиска", () ->
                $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys("Appium"));

        step("Проверяем список найденного", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));

        step("Переходим по первой найденной ссылке", () ->
                $$(id("org.wikipedia.alpha:id/page_list_item_title")).first().click());

        step("Проверяем открытую страницу", () ->
                $(id("org.wikipedia.alpha:id/view_wiki_error_text")).shouldBe(visible));
    }
}

