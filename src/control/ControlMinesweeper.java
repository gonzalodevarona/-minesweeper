package control;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import gui.Menu;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.Buscaminas;
import modelo.Casilla;

public class ControlMinesweeper implements Initializable{
	
	
	
	private int level;
	private Buscaminas game;
	private Menu menu;
	
	private Button[][] buttons;
	
	
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	public ControlMinesweeper(int level) {
		this.level = level;

	}
	
	public Scene makeGrid(Stage primaryS) {
		
		HBox hbox = new HBox(12);
		
		Scene secondWindow = new Scene(hbox);
		
		GridPane gridpane = new GridPane();
		hbox.getChildren().add(gridpane);
		
		VBox vbox = new VBox();
		hbox.getChildren().add(vbox);
		
	    game = new Buscaminas(getLevel());

	    Button hint = new Button("Dar Pista");
	    Button solve = new Button("Resolver");
	    Button exit = new Button("Salir");
	    Label status = new Label("En juego");
	    vbox.getChildren().addAll(hint, solve, exit, status);
	    
		Casilla[][] c = game.darCasillas();
	    buttons = new Button[c.length][c[0].length];
		
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[0].length; j++) {	
				Button b = new Button();
				buttons[i][j] = b;
				
				b.setMaxSize(30, 30);
				b.setMinSize(30, 30);
			    
			    gridpane.add(b, j, i);
			    
			    
			    b.setOnMousePressed((event) -> {
					
			    	abrirCasilla(event,b, hint, solve, gridpane, status);
						
				});
			}
		}
				
		
		hint.setOnMousePressed((event) -> {
			
			String pos = game.darPista();
			
			System.out.println(pos);
			
			if (!(pos.equalsIgnoreCase(""))) {
				
				System.out.println("entro al if");
				String[] coordenates = pos.split(",");
				System.out.println(Arrays.deepToString(coordenates));

				int r = Integer.parseInt( coordenates[0]);
				int k = Integer.parseInt( coordenates[1]);
				
				Button b = (Button) getNodeFromGridPane(gridpane,  k, r);
				
				abrirCasilla(event, b, hint, solve, gridpane, status);
				
			}
		
		});
		
		exit.setOnAction(e-> {

			 menu = new Menu();
			try {
				menu.start(primaryS);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}); 
		
		solve.setOnAction(e-> {
			gridpane.getChildren().clear();
			
			switch (getLevel()) {
			case 1:
			
				for (int i = 0; i < Buscaminas.FILAS_PRINCIPIANTE; i++) {
					for (int j = 0; j < Buscaminas.COLUMNAS_PRINCIPIANTE; j++) {			
						Button b = new Button();
						b.setMaxSize(30, 30);
						b.setMinSize(30, 30);
					    
					    gridpane.add(b, j, i);
					    int x = GridPane.getRowIndex(b);
				    	int y = GridPane.getColumnIndex(b);
					    b.setText(game.darValorCasilla(x, y));
					    
					   
					}
				}
				break;
			case 2:
				for (int i = 0; i < Buscaminas.FILAS_INTERMEDIO; i++) {
					for (int j = 0; j < Buscaminas.COLUMNAS_INTERMEDIO; j++) {			
						Button b = new Button();
					    b.setPrefSize(8, 8);
					    b.setMaxSize(30, 30);
						b.setMinSize(30, 30);
					    
					    gridpane.add(b, j, i);
					    int x = GridPane.getRowIndex(b);
				    	int y = GridPane.getColumnIndex(b);
					    b.setText(game.darValorCasilla(x, y));
				    
					   
					}
				}
				break;
			case 3:
				for (int i = 0; i < Buscaminas.FILAS_EXPERTO; i++) {
					for (int j = 0; j < Buscaminas.COLUMNAS_EXPERTO; j++) {			
						Button b = new Button();
					    b.setPrefSize(8, 8);
					    b.setMaxSize(30, 30);
						b.setMinSize(30, 30);
					    
					    gridpane.add(b, j, i);
					    int x = GridPane.getRowIndex(b);
				    	int y = GridPane.getColumnIndex(b);
					    b.setText(game.darValorCasilla(x, y));
					    
					   
					}
				}
				break;
			default:
				break;
		}
			
			hint.setDisable(true);
	    	solve.setDisable(true);
	    	gridpane.setDisable(true);
	    	status.setText("LOSER \n PERDISTE");
		});
		
			
			
		
		
		return secondWindow;
	}

	//DISCLAIMER, THIS METHOD WAS COPIED FROM https://bit.ly/36v8aI7 IN ORDER TO GET A NODE FROM SPECIFIC POSITION OF THE GRIDPANE
	private Node getNodeFromGridPane(GridPane gridPane, int c, int r) {
	    for (Node node : gridPane.getChildren()) {
	        if (GridPane.getColumnIndex(node) == c && GridPane.getRowIndex(node) == r) {
	            return node;
	        }
	    }
	    return null;
	}
	



	
		public String abrirCasilla(MouseEvent event, Button b, Button hint, Button solve, GridPane gridpane, Label status ) {

			String symbol = "";
			
			int x = GridPane.getRowIndex(b);
	    	int y = GridPane.getColumnIndex(b);
		    
		    
		    if(event.getButton()==MouseButton.PRIMARY){
		    	
		    	
		    	
		    	
		    	if(game.abrirCasilla(x, y)) {
		    		symbol = game.darValorCasilla(x,y);
		    		
		    		
		    		b.setText(symbol);
		    		b.setDisable(true);
		    	}
		    	
		    	
		    	
		    	if (game.darPerdio()) {
			    	hint.setDisable(true);
			    	solve.setDisable(true);
			    	gridpane.setDisable(true);
			    	status.setText("LOSER \n PERDISTE");
				}
			    
			    if (game.gano()) {
			    	hint.setDisable(true);
			    	solve.setDisable(true);
			    	gridpane.setDisable(true);
			    	status.setText("VICTORIA \n CAMPAL");
			    	status.setTextFill(Color.web("#ff2800"));
			    	status.setFont(Font.font("Courier", FontWeight.BOLD, 14));
			    	
				}
				
			}
			else if(event.getButton()==MouseButton.SECONDARY){
				if(game.possibleAt(x,y)) {
					b.setText("M");
					b.setFont(Font.font("Courier", FontWeight.BOLD, 14));
					
					
				} else {
					game.impossibleAt(x,y);
					b.setText("");
				}
				
			}
			
			return symbol;
		}
		
		


	
} //end of class
