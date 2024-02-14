import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Food {
	private int foodID;
	private String nameOfFood;
	private int calorieCount;
    static public HashMap<String, Food> data_dict;
	
	static void set_food_dict(String file_path) throws FileNotFoundException {
		File file = new File(file_path);
		Scanner reader = new Scanner(file);
		
		HashMap<String, Food> food_dict = new HashMap<String, Food>();
		while (reader.hasNext()) 
		{
			ArrayList<Object> food_data = new ArrayList<Object>(Arrays.asList(reader.nextLine().split("\t")));
			food_dict.put((String) food_data.get(0), new Food(Integer.parseInt((String) food_data.get(0)),(String) food_data.get(1),Integer.parseInt((String) food_data.get(2))));
		}
		reader.close();
		data_dict = food_dict;
	}
	
	static HashMap<String,Food> get_food_dict() {
		return data_dict;
	}
	
	public Food(int foodID, String nameOfFood, int calorieCount) {
		this.foodID = foodID;
		this.nameOfFood = nameOfFood;
		this.calorieCount = calorieCount;
	}

	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	public String getNameOfFood() {
		return nameOfFood;
	}
	public void setNameOfFood(String nameOfFood) {
		this.nameOfFood = nameOfFood;
	}
	public int getCalorieCount() {
		return calorieCount;
	}
	public void setCalorieCount(int calorieCount) {
		this.calorieCount = calorieCount;
	}
	
	
}
