import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;


public class appCardDeliveryTest {

    @Test
    void shouldRegisterCardDelivery(){
        Configuration.headless = true;
        open("http://localhost:9999");
        $("[placeholder=\"Город\"]").setValue("Кемерово");
        $("[name='name']").setValue("Иванов Иван");
        $("[name='phone']").setValue("+79236026062");
        $x("//*[contains(text(), 'Я соглашаюсь')]").click();
        $x("//*[contains(text(), 'Забронировать')]").click();
        $x("//div[contains(text(), 'Успешно')]").should(Condition.appear, Duration.ofSeconds(12));
    }

}
