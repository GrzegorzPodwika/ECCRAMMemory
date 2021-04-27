package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import sample.algorithms.HammingAlgorithm;
import sample.other.Constants;
import sample.other.ResponseCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static sample.other.Constants.*;

public class Controller {
    @FXML public Label labelMessage;
    @FXML public Button button0;
    @FXML public Button button1;
    @FXML public Button button2;
    @FXML public Button button3;
    @FXML public Button button4;
    @FXML public Button button5;
    @FXML public Button button6;
    @FXML public Button button7;
    @FXML public Button button8;
    @FXML public Button button9;
    @FXML public Button button10;
    @FXML public Button button11;
    @FXML public Button button12;
    @FXML public Button button13;
    @FXML public Button button14;
    @FXML public Button button15;
    @FXML public Button button16;
    @FXML public Button button17;
    @FXML public Button button18;
    @FXML public Button button19;
    @FXML public Button button20;
    @FXML public Button button21;
    @FXML public Button button22;
    @FXML public Button button23;
    @FXML public Button button24;
    @FXML public Button button25;
    @FXML public Button button26;
    @FXML public Button button27;
    @FXML public Button button28;
    @FXML public Button button29;
    @FXML public Button button30;
    @FXML public Button button31;
    @FXML public Button button32;
    @FXML public Button button33;
    @FXML public Button button34;
    @FXML public Button button35;
    @FXML public Button button36;
    @FXML public Button button37;
    @FXML public Button button38;
    @FXML public Button button39;
    @FXML public Button button40;
    @FXML public Button button41;
    @FXML public Button button42;
    @FXML public Button button43;
    @FXML public Button button44;
    @FXML public Button button45;
    @FXML public Button button46;
    @FXML public Button button47;
    @FXML public Button button48;
    @FXML public Button button49;
    @FXML public Button button50;
    @FXML public Button button51;
    @FXML public Button button52;
    @FXML public Button button53;
    @FXML public Button button54;
    @FXML public Button button55;
    @FXML public Button button56;
    @FXML public Button button57;
    @FXML public Button button58;
    @FXML public Button button59;
    @FXML public Button button60;
    @FXML public Button button61;
    @FXML public Button button62;
    @FXML public Button button63;
    @FXML public Button button64;
    @FXML public Button button65;
    @FXML public Button button66;
    @FXML public Button button67;
    @FXML public Button button68;
    @FXML public Button button69;
    @FXML public Button button70;
    @FXML public Button button71;
    @FXML public TextField textFieldFileName;
    @FXML public Button buttonFetchNextWord;

    private final Paint RED_COLOR = Paint.valueOf("#FF0000");
    private final Paint GREEN_COLOR = Paint.valueOf("#008000");
    private final Paint BLACK_COLOR = Paint.valueOf("#000000");

    private FileWriter reportFile;

    private int[] currentWord = new int[72];
    private int currentBadIndex = ResponseCode.NO_ERRORS.code;
    private final List<String> messages = new ArrayList<>();
    private int messageIterator = -1;
    private final List<Button> buttons = new ArrayList<>(72);

