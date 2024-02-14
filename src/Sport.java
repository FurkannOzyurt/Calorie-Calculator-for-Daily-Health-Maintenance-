import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Sport {
	private int sportID;
	private String nameOfSport;
	private int calorieBurned;
    static public HashMap<String, Sport> data_dict;
	
	static void set_sport_dict(String file_path) throws FileNotFoundException {
		File file = new File(file_path);
		Scanner reader = new Scanner(file);
		
		HashMap<String, Sport> sport_dict = new HashMap<String, Sport>();
		while (reader.hasNext()) 
		{
			ArrayList<Object> sport_data = new ArrayList<Object>(Arrays.asList(reader.nextLine().split("\t")));
			sport_dict.put((String) sport_data.get(0), new Sport(Integer.parseInt((String) sport_data.get(0)),(String) sport_data.get(1),Integer.parseInt((String) sport_data.get(2))));
		}
		reader.close();
		data_dict = sport_dict;
	}
	
	static HashMap<String,Sport> get_sport_dict() {
		return data_dict;
	}
	
	public Sport(int sportID, String nameOfSport, int calorieBurned) {
		this.sportID = sportID;
		this.nameOfSport = nameOfSport;
		this.calorieBurned = calorieBurned;
	}

	public int getSportID() {
		return sportID;
	}
	public void setSportID(int sportID) {
		this.sportID = sportID;
	}
	public String getNameOfSport() {
		return nameOfSport;
	}
	public void setNameOfSport(String nameOfSport) {
		this.nameOfSport = nameOfSport;
	}
	public int getCalorieBurned() {
		return calorieBurned;
	}
	public void setCalorieBurned(int calorieBurned) {
		this.calorieBurned = calorieBurned;
	}
	
	
}
