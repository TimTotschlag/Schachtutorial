package Schach;

import java.lang.Math;

public class Turm extends ChessPieces {
	
	Turm(int a,int b,int c,int d){
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
		if((xPos == destX && yPos != destY) || (xPos != destX && yPos == destY))
			valid = true;
		return  valid;
	}
	
	void makeMove(int destX, int destY){
		if(boardCheck(destX,destY) == true)
		this.movePiece(destX, destY);
	}
}