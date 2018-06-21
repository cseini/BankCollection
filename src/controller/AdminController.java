package controller;
import javax.swing.JOptionPane;
import service.*;
import serviceImpl.*;
import domain.*;
enum AdminButt{
	EXIT,
	ADD, 
	COUNT, LIST,FIND_BY_ID,FIND_BY_NAME,
	UPDATE,
	REMOVE
;}
public class AdminController {
	public static void main(String[] args) {
		MemberService service= new MemberServiceImpl();
		MemberBean member=null;
		while(true) {
			switch((AdminButt) JOptionPane.showInputDialog(null,
					"MAIN PAGE",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					new AdminButt[] {
						AdminButt.EXIT,
						AdminButt.ADD,
						AdminButt.COUNT,
						AdminButt.LIST,
						AdminButt.FIND_BY_ID,
						AdminButt.FIND_BY_NAME,
						AdminButt.UPDATE,
						AdminButt.REMOVE},
						null)) {
			case EXIT:
				return;
			case ADD:
				member = new StaffBean();
				member.setUid(JOptionPane.showInputDialog("이름"));
				service.createStaff((StaffBean) member);
				break;
			case COUNT:
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.map());
				break;
			case FIND_BY_ID:
				break;
			case FIND_BY_NAME:
				break;
			case UPDATE:
				break;
			case REMOVE:
				break;
			default:
				break;
			}
		}
	}
}
