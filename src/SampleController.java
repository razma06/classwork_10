import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class SampleController implements Initializable {
    @FXML
    private ChoiceBox<String> language;
    @FXML
    private TextArea areaText;
    @FXML
    private TextArea minWords;
    @FXML
    private TextArea maxWords;

    @FXML
    private TextArea minChars;
    @FXML
    private TextArea maxChars;

    @FXML
    private TextArea sentences;
    private final String[] languages = {"Eng", "Geo"};

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        language.setValue("Geo");
        language.getItems().setAll(languages);
    }

    @FXML
    void generateBtnClick(){
        try{
            int nOfSentences = Integer.parseInt(sentences.getText());
            int words_min = Integer.parseInt(minWords.getText());
            int words_max = Integer.parseInt(maxWords.getText());
            int chars_min = Integer.parseInt(minChars.getText());
            int chars_max = Integer.parseInt(maxChars.getText());
            Randomizer randomizer = new Randomizer(language.getValue(), nOfSentences, words_min, words_max, chars_min, chars_max);
            areaText.setText(randomizer.Generate());

        }catch (Exception e){
            System.out.println("Enter values correctly");
        }
    }

}