    @FXML
    public void initialize() {
        buttons.add(button0); buttons.add(button1); buttons.add(button2); buttons.add(button3); buttons.add(button4); buttons.add(button5);
        buttons.add(button6); buttons.add(button7); buttons.add(button8); buttons.add(button9); buttons.add(button10); buttons.add(button11);
        buttons.add(button12); buttons.add(button13); buttons.add(button14); buttons.add(button15); buttons.add(button16); buttons.add(button17);
        buttons.add(button18); buttons.add(button19); buttons.add(button20); buttons.add(button21); buttons.add(button22); buttons.add(button23);
        buttons.add(button24); buttons.add(button25); buttons.add(button26); buttons.add(button27); buttons.add(button28); buttons.add(button29);
        buttons.add(button30); buttons.add(button31); buttons.add(button32); buttons.add(button33); buttons.add(button34); buttons.add(button35);
        buttons.add(button36); buttons.add(button37); buttons.add(button38); buttons.add(button39); buttons.add(button40); buttons.add(button41);
        buttons.add(button42); buttons.add(button43); buttons.add(button44); buttons.add(button45); buttons.add(button46); buttons.add(button47);
        buttons.add(button48); buttons.add(button49); buttons.add(button50); buttons.add(button51); buttons.add(button52); buttons.add(button53);
        buttons.add(button54); buttons.add(button55); buttons.add(button56); buttons.add(button57); buttons.add(button58); buttons.add(button59);
        buttons.add(button60); buttons.add(button61); buttons.add(button62); buttons.add(button63); buttons.add(button64); buttons.add(button65);
        buttons.add(button66); buttons.add(button67); buttons.add(button68); buttons.add(button69); buttons.add(button70); buttons.add(button71);

        for (int i = 0; i < buttons.size(); i++) {
            int finalI = i;
            buttons.get(i).setOnAction(event -> {
                changeBitToOppositeValue(finalI, RED_COLOR);
            });
        }

        try {
            reportFile = new FileWriter("report.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void loadFromFile() {
        String path = textFieldFileName.getText();

        if (path == null || path.isEmpty()) {
            showAlert(ALERT_PROVIDE_FILENAME, AlertType.WARNING);

            return;
        }

        File file = new File(path);

        try (Scanner scanner = new Scanner(file)) {
            messages.clear();
            messageIterator = -1;

            while (scanner.hasNextLine()) {
                messages.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            showAlert(ERROR_FILE_DOES_NOT_EXIST, AlertType.ERROR);

            return;
        }

        buttonFetchNextWord.setDisable(false);
        fetchNextWord();
    }

    private void showAlert(String message, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle("Info");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

        writeToReport(message);
    }

    @FXML
    public void fetchNextWord() {
        messageIterator++;

        if (messageIterator < messages.size()) {
            String message = messages.get(messageIterator);

            transformAndShowMessage(message);
        } else {
            buttonFetchNextWord.setDisable(true);
        }
    }

    private void transformAndShowMessage(String message) {
        currentWord = HammingAlgorithm.calculate(message);
        writeToReport(message);

        showTransformedWord();
    }

    private void writeToReport(String message) {
        try {
            reportFile.write(message);
            reportFile.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showTransformedWord() {
        for (int i = 0; i < currentWord.length; i++) {
            String singleValue = String.valueOf(currentWord[i]);
            buttons.get(i).setText(singleValue);
        }
        writeToReport(Arrays.toString(currentWord));
    }

    @FXML
    public void generateRandomWord() {
        String random64bitWord = generate64bitWord();

        transformAndShowMessage(random64bitWord);
    }

    private String generate64bitWord() {
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(64);

        for (int i = 0; i < 64; i++) {
            int randomValue = rnd.nextInt(2); // <0,1>
            sb.append(randomValue);
        }

        return sb.toString();
    }

    @FXML
    public void breakBit() {
        Random rnd = new Random();
        int randomIndex = rnd.nextInt(72);

        changeBitToOppositeValue(randomIndex, RED_COLOR);
    }

    private void changeBitToOppositeValue(int index, Paint textColor) {
        if (currentWord[index] == 0)
            currentWord[index] = 1;
        else
            currentWord[index] = 0;

        Button searchButton = buttons.get(index);
        searchButton.setText(String.valueOf(currentWord[index]));

        searchButton.getStylesheets().clear();

        if (searchButton.getTextFill().equals(textColor)) {
            searchButton.setTextFill(BLACK_COLOR);
            searchButton.setStyle("-fx-focus-color: transparent;");
        } else {
            searchButton.setTextFill(textColor);
            searchButton.getStylesheets().add(getClass().getResource("/css/error_button_style.css").toExternalForm());
        }

        writeToReport(Arrays.toString(currentWord));
    }

    @FXML
    public void checkCorrectness() {
        currentBadIndex = HammingAlgorithm.calculateErrorIndex(currentWord);

        if (currentBadIndex == ResponseCode.NO_ERRORS.code) {
            labelMessage.setText(MESSAGE_NO_ERRORS);
            writeToReport(MESSAGE_NO_ERRORS);

        }
        else if(currentBadIndex == ResponseCode.TWO_ERRORS.code) {
            labelMessage.setText(MESSAGE_TWO_ERRORS);
            writeToReport(MESSAGE_TWO_ERRORS);
        }
        else {
            String badIndex = String.format(MESSAGE_BAD_INDEX, currentBadIndex);
            labelMessage.setText(badIndex);
            writeToReport(badIndex);
        }
    }

    @FXML
    public void correctBit() {
        if (currentBadIndex >= buttons.size()) {
            showAlert(ALERT_MORE_THAN_TWO_ERRORS, AlertType.INFORMATION);
        } else if (currentBadIndex == ResponseCode.TWO_ERRORS.code) {
            showAlert(ALERT_TWO_ERRORS, AlertType.INFORMATION);
        } else if(currentBadIndex == ResponseCode.NO_ERRORS.code) {
            showAlert(ALERT_NO_ERRORS, AlertType.INFORMATION);
        } else {
            changeBitToOppositeValue(currentBadIndex, GREEN_COLOR);
        }
    }

    @FXML
    public void cleanUpGridView() {
        for (int i = 0; i < buttons.size(); i++) {
            Button button = buttons.get(i);
            button.setText("0");
            button.setTextFill(BLACK_COLOR);

            button.getStylesheets().clear();
            if (i == 0) {
                button.getStylesheets().add(getClass().getResource("/css/general_parity_button_style.css").toExternalForm());
            } else if(i == 1 || i == 2 || i == 4 ||i == 8 ||i == 16 || i == 32 || i == 64) {
                button.getStylesheets().add(getClass().getResource("/css/parity_button_style.css").toExternalForm());

            }
        }

        clearLabelMessage();
        clearCurrentWord();
    }

/*    @FXML
    public void changeBit(int index) {

    }*/

    private void clearLabelMessage() {
        labelMessage.setText("");
    }

    private void clearCurrentWord() {
        currentWord = new int[72];
        currentBadIndex = ResponseCode.NO_ERRORS.code;

        writeToReport(Arrays.toString(currentWord));
    }

    public void shutdown() {
        try {
            reportFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
