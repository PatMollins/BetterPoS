import java.util.Observable;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.input.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.layout.*; 
import javafx.event.ActionEvent; 

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;

import java.util.Iterator;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BetterPOS extends Application {
    BorderPane border = new BorderPane();
    Group root = new Group();
    int c = 0;
    int code = 0;
    ArrayList<Integer> log = new ArrayList<Integer>();
    public String format = "Format.json";

    @Override
    public void start(Stage stage) {
        //border.setLeft(leftMenu(stage));
        border.setCenter(numPad(stage));
        Scene scene = new Scene(border);
        scene.setFill(Color.CORNSILK);
        stage.setTitle("Better Point of Sale");
        stage.setFullScreen(true);
        stage.setScene(scene);        
        stage.show();
    }

    //Make a getFile method
    public void getFile(){
    }

    public VBox menu(Stage stage, int num){
        VBox col = new VBox();

        return col;
    }

    public GridPane numPad(Stage stage){
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(100,100,100,500));
        pane.setHgap(10);
        pane.setVgap(10);
        Text text = new Text();
        pane.add(text,1,0,1,1);
        Button[] nums = new Button[10];
        for(c = 0; c<nums.length-1; c++){
            nums[c] = new Button(""+(c+1));
            nums[c].setMinSize(100, 100);
            nums[c].setStyle("-fx-font-size: 45px;");
        }
        nums[9] = new Button("0");
        nums[9].setMinSize(100, 100);
        nums[9].setStyle("-fx-font-size: 45px;");

        EventHandler<ActionEvent> one = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+1);
            }
        };
        EventHandler<ActionEvent> two = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+2);
            }
        };
        EventHandler<ActionEvent> three = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+3);
            }
        };
        EventHandler<ActionEvent> four = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+4);
            }
        };
        EventHandler<ActionEvent> five = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+5);
            }
        }; 
        EventHandler<ActionEvent> six = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+6);
            }
        }; 
        EventHandler<ActionEvent> seven = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+7);
            }
        }; 
        EventHandler<ActionEvent> eight = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+8);
            }
        }; 
        EventHandler<ActionEvent> nine = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+9);
            }
        }; 
        EventHandler<ActionEvent> zero = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                    text.setText(text.getText()+""+0);
            }
        };

        nums[0].setOnAction(one);
        nums[1].setOnAction(two);
        nums[2].setOnAction(three);
        nums[3].setOnAction(four);
        nums[4].setOnAction(five);
        nums[5].setOnAction(six);
        nums[6].setOnAction(seven);
        nums[7].setOnAction(eight);
        nums[8].setOnAction(nine);
        nums[9].setOnAction(zero);

        int i = 0;
        while(i<nums.length){
            if(nums[i].getText().equals("0")){
                pane.add(nums[i], 1,4,1,1);
            }
            else{
                pane.add(nums[i],i%3,(i/3)+1,1,1);
            }
            i++;
        }

        Button enter = new Button("Enter");
        Button cancel = new Button("Cancel");
        enter.setMinSize(100, 100);
        cancel.setMinSize(100, 100);
        enter.setStyle("-fx-font-size: 20px;");
        cancel.setStyle("-fx-font-size: 20px;");
        pane.add(cancel, 0,4,1,1);
        pane.add(enter,2,4,1,1);

        EventHandler<ActionEvent> enterEvent = new EventHandler<ActionEvent>(){ 
            public void handle(ActionEvent e){ 
                if(!(text.getText().equals("")) && login(Integer.parseInt(text.getText()))){
                    text.setText("");
                    home(stage);
                }
                else{
                    text.setText("");
                }
            } 
        }; 
        EventHandler<ActionEvent> cancelEvent = new EventHandler<ActionEvent>(){
            public void handle(ActionEvent e){
                text.setText("");
                code = 0;
            }
        }; 
        cancel.setOnAction(cancelEvent);
        enter.setOnAction(enterEvent);
        root.getChildren().add(pane);
        return pane;
    }

    public boolean login(int num){
        //add check for valid login with sql server
        log.add(num);
        return true;
    }

    public void home(Stage stage){
        border.setLeft(leftMenu(stage));
        border.setCenter(menu(stage, 0));
        getFile();
    }

    public VBox leftMenu(Stage stage){
        VBox box = new VBox();
        box.setSpacing(10);
        box.setPadding(new Insets(10));
        String style = "-fx-background-color: rgba(255, 0, 45, 0.5);";
        box.setStyle(style);
        Button one = new Button("1");
        Button two = new Button("2");
        Button three = new Button("3");
        one.setMinSize(150, 95);
        box.getChildren().add(one);
        box.getChildren().add(two);
        box.getChildren().add(three);
        return box;
    }

    public static void main(String[] args) {
        launch();
    }
}