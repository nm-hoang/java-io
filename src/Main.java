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
			file.InitializeListStudent();
			System.out.println("Initialize file student");
		}
		
//		file.Create();
		sm = file.ReadBinaryFile();					


		while(true) {
			System.out.println("\n0: Initialize list student");
			System.out.println("1: Add a student");
			System.out.println("2: Update student information");
			System.out.println("3: Delete student");
			System.out.println("4: Show list student");
			System.out.println("5: Import file");
			System.out.println("6: Export file");
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
					sm.ShowListStudent();
					sm.DeleteStudent();
					break;
				case "4":
					System.out.println("a. Increase ID \nb. Decrease ID \nc. Increase Score \nd. Decrease Score");
					System.out.print("Choose: ");
					String option = scanner.nextLine();
					switch(option) {
						case "a": {
							sm.ListIncreaseId().ShowListStudent();
							break;
						}
						case "b": {
							sm.ListIncreaseId().ReverseListStudent();
							break;
						}
						case "c": {
							sm.ListIncreaseScore().ShowListStudent();
							break;
						}
						case "d": {
							sm.ListIncreaseScore().ReverseListStudent();
							break;
						}
						default:
							break;
					}
					
					break;
				case "5":
					sm = file.ImportCSV();
					break;
				case "6":
					file.ExportCSV(sm);
					break;
				case "0":
					file.InitializeListStudent();
					break;
				case "7":
					sm.ShowListStudent();
					break;
				default:
					System.out.println("Invalid");
			}
		}
	}
}
