import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestDragAndDrop {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.startMaximized = true;
    }

    @Test
    void dragAndDropTest(){

//      - Откройте https://the-internet.herokuapp.com/drag_and_drop
        open("/drag_and_drop");
//      - Перенесите прямоугольник А на место В
//        SelenideElement col_a = $("#column-a");
//        SelenideElement col_b = $("#column-b");
//        actions().moveToElement(col_b).click(col_a).build().perform();
        $("#column-a").dragAndDropTo("#column-b");
//      - Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("B"));

    }
}
