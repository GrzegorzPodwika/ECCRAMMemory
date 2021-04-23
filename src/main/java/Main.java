import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layouts/main-layout.fxml"));
        Parent root = fxmlLoader.load();
        Controller controller = fxmlLoader.getController();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ECC RAM");
        primaryStage.setResizable(false);
        primaryStage.setOnHidden(e -> controller.shutdown());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
