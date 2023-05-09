import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainApplication extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("计算器©LYC");
        stage.setScene(scene);
        stage.initStyle(StageStyle.UNIFIED);
        stage.setResizable(false);
        stage.getIcons().add(new Image("calculator.png"));
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
