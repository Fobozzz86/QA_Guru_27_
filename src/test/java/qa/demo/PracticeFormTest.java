package qa.demo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {
    @BeforeAll
    static void beforeAll() {
        //Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successFillPracticeFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Artem");
        $("#lastName").setValue("Bulaev");
        $("#userEmail").setValue("Fooolll@test.com");
        $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("89649990000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Maths").sendKeys(Keys.ENTER);
        $("#subjectsInput").setValue("bio").sendKeys(Keys.ENTER);
        $("#subjectsInput").setValue("ch").sendKeys(Keys.ENTER);
        $("[for=hobbies-checkbox-2]").click();
        $("[for=hobbies-checkbox-3]").click();
        $("#uploadPicture").uploadFromClasspath("img/Test.jpg");
        $("#currentAddress").setValue("Penza");
        $("#submit").scrollIntoView(true);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".table-hover").shouldHave(text("Artem Bulaev"), text("Fooolll@test.com"),
                text("Male"), text("8964999000"));
        $("#closeLargeModal").scrollIntoView(true).click();

//        sleep(600_000);

    }
}
