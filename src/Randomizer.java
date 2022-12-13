import java.util.Random;

public class Randomizer {
    int sentences=1, words_min=1,words_max = 1, chars_min=1, chars_max = 1;
    int ascii_min = 97;
    int ascii_max = 123;

    String language;
    public Randomizer(String language, int sentences, int words_min, int words_max, int chars_min, int chars_max) {
        this.language = language;
        this.sentences = sentences;
        this.words_min = words_min;
        this.words_max = words_max;
        this.chars_min = chars_min;
        this.chars_max = chars_max;
        if (language.equals("Geo")){
            this.ascii_min=4304;
            this.ascii_max=4338;
        }
    }

    public String Generate(){
        StringBuilder result = new StringBuilder();

        for (int i=0; i<sentences; i++){
            result.append(GenerateRandomSentence()).append('\n');
        }

        return result.toString();
    }

    public String GenerateRandomSentence(){
        StringBuilder sentence = new StringBuilder();
        Random random = new Random();
        for (int i=0; i<random.nextInt(words_min, words_max + 1); i++){
            sentence.append(GenerateRandomWord()).append(" ");
        }
        return sentence.toString();
    }

    public String GenerateRandomWord(){
        StringBuilder word = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i<=random.nextInt(chars_min, chars_max+1); i++){
            word.append(GenerateRandomChar());
        }

        return word.toString();
    }

    public char GenerateRandomChar() {
        Random random = new Random();
        return ( char ) random.nextInt(ascii_min, ascii_max);
    }
}
