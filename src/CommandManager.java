import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommandManager {
	static void command_manager_func(Scanner reader) throws NumberFormatException, IOException 
	{
		int people_counter = 0;
		while (reader.hasNext()) {
			ArrayList<Object> line = new ArrayList<Object>(Arrays.asList(reader.nextLine().split("\t")));
			
			if (line.size() == 3) 
			{
				if (((String) line.get(1)).startsWith("1")) 
				{
					People.get_people_dict().get(line.get(0)).eat((Food) Food.get_food_dict().get(line.get(1)),(int) Integer.parseInt((String) line.get(2)),reader);
				    if (!People.people_id_list.contains(line.get(0))) {
				    	People.people_id_list.add(people_counter,(String) line.get(0));
				    	people_counter += 1;
					} 
				    else 
				    {
				    	;
					}
				} 
				else 
				{
					People.get_people_dict().get(line.get(0)).do_sport((Sport) Sport.get_sport_dict().get(line.get(1)),(int) Integer.parseInt((String) line.get(2)),reader);
					if (!People.people_id_list.contains(line.get(0))) {
				    	People.people_id_list.add(people_counter,(String) line.get(0));
				    	people_counter += 1;
					} 
				    else 
				    {
				    	;
					}
				}
			} 
			else 
			{
				if (((String) line.get(0)).equals("printList")) 
				{
					People.printList(reader);	
				}
				else if (((String) line.get(0)).equals("printWarn")) 
				{
					People.printWarn(reader);
				}
				else 
				{
					String people_id_str = ((String) line.get(0)).substring(6,11);
					People.get_people_dict().get(people_id_str).print();
					People.monitorString += "***************"+"\n";
				}
			}	
		}
	}
}
