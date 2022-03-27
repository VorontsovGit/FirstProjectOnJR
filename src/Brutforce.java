import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Brutforce {
    public static void Break(){
        HashMap<Integer, StringBuilder> lineVariants = new HashMap<>();

        //Ищем файл
        String fileContent = Utility.findPath();

        //Записываем текст из файла
        ArrayList fileStringToChars = Utility.writeWords(fileContent);

        //Получаем варианты
        for (int i = 0; i < 40; i++) {
            StringBuilder resultBreak = new StringBuilder();
            for (int j = 0; j < fileStringToChars.size(); j++) {
                if (Utility.getSymbolsList().contains(fileStringToChars.get(j))) {
                    int symbolIndexInAlphabet = Utility.getSymbolsList().indexOf(fileStringToChars.get(j));
                    int reminder = symbolIndexInAlphabet - Utility.getSymbolsList().size() + i;
                    try {
                        resultBreak.insert(j, Utility.getSymbolsList().get(symbolIndexInAlphabet + i));
                    } catch (IndexOutOfBoundsException e){
                        resultBreak.insert(j, Utility.getSymbolsList().get(reminder));
                    }
                }
                else{
                    resultBreak.insert(j, fileStringToChars.get(j));
                }
            }
            lineVariants.put(40 - i, resultBreak);
        }

        //Выводим на экран варианты
        System.out.println("Возможные варианты:");
        for (int i = 1; i < lineVariants.size(); i++) {
            System.out.printf("Ключ: %d  , cодержимое: %s ",i ,lineVariants.get(i));
        }
    }
}
