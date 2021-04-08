import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Student implements Serializable{
	private String MHS;
	private String TenHS;
	private float Diem;
	private String DiaChi;
	private String GhiChu;
	public Student() {
		
	}
	public Student(String MHS, String TenHS, float Diem, String DiaChi, String GhiChu) {
		setMHS(MHS);
		setTenHS(TenHS);
		setDiem(Diem);
		setDiaChi(DiaChi);
		setGhiChu(GhiChu);
	}

	public Student Input(String Id) {
		Scanner scanner = new Scanner(System.in);
//		do {
//			System.out.print("Student's ID: ");
//			MHS = scanner.nextLine();
//		}while(MHS.isEmpty());
		MHS = Id;
		do {
			System.out.print("Student's name: ");
			TenHS = scanner.nextLine();
		}while(TenHS.isEmpty());

		do {
			System.out.print("Student's score: ");
			String Score = scanner.nextLine();
			Diem = (!Score.isEmpty()) ? Float.parseFloat(Score) : -1 ;
		}while( Diem < 0 || Diem > 10);
		

		do {
			System.out.print("Student's Address: ");
			DiaChi = scanner.nextLine();
		}while(DiaChi.isEmpty());
		
		do {
			System.out.print("Student's note: ");
			GhiChu = scanner.nextLine();
		}while(GhiChu.isEmpty());
		
		return this;
	}
	public void ShowStudent() {
		System.out.println("ID: "+ MHS);
		System.out.println("Name: "+ TenHS);
		System.out.println("Score: "+ Diem);
		System.out.println("Address: "+ DiaChi);
		System.out.println("Note: "+ GhiChu + "\n");
	}
	public void Update() {
		Scanner scanner = new Scanner(System.in);
		
		do {
			System.out.print("Student's name: ");
			setTenHS(scanner.nextLine());
		}while(TenHS.isEmpty());

		do {
			System.out.print("Student's score: ");
			String Score = scanner.nextLine();
			if(!Score.isEmpty()) {
				setDiem(Float.parseFloat(Score));
			}else {
				setDiem(-1);
			}
		}while( Diem < 0 || Diem > 10);
		

		do {
			System.out.print("Student's Address: ");
			setDiaChi(scanner.nextLine());
		}while(DiaChi.isEmpty());
		
		do {
			System.out.print("Student's note: ");
			setGhiChu(scanner.nextLine());
		}while(GhiChu.isEmpty());
		
	}
	public void setMHS(String MHS) {
		this.MHS = MHS;
	}
	public void setTenHS(String TenHS) {
		this.TenHS = TenHS;
	}
	public void setDiem(float Diem) {
		this.Diem = Diem;
	}
	public void setDiaChi(String DiaChi) {
		this.DiaChi = DiaChi;
	}
	public void setGhiChu(String GhiChu) {
		this.GhiChu = GhiChu;
	}
	public String getMHS() {
		return this.MHS;
	}
	public String getTenHS() {
		return this.TenHS;
	}
	public float getDiem() {
		return this.Diem;
	}
	public String getDiaChi() {
		return this.DiaChi;
	}
	public String getGhiChu() {
		return this.GhiChu;
	}
	
//	public String toString() {
//		return "Student{" + "ID: " + MHS + "Name: " + TenHS + "Score: " + Diem + "Address: " + DiaChi + "Note: " + GhiChu + " }";
//	}
	
}
