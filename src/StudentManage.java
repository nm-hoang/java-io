import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManage implements Serializable{
	protected List<Student> students;
	
	public StudentManage() {
		this.students = new ArrayList<>();
	}
	public List<Student> getStudents() {
		return this.students;
	}
	
	public boolean CheckId(String Id) {
		for(int i = 0; i<students.size(); i++) {
			if(Id == students.get(i).getMHS()) {
				return false;
			}
		}
		return true;
	}
	public void Add() {
		Scanner scanner = new Scanner(System.in);
		Student student = new Student();	
		String Id;
		System.out.print("Student's ID: ");
		Id = scanner.nextLine();
		do {
			System.out.print("ID already exist \n Student's ID: ");
			Id = scanner.nextLine();
		}while(CheckId(Id)==false);
		
		this.students.add(student.Input(Id));
	}
	
	public void ShowListStudent() {
		Student student = new Student();
		for(int i = 0; i<students.size(); i++) {
			student.ShowStudent(students.get(i));
		}
	}
	public int GetIndexById(String id) {
		for(int i = 0; i < students.size(); i++) {
			if(students.get(i).getMHS().equals(id)) {
				return i;
			}
		}
	
	  return -1;
	}
	public void Update() {
		Scanner scanner = new Scanner(System.in);
		this.ShowListStudent();
		System.out.print("Choose student's ID to update: ");
		String chooseId = scanner.nextLine();
		System.out.println(chooseId);
		Student student = new Student();
		if(this.GetIndexById(chooseId) >=0 ) {
			students.get(this.GetIndexById(chooseId)).Update();
		}else {
			System.out.println("Student's ID invalid!!!");
		}
//		student.ShowStudent(student);	
	}
	public void DeleteStudent() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Type student's ID you want to DELETE: ");
		String Id = scanner.nextLine();
		int index =  this.GetIndexById(Id);
		if(index < 0) {
			System.out.println("ID invalid!!!");
		}else {
			students.remove(index);			
			System.out.println("Delete successful!");
		}
	}
}
