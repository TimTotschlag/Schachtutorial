package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ChessBoard extends Application {
	
	static Pane mainPane = new Pane();


	static boolean choose = true;
	static int chooseX;
	static int chooseY;
	static int typeSelect = 0;
	static int pieceSelect = 0;
	static int xPos = 0;
	static int yPos = 0;
	static boolean first = true; // True if first piece of its type
	static Bauer[] bauer = new Bauer[16];
	static Turm[] turm = new Turm[4];
	static Springer[] springer = new Springer[4];
	static Läufer[] läufer = new Läufer[4];
	static Dame[] dame = new Dame[2];
	static König[] könig = new König[2];

	/**
	 * @param args
	 */
	public static void main(String[] args)throws Exception {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		mainPane = (Pane) FXMLLoader.load(ChessBoard.class.getResource("Anmeldefenster.fxml")); //lÃ¤d die fxml Datei an welches die Daten des Fensters enthÃ¤lt
		primaryStage.setScene(new Scene(mainPane)); //erstellt das Fenster
		primaryStage.setResizable(false); //Die grÃ¶ÃŸe des Fensters kann nicht verÃ¤ndert werden
		primaryStage.setTitle("Schach");
		primaryStage.show(); //Zeigt das Fenster welches man erstellt hat an
	}

	static void chooseMove(int xPos, int yPos){
		if (choose == true){
			chooseX = xPos;
			chooseY = yPos;
			choose = false;
		}
		else{
			for (int j = 0; j < bauer.length; j++) {
				if (chooseX == bauer[j].xPos && chooseY == bauer[j].yPos && bauer[j].alive == true) {
					bauer[j].makeMove(xPos, yPos);
				}
			}
			for (int j = 0; j < turm.length; j++) {
				if (chooseX == turm[j].xPos && chooseY == turm[j].yPos && bauer[j].alive == true) {
					turm[j].makeMove(xPos, yPos);
				}
			}
			for (int j = 0; j < springer.length; j++) {
				if (chooseX == springer[j].xPos && chooseY == springer[j].yPos && bauer[j].alive == true) {
					springer[j].makeMove(xPos, yPos);
				}
			}
			for (int j = 0; j < läufer.length; j++) {
				if (chooseX == läufer[j].xPos && chooseY == läufer[j].yPos && bauer[j].alive == true) {
					läufer[j].makeMove(xPos, yPos);
				}
			}
			for (int j = 0; j < dame.length; j++) {
				if (chooseX == dame[j].xPos && chooseY == dame[j].yPos && bauer[j].alive == true) {
					dame[j].makeMove(xPos, yPos);
				}
			}
			for (int j = 0; j < könig.length; j++) {
				if (chooseX == könig[j].xPos && chooseY == könig[j].yPos && bauer[j].alive == true) {
					könig[j].makeMove(xPos, yPos);
				}
			}
			choose = true;
			showAll();
		}
	}


	/**
	 * Outputs all Pieces on the board
	 */
	static void showAll(){
		for(int i = 0; i < bauer.length; i++)
			 bauer[i].getAll();
			 for(int i = 0; i < turm.length; i++)
			 turm[i].getAll();
			 for(int i = 0; i < springer.length; i++)
			 springer[i].getAll();
			 for(int i = 0; i < läufer.length; i++)
			 läufer[i].getAll();
			 for(int i = 0; i < dame.length; i++)
			 dame[i].getAll();
			 for(int i = 0; i < könig.length; i++)
			 könig[i].getAll();
			 System.out.println();
	}



	/**
	 * Used in generating the Chessboard
	 * Switching to the next type of pieces
	 * @param j
	 * @param pieceLimit, setting the limit on how many of this type should be made
	 */
	static void nextType(int j, int pieceLimit){
		if (j == pieceLimit) {
			typeSelect++;
			pieceSelect = 0;
			first = true;
		}
	}

	/**
	 * Picking out which side to choose next
	 * @param i
	 * @param xPosWhite
	 * @param yPosWhite
	 * @param xPosBlack
	 * @param yPosBlack
	 * @param pieceSelectId44
	 */
	static void chooseSide(int i,int xPosWhite,int yPosWhite,int xPosBlack,int yPosBlack,int pieceSelectId){
		if(first == true){
			switch (i){
				case 0:
					xPos = xPosWhite;
					yPos = yPosWhite;
					first = false;
					break;
				case 1:
					xPos = xPosBlack;
					yPos = yPosBlack;
					pieceSelect = pieceSelectId;
					first = false;
					break;
				}
			}
		}

	/**
	 *Creating all ChessPieces
	 */
	static void fullBoard(){
		// Setting all Chess Pieces up on a ChessBoard
				for (int i = 0; i < 2; i++) {// One Cycle for every color
					for (int j = 0; j < 16; j++) {// One Cycle for every piece
						switch (typeSelect) {

						case 0: // Case Bauer
							chooseSide(i,0,6,0,1,8);
							bauer[pieceSelect] = new Bauer(xPos, yPos, typeSelect, i);
							pieceSelect++;
							xPos++;
							nextType(j,7);
							break;

						case 1:// Case Turm
							chooseSide(i,0,7,0,0,2);
							first = false;
							turm[pieceSelect] = new Turm(xPos, yPos, typeSelect, i);
							pieceSelect++;
							xPos = xPos + 7;
							nextType(j,9);
							break;

						case 2:// Case Springer
							chooseSide(i,1,7,1,0,2);
							springer[pieceSelect] = new Springer(xPos, yPos, typeSelect, i);
							xPos = xPos + 5;
							pieceSelect++;
							nextType(j,11);
							break;

						case 3:// Case Läufer
							chooseSide(i,2,7,2,0,2);
							läufer[pieceSelect] = new Läufer(xPos, yPos, typeSelect, i);
							xPos = xPos + 3;
							pieceSelect++;
							nextType(j,13);
							break;

						case 4:// Case Dame
							chooseSide(i,3,7,4,0,1);
							dame[pieceSelect] = new Dame(xPos, yPos, typeSelect, i);
							nextType(j,14);
							break;

						case 5:// Case König
							chooseSide(i,4,7,3,0,1);
							könig[pieceSelect] = new König(xPos, yPos, typeSelect, i);
							nextType(j,15);
							typeSelect = 0;
							break;
				} // Switch End
			} // 16x Loop End
		} // 2x Loop End
	}
}