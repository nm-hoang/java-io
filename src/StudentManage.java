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
			if(students.get(i).getMHS().equals(Id)) {
				return false;
			}
		}
		return true;
	}
	public void Add() {
		Scanner scanner = new Scanner(System.in);
		Student student = new Student();	
		String Id;
		do {
			System.out.print("Student's ID: ");
			Id = scanner.nextLine();
			if(CheckId(Id)==false) {
				System.out.println("ID already exist");
			}
		}while(CheckId(Id)==false);
		
		this.students.add(student.Input(Id));
	}
	
	public void ShowListStudent() {
		
		for(int i = 0; i<students.size(); i++) {
			students.get(i).ShowStudent();;
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
	
	public void Swap(Student t1, Student t2) {
		Student temp = t1;
		t1 = t2;
		t2 = temp;
	}
	public StudentManage ListIncreaseId() {
		StudentManage sm2 = this;
		for(int i=0; i<sm2.getStudents().size()-1; i++) {
			for(int j=sm2.getStudents().size()-1; j>i; j--) {
				if(Float.parseFloat(sm2.getStudents().get(j).getMHS()) < 
					Float.parseFloat(sm2.getStudents().get(j-1).getMHS())){
					this.Swap(sm2.getStudents().get(j), sm2.getStudents().get(j-1));
				}
			}
		}
		sm2.ShowListStudent();
		return sm2;
	}
	public StudentManage ListIncreaseScore() {
		StudentManage sm2 = new StudentManage();
		sm2 = this;
		for(int i=0; i<sm2.getStudents().size()-1;i++) {
			for(int j=i+1;j<sm2.getStudents().size(); j++) {
				if(Float.compare(sm2.getStudents().get(i).getDiem(), sm2.getStudents().get(j).getDiem()) > 0) {
					Swap(sm2.getStudents().get(i), sm2.getStudents().get(j));
				}
			}
		}
		return sm2;
	}
	public void ReverseListStudent() {
		for(int i=students.size()-1; i >=0; i--) {
			students.get(i).ShowStudent();
		}
	}
}
