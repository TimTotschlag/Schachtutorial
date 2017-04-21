package Schach;

public class Turm extends ChessPieces {

	Turm(int a,int b,int c,int d){
		super(a,b,c,d);
	}

	/**
	 * If X or Y (not both) have changed, move is valid
	 * @param xPos
	 * @param yPos
	 * @param destX
	 * @param destY
	 * @return
	 */
	boolean isValid(int xPos, int yPos,int destX,int destY){
		boolean valid = false;
		if((xPos == destX && yPos != destY) || (xPos != destX && yPos == destY))
			valid = true;
		return  valid;
	}

	/**
	 * Sets new X and Y Positions for this Piece if Destination is Valid
	 * @param destX
	 * @param destY
	 */
	void movePiece(int destX, int destY){
		if(isValid(this.xPos,this.yPos,destX,destY) == true){
			this.xPos = destX;
			this.yPos = destY;
		}
	}



	/**
	 * If move is valid, move piece
	 * @param destX
	 * @param destY
	 */
	void makeMove(int destX, int destY){
		if(boardCheck(destX,destY) == true && collisionCheck(destX,destY) == true){
			if(attack(destX, destY) == true)
				this.movePiece(destX, destY);
			else
				System.out.println("INVALID");
		}
	}
}