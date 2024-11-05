public class Encryptor {
    public static void main(String[] args) {
        System.out.println(encryptString("Wipro Tech", 20));
        System.out.println(encryptString("Hello World", 15));
    }

    public static String encryptString(String input1, int input2) {
        StringBuilder encrypted = new StringBuilder();
        for (String word : input1.split(" ")) {
            for (char c : word.toCharArray()) {
                char encryptedChar;
                if (Character.isUpperCase(c)) {
                    encryptedChar = (char) ((Character.toLowerCase(c) - 'a' + input2) % 26 + 'A');
                } else {
                    encryptedChar = (char) ((c - 'a' + input2) % 26 + 'a');
                }
                encrypted.append(encryptedChar);
            }
            encrypted.append(" ");
        }
        return encrypted.toString().trim();
    }
}
