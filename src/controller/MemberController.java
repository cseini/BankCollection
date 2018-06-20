package controller;
import javax.swing.JOptionPane;
import service.*;
import serviceImpl.*;
import domain.*;
enum MemberButt{
	EXIT,
	JOIN,ADD, //join 일반회원, add 직원추가
	COUNT, LIST,FIND_BY_ID,FIND_BY_NAME,
	UPDATE,
	WITHDRAWAL
;}
public class MemberController {
	public static void main(String[] args) {
		MemberService service= new MemberServiceImpl();
		MemberBean member=null;
		while(true) {
			switch((MemberButt) JOptionPane.showInputDialog(null,
					"MAIN PAGE",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					new MemberButt[] {
						MemberButt.EXIT,
						MemberButt.JOIN,
						MemberButt.ADD,
						MemberButt.COUNT,
						MemberButt.LIST,
						MemberButt.FIND_BY_ID,
						MemberButt.FIND_BY_NAME,
						MemberButt.UPDATE,
						MemberButt.WITHDRAWAL},
						null)) {
			case EXIT:
				return;
			case JOIN:
				member = new UserBean();
				member.setUid(JOptionPane.showInputDialog("이름"));
				service.createUser((UserBean) member);
				break;
			case ADD:
				member = new StaffBean();
				member.setUid(JOptionPane.showInputDialog("이름"));
				service.createStaff((StaffBean) member);
				break;
			case COUNT:
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.list());
				break;
			case FIND_BY_ID:
				break;
			case FIND_BY_NAME:
				break;
			case UPDATE:
				break;
			case WITHDRAWAL:
				break;
			default:
				break;
			}
		}
	}
}
