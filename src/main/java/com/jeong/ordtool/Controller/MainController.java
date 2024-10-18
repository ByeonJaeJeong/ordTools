package com.jeong.ordtool.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {

    @FXML
    BorderPane rootPane;

    @FXML
    MenuItem menu_teamPick;

    @FXML
    MenuItem menu_rolePick;

    @FXML
    MenuItem menu_gamblePick;

    @FXML
    MenuItem menu_characterPick;

    @FXML
    MenuItem menu_banPick;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadPage("teamPick");

       menu_teamPick.setOnAction(event -> {
            loadPage("teamPick");
        });

        menu_rolePick.setOnAction(event -> {
            loadPage("rolePick");
        });

        menu_gamblePick.setOnAction(event -> {
            loadPage("gamebleCount");
        });

        menu_characterPick.setOnAction(event -> {
            loadPage("characterPick");
        });

        menu_banPick.setOnAction(event -> {
            loadPage("banPick");
        });

    }


    private void loadPage(String page) {
        try {
            URL fxmlFile = getClass().getResource("/com/jeong/ordtool/fxml/" + page + ".fxml"); // 적절한 경로 설정
            if (fxmlFile == null) {
                throw new IOException("FXML 파일을 찾을 수 없습니다: " + page + ".fxml");
            }
            Parent root = FXMLLoader.load(fxmlFile);
            rootPane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, "페이지 로드 중 오류 발생", ex);
        }
    }
}





