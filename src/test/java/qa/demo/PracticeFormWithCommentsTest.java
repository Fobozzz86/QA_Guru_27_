package qa.demo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithCommentsTest {
    @BeforeAll
    static void beforeAll() {
        //Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void successFillPracticeFormTest() {
        open("/automation-practice-form");

        //    Тест может упасть из-за всплывающих баннеров (ошибка element click intercepted), можно добавить
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $(".practice-form-wrapper").shouldHave(text("Practice Form"));
        $("#firstName").setValue("Artem");
        $("#lastName").setValue("Bulaev");
        $("#userEmail").setValue("Fooolll@test.com");
        $("#genterWrapper").$(byText("Male")).click(); // Такой локатор более читабельный
 //      $("[for=gender-radio-1]").click();
        $("#userNumber").setValue("89649990000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__year-select").selectOption("1990");
//        $(".react-datepicker__day--010").click(); //если на форме выбора числа нет дублирующих чисел
        // Код когда на форме выбора числа есть дублирующиеся числа --30--
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Maths").sendKeys(Keys.ENTER);
        $("#subjectsInput").setValue("bio").pressEnter();
        $("#subjectsInput").setValue("ch").pressEnter();
        $("[for=hobbies-checkbox-3]").click();
        $("#hobbiesWrapper").$(byText("Sports")).click(); // оптимальный код
        $("#uploadPicture").uploadFromClasspath("img/Test.jpg");
        $("#currentAddress").setValue("Penza");
        $("#submit").scrollIntoView(true);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click(); // setTimeout(function() { debugger; }, 5000);
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-hover").shouldHave(text("Artem Bulaev"), text("Fooolll@test.com"),
                text("Male"), text("8964999000"));
        $("#closeLargeModal").scrollIntoView(true).click();
        $(".practice-form-wrapper").shouldHave(text("Practice Form"));

//        sleep(600_000);

    }
}
