/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Propuesta de soluci�n laboratorio Unidad 5
 * @author Camilo Barrios - camilo.barrios@correo.icesi.edu.co
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */


package gui;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Buscaminas;
import control.*;

public class Menu extends Application{
	
	ControlMinesweeper controlGame;
	
	/**
	 * Metodo main
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
		controlGame = new ControlMinesweeper(0);
		VBox vbox = new VBox(2);
		vbox.setId("vbox");
		

		VBox vboxIn = new VBox();
		
		Label firstMessage = new Label(" BIENVENIDO AL BUSCAMINAS \n \n Desarrollado por: Lord Camilo Barrios \n <groovy.kmilo@gmail.com> \n Universidad Icesi \n \n");
		firstMessage.setTextFill(Color.web("#000000"));
		firstMessage.setFont(Font.font("Courier", FontWeight.BOLD, 12.8));
		vboxIn.getChildren().add(firstMessage);
		vboxIn.setAlignment(Pos.CENTER);
		
		vbox.getChildren().add(vboxIn);
		
		
		
		Button b = new Button("Fácil");
		Button b1 = new Button("Intermedio");
		Button b2 = new Button("Difícil");
		HBox hbox = new HBox(2);
		
		
		hbox.getChildren().add(b);
		hbox.getChildren().add(b1);
		hbox.getChildren().add(b2);
		hbox.setAlignment(Pos.CENTER);
		
		vbox.getChildren().add(hbox);
		vbox.setAlignment(Pos.CENTER);
		
		Label askLevel = new Label("Por favor seleccione una dificultad:");
		askLevel.setTextFill(Color.web("#fc9e4c"));
		askLevel.setFont(new Font("Courier", 12));
		vbox.getChildren().add(askLevel);
		
		b.setOnAction(e->{
			
			makeGrid(primaryStage, Buscaminas.PRINCIPIANTE);
		});
		
		b1.setOnAction(e->{
			
			makeGrid(primaryStage, Buscaminas.INTERMEDIO);
		});
		
		b2.setOnAction(e->{
			
			makeGrid(primaryStage, Buscaminas.EXPERTO);
		
		});
		
		
		Scene scene = new Scene(vbox,300,200);
		
		scene.getStylesheets().add(getClass().getResource("style4Menu.css").toExternalForm());
//		primaryStage.setResizable(false);
		primaryStage.setTitle("MINESWEEPER");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		}  catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void makeGrid(Stage primaryS, int difficult) {
		controlGame.setLevel(difficult);
		Scene second = controlGame.makeGrid(primaryS);
		
		primaryS.setScene(second);
		
	}
	
		
	
} //end of class
