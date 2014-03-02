package csci567.rj.project4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import android.content.Context;

public class FileModel {
	
	public static final String FILENAME = "data.txt";
	
	private File dataFile;
	
	public FileModel(String baseDir) {
		this.dataFile = new File(baseDir, FileModel.FILENAME);
	}
	
	public String readFile() {
		String s;
		StringBuilder sb = new StringBuilder();
		int num_read, offset = 0;
		if (!this.dataFile.exists()) {
			return "";
		}
		
		try {
			FileInputStream fis   = new FileInputStream(this.dataFile);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br     = new BufferedReader(isr);
			
			s = br.readLine();
			
			while (s != null) {
				sb.append(s);
				sb.append('\n');
				s = br.readLine();
			}
			
			br.close();
			isr.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("string: " + sb.toString());
		
		return sb.toString();
	}
	
	public void appendFile(String s) {
		try {
			FileOutputStream fos = new FileOutputStream(this.dataFile, true);
			fos.write(s.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void writeFile(String s) {
		try {
			FileOutputStream fos = new FileOutputStream(this.dataFile, false);
			fos.write(s.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
