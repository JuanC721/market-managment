package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.*;

public class FileManager {
	
	public GroceryStore loadScores(String name){
		GroceryStore groce = new GroceryStore("z", 2, 2, "z", "a");	
		File resourse = new File(name);
		if(resourse.exists()) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(resourse));
				groce = (GroceryStore)ois.readObject();
				ois.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return groce;
	}
	public void saveGroceryData(String nameOfPath, GroceryStore groceryStore) throws FileNotFoundException, IOException{
		ObjectOutputStream lop = new ObjectOutputStream(new FileOutputStream(nameOfPath));
		lop.writeObject(groceryStore);
		lop.close();
	}
}
