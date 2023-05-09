package view;

import controller.MainViewController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import pojo.History;
import service.MainService;
import tool.NumTool;

import java.util.ArrayList;

public class HistoryView extends Application {
    private ArrayList<History> histories;
    private MainService mainService;
    private Label firstIn;
    private Label secondIn;
    private MainViewController mainViewController;
    public HistoryView(ArrayList<History> histories, MainService mainService, Label firstIn, Label secondIn,MainViewController mainViewController) {
        this.histories = histories;
        this.mainService = mainService;
        this.firstIn = firstIn;
        this.secondIn = secondIn;
        this.mainViewController=mainViewController;
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        NumTool numTool=new NumTool();
        ScrollPane scrollPane=new ScrollPane();
        scrollPane.setPrefViewportWidth(300);
        scrollPane.setPrefViewportHeight(400);
        VBox vBox=new VBox();
        vBox.setPrefWidth(300);
        vBox.setAlignment(Pos.CENTER_RIGHT);
        int k=histories.size();
        if(k>0) {
            for (int i = k-1; i >=0; i--) {
                History history=histories.get(i);
                Button bt = new Button();
                //处理预备信息
                String text = numTool.dts(history.getA())
                        +" "+history.getOp()+" "
                        +numTool.dts(history.getB())
                        +" = "
                        +history.getAns();
                //注入文字
                bt.setText(text);
                //设置按钮ID
                bt.setId(String.valueOf(i));
                //设置按钮样式
                bt.setStyle("-fx-background-color:#f3f3f3");//背景颜色
                bt.setFont(new Font("Microsoft YaHei", 20));
                bt.setPrefWidth(300);
                bt.setAlignment(Pos.CENTER_RIGHT);
                //设置按钮鼠标交互动画
                bt.setOnMouseEntered(mouseEvent -> {
                    bt.setStyle("-fx-background-color: #dadada");//背景颜色

                });
                bt.setOnMouseExited(mouseEvent -> {
                    bt.setStyle("-fx-background-color:#f3f3f3");//背景颜色
                });
                bt.setOnMousePressed(mouseEvent -> {
                    bt.setStyle("-fx-background-color: #b6b6b6");//背景颜色
                });
                bt.setOnMouseReleased(mouseEvent -> {
                    bt.setStyle("-fx-background-color: #dadada");//背景颜色
                });
                int id=i;
                bt.setOnMouseClicked(mouseEvent -> {
                    mainService.rollBackToId(firstIn,secondIn,id);
                    primaryStage.close();
                });
                vBox.getChildren().add(bt);
            }
        }
        else {
            Button bt = new Button();
            //处理预备信息
            String s = "无记录";
            //注入文字
            bt.setText(s);
            //设置按钮ID
            bt.setId("No History");
            //设置按钮样式
            bt.setStyle("-fx-background-color:#f3f3f3");//背景颜色
            bt.setFont(new Font("Microsoft YaHei", 20));
            bt.setPrefWidth(300);
            bt.setAlignment(Pos.CENTER_RIGHT);
            //设置按钮鼠标交互动画
            bt.setOnMouseEntered(mouseEvent -> {
                bt.setStyle("-fx-background-color: #dadada");//背景颜色

            });
            bt.setOnMouseExited(mouseEvent -> {
                bt.setStyle("-fx-background-color:#f3f3f3");//背景颜色
            });
            bt.setOnMousePressed(mouseEvent -> {
                bt.setStyle("-fx-background-color: #b6b6b6");//背景颜色
            });
            bt.setOnMouseReleased(mouseEvent -> {
                bt.setStyle("-fx-background-color: #dadada");//背景颜色
            });
            //放入Vbox中
            vBox.getChildren().add(bt);
        }
        scrollPane.setContent(vBox);
        Scene scene=new Scene(scrollPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("历史记录©LYC");
        primaryStage.getIcons().add(new Image("calculator.png"));
        primaryStage.setResizable(false);
        primaryStage.setMaxHeight(400);
        primaryStage.setMaxWidth(331);
        primaryStage.setMinWidth(331);
        primaryStage.setMaxHeight(400);
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
                mainViewController.setFlagOperation(true);
        });
    }
}
