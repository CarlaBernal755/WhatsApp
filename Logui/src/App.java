import java.util.List;

import dominio.Contact;
import dominio.Mensaje;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import repository.MessageRepository;

public class App extends Application {


    
    public int User= 0;
    public int contact = 1;

 
    MessageRepository messageRepository = new MessageRepository();


    
    @Override
    public void start(Stage primaryStage) throws Exception {

         // Verde
         ScrollPane scrollPane2 = new ScrollPane();
         scrollPane2.setVbarPolicy(ScrollBarPolicy.ALWAYS);
         scrollPane2.setStyle("-fx-background-color: #77ff33");
         
         VBox vBox2 = new VBox(8);
         scrollPane2.setContent(vBox2);
         List <Contact> res= messageRepository.getContact(contact);

         for (Contact usr: res) {

            Image image = new Image(getClass().getResourceAsStream("./Images/Armando.png"));
            Image image2 = new Image(getClass().getResourceAsStream("./Images/Luis.png"));
            ImageView imageView = new ImageView(image);
 

             imageView.setFitHeight(50);
             imageView.setFitWidth(50);


             FlowPane flowPane2 = new FlowPane();
             
             flowPane2.setPrefWidth(300);
             
             Label lblName = new Label(usr.getNombreContact());
            
             flowPane2.setOnMouseClicked( event -> {
             String contact = String.valueOf(lblName.getText());
             System.out.print(contact);
             });

             if (usr.getNombreContact()=="Yo") {
                imageView.setImage(image2);
                
             }

             flowPane2.getChildren().addAll(imageView,lblName);
             vBox2.getChildren().add(flowPane2);
        }
     


    List<Mensaje> resultMe= messageRepository.getMessage(User, contact);

     // ROJO
     ScrollPane scrollPane = new ScrollPane();
     scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
     scrollPane.setStyle("-fx-background-color:#FF3333");
     

     VBox vBox = new VBox();

     scrollPane.setContent(vBox);

     // String User = "Armando";
     System.out.print(User); 
    

    

     for (Mensaje msg: resultMe) {
         FlowPane flowPane = new FlowPane(10,10);
        //  Label lblImage = new Label(msg.getContact());
         Label lblMessage = new Label(msg.getContent());
        //  flowPane.getChildren().addAll(lblImage);
         flowPane.getChildren().addAll(lblMessage);
         vBox.getChildren().add(flowPane);
         
     }

   

     FlowPane flowPane = new FlowPane();
     flowPane.setPrefHeight(50);
     flowPane.setStyle("-fx-background-color: #ddd");

     TextField input = new TextField();
     input.setPromptText("Escribe un mensaje aqui");


     Button btn = new Button("Send");
     btn.setOnAction(new EventHandler<ActionEvent>() {

         @Override
         public void handle(ActionEvent event) {

             Image image1 = new Image(getClass().getResourceAsStream("./Images/Luis.png"));
             ImageView imageView = new ImageView(image1);
             imageView.setFitHeight(50);
             imageView.setFitWidth(50);
             FlowPane flowPane = new FlowPane();
             Label lblMessage = new Label(input.getText());

             flowPane.getChildren().add(lblMessage);
             flowPane.getChildren().add(imageView);
             vBox.getChildren().add(flowPane);
         }
     });

     flowPane.getChildren().addAll(input,btn);


     AnchorPane root = new AnchorPane();
     root.getChildren().addAll(scrollPane,scrollPane2,flowPane);


     AnchorPane.setBottomAnchor(scrollPane, 50.0);
     AnchorPane.setLeftAnchor(scrollPane, 300.0);
     AnchorPane.setRightAnchor(scrollPane, 0.0);
     AnchorPane.setTopAnchor(scrollPane, 0.0);
     
     AnchorPane.setBottomAnchor(flowPane, 0.0);
     AnchorPane.setLeftAnchor(flowPane, 300.0);
     AnchorPane.setRightAnchor(flowPane, 0.0);

     AnchorPane.setBottomAnchor(scrollPane2, 50.0);
     AnchorPane.setTopAnchor(scrollPane2, 0.0);
     AnchorPane.setBottomAnchor(scrollPane2, 0.0);

     

     Scene scene = new Scene(root,1290,720);
     primaryStage.setScene(scene);
     primaryStage.setTitle("Discordia");
     primaryStage.show();


 }

    


    public static void main(String[] args) {
        launch(args);
    }





}
