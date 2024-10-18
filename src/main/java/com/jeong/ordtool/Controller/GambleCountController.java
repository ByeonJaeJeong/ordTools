package com.jeong.ordtool.Controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class GambleCountController implements Initializable {
    @FXML
    private Button gambleCountBtn;

    @FXML
    private Label gambleCountLabel;

    @FXML
    private TextField gableMaxCountField;

    List<String> textList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gambleCountLabel.setText("이씹년 오늘도 고도 해야겠지?");

        textList.add("성민우 이씹년");
        textList.add("오늘도 고도 망쳐봐야겠지?");
        textList.add("드가보자꾸나~");
        textList.add("나만 아니면돼~");


        gambleCountBtn.setOnMouseClicked(event -> {
            Thread thread = new Thread(() -> {
                try {

                } catch (Exception e) {
                    int maxCount = 10;
                }
                int i = 20;
                while (i > 1) {
                    try {
                        i = i - 1;
                        int maxCount = Integer.parseInt(gableMaxCountField.getText());
                        Thread.sleep(50);
                        if(i > 1 && i % 2==0 ) {
                            Collections.shuffle(textList);
                            Platform.runLater(() -> gambleCountLabel.setText(textList.get(0)));
                        } else {
                            Random random = new Random();
                            Integer count = random.nextInt(maxCount);
                            Platform.runLater(() -> gambleCountLabel.setText(count.toString()));
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        });


    }


}





