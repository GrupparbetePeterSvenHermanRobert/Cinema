package cinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/** This class is a singleton object that handles reading and writing to files.
 * @author Gustaf Peter Hultgren
 * @version 0.2 **/
public class FileHandler {
	/** The last path used. **/
	private Path path;
	/** The one and only instance of this class. **/
	private static FileHandler instance = null;
	
	/** Hidden constructor to prevent the creation of unauthorized instances. **/
	private FileHandler() {
		path = Paths.get("");
	}
	
	/** Get the one  one and only instance of this class.
	 *	@return The singleton instance of this object. **/
	public static FileHandler getSingleton() {
		if(instance == null)
			instance = new FileHandler();
		
		return instance;
	}
	
	/** Save the given data to the selected file.
	 * @param data -A string array containing the data to save to file.
	 * @param path -The path to the file to save to. 
	 * @throws IOException **/
	public void save(String[] data, Path path) throws IOException {
		this.path = path;
		BufferedWriter bw = null;
		
		bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
		bw.write("");
		
		for(String string : data) {
			bw.append(string);
			bw.newLine();
		}
		
		bw.close();
	}
	
	/** Save the given data to the previously used file.
	 * @param data -A string array containing the data to save to file.
	 * @throws IOException **/
	public void save(String[] data) throws IOException {
		BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
		bw.write("");
		
		for(String string : data) {
			bw.append(string);
			bw.newLine();
		}
		
		bw.close();
	}
	
	/** Save the given data to the selected file.
	 * @param data -A string containing the data to save to file.
	 * @param path -The path to the file to save to. 
	 * @throws IOException **/
	public void save(String data, Path path) throws IOException {
		this.path = path;
		BufferedWriter bw = null;
		
		bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
		bw.write(data);
		
		bw.close();
	}
	
	/** Save the given data to the previously used file.
	 * @param data -A string containing the data to save to file.
	 * @throws IOException **/
	public void save(String data) throws IOException {
		BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8);
		bw.write(data);
		
		bw.close();
	}
	
	/** Load the selected file.
	 * @param path -The path of the file.
	 * @throws IOException 
	 * @return An array of strings where each element represents a row in the file. **/
	public String[] load(Path path) throws IOException {
		this.path = path;
		BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		ArrayList<String> strings = new ArrayList<String>();
		
		String line = br.readLine();
		while(line != null)
		{
			strings.add(line);
			line = br.readLine();
		}
		
		br.close();
		
		return strings.toArray(new String[0]);
	}
	
	/** Load the selected file.
	 * @throws IOException 
	 * @return An array of strings where each element represents a row in the file. **/
	public String[] load() throws IOException {
		BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		ArrayList<String> strings = new ArrayList<String>();
		
		String line = br.readLine();
		while(line != null)
		{
			strings.add(line);
			line = br.readLine();
		}
		
		br.close();
		
		return strings.toArray(new String[0]);
	}
	
	/** Load the selected file.
	 * @param path -The path of the file.
	 * @throws IOException 
	 * @return An array of strings where each element represents a row in the file. **/
	public String loadString(Path path) throws IOException {
		this.path = path;
		BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		String data = "";
		
		String line = br.readLine();
		while(line != null)
		{
			if(data.length() > 0)
				data += "\n";
			
			data += line;
			line = br.readLine();
		}
		
		br.close();
		
		return data;
	}
	
	/** Load the selected file.
	 * @throws IOException 
	 * @return An array of strings where each element represents a row in the file. **/
	public String loadString() throws IOException {
		BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8);
		String data = "";
		
		String line = br.readLine();
		while(line != null)
		{
			if(data.length() > 0)
				data += "\n";
			
			data += line;
			line = br.readLine();
		}
		
		br.close();
		
		return data;
	}
	
	/** Main function for testing this class. **/
	public static void main(String[] args) {
		FileHandler fileHandler = FileHandler.getSingleton();
		String data[] = {"Hello", "World", "!"};
		String data2[] = {"Hello", "World", "II", "!"};
		
		
		try {
			fileHandler.save("Hello World!", Paths.get("data", "string.txt"));
			fileHandler.save("Hello World II!");
			
			fileHandler.save(data, Paths.get("data", "strings.txt"));
			fileHandler.save(data2);
			
			System.out.println(fileHandler.loadString(Paths.get("data", "string.txt")));
			System.out.println(fileHandler.loadString());
			
			String data3[] = fileHandler.load(Paths.get("data", "strings.txt"));
			for(String string : data3) {
				System.out.println(string);
			}
			
			String data4[] = fileHandler.load();
			for(String string : data4) {
				System.out.println(string);
			}
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
