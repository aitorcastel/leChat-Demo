package pgv.javafx.leChat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class TemplateApp extends Application {
	
	private static Stage primaryStage;
	private TemplateController controller;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		TemplateApp.primaryStage = primaryStage;
		
		controller = new TemplateController();
		
		primaryStage.setTitle("Le Chat v1.0.0");
		primaryStage.setScene(new Scene(controller.getView(), 640, 800));
		primaryStage.getIcons().add(new Image(getClass().getResource("/img/logo-design-by-adam-abd.jpg").toExternalForm()));
		primaryStage.show();
	}
	
	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
