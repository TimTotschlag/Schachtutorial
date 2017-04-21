package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class chessboardController {
	
	static int xPos;
	static int yPos;

    @FXML
    void a1(ActionEvent event) {
    	xPos = 1;
    	yPos = 8;
    }

    @FXML
    void a2(ActionEvent event) {
    	xPos = 1;
    	yPos = 7;
    }

    @FXML
    void a3(ActionEvent event) {
    	xPos = 1;
    	yPos = 6; 
    	ChessBoard.bauer[0].makeMove(xPos,yPos);
    	ChessBoard.showAll();
    }

    @FXML
    void a4(ActionEvent event) {
    	xPos = 1;
    	yPos = 5;
    }

    @FXML
    void a5(ActionEvent event) {
    	xPos = 1;
    	yPos = 4;
    }

    @FXML
    void a6(ActionEvent event) {
    	xPos = 1;
    	yPos = 3;
    }

    @FXML
    void a7(ActionEvent event) {
    	xPos = 1;
    	yPos = 2;
    }

    @FXML
    void a8(ActionEvent event) {
    	xPos = 1;
    	yPos = 1;
    }

    @FXML
    void b1(ActionEvent event) {
    	xPos = 2;
    	yPos = 8;
    }

    @FXML
    void b2(ActionEvent event) {
    	xPos = 2;
    	yPos = 7;
    }

    @FXML
    void b3(ActionEvent event) {
    	xPos = 2;
    	yPos = 6;
    }

    @FXML
    void b4(ActionEvent event) {
    	xPos = 2;
    	yPos = 5;
    }

    @FXML
    void b5(ActionEvent event) {
    	xPos = 2;
    	yPos = 4;
    }

    @FXML
    void b6(ActionEvent event) {
    	xPos = 2;
    	yPos = 3;
    }

    @FXML
    void b7(ActionEvent event) {
    	xPos = 2;
    	yPos = 2;
    }

    @FXML
    void b8(ActionEvent event) {
    	xPos = 2;
    	yPos = 1;
    }

    @FXML
    void c1(ActionEvent event) {
    	xPos = 3;
    	yPos = 8;
    }

    @FXML
    void c2(ActionEvent event) {
    	xPos = 3;
    	yPos = 7;
    }

    @FXML
    void c3(ActionEvent event) {
    	xPos = 3;
    	yPos = 6;
    }

    @FXML
    void c4(ActionEvent event) {
    	xPos = 3;
    	yPos = 5;
    }

    @FXML
    void c5(ActionEvent event) {
    	xPos = 3;
    	yPos = 4;
    }

    @FXML
    void c6(ActionEvent event) {
    	xPos = 3;
    	yPos = 3;
    }

    @FXML
    void c7(ActionEvent event) {
    	xPos = 3;
    	yPos = 2;
    }

    @FXML
    void c8(ActionEvent event) {
    	xPos = 3;
    	yPos = 1;
    }

    @FXML
    void d1(ActionEvent event) {
    	xPos = 4;
    	yPos = 8;
    }

    @FXML
    void d2(ActionEvent event) {
    	xPos = 4;
    	yPos = 7;
    }

    @FXML
    void d3(ActionEvent event) {
    	xPos = 4;
    	yPos = 6;
    }

    @FXML
    void d4(ActionEvent event) {
    	xPos = 4;
    	yPos = 5;
    }

    @FXML
    void d5(ActionEvent event) {
    	xPos = 4;
    	yPos = 4;
    }

    @FXML
    void d6(ActionEvent event) {
    	xPos = 4;
    	yPos = 3;
    }	

    @FXML
    void d7(ActionEvent event) {
    	xPos = 4;
    	yPos = 2;
    }

    @FXML
    void d8(ActionEvent event) {
    	xPos = 4;
    	yPos = 1;
    }

    @FXML
    void e1(ActionEvent event) {
    	xPos = 5;
    	yPos = 8;
    }

    @FXML
    void e2(ActionEvent event) {
    	xPos = 5;
    	yPos = 7;
    }

    @FXML
    void e3(ActionEvent event) {
    	xPos = 5;
    	yPos = 6;
    }

    @FXML
    void e4(ActionEvent event) {
    	xPos = 5;
    	yPos = 5;
    }

    @FXML
    void e5(ActionEvent event) {
    	xPos = 5;
    	yPos = 4;
    }

    @FXML
    void e6(ActionEvent event) {
    	xPos = 5;
    	yPos = 3;
    }

    @FXML
    void e7(ActionEvent event) {
    	xPos = 5;
    	yPos = 2;
    }

    @FXML
    void e8(ActionEvent event) {
    	xPos = 5;
    	yPos = 1;
    }

    @FXML
    void f1(ActionEvent event) {
    	xPos = 6;
    	yPos = 8;
    }

    @FXML
    void f2(ActionEvent event) {
    	xPos = 6;
    	yPos = 7;
    }

    @FXML
    void f3(ActionEvent event) {
    	xPos = 6;
    	yPos = 6;
    }

    @FXML
    void f4(ActionEvent event) {
    	xPos = 6;
    	yPos = 5;
    }

    @FXML
    void f5(ActionEvent event) {
    	xPos = 6;
    	yPos = 4;
    }

    @FXML
    void f6(ActionEvent event) {
    	xPos = 6;
    	yPos = 3;
    }

    @FXML
    void f7(ActionEvent event) {
    	xPos = 6;
    	yPos = 2;
    }

    @FXML
    void f8(ActionEvent event) {
    	xPos = 6;
    	yPos = 1;
    }

    @FXML
    void g1(ActionEvent event) {
    	xPos = 7;
    	yPos = 8;	
    }

    @FXML
    void g2(ActionEvent event) {
    	xPos = 7;
    	yPos = 7;	
    }

    @FXML
    void g3(ActionEvent event) {
    	xPos = 7;
    	yPos = 6;
    }

    @FXML
    void g4(ActionEvent event) {
    	xPos = 7;
    	yPos = 5;
    }

    @FXML
    void g5(ActionEvent event) {
    	xPos = 7;
    	yPos = 4;
    }

    @FXML
    void g6(ActionEvent event) {
    	xPos = 7;
    	yPos = 3;
    }

    @FXML
    void g7(ActionEvent event) {
    	xPos = 7;
    	yPos = 2;
    }

    @FXML
    void g8(ActionEvent event) {
    	xPos = 7;
    	yPos = 1;
    }

    @FXML
    void h1(ActionEvent event) {
    	xPos = 8;
    	yPos = 8;
    }

    @FXML
    void h2(ActionEvent event) {
    	xPos = 8;
    	yPos = 7;
    }

    @FXML
    void h3(ActionEvent event) {
    	xPos = 8;
    	yPos = 6;
    }

    @FXML
    void h4(ActionEvent event) {
    	xPos = 8;
    	yPos = 5;
    }

    @FXML
    void h5(ActionEvent event) {
    	xPos = 8;
    	yPos = 4;
    }

    @FXML
    void h6(ActionEvent event) {
    	xPos = 8;
    	yPos = 3;
    }

    @FXML
    void h7(ActionEvent event) {
    	xPos = 8;
    	yPos = 2;
    }

    @FXML
    void h8(ActionEvent event) {
    	xPos = 8;
    	yPos = 1;
    }

}
