package Schach;

import java.lang.Math;

public class König extends ChessPieces {
	
	König(int a,int b,int c,int d){
		super(a,b,c,d);
	}
	
	void movePiece(int destX, int destY){
		if(isValid(this.xPos,this.yPos,destX,destY) == true){
			this.xPos = destX;
			this.yPos = destY;
		}
		else
			System.out.println("INVALID");
	}
	
	boolean isValid(int xPos, int yPos,int destX,int destY){
		boolean valid = false;
		if(Math.abs(destX - xPos) == 1 || Math.abs(destY - yPos) == 1)
			if(Math.abs(destX - xPos) < 2 && Math.abs(destY -yPos) < 2)
				valid = true;
			else
				valid = false;
		return  valid;
	}
}