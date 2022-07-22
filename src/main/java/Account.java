public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
        */

        boolean nameLength = name.length() >= 3 & name.length() <= 19; // в строке не меньше 3 и не больше 19 символов
        boolean nameNotStartsWithSpace = !(name.startsWith(" ")); //пробел стоит не в начале строки
        boolean nameNotEndsWithSpace = !(name.endsWith(" ")); //пробел стоит не в конце строки

        int spacesInName = 0;
        char space;
        for (int i = 0; i < name.length(); i++) {
            space = name.charAt(i);
            if (space == ' ')
                spacesInName++;
        }

        boolean nameHasOnlyOneSpace = (spacesInName == 1); // в строке есть только один пробел

        return (nameLength
                & nameHasOnlyOneSpace
                & nameNotStartsWithSpace
                & nameNotEndsWithSpace); // все проверки вместе должны возвращать true, если строка валидная
    }

}