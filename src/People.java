import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class People {
	private int personID;
	private String name;
	private String gender;
	private int weight;
	private int height;
	private int dateOfBirth;
	private int calories_taken;
	private int calories_burned;
	static public HashMap<String, People> data_dict;
	
	static ArrayList<String> people_id_list = new ArrayList<String>();
	static String monitorString = "";
	
	static void set_people_dict(String file_path) throws FileNotFoundException {
		File file = new File(file_path);
		Scanner reader = new Scanner(file);
		
		HashMap<String, People> people_dict = new HashMap<String, People>();
		while (reader.hasNext()) 
		{
			ArrayList<Object> people_data = new ArrayList<Object>(Arrays.asList(reader.nextLine().split("\t")));
			people_dict.put((String) people_data.get(0), new People(Integer.parseInt((String) people_data.get(0)),(String) people_data.get(1),(String) people_data.get(2),Integer.parseInt((String) people_data.get(3)),Integer.parseInt((String) people_data.get(4)),Integer.parseInt((String) people_data.get(5))));
		}
		reader.close();
		data_dict = people_dict;
	}
	
	static HashMap<String,People> get_people_dict() {
		return data_dict;
	}
	
	public People(int personID, String name, String gender, int weight, int height, int dateOfBirth) {
		this.personID = personID;
		this.name = name;
		this.gender = gender;
		this.weight = weight;
		this.height = height;
		this.dateOfBirth = dateOfBirth;
	}
	
	public int getCalories_taken() {
		return calories_taken;
	}

	public void setCalories_taken(int calories_taken) {
		this.calories_taken = calories_taken;
	}

	public int getCalories_burned() {
		return calories_burned;
	}

	public void setCalories_burned(int calories_burned) {
		this.calories_burned = calories_burned;
	}

	public int getPersonID() {
		return personID;
	}
	public void setPersonID(int personID) {
		this.personID = personID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(int dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public int age() {
		return 2022 - this.dateOfBirth;
	}
	
	public double dailyCalorieNeeds() {
		if (this.gender.equals("male")) 
		{
			double dailyCalorieNeeds_male = 66 + (13.75 * this.weight) + (5 * this.height) - (6.8 * this.age());
			return Math.rint(dailyCalorieNeeds_male);
		} 
		else 
		{
			double dailyCalorieNeeds_female = 665 + (9.6 * this.weight) + (1.7 * this.height) - (4.7 * this.age());
			return Math.rint(dailyCalorieNeeds_female);
		}
	}
	
    public void eat(Food food, int portion, Scanner reader) throws IOException {
		People.monitorString += this.personID +"\t"+ "has" +"\t"+ "taken" +"\t"+ (food.getCalorieCount() * portion) + "kcal" +"\t"+ "from" +"\t"+ food.getNameOfFood() +"\n";
		if (reader.hasNext()) {
			People.monitorString += "***************"+"\n";
		}
		this.calories_taken += (food.getCalorieCount() * portion);
    }
	
    public void do_sport(Sport sport, int minute, Scanner reader) throws IOException {
    	People.monitorString += this.personID +"\t"+ "has" +"\t"+ "burned" +"\t"+ ((int) (sport.getCalorieBurned() * (minute / 60))) + "kcal" +"\t"+ "thanks to" +"\t"+ sport.getNameOfSport()+"\n";
    	if (reader.hasNext()) {
    		People.monitorString += "***************"+"\n";
		}
    	this.calories_burned += (int) ((sport.getCalorieBurned() * ((double) minute / (double) 60)));
    }
    
    public String result() {
		int result_int = (int) Math.rint((this.dailyCalorieNeeds() - (this.calories_taken - this.calories_burned)));
		if (result_int > 0) 
		{
			return "-" + String.valueOf(result_int) + "kcal";
		}
		else if (result_int < 0) 
		{
			return "+" + String.valueOf(result_int).substring(1) + "kcal";
		}
		else 
		{
			return String.valueOf(result_int) + "kcal";
		}
	}
    
    public void print() throws IOException {
    	People.monitorString += this.name +"\t"+ this.age() +"\t"+ (int) this.dailyCalorieNeeds() + "kcal" +"\t"+ this.calories_taken + "kcal" +"\t"+ this.calories_burned + "kcal" +"\t"+ this.result()+"\n";
    }
    
    static void printList(Scanner reader) throws IOException {
    	for (String people_id : People.people_id_list) 
		{
			People.get_people_dict().get(people_id).print();
		}
    	if (reader.hasNext()) {
    		People.monitorString += "***************"+"\n";
		}
	}
    
    static void printWarn(Scanner reader) throws IOException {
    	int warned_people = 0;
    	for (String people_id : People.people_id_list) 
		{
			if (People.get_people_dict().get(people_id).result().startsWith("+")) 
			{
				People.get_people_dict().get(people_id).print();
				warned_people += 1;
			} 	
		}
    	
    	if (warned_people == 0) 
    	{
    		People.monitorString += "there" +"\t"+ "is" +"\t"+ "no" +"\t"+ "such" +"\t"+ "person"+"\n";
    	}
    	
    	if (reader.hasNext()) {
    		People.monitorString += "***************"+"\n";
		}
    }	
}
