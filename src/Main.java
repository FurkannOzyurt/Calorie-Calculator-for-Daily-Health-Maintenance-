import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		File file = new File(args[0]);
		Scanner reader = new Scanner(file);
		BufferedWriter writer = new BufferedWriter(new FileWriter("monitoring.txt"));
		
		People.set_people_dict("people.txt");
		Food.set_food_dict("food.txt");
		Sport.set_sport_dict("sport.txt");
		
		CommandManager.command_manager_func(reader);
		MonitorManager.monitor_manager_func(reader, writer);
	}
}
