package com.jeong.ordtool.Controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jeong.ordtool.Entity.UnitEntity;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class CharacterPickController implements Initializable {
    @FXML
    private Button characterBtn;

    @FXML
    private Label characterLabel;

    @FXML
    private TextField gableMaxCountField;

    List<String> textList = new ArrayList<>();
    List<UnitEntity> unitList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        characterLabel.setText("이씹년 오늘도 고도 해야겠지?");

        textList.add("성민우 이씹년");
        textList.add("오늘도 고도 망쳐봐야겠지?");
        textList.add("드가보자꾸나~");
        textList.add("나만 아니면돼~");


        String root = "/com/jeong/ordtool/json";
        Gson gson = new Gson();




        // 전설정보 가져오기
        URL resource = getClass().getResource(root+"/legend.json");
        if (resource != null) {
            // 리소스 파일을 Reader로 읽기
            try {
                Reader reader = new InputStreamReader(resource.openStream(), StandardCharsets.UTF_8);

                // JSON 파일을 List 형식으로 변환
                Type listType = new TypeToken<List<UnitEntity>>() {}.getType();
                List<UnitEntity> list = gson.fromJson(reader, listType);

                // 변환된 데이터 출력 (확인용)
                for (UnitEntity obj : list) {
                    unitList.add(obj);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        // 히든정보 가져오기
        URL resource2 = getClass().getResource(root+"/hidden.json");
        if (resource2 != null) {
            // 리소스 파일을 Reader로 읽기
            try {
                Reader reader = new InputStreamReader(resource2.openStream(), StandardCharsets.UTF_8);

                // JSON 파일을 List 형식으로 변환
                Type listType = new TypeToken<List<UnitEntity>>() {}.getType();
                List<UnitEntity> list = gson.fromJson(reader, listType);

                // 변환된 데이터 출력 (확인용)
                for (UnitEntity obj : list) {
                    unitList.add(obj);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        characterBtn.setOnMouseClicked(event -> {
            Thread thread = new Thread(() -> {
                try {

                } catch (Exception e) {
                    int maxCount = 10;
                }
                int i = 20;
                while (i > 1) {
                    try {
                        i = i - 1;
                        Thread.sleep(50);
                        if(i > 1 && i % 2==0 ) {
                            Collections.shuffle(textList);
                            Platform.runLater(() -> characterLabel.setText(textList.get(0)));
                        } else {
                            Collections.shuffle(unitList);
                            String unitName =  unitList.get(0).getName();
                            Platform.runLater(() -> characterLabel.setText(unitName));
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





