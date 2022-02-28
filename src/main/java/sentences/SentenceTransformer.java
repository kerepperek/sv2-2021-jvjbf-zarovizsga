package sentences;

import java.util.Locale;

public class SentenceTransformer {

    private final static String END_SIGNS = ".!?";

    public String shortenSentence(String sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("Empty sentence!");
        }
        if (sentence.length() == 0) {
            throw new IllegalArgumentException("Empty sentence!");
        }
        sentence = sentence.trim();

        if (String.valueOf(sentence.charAt(0)).equals(String.valueOf(sentence.charAt(0)).toLowerCase())) {
            throw new IllegalArgumentException("Must start with capital letter!");
        }
        System.out.println();
        if (!END_SIGNS.contains(String.valueOf(sentence.charAt(sentence.length() - 1)))) {
            throw new IllegalArgumentException("Must end with . ! or ?");
        }

        String[] splitted = sentence.split(" ");
        int pcs = splitted.length;

        if (pcs >= 5) {
            StringBuilder sb = new StringBuilder();
            sb.append(splitted[0]).append(" ... ").append(splitted[pcs - 1]);
            return sb.toString();
        } else {
            return sentence;
        }

    }
}
