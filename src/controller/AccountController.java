package controller;
import javax.swing.JOptionPane;
import service.*;
import serviceImpl.*;
import domain.*;
enum Butt{
	EXIT,
	ACCOUNT,
	MINUS_ACCOUNT,
	LIST,
	FIND_BY_ID,
	FIND_BY_NAME,
	MINUS_LIST,
	DEPOSIT,
	WITHDRAW,
	CHANGE_PASS,
	DELETE_ACCOUNT
;}
public class AccountController {
	public static void main(String[] args) {
		AccountService service= new AccountServiceImpl();
		AccountBean account=null;
		while(true) {
			switch((Butt) JOptionPane.showInputDialog(null,
					"MAIN PAGE",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					new Butt[] {
						Butt.EXIT,
						Butt.ACCOUNT,
						Butt.MINUS_ACCOUNT,
						Butt.LIST,
						Butt.FIND_BY_ID,
						Butt.FIND_BY_NAME,
						//Butt.MINUS_LIST,
						//Butt.DEPOSIT,
						//Butt.WITHDRAW,
						Butt.CHANGE_PASS,
						Butt.DELETE_ACCOUNT},
						null)) {
			case EXIT:
				return;
			case ACCOUNT:
				account = new AccountBean();
				account.setName(JOptionPane.showInputDialog("이름"));
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("패스워드"));
				service.createAccount(account);
				break;
			case MINUS_ACCOUNT:
				account = new MinusAccountBean();
				account.setName(JOptionPane.showInputDialog("이름"));
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("패스워드"));
				((MinusAccountBean) account).setLimit(Integer.parseInt(JOptionPane.showInputDialog("대출한도")));
				service.createMinusAccount((MinusAccountBean) account);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null, service.map());
				break;
			/*case DEPOSIT:
				break;
			case WITHDRAW:
				break;*/
			case FIND_BY_ID:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("패스워드"));
				JOptionPane.showMessageDialog(null, service.findById(account));
				break;
			case FIND_BY_NAME:
				JOptionPane.showInputDialog(service.findByName(JOptionPane.showInputDialog("이름")));
				break;
			/*case MINUS_LIST:
				break;*/
			case CHANGE_PASS:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("패스워드")
						+"/"+JOptionPane.showInputDialog("new패스워드"));
				service.chagePassword(account);
				break;
			case DELETE_ACCOUNT:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("패스워드")
						+"/"+JOptionPane.showInputDialog("패스워드 확인"));
				service.deleteAccount(account);
				break;
			default:
				break;
			}
		}
	}
}
