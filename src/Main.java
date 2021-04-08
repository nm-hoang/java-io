import java.io.*;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		FileIO file = new FileIO();
		
		StudentManage sm = new StudentManage();
		File f = new File(file.getPath());
		//Load student manage from file
		if(!f.exists()) { 
			file.Create();
			System.out.println("Initialize file student");
		}
		sm = file.Read();					


		while(true) {
			System.out.println("1: Add a student");
			System.out.println("2: Update student information");
			System.out.println("3: Delete student");
			System.out.println("4: Show list student");
			
			System.out.print("Choose: ");
			String line = scanner.nextLine();
			switch(line) {
				case "1":{
					sm.Add();
					break;
				}
				case "2":{
					sm.Update();
					break;
				}
				case "3":
					sm.DeleteStudent();
					break;
				case "4":
					sm.ShowListStudent();
					break;
				case "5":
					file.Read();
					break;
				case "6":
					file.Create();
					break;
				default:
					System.out.println("Invalid");
			}
		}
	}
}
