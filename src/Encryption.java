import java.util.ArrayList;

/**
 * Это метод для шифрования текстового файла.
 */
public class Encryption{
    public static void Crypt() {

        StringBuffer encryptionResult = new StringBuffer();


        // Получаем путь к файлу
        String fileContent = Utility.findPath();

        //Если файл есть, записываем символы в коллекцию
        ArrayList fileStringToChars = Utility.writeWords(fileContent);

        //Цикл для шифрования полученной строки из файла
        for (int i = 0; i < fileStringToChars.size(); i++) {
            if (Utility.getSymbolsList().contains(fileStringToChars.get(i))) {
                int symbolIndexInAlphabet = Utility.getSymbolsList().indexOf(fileStringToChars.get(i)) + Utility.Key.getKey();
                int reminder = symbolIndexInAlphabet - Utility.getSymbolsList().size();
                try {
                    encryptionResult.insert(i, Utility.getSymbolsList().get(symbolIndexInAlphabet));
                } catch (IndexOutOfBoundsException e) {
                    encryptionResult.insert(i, Utility.getSymbolsList().get(reminder));
                }
            } else {
                encryptionResult.insert(i, fileStringToChars.get(i));
            }
        }

        //Создаём новый файл
        Utility.createFile(encryptionResult);
        }
    }
