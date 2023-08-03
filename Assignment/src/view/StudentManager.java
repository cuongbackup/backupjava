package view;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import model.SinhVien;




public class StudentManager {
	private static ArrayList<SinhVien> studentList = new ArrayList<>();
	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu();
		int isStop = 0;
        boolean writeToFile = false;
		do {
			menu.printMenu();
			menu.setChoice();
			switch (menu.getChoice()) {
			case 1:
				menu.inputStudentInfo(studentList);
				writeToFile = true;
				break;
			case 2:
				if(studentList.isEmpty()) System.out.println("Danh sach dang trong");
				else menu.updateWithMaSV(studentList);
				break;
			case 3:
				if(studentList.isEmpty()) System.out.println("Danh sach dang trong");
				else menu.printData(studentList, 0);
				break;
			case 4:
				if(studentList.isEmpty()) System.out.println("Danh sach dang trong");
				else {
					menu.sortByDiemTB(studentList);
					menu.printData(studentList, 5);
				}
				break;
			case 5:
				if(studentList.isEmpty()) System.out.println("Danh sach dang trong");
				else menu.findByDiaChi(studentList);
				break;
			case 6:
				if(studentList.isEmpty()) System.out.println("Danh sach dang trong");
				else menu.removeByMSSV(studentList);
				break;
			case 7:
				if(studentList.isEmpty()) System.out.println("Danh sach dang trong");
				else menu.sortByHoTen(studentList);
				break;
                        }
			System.out.println("=========================================================");
			System.out.println("Tiep tuc chay chuong trinh? [1] dong y, [2] khong dong y");
			do {
				menu.setChoice();
				isStop = menu.getChoice();
			} while (isStop < 1 || isStop > 2);
		} while (isStop != 2);
		
	}
	
}
