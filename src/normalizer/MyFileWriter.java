package normalizer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MyFileWriter {
	
	public void writeInFile(ArrayList<String> allStringToWrite, String fileName)
			throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		for (String data : allStringToWrite) {
			printWriter.println(data);
		}

		printWriter.close();
	}
	
}
