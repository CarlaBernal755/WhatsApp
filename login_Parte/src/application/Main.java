
package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;


public class Main extends Application {

			public static TextField text;
			public static PasswordField pwr;
			
			@Override
			public void start(Stage primaryStage) {
				try {
					
					
					VBox vbx = new VBox ();
					
					Image imagen = new Image(getClass().getResourceAsStream("/Imagenes/wasppp.png"));
					ImageView vi = new ImageView(imagen);
					vi.setPreserveRatio(true);
					vi.setSmooth(true);
					vi.setCache(true);
					vbx.getChildren().add(vi);
					
					
					VBox Vbox = new VBox();
					Vbox.setStyle("-fx-background-color: #ddd");
					
					VBox vbox = new VBox();
					vbox.setSpacing(40);
					Label lnl = new Label(" USUARIO");
					TextField text = new TextField();
					Label lbl = new Label(" CONTRASEÑA");
					PasswordField  pwr= new PasswordField();
					vbox.getChildren().addAll(lnl,text,lbl, pwr);
					Vbox.getChildren().add(vbox);


					 Button btn = new Button("ACEPTAR");
					 btn.setOnAction(new EventHandler<ActionEvent> () {
						@Override
						public void handle(ActionEvent arg0) {
						if(text.getText().equals("")||(pwr.getText().equals(""))){
						 System.out.println("ingrese datos");
					 }else {
						 if((text.getText().equals("Amanecer"))&&(pwr.getText().equals("admin"))) {
							 System.out.println("ingreso acptado"); 
						 }else {
							 System.out.println("Error"); 
						 }
					 }
						}
						 
					 });
					 btn.setStyle("-fx-background-color: orange;");
					 Vbox.getChildren().add(btn);
					
							
					AnchorPane root  = new AnchorPane();
					root.getChildren().addAll(vbx, Vbox);
					
			
					AnchorPane.setBottomAnchor(vbx, 0.0);
					AnchorPane.setLeftAnchor(vbx, 0.0);
					AnchorPane.setRightAnchor(vbx,370.0);
					AnchorPane.setTopAnchor(vbx, 0.0);
					
					AnchorPane.setBottomAnchor(Vbox, 0.0);
		 	    	AnchorPane.setLeftAnchor(Vbox, 350.0);
					AnchorPane.setRightAnchor(Vbox, 0.0);
					AnchorPane.setTopAnchor(Vbox, 0.0);
					

					
					Scene scene = new Scene(root,700,350);
					primaryStage.setTitle(" WHATSAPP");
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			

			public static void main(String[] args) {
				launch(args);
			}

			
			
		}

