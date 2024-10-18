package com.jeong.ordtool.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class TeamPickController implements Initializable {
    @FXML
    private Button team_userAddBtn;
    @FXML
    private ListView<String> teamUserList;

    @FXML
    private ListView<String> team1List;

    @FXML
    private ListView<String> team2List;
    @FXML
    private TextField team_textField;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        teamUserList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        teamUserList.setCellFactory(cell -> new ListCell<>() {
            @Override
            protected void updateItem(String s, boolean b) {
                super.updateItem(s, b);
                if(s != null) {
                    setText(s);
                    setFont(Font.font(20));
                } else {
                    setText(null);
                }
            }
        });

        team1List.setCellFactory(cell -> new ListCell<>() {
            @Override
            protected void updateItem(String s, boolean b) {
                super.updateItem(s, b);
                if(s != null) {
                    setText(s);
                    setFont(Font.font(20));
                } else {
                    setText(null);
                }
            }
        });

        team2List.setCellFactory(cell -> new ListCell<>() {
            @Override
            protected void updateItem(String s, boolean b) {
                super.updateItem(s, b);
                if(s != null) {
                    setText(s);
                    setFont(Font.font(20));
                } else {
                    setText(null);
                }
            }
        });
        teamUserList.getItems().add("재정");
        teamUserList.getItems().add("민우");
        teamUserList.getItems().add("성준");
        teamUserList.getItems().add("감자");
        teamUserList.getItems().add("첵탑");
        teamUserList.getItems().add("남지");
        teamUserList.getItems().add("승연");
        teamUserList.getItems().add("도근");

        teamUserList.setOnMouseClicked(event -> {
            if (event.getClickCount() > 1) {
                teamUserList.getItems().remove(teamUserList.getSelectionModel().getSelectedIndex());
            }
        });


    }

    @FXML
    protected void onTeamAddButtonClick() {
        if(!teamUserList.getItems().contains(team_textField.getText())) {
            teamUserList.getItems().add(team_textField.getText());
        };

    }

    @FXML
    protected void onTeamPickButtonClick() {

        List<String> items = new ArrayList<>(teamUserList.getItems());

        team1List.getItems().clear();
        team2List.getItems().clear();
        Collections.shuffle(items);
        int index = 0;
        for (String item : items) {
            if (index % 2 == 0) {
                team1List.getItems().add(item);
            } else {
                team2List.getItems().add(item);
            }
            index++;
        }


    }


}





