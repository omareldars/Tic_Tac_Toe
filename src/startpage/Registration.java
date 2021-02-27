package startpage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//jdbc:mysql://localhost:3306/tictactoe?zeroDateTimeBehavior=convertToNull
/**
 *
 * @author Mony
 */
public class Registration extends Application {
    
    @Override
    public void start(Stage primaryStage2) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        RegistrationFXMLBase root = new RegistrationFXMLBase(primaryStage2);
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 700, 550);
        
        primaryStage2.setTitle("Hello World!");
        primaryStage2.setScene(scene);
        primaryStage2.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
