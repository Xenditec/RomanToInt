import java.util.HashMap;
import java.util.Map;


public class Main {
    public static int romanToInt(String s) {
        // Создаем словарь используя мапу для сопоставления их числовым эквивалентам.
        Map<Character, Integer> romanValue = new HashMap<>();
        romanValue.put('I', 1);
        romanValue.put('V', 5);
        romanValue.put('X', 10);
        romanValue.put('L', 50);
        romanValue.put('C', 100);
        romanValue.put('D', 500);
        romanValue.put('M', 1000);


        int total = 0;
        int i = 0;

        // двигаемся в цикле пока не сравняемся по длине слова.  например XMVDII   VI iV MX MIX
        while (i < s.length()) {
            // Описываем логику "хождения" по словарю
            // Если элемент текущий меньше элемента следующего, то мы вычитаем из большего меньшее и записываем разницу в тотал
            if (i + 1 < s.length() && romanValue.get(s.charAt(i)) < romanValue.get(s.charAt(i + 1))) {
                total += romanValue.get(s.charAt(i + 1)) - romanValue.get(s.charAt(i));
                i += 2; // двигаемся со следующего элемента так как он уже был учтён.
            } else {
                total += romanValue.get(s.charAt(i));
                i++;
            }
        }
        return total;
    }

    public static void main(String[] args) {

        String rimskaya = "MDVII"; // 1507
        String rimskaya2 = "XIV"; // 14
        String rimskaya1 = "MMCXVI"; // 2116

        int result = romanToInt(rimskaya);
        System.out.println("Rimskaya " + rimskaya1 + " равна " + romanToInt(rimskaya1));
        System.out.println("Rimskaya " + rimskaya + " равна " + result);
        System.out.println("Rimskaya " + rimskaya2 + " равна " + romanToInt(rimskaya2));
    }
}
