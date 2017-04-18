package Schach;

import java.lang.Math;

public class Springer extends ChessPieces {
	
	Springer(int a,int b,int c,int d){
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
		if(Math.abs(destX - xPos) == 2 && Math.abs(destY - yPos) == 1)
			valid = true;
		if(Math.abs(destX - xPos) == 1 && Math.abs(destY - yPos) == 2)
			valid = true;
		return  valid;
	}
	
	void makeMove(int destX, int destY){
		if(boardCheck(destX,destY) == true)
		this.movePiece(destX, destY);
	}
}