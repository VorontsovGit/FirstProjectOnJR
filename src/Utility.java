import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Классы и методы, чтобы по 100 раз не писать и не создавать объекты
 */
public class Utility {

    /**
     * Ключ для шифров
     */
    public static class Key{
        private static ZoneId zone = ZoneId.of("Europe/Moscow");
        private static ZonedDateTime day = ZonedDateTime.now(zone);
        public static int getKey(){
            return day.getDayOfMonth();
        }
    }

    /**
     * Класс для получения текста с клавиатуры
     */
    public static class KeyboardScanner{
        private static final Scanner keyboard = new Scanner(System.in);
        public static String nextLine(){
            return keyboard.nextLine();
        }
    }

    /**
     * Коллекция символов
     */
        public static ArrayList<Character> getSymbolsList(){
            ArrayList<Character> symbols = new ArrayList<>();
            for(char i = 'а'; i <= 'я'; i++){
                symbols.add(i);
            }
            symbols.add('.');
            symbols.add(',');
            symbols.add('"');
            symbols.add(':');
            symbols.add('-');
            symbols.add('!');
            symbols.add('?');
            symbols.add(' ');
            return symbols;
        }

    /**
     * Метод для поиска пути к файлу
     */
    public static String findPath(){
        String fileContent = null;
        String repeat = "";
        do {
            try {
                System.out.println("Введите путь к файлу:");
                fileContent = Files.readString(Paths.get(Utility.KeyboardScanner.nextLine()));
            } catch (IOException e) {
                System.out.println("Не удалось найти файл или кодировка файла не стандартная.");
                System.out.println("Продолжить выполнение программы?");
                repeat = Utility.KeyboardScanner.nextLine();
            }
            if (fileContent != null || !repeat.equalsIgnoreCase("да")) {
                break;
            }
        } while (repeat.equalsIgnoreCase("да"));
        return fileContent;
    }

    /**
     * Метод для записи в коллекцию символов из файла
     * @param fileContent путь к файлу
     * @return возвращает коллекцию
     */
    public static ArrayList writeWords (String fileContent){
        ArrayList<Character> fileStringToChars = new ArrayList<>();
        if (fileContent != null) {
            String wordsInFile = fileContent.toLowerCase();
            char[] charsInFile = wordsInFile.toCharArray();
            for (int i = 0; i < charsInFile.length; i++) {
                fileStringToChars.add(i, charsInFile[i]);
            }
        }
        return fileStringToChars;
    }

    /**
     * Метод для создания файла
     * @param encryptionResult строка с изменённым текстом
     */
    public static void createFile(StringBuffer encryptionResult){
        try {
            System.out.print("Введите путь, для создания файла:");
            Path createOutputPath = Files.createFile(Paths.get(Utility.KeyboardScanner.nextLine()));
            Files.writeString(createOutputPath, encryptionResult);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Не удалось создать файл. Возможно файл с таким названием уже существует.");
        }
    }
}
