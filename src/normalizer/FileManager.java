package normalizer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {

	public void givenWritingStringToFile_whenUsingPrintWriter_thenCorrect(ArrayList<String> allStringToWrite)
			throws IOException {
		FileWriter fileWriter = new FileWriter(NormalizerMain.OUTPUT_FILE);
		PrintWriter printWriter = new PrintWriter(fileWriter);

		for (String data : allStringToWrite) {
			printWriter.println(data);
		}

		printWriter.close();
	}

}
