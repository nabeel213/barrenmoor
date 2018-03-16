package barrenmoor;

import barrenmoor.Player;

public class Grid {
	int dimension1, dimension2;
	int[][] layout;
	
	public Grid(int dimension1, int dimension2, Player player) {
		this.dimension1 = dimension1;
		this.dimension2 = dimension2;
		layout = new int[dimension1][dimension2];
		
		for(int i=0; i<dimension1; i++) {
			for(int j=0; j<dimension2; j++) {
				layout[i][j] = 0;
			}
		}
		
		layout[0][0] = -1;
		layout[player.getX()][player.getY()] = 1;
	}
	
	//maps player's position on grid
	public void setCoord(int posX, int posY) {
		layout[posX][posY] = 1;
	}
	
	public void resetCoord(int posX, int posY) {
		layout[posX][posY] = 0;
	}
	
	public int checkTreasure(int posX, int posY) {
		return layout[posX][posY];
	}
	
	public void printGrid() {
		for (int[] x : layout)
		{
			for (int y : x)
			{
				System.out.print(y + " ");
			}
			System.out.println();
		}	
	}
}


