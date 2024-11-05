public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        justifyText(words, maxWidth);
    }

    public static void justifyText(String[] words, int maxWidth) {
        int currentWidth = 0;
        StringBuilder currentLine = new StringBuilder();

        for (String word : words) {
            if (currentWidth + word.length() + currentLine.length() > maxWidth) {
                printLine(currentLine, maxWidth);
                currentLine = new StringBuilder();
                currentWidth = 0;
            }

            currentLine.append(word).append(" ");
            currentWidth += word.length() + 1;
        }

        printLastLine(currentLine, maxWidth);
    }

    public static void printLine(StringBuilder line, int maxWidth) {
        int numSpaces = maxWidth - line.length() + 1;
        int spaceBetweenWords = numSpaces / (line.toString().split(" ").length - 1);
        int extraSpaces = numSpaces % (line.toString().split(" ").length - 1);

        String[] words = line.toString().split(" ");
        StringBuilder justifiedLine = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            justifiedLine.append(words[i]);
            if (i < words.length - 1) {
                for (int j = 0; j < spaceBetweenWords; j++) {
                    justifiedLine.append(" ");
                }
                if (extraSpaces > 0) {
                    justifiedLine.append(" ");
                    extraSpaces--;
                }
            }
        }

        System.out.println(justifiedLine.toString());
    }

    public static void printLastLine(StringBuilder line, int maxWidth) {
        System.out.print(line.toString().trim());
        for (int i = 0; i < maxWidth - line.length() + 1; i++) {
            System.out.print(" ");
        }
        System.out.println();
    }
}
