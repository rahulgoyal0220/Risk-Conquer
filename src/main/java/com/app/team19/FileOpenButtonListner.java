package com.app.team19;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.stream.Stream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FileOpenButtonListner extends Application implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		 final Stage dialog = new Stage();
		 String text = showSingleFileChooser();
		 dialog.initModality(Modality.APPLICATION_MODAL);
         dialog.alwaysOnTopProperty();
         dialog.isResizable();
         VBox dialogVbox = new VBox(20);
         dialogVbox.getChildren().add(new Text(text));
         Scene dialogScene = new Scene(dialogVbox, 300, 200);
         dialog.setScene(dialogScene);
         dialog.show();
		

	}

	private String showSingleFileChooser() {
		FileChooser filechooser = new FileChooser();
		File file = filechooser.showOpenDialog(null);
		StringBuilder contentBuilder = new StringBuilder();

		try (Stream<String> stream = Files.lines(file.toPath(), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(contentBuilder.toString());
		return contentBuilder.toString();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
