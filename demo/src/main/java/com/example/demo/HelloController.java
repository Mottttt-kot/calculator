package com.example.demo;
//matvolodkin@gmail.com
//Matvey Volodkin
//https://github.com/Mottttt-kot
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloController {
    @FXML private Pane titlePane;
    @FXML private ImageView btnMinimize, btnClose;
    @FXML private Label lblResult;
    @FXML private Label lblResult1;
    private double x, y;
    private long num1 = 0;
    private long num2 = 0;
    private String operator = "";
    private String temp = "";
    private String temp_res2 = "";
    private long result = 0;


    public void init(Stage stage) {
        titlePane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlePane.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX()-x);
            stage.setY(mouseEvent.getScreenY()-y);
        });

        btnClose.setOnMouseClicked(mouseEvent -> stage.close());
        btnMinimize.setOnMouseClicked(mouseEvent -> stage.setIconified(true));
    }
    @FXML
    public void onNumberClicked(MouseEvent event)
    {
        String symbol = ((Pane)event.getSource()).getId().replace("btn","");
        temp  += symbol;
        temp_res2 += symbol;
        if(operator.equals(""))
        {
            num1 = Long.valueOf(temp.toString());
        }
        else {
            num2 = Long.valueOf(temp.toString());
        }
        lblResult.setText(temp_res2);
        //System.out.print(num1);
    }

    @FXML
    public void onSymbolClicked(MouseEvent event)
    {

        String symbol = ((Pane)event.getSource()).getId().replace("btn","");
        temp_res2 = temp;
        temp = "";
        if (symbol.equals("Plus"))
        {
            operator ="+";
        }
        else if (symbol.equals("Minus"))
        {
            operator ="-";
        }
        else if (symbol.equals("Divide"))
        {
            operator ="/";
        }
        else if (symbol.equals("Multiply"))
        {
            operator ="*";
        }
        else if (symbol.equals("Clear"))
        {
            operator = "";
            result = 0;
            num1 = 0;
            num2 = 0;
            temp = "";
            temp_res2 = "";
        }
        temp_res2 += operator;
        lblResult.setText(temp_res2);
        if (symbol.equals("Equals"))
        {

            switch (operator) {
                case "+":
                {
                    result = num1 + num2;
                    System.out.println("= " + result);
                    break;
                }
                case "-":
                {
                    result = num1 - num2;
                    System.out.println("= " + result);
                    break;
                }
                case "*":
                {
                    result = num1 * num2;
                    System.out.println("= " + result);
                    break;
                }
                case "/":
                {
                    if(num2 != 0 & num1 != 0)
                    {
                        result = num1 / num2;
                        System.out.println("= " + result);
                    }
                    else {
                        lblResult.setText("Error");
                        return;
                    }
                    break;
                }
            }

            lblResult.setText("= "+ Long.toString(result));
            num1 = result;
            num2 = 0;
            temp = "";
            operator ="";

        }
    }


}