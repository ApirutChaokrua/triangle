package sample;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.text.DecimalFormat;
import java.text.ParsePosition;
import javafx.scene.control.TextFormatter;

public class Controller {

    @FXML
    private TextField inputSide1;

    @FXML
    private Label Result;

    @FXML
    private TextField inputSide3;

    @FXML
    private TextField inputSide2;

    private int A,B,C,temp;
    public void initialize(){

        inputSide1.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inputSide1.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        inputSide2.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inputSide2.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        inputSide3.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    inputSide3.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });

    }


    @FXML
    private void side1Handler(){
        try{
            A = Integer.parseInt(inputSide1.getText());
            if(A < 1 || A > 100){
                Result.setText("Your length could not"+"\n"+" be Triangle or Invalid");
            }else{
                Result.setText("-");
                inputSide2.setDisable(false);
                inputSide2.requestFocus();
            }
        }catch (Exception e){
            Result.setText("ERROR");
        }
    }

    @FXML
    private void side2Handler(){
        try{
            B = Integer.parseInt(inputSide2.getText());
            if(B < 1 || B > 100){
                Result.setText("Your length could not"+"\n"+" be Triangle or Invalid");
            }else{
                Result.setText("-");
                inputSide3.setDisable(false);
                inputSide3.requestFocus();
            }
        }catch (Exception e){
            Result.setText("ERROR");
        }
    }

    @FXML
    private void side3Handler(){
        try{

            C = Integer.parseInt(inputSide3.getText());
            if(C < 1 || C > 100){
                Result.setText("Your length could not"+"\n"+" be Triangle or Invalid");
            }else{

                // sort A,B,C
                int a=A, b=B, c=C;
                if(a > b) { temp=b; b=a; a=temp;}
                if(b > c) { temp=c; c=b; b=temp;}
                if(a > b) { temp=b; b=a; a=temp;}

                //check
                if(a+b > c){
                    if(a==b && b==c){
                        Result.setText("Equilateral Triangle");
                    }else if(a==b || b==c || a==c){
                        Result.setText("Isosceles Triangle");
                    }else if(Math.sqrt((a*a+b*b)) == c ){
                        Result.setText("Right Triangle");
                    }else{
                        Result.setText("Scalene Triangle");
                    }
                }else{
                    Result.setText("Your length could not"+"\n"+" be Triangle or Invalid");
                }
            }
        }catch (Exception e){
            Result.setText("ERROR");
        }
    }


}
