import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;
public class FileIO{
	private String path = "student.txt";
	public String getPath() {
		return path;
	}
	public void Create(){
		Student st1 = new Student("1", "hoang", 6, "Dalat", "note");
		Student st2 = new Student("2", "giang", 10, "Tien Giang", "note");
		Student st3 = new Student("3", "minh", 8, "Sai Gon", "note");
		Student st4 = new Student("5", "nguyen", 9, "Lam Dong", "note");
		StudentManage sm = new StudentManage();
		sm.students.add(st1);
		sm.students.add(st2);
		sm.students.add(st3);
		sm.students.add(st4);
		System.out.println(sm);
		File f = new File(path);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sm);
			oos.close();
			System.out.println("data write successful");
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public StudentManage Read() {
		File f = new File(path);
		StudentManage sm = new StudentManage();
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			sm = (StudentManage) ois.readObject();
			sm.ShowListStudent();
			ois.close();
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sm;
	}
	public void Write() {
		
	}
}
