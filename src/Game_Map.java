import java.awt.Color;

public class Game_Map {
	final int Size = 40;
	//type 0, land
	//type 1, big block
	//type 2, chance
	//type 3, others
	//type 9, NOT assign
	int[] type = new int[Size];
	int[] id = new int[Size];
	
	//owner 0, No one
	//owner 1, player 1...
	int[] owner = new int[Size];
	String[] name = new String[Size];
	long[] value = new long[Size];
	Color[] color = new Color[Size];
}