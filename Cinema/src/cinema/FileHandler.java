package cinema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

/** This class is a singleton object that handles reading and writing to files.
 * @author Gustaf Peter Hultgren
 * @version 0.1.1 **/
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
		if(instance != null)
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
		
		bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
		bw.write("");
		
		for(String string : data) {
			bw.append(string);
			bw.newLine();
		}
	}
	
	/** Save the given data to the previously used file.
	 * @param data -A string array containing the data to save to file.
	 * @throws IOException **/
	public void save(String[] data) throws IOException {
		BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
		bw.write("");
		
		for(String string : data) {
			bw.append(string);
			bw.newLine();
		}
	}
	
	/** Save the given data to the selected file.
	 * @param data -A string containing the data to save to file.
	 * @param path -The path to the file to save to. 
	 * @throws IOException **/
	public void save(String data, Path path) throws IOException {
		this.path = path;
		BufferedWriter bw = null;
		
		bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
		bw.write(data);
	}
	
	/** Save the given data to the previously used file.
	 * @param data -A string containing the data to save to file.
	 * @throws IOException **/
	public void save(String data) throws IOException {
		BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
		bw.write(data);
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
		}
		
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
		}
		
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
		}
		
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
		}
		
		return data;
	}
}
