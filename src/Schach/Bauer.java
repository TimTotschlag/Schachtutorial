package Schach;

import java.lang.Math;

public class Bauer extends ChessPieces {
	
	boolean firstMove = true;
	
	Bauer(int a,int b,int c,int d){
		super(a,b,c,d);
	}

	/**
	 * 
	 * @param xPos
	 * @param yPos
	 * @param destX
	 * @param destY
	 * @return
	 */
	boolean isValid(int xPos, int yPos,int destX,int destY){
		boolean valid = false;
		if(firstMove == true && destY - yPos == -2 && destX == xPos){
			valid = true;
			this.firstMove = false;
		}
		if(destX == xPos && destY - yPos == -1){
			valid = true;
			this.firstMove = false;
		}
		return  valid;
	}
	
	/**
	 * 
	 * @param destX
	 * @param destY
	 */
	void movePiece(int destX, int destY){
		if(isValid(this.xPos,this.yPos,destX,destY) == true){
			this.xPos = destX;
			this.yPos = destY;
		}
		else
			System.out.println("INVALID");
	}
}
