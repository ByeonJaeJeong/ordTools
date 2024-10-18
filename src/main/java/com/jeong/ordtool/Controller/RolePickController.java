package com.jeong.ordtool.Controller;

import com.google.gson.Gson;
import com.jeong.ordtool.Entity.UnitEntity;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.FileReader;
import java.io.Reader;
import java.net.URL;
import java.util.*;

public class RolePickController implements Initializable {
    @FXML
    private Button roleBtn;

    @FXML
    private Label roleLabel;

    List<String> roleList = new ArrayList<>();
    List<String> textList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleLabel.setText("이씹년 오늘도 고도 해야겠지?");

        roleList.add("인생의고도전");
        roleList.add("이캐릭터들 필수예요");
        roleList.add("밴살 고르기");

        textList.add("성민우 이씹년");
        textList.add("오늘도 고도 망쳐봐야겠지?");
        textList.add("드가보자꾸나~");
        textList.add("나만 아니면돼~");


        roleBtn.setOnMouseClicked(event -> {
            Thread thread = new Thread(() -> {
                int i = 20;
                while (i > 1) {
                    try {
                        i = i - 1;
                        Thread.sleep(50);
                        if(i > 1 && i % 2==0 ) {
                            Collections.shuffle(textList);
                            Platform.runLater(() -> roleLabel.setText(textList.get(0)));
                        } else {
                            Collections.shuffle(roleList);
                            Platform.runLater(() -> roleLabel.setText(roleList.get(0)));
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





