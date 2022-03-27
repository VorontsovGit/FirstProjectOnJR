public class Main {

    private static String READY = "Готово.";

    public static void main(String[] args) {
        String exit;
        do {
            System.out.println("Выберите режим работы программы: шифрование, расшифровка или криптоанализ.");
            String mode = Utility.KeyboardScanner.nextLine();
            if(mode.equalsIgnoreCase("шифрование")){
                Encryption.Crypt();
                System.out.println(READY);
            }

            else if (mode.equalsIgnoreCase("расшифровка")){
                Decryption.Crypt();
                System.out.println(READY);
            }

            else if (mode.equalsIgnoreCase("криптоанализ")){
                Brutforce.Break();
                System.out.println(READY);
            }

            else {
                System.out.println("Не удалось определить режим, попробуйте написать корректнее.");
            }

            System.out.println("Продолжить выполнение программы? Да или нет.");
            exit = Utility.KeyboardScanner.nextLine();
        }
        while (exit.equalsIgnoreCase("да"));
    }
}

