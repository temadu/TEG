package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import assets.GameManager;

public class GameIO {

	public static GameManager game;

	public static void setGame(GameManager game){
		GameIO.game = game;
	}

	public static void saveGame(){

		File file = new File("savegame/TEG.save");

		try{
			FileOutputStream saveFile = new FileOutputStream(file);
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(game);
			save.close();
			saveFile.close();
			System.out.println("Saved2");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void loadGame() throws IOException, ClassNotFoundException {

		File file = new File("savegame/TEG.save");

		FileInputStream saveFile = new FileInputStream(file);
		ObjectInputStream save = new ObjectInputStream(saveFile);
		GameManager game = (GameManager) save.readObject();
		GameManager.getInstance().loadGame(game);
		save.close();
		saveFile.close();

	}		

}


