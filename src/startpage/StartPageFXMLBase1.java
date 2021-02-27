package startpage;

import static java.awt.SystemColor.window;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StartPageFXMLBase1 extends AnchorPane {

    protected final Button RegBtn;
    protected final Button LognBtn;
    protected final Button GuestBtn;
    protected final Label label;

    public StartPageFXMLBase1(Stage primaryStage) {

        RegBtn = new Button();
        LognBtn = new Button();
        GuestBtn = new Button();
        label = new Label();

        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        RegBtn.setLayoutX(238.0);
        RegBtn.setLayoutY(85.0);
        RegBtn.setMnemonicParsing(false);
//        RegBtn.setOnAction(this::regAction);
        RegBtn.setPrefHeight(26.0);
        RegBtn.setPrefWidth(124.0);
        RegBtn.setText("Register");

        LognBtn.setLayoutX(237.0);
        LognBtn.setLayoutY(132.0);
        LognBtn.setMnemonicParsing(false);
//        LognBtn.setOnAction(this::loginAction);
        LognBtn.setPrefHeight(26.0);
        LognBtn.setPrefWidth(126.0);
        LognBtn.setText("Login");

        GuestBtn.setLayoutX(235.0);
        GuestBtn.setLayoutY(173.0);
        GuestBtn.setMnemonicParsing(false);
//        GuestBtn.setOnAction(this::guestAction);
        GuestBtn.setPrefHeight(26.0);
        GuestBtn.setPrefWidth(129.0);
        GuestBtn.setText("Guest");

        label.setLayoutX(286.0);
        label.setLayoutY(227.0);
        label.setText("Hii");

        getChildren().add(RegBtn);
        getChildren().add(LognBtn);
        getChildren().add(GuestBtn);
        getChildren().add(label);

        RegBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello22222222222222222 World!");
//                Parent tableViewParent;
//                try {
//                     System.out.println("Hello2121 World!");
//                    tableViewParent = FXMLLoader.load(getClass().getResource("RegistrationFXMLBase.java"));
//                     Scene scene = new Scene(tableViewParent);
//                      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                      window.setScene(scene);
//                        window.show(); 
//                } catch (IOException ex) {
//                    Logger.getLogger(StartPageFXMLBase1.class.getName()).log(Level.SEVERE, null, ex);
//                }

                //This line gets the Stage information
               

               
            }
        });
    }
}
