package startpage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//"E:\Drive D\ITI\Tic Tac Toe\Pages\StartPage\src\startpage\RegistrationFXMLBase.java"
public class RegistrationFXMLBase extends AnchorPane {

    protected final Label username;
    protected final TextField usernamefield;
    protected final Label email;
    protected final TextField mailfield;
    protected final Label pssword;
    protected final TextField passfield;
    protected final Button registerbtn;
    protected final Hyperlink hyperlink;
    protected Connection con;
    protected Statement stmt;
    protected final Label userErr;
    protected final Label mailErr;
    protected final Label passErr;

    public RegistrationFXMLBase(Stage primaryStage) {

   
        username = new Label();
        usernamefield = new TextField();
        email = new Label();
        mailfield = new TextField();
        pssword = new Label();
        passfield = new TextField();
        registerbtn = new Button();
        hyperlink = new Hyperlink();
        userErr = new Label();
        mailErr = new Label();
        passErr = new Label();
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);

        username.setLayoutX(161.0);
        username.setLayoutY(92.0);
        username.setText("Username");

        usernamefield.setLayoutX(226.0);
        usernamefield.setLayoutY(95.0);

        email.setLayoutX(161.0);
        email.setLayoutY(131.0);
        email.setText("Email");

        mailfield.setLayoutX(226.0);
        mailfield.setLayoutY(127.0);

        pssword.setLayoutX(161.0);
        pssword.setLayoutY(167.0);
        pssword.setText("Password");

        passfield.setLayoutX(226.0);
        passfield.setLayoutY(163.0);

        registerbtn.setLayoutX(261.0);
        registerbtn.setLayoutY(232.0);
        registerbtn.setMnemonicParsing(false);
        registerbtn.setText("Register");

        hyperlink.setLayoutX(228.0);
        hyperlink.setLayoutY(268.0);
        hyperlink.setText("Already have an Account?");

        userErr.setLayoutX(400.0);
        userErr.setLayoutY(99.0);

        mailErr.setLayoutX(400.0);
        mailErr.setLayoutY(131.0);

        passErr.setLayoutX(400.0);
        passErr.setLayoutY(167.0);

        getChildren().add(username);
        getChildren().add(usernamefield);
        getChildren().add(email);
        getChildren().add(mailfield);
        getChildren().add(pssword);
        getChildren().add(passfield);
        getChildren().add(registerbtn);
        getChildren().add(hyperlink);
        getChildren().add(userErr);
        getChildren().add(mailErr);
        getChildren().add(passErr);
        registerbtn.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            public String validatemail (String mail ){
//                 String mailregex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";
                 String mailregex = "^(.+)@(.+)$";
                Pattern emailpattern = Pattern.compile(mailregex);
                if (emailpattern.matcher(mail).matches())
                {
                    return "vaild";
                }
                else {
                       return "invaild";
                }

            }
            @Override
            public void handle(javafx.event.ActionEvent event) {
                System.out.println("xDB WorldERR11!");
                int uflag = 0, eflag = 0, pflag = 0;
               
//Username validation

                if (usernamefield.getText().length() == 0) {
                    userErr.setText("username is empty! ");
                } else {
                    userErr.setText("");
                    uflag = 1;
                }
//Email validation

                if (mailfield.getText().length() == 0) {
                    mailErr.setText("Email is empty! ");

                } else if (validatemail(mailfield.getText()) == "invaild") {
                    System.out.println("\\n Incoorreesscctt mamail");
                    mailErr.setText("Email is in Incorrect Format ! ");
                }
                else {
                    mailErr.setText("");
                    eflag = 1;
                }
//Password validation
                if (passfield.getText().length() == 0) {
                    passErr.setText("Pssword is empty! ");

                } else if (passfield.getText().length() < 6) {
                    passErr.setText("Pssword should not be less than 6 chars! ");
                } else {
                    passErr.setText(" ");
                    pflag = 1;
                }


                if (uflag == 1 && eflag == 1 && pflag == 1) {
                    try {
                        Class cls = Class.forName("com.mysql.cj.jdbc.Driver");
                        int key = 5;
                        String decPass = passfield.getText();
                        char[] chars = decPass.toCharArray();

                        StringBuilder setbuilder = new StringBuilder();

                        for (char c : chars) 
                        {
                            c += key;
                            setbuilder.append(c);

                            System.out.println(c);
                        }
                        String string = setbuilder.toString();
                        System.out.printf("Resultant String is: %s", string);
                        System.out.println("\\n DB0Y");

                        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictactoe?zeroDateTimeBehavior=convertToNull", "root", "");
                        stmt = con.createStatement();
                        stmt.executeUpdate("INSERT INTO `users` (`id`, `username`, `email`, `password`) VALUES (NULL, '" + usernamefield.getText() + "','" + mailfield.getText() + "', '" + string + "')");

                    } catch (SQLException ex) {
                        Logger.getLogger(RegistrationFXMLBase.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(RegistrationFXMLBase.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
    }
}
