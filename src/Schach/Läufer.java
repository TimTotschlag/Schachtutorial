package Schach;

import java.lang.Math;

public class Läufer extends ChessPieces {
	
	Läufer(int a,int b,int c,int d){
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
		if(Math.abs(destX - xPos) == Math.abs(destY - yPos))
			valid = true;
		return  valid;
	}
}