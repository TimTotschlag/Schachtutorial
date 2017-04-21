package Schach;

//import java.util.Arrays;



public class ChessPieces {

	boolean alive = true;
	int xPos;
	int yPos;
	String type;
	String color;

	/**
	 * Setting all attributes for this object
	 * @param xPosId
	 * @param yPosId
	 * @param typeId
	 * @param colorId
	 */
	ChessPieces(int xPosId, int yPosId, int typeId, int colorId){
		int yPos[] = {1,2,3,4,5,6,7,8};
		this.yPos = yPos[yPosId];
		int xPos[] = {1,2,3,4,5,6,7,8};
		this.xPos = xPos[xPosId];
		String type[] = {"Bauer", "Turm", "Springer", "Läufer", "Dame", "König"};
		this.type = type[typeId];
		String color[] = {"Weiß","Schwarz"};
		this.color = color[colorId];
	}

	
	/**
	 * Checking if Destination is on board
	 * @param destX
	 * @param destY
	 * @return
	 */
	boolean boardCheck(int destX, int destY){
		boolean valid = true;
		if(destX > 8 || destX < 1 || destY > 8 || destY < 1){
			valid = false;
			System.out.println("Out of borders");
		}
		return valid;
	}


	/**
	 * Displaying all attributes for this Object
	 */
	void getAll(){
		System.out.println(this.xPos + " " + this.yPos + "   " + this.type + "\t" + this.color + "\t" + this.alive);
	}

	
	/**
	 * Cycles through every Piece and Checks if it is on this Piece's Destination to take it off the playing field
	 * If same Team move is not valid
	 * @param destX
	 * @param destY
	 * @return
	 */
	boolean attack(int destX, int destY) {
		boolean valid = true;
		for (int i = 0; i < ChessBoard.bauer.length; i++) {
			if (destX == ChessBoard.bauer[i].xPos && destY == ChessBoard.bauer[i].yPos) {
				if (ChessBoard.bauer[i].color.equals(this.color) == true)
					valid = false;
				else
					ChessBoard.bauer[i].alive = false;
			}
		}
		for (int i = 0; i < ChessBoard.turm.length; i++) {
			if (destX == ChessBoard.turm[i].xPos && destY == ChessBoard.turm[i].yPos) {
				if (ChessBoard.turm[i].color.equals(this.color) == true)
					valid = false;
				else
					ChessBoard.turm[i].alive = false;
			}
		}
		for (int i = 0; i < ChessBoard.springer.length; i++) {
			if (destX == ChessBoard.springer[i].xPos && destY == ChessBoard.springer[i].yPos) {
				if (ChessBoard.springer[i].color.equals(this.color) == true)
					valid = false;
				else
					ChessBoard.springer[i].alive = false;
			}
		}
		for (int i = 0; i < ChessBoard.läufer.length; i++) {
			if (destX == ChessBoard.läufer[i].xPos && destY == ChessBoard.läufer[i].yPos) {
				if (ChessBoard.läufer[i].color.equals(this.color) == true)
					valid = false;
				else
					ChessBoard.läufer[i].alive = false;
			}
		}
		for (int i = 0; i < ChessBoard.dame.length; i++) {
			if (destX == ChessBoard.dame[i].xPos && destY == ChessBoard.dame[i].yPos) {
				if (ChessBoard.dame[i].color.equals(this.color) == true)
					valid = false;
				else
					ChessBoard.dame[i].alive = false;
			}
		}
		for (int i = 0; i < ChessBoard.könig.length; i++) {
			if (destX == ChessBoard.könig[i].xPos && destY == ChessBoard.könig[i].yPos) {
				if (ChessBoard.könig[i].color.equals(this.color) == true)
					valid = false;
				else
					ChessBoard.könig[i].alive = false;
			}
		}
		return valid;
	}

	/**
	 * Checks if a piece is between current location and Destination
	 * @param destX
	 * @param destY
	 * @return
	 */
	boolean collisionCheck(int destX, int destY) {
		int bufferX;
		int bufferY;
		int xClone = this.xPos;
		int yClone = this.yPos;
		boolean valid = true;
		bufferX = destX - xClone;
		bufferY = destY - yClone;
		for (int i = 1; i < Math.abs(bufferX); i++) {
			if (xClone == 0 || yClone == 0) {
				try {
					xClone += bufferX / Math.abs(bufferX);	
				} catch (java.lang.ArithmeticException e) {
					yClone += bufferY / Math.abs(bufferY);
				}
			} else {
				xClone += bufferX / Math.abs(bufferX);
				yClone += bufferY / Math.abs(bufferY);
			}
			valid = checkAll(valid, xClone, yClone);
		}
		return valid;
	}


	/**
	 *
	 * @param valid
	 * @param xClone
	 * @param yClone
	 * @return
	 */
	boolean checkAll(boolean valid, int xClone, int yClone) {
		for (int j = 0; j < ChessBoard.bauer.length; j++)
			if (xClone == ChessBoard.bauer[j].xPos && yClone == ChessBoard.bauer[j].yPos)
				valid = false;
		for (int j = 0; j < ChessBoard.turm.length; j++)
			if (xClone == ChessBoard.turm[j].xPos && yClone == ChessBoard.turm[j].yPos)
				valid = false;
		for (int j = 0; j < ChessBoard.springer.length; j++)
			if (xClone == ChessBoard.springer[j].xPos && yClone == ChessBoard.springer[j].yPos)
				valid = false;
		for (int j = 0; j < ChessBoard.läufer.length; j++)
			if (xClone == ChessBoard.läufer[j].xPos && yClone == ChessBoard.läufer[j].yPos)
				valid = false;
		for (int j = 0; j < ChessBoard.dame.length; j++)
			if (xClone == ChessBoard.dame[j].xPos && yClone == ChessBoard.dame[j].yPos)
				valid = false;
		for (int j = 0; j < ChessBoard.könig.length; j++)
			if (xClone == ChessBoard.könig[j].xPos && yClone == ChessBoard.könig[j].yPos)
				valid = false;
		return valid;
	}
}
