import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
public class FileIO{
	private static final String COMMA_DELIMITER = null;
	private String path = "student.txt";
	public String getPath() {
		return path;
	}
	public void InitializeListStudent(){
		Student st1 = new Student("1", "hoang", 6, "Dalat", "note");
		Student st2 = new Student("2", "giang", 10, "Tien Giang", "note");
		Student st3 = new Student("3", "minh", 8, "Sai Gon", "note");
		Student st4 = new Student("4", "nguyen", 9, "Lam Dong", "note");
		StudentManage sm = new StudentManage();
		sm.students.add(st1);
		sm.students.add(st2);
		sm.students.add(st3);
		sm.students.add(st4);
//		System.out.println(sm);
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
	
	public StudentManage ReadBinaryFile() {
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
	public void WriteBinaryFile(StudentManage sm) {
		File f = new File(path);
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(sm);
			oos.close();
			System.out.println("data write successful \n");
		}catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public StudentManage ImportCSV() {
		StudentManage sm2 = new StudentManage();
		try (BufferedReader br = new BufferedReader(new FileReader("import.csv"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(",");
		        Student st = new Student(values[0],values[1],Float.parseFloat(values[2]),values[3],values[4]);		        
	        	sm2.students.add(st);
//		        records.add(Arrays.asList(values));
		    }
		    System.out.println("Import done!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sm2;
	}
	public void ExportCSV(StudentManage sm) {
	    try (PrintWriter writer = new PrintWriter(new File("export.csv"))) {
	      StringBuilder sb = new StringBuilder();
	     for(Student st : sm.students) {
	    	 sb.append(st.getMHS()+","+st.getTenHS()+","+st.getDiem()+","+st.getDiaChi()+","+st.getGhiChu()+"\n");
	     }

	      writer.write(sb.toString());
	      System.out.println("Export done!");
	    } catch (FileNotFoundException e) {
	      System.out.println(e.getMessage());
	    }
	}
	
	
}
