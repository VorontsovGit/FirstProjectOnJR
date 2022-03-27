import java.util.ArrayList;

/**
 * Это метод для дешифрования текстового файла.
 */
public class Decryption{
    public static void Crypt(){
        /*
        Работа метода аналогична такому же в классе Encryption, но вместо сдвига вперёд на n ключа сдвиг происходит
        назад
         */
        StringBuffer decryptionResult = new StringBuffer();

        String fileContent = Utility.findPath();

        ArrayList fileStringToChars = Utility.writeWords(fileContent);

        for (int i = 0; i < fileStringToChars.size(); i++) {
            if (Utility.getSymbolsList().contains(fileStringToChars.get(i))) {
                int symbolIndexInAlphabet = Utility.getSymbolsList().indexOf(fileStringToChars.get(i)) - Utility.Key.getKey();
                int reminder = Utility.getSymbolsList().size() + symbolIndexInAlphabet;
                try {
                    decryptionResult.insert(i, Utility.getSymbolsList().get(symbolIndexInAlphabet));
                } catch (IndexOutOfBoundsException e) {
                    decryptionResult.insert(i, Utility.getSymbolsList().get(reminder));
                }
            } else {
                decryptionResult.insert(i, fileStringToChars.get(i));
            }
        }
        Utility.createFile(decryptionResult);
    }
}
