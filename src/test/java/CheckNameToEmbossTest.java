import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckNameToEmbossTest {

    private final String name;
    private final boolean expected;

    public CheckNameToEmbossTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getName() {
        return new Object[][] {
                {"Тимоти Шаламе", true},
                {"1 2", true}, // строка из 3-х символов
                {"Тимофей Шаломееевич", true}, // строка с 19-ю символами
                {"Шаломей Триумфомовичь", false}, // строка с длиной, превышающей 19 символов
                {"12", true}, // строка с длиной, меньше 3-х символов
                {" ", false}, // пробел единственный символ в строке
                {"", false}, // пустая строка
                {"ИванСусанин", true}, // строка без пробелов
                {" Василий Петькин", false}, // пробел в начале строки
                {"Гендальф Серый ", false}, // пробел в конце строки
                {"Рокки   Бальбо", false}, // более одного пробела в середине строки
        };
    }

    @DisplayName("Тест метода проверки ограничений для вводимого имени")
    @Description("В этом тесте проверяется работа метода checkValidNameTest, \nпокрывающего следующие требования: \n - в строке не меньше 3 и не больше 19 символов \n - в строке есть только один пробел \n - пробел стоит не в начале и не в конце строки")
    @Test
    public void checkValidNameTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();

        assertEquals(expected, actual);
    }

}
