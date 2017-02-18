package sample;

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

        su = new StringUtil();
        txtInput.setText("een, twee, drie, vier, hoedje van, hoedje van, een, twee, drie, vier, hoedje van papier.");
    }

    @FXML
    private void btnAmountClicked(){
        txtOutput.setText(su.amount(txtInput.getText()));
    }

    @FXML
    private void btnSortClicked(){
        txtOutput.setText(su.sort(txtInput.getText()));
    }

    @FXML
    private void btnConcordanceClicked(){
        txtOutput.setText(su.concordance(txtInput.getText()));
    }

    @FXML
    private void btnFrequenceClicked(){
        txtOutput.setText(su.frequence(txtInput.getText()));
    }
}
