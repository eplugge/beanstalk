package nu.plugge.beanstalk;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import nu.plugge.beanstalk.models.MainModel;
import nu.plugge.beanstalk.views.MainView;
import nu.plugge.beanstalk.controllers.MainController;

public class BeanStalk extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainModel m = new MainModel();
        MainView v = new MainView();
        MainController c = new MainController(m,v);
    }
    
    public static void main() {
        launch();
    }
}
