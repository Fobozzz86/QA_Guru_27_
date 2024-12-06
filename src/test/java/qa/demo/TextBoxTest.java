package qa.demo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTest {

    @BeforeAll
    static void beforeAll() {
 //       Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void successFillTest() {
        open("/text-box");
        $("#userName").setValue("Artem"); // - # это сокращение для id
        $("#userEmail").setValue("Fooolll@test.com");
        $("#currentAddress").setValue("Pnz");
        $("#permanentAddress").setValue("Russia");
        $("#submit").scrollIntoView(true); // прокрутка для видимости кнопки
        $("#submit").click();

        $("#output").should(text("Artem"), text("Fooolll@test.com"),
                text("Pnz"), text("Russia"));

        // Другой вариант проверки
//        $("#output #name").should(text("Artem"));
//        $("#output #email").should(text("Fooolll@test.com"));
//        $("#output #currentAddress").should(text("Pnz"));
//        $("#output #permanentAddress").should(text("Russia"));

 //       sleep(600_000);
    }
}