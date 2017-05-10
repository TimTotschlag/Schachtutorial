package application;

public class Bauer extends ChessPieces {

	boolean firstMove = true;

	Bauer(int a,int b,int c,int d){
		super(a,b,c,d);
	}

	/**
	 *Defines Moves for Bauer
	 * @param xPos Initial X Position
	 * @param yPos Initial Y Position
	 * @param destX Final X position
	 * @param destY Final Y Position
	 * @return
	 */
	boolean isValid(int xPos, int yPos, int destX, int destY) {
		boolean valid = false;
		
		//Moves White
		if(this.color == "Weiﬂ"){
		//Moving 2 Tiles
		if (firstMove == true && destY - yPos == -2 && destX == xPos) {
			valid = true;
			this.firstMove = false;
		}
		//Moving 1 Tile
		if (destX == xPos && destY - yPos == -1) {
			valid = true;
			this.firstMove = false;
		}
		//Moving Diagonal if enemy is there
		if ((destX == xPos + 1 || destX == xPos-1) && destY == yPos -1){
			valid = isValidLoop(destX, destY, valid);
		}
		return valid;
		} 
		
		//Moves Black
		else {
		//Moving 2 Tiles
		if (firstMove == true && destY - yPos == 2 && destX == xPos) {
			valid = true;
			this.firstMove = false;
		}
		//Moving 1 Tile
		if (destX == xPos && destY - yPos == 1) {
			valid = true;
			this.firstMove = false;
		}
		//Moving Diagonal
		if ((destX == xPos + 1 || destX == xPos-1) && destY == yPos +1){
			valid = isValidLoop(destX, destY,valid);
		}
		}
		return valid;
	}


	/**
	 * Sets new X and Y Positions for this Piece if Destination is Valid
	 * @param destX Final X Position
	 * @param destY Final Y Position
	 */
	void movePiece(int destX, int destY){
		if(isValid(this.xPos,this.yPos,destX,destY) == true){
			this.xPos = destX;
			this.yPos = destY;
		}
	}

	/**
	 * If move is valid, move piece
	 * @param destX Final X Position
	 * @param destY Final Y Position
	 */
	void makeMove(int destX, int destY){
		if(boardCheck(destX,destY) == true && collisionCheck(destX,destY) == true && checkPlayer() == true){
			if(attack(destX, destY) == true)
				this.movePiece(destX, destY);
			else
				System.out.println("INVALID");
		}
	}

	/**
	 * Loop used in the is Valid Method
	 * Cycles through all pieces
	 * @param valid
	 * @return 
	 */
	boolean isValidLoop(int xPos, int yPos, boolean valid){
		for (int j = 0; j < ChessBoard.bauer.length; j++)
			if (xPos == ChessBoard.bauer[j].xPos && yPos == ChessBoard.bauer[j].yPos)
				valid = true;
		for (int j = 0; j < ChessBoard.turm.length; j++)
			if (xPos == ChessBoard.turm[j].xPos && yPos == ChessBoard.turm[j].yPos)
				valid = true;
		for (int j = 0; j < ChessBoard.springer.length; j++)
			if (xPos == ChessBoard.springer[j].xPos && yPos == ChessBoard.springer[j].yPos)
				valid = true;
		for (int j = 0; j < ChessBoard.l‰ufer.length; j++)
			if (xPos == ChessBoard.l‰ufer[j].xPos && yPos == ChessBoard.l‰ufer[j].yPos)
				valid = true;
		for (int j = 0; j < ChessBoard.dame.length; j++)
			if (xPos == ChessBoard.dame[j].xPos && yPos == ChessBoard.dame[j].yPos)
				valid = true;
		for (int j = 0; j < ChessBoard.kˆnig.length; j++)
			if (xPos == ChessBoard.kˆnig[j].xPos && yPos == ChessBoard.kˆnig[j].yPos)
				valid = true;
		return valid;
	}
	
}
