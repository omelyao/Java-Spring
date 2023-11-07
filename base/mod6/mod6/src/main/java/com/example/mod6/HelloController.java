package com.example.mod6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import static javafx.collections.FXCollections.observableArrayList;

public class HelloController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private ComboBox<String> combobox;
    @FXML
    private Label gramm;
    @FXML
    private TextField inputtext;
    @FXML
    private Label kilogramm;
    @FXML
    private Label tonna;
    private float tn;
    private float kg;
    private float gr;
    private String str;
    private int num;

    @FXML
    public void initialize() {
        combobox.setItems(observableArrayList("Тонны","Килограммы", "Граммы"));
        combobox.getSelectionModel().select("Тонны");
        inputtext.setOnKeyTyped(event ->{
            converter();
        });
        combobox.setOnAction(event ->{
            converter();
        });
    }
    void converter(){
        this.str = combobox.getValue();
        switch(this.str){
            case "Тонны":
                num = Integer.parseInt(this.inputtext.getText());
                tn = num;
                kg = tn * 1000;
                gr = kg * 1000;
                tonna.setText(Float.toString(tn));
                kilogramm.setText(Float.toString(kg));
                gramm.setText(Float.toString(gr));
                break;
            case "Килограммы":
                num = Integer.parseInt(this.inputtext.getText());
                kg = num;
                tn = kg / 1000;
                gr = kg * 1000;
                tonna.setText(Float.toString(tn));
                kilogramm.setText(Float.toString(kg));
                gramm.setText(Float.toString(gr));
                break;
            case "Граммы":
                num = Integer.parseInt(this.inputtext.getText());
                gr = num;
                kg = gr /1000;
                tn = kg / 1000;
                tonna.setText(Float.toString(tn));
                kilogramm.setText(Float.toString(kg));
                gramm.setText(Float.toString(gr));
                break;
        }
    }
    public void input(){
        str = this.inputtext.getText();
        tn = Integer.parseInt(str);
        kg = tn * 1000;
        gr = tn * 1000 * 1000;
        tonna.setText(str);
        kilogramm.setText(Float.toString(kg));
        gramm.setText(Float.toString(gr));
    }
}



    /*void addNumber(int number){
        this.str_num += Integer.toString(number);
        label_field.setText(str_num);
    }
    void mathAction(char operation){
        if(this.operation != '+' && this.operation != '-'
                && this.operation !='x' && this.operation != '/') {
            this.first_num = Float.parseFloat(this.str_num);
            label_field.setText(String.valueOf(operation));
            this.str_num = "";
            this.operation = operation;
        }
    }
    void equalMetod(){
        float res = 0;
        switch(this.operation){
            case '+':
                res = this.first_num + Float.parseFloat(this.str_num);
                break;
            case '-':
                res = this.first_num - Float.parseFloat(this.str_num);
                break;
            case '/':
                if(Integer.parseInt(this.str_num) != 0)
                res = this.first_num / Float.parseFloat(this.str_num);
                else
                    res = 0;
                break;

            case 'x':
                res = this.first_num * Float.parseFloat(this.str_num);
                break;
        }
        label_field.setText(Float.toString(res));
        this.str_num = "";
        this.operation = 'A';
        this.first_num = 0;
    }*/


