package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import sample.algorithms.HammingAlgorithm;
import sample.algorithms.ResponseCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    private final Paint RED_COLOR = Paint.valueOf("#FF0000");
    private final Paint GREEN_COLOR = Paint.valueOf("#008000");
    private final List<Button> buttons = new ArrayList<>(72);
    private int[] currentWord = new int[72];
    private int currentBadIndex = ResponseCode.NO_ERRORS.code;

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
    }


    @FXML
    public void loadFromFile() {

    }

    @FXML
    public void generateRandomWord() {
        String random64bitWord = generate64bitWord();

        currentWord = HammingAlgorithm.calculate(random64bitWord);

        showTransformedWord();
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

    private void showTransformedWord() {
        for (int i = 0; i < currentWord.length; i++) {
            String singleValue = String.valueOf(currentWord[i]);
            buttons.get(i).setText(singleValue);
        }
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

        searchButton.setTextFill(textColor);
    }

    @FXML
    public void checkCorrectness() {
        currentBadIndex = HammingAlgorithm.calculateErrorIndex(currentWord);

        if (currentBadIndex == ResponseCode.NO_ERRORS.code)
            labelMessage.setText("No errors have been detected");
        else if(currentBadIndex == ResponseCode.TWO_ERRORS.code)
            labelMessage.setText("Two errors have been detected");
        else
            labelMessage.setText("Bad Index = " + currentBadIndex);
    }

    @FXML
    public void correctBit() {
        // more than two errors have been detected
        if (currentBadIndex >= buttons.size()) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("More than two errors have been detected. Program cannot correct more than one error.");
            alert.showAndWait();
        } else if (currentBadIndex == ResponseCode.TWO_ERRORS.code) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("Two errors have been detected. Program cannot correct two errors.");
            alert.showAndWait();
        } else if(currentBadIndex == ResponseCode.NO_ERRORS.code) {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Info");
            alert.setHeaderText(null);
            alert.setContentText("No errors have been detected. Please change one bit to wrong value.");
            alert.showAndWait();
        } else {
            changeBitToOppositeValue(currentBadIndex, GREEN_COLOR);
            //clearLabelMessage();
        }
    }

    @FXML
    public void cleanUpGridView() {
        for (Button button : buttons) {
            button.setText("0");
            button.setTextFill(Paint.valueOf("#000000"));
        }

        clearLabelMessage();
    }

    private void clearLabelMessage() {
        labelMessage.setText("");
    }
}
