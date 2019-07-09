package src.za.wethinkcode.avaj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
	private static WriteFile writefile = null;
	private static FileWriter fileWriter = null;
	private static File file = null;
	private static BufferedWriter bufferedWriter = null;
	private WriteFile() { }
	public static WriteFile	getWriteFile() {
		if (writefile == null) {
			try{
				writefile = new WriteFile();
				file = new File("Simulation.txt");
				fileWriter = new FileWriter(file);
				bufferedWriter = new BufferedWriter(fileWriter);
			} catch (IOException e) { System.out.println(e); }
		}
		return writefile;
	}

	public void	writetofile(String str) {
		try {
			if (!file.exists()) { file.createNewFile(); }
			bufferedWriter.write(str);
			bufferedWriter.newLine();
		} catch (IOException e) { e.printStackTrace(); }
	}

	public void close() {
		try {
			if ( bufferedWriter != null)
				bufferedWriter.close();
		} catch (Exception e) { System.out.println("Error in closing the BufferedWriter" + e); }
	}
}