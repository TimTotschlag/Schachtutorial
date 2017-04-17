package Schach;

//import java.util.Arrays;



public class ChessPieces {
	
	int xPosId;
	int xPos; 
	int yPos;
	String type;
	String color;	

	/**
	 * Setting all attributes for chosen object
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
	
//	void setAll(int xPosId, int yPosId, int typeId, int colorId){
//		int yPos[] = {1,2,3,4,5,6,7,8};
//		this.yPos = yPos[yPosId];
//		int xPos[] = {1,2,3,4,5,6,7,8};
//		this.xPos = xPos[xPosId];
//		String type[] = {"Bauer", "Turm", "Springer", "Läufer", "Dame", "König"};
//		this.type = type[typeId];
//		String color[] = {"Weiß","Schwarz"};
//		this.color = color[colorId];
//	}
	
	
	/**
	 * Displaying all attributes for chosen object
	 */
	void getAll(){
		System.out.println(this.xPos + " " + this.yPos + " " + this.type + " " + this.color);
	}
	
//	public void setColor(int colorId){
//	String color[] = {"Weiß","Schwarz"};
//	this.color = color[colorId];
//}
// 
//
//public void setPiece(int typeId){
//	String type[] = {"Bauer", "Turm", "Springer", "Läufer", "Dame", "König"};
//	this.type = type[typeId];
//}
//
//
//public void setX(int xPosId){
//	int xPos[] = {1,2,3,4,5,6,7,8};
//	this.xPos = xPos[xPosId];
//}
//
//
//public void setY(int yPosId){
//	int yPos[] = {1,2,3,4,5,6,7,8};
//	this.yPos = yPos[yPosId];
//}
}
