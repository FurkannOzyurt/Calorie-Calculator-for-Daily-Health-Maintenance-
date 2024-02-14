import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class MonitorManager {
	static void monitor_manager_func(Scanner reader, BufferedWriter writer) throws IOException 
	{
		writer.write(People.monitorString.trim());
		reader.close();
		writer.close();
	}
}
