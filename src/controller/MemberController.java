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
				member.setName(JOptionPane.showInputDialog("이름"));
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPass(JOptionPane.showInputDialog("비밀번호"));
				member.setSsn(JOptionPane.showInputDialog("주민번호"));
				member.setAddr(JOptionPane.showInputDialog("주소"));
				member.setPhone(JOptionPane.showInputDialog("전화번호"));
				member.setEmail(JOptionPane.showInputDialog("이메일"));
				service.createUser((UserBean) member);
				break;
			case ADD:
				member = new StaffBean();
				member.setName(JOptionPane.showInputDialog("이름"));
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPass(JOptionPane.showInputDialog("비밀번호"));
				member.setSsn(JOptionPane.showInputDialog("주민번호"));
				member.setAddr(JOptionPane.showInputDialog("주소"));
				member.setPhone(JOptionPane.showInputDialog("전화번호"));
				member.setEmail(JOptionPane.showInputDialog("이메일"));
				service.createStaff((StaffBean) member);
				break;
			case COUNT:
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.map());
				break;
			case FIND_BY_ID:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPass(JOptionPane.showInputDialog("비밀번호"));
				JOptionPane.showMessageDialog(null,service.findById(member));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null,service.findByName(JOptionPane.showInputDialog("이름")));
				break;
			case UPDATE:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPass(JOptionPane.showInputDialog("비밀번호"));
				service.updatePassword(member);
				break;
			case WITHDRAWAL:
				member = new MemberBean();
				member.setUid(JOptionPane.showInputDialog("아이디"));
				member.setPass(JOptionPane.showInputDialog("비밀번호"));
				service.deleteMember(member);
				break;
			default:
				break;
			}
		}
	}
}
