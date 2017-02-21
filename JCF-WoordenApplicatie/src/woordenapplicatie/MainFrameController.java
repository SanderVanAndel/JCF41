package woordenapplicatie;

        import javafx.fxml.FXML;
        import javafx.fxml.Initializable;
        import javafx.scene.control.Button;
        import javafx.scene.control.TextArea;
        import java.net.URL;
        import java.util.ResourceBundle;

public class MainFrameController implements Initializable{

    @FXML
    Button btnConcordance, btnFrequence, btnSort, btnAmount;
    @FXML
    TextArea txtOutput, txtInput;

    private StringUtil su;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        txtInput.setWrapText(true);
        txtOutput.setWrapText(true);

        su = new StringUtil();
        txtInput.setText("een, twee, drie, vier,\nhoedje van, hoedje van,\neen, twee, drie, vier,\nhoedje van papier.");
    }

    @FXML
    private void btnAmountClicked(){
        int result[] = su.amount(txtInput.getText());
        txtOutput.setText("Amount of words: " + result[0] + "\nAmount of unique words: " + result[1]);
    }


    @FXML
    private void btnSortClicked(){
        txtOutput.setText(su.sort(txtInput.getText()).toString());
    }

    @FXML
    private void btnConcordanceClicked(){
        txtOutput.setText(su.concordance(txtInput.getText()).toString());
    }

    @FXML
    private void btnFrequenceClicked(){
        txtOutput.setText(su.frequence(txtInput.getText()).toString());
    }
}
