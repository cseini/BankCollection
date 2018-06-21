package serviceImpl;
import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import domain.*;
import service.AccountService;
public class AccountServiceImpl implements AccountService {
	List<AccountBean> list;
	public AccountServiceImpl() {
		list = new ArrayList<>();
	}
	@Override
	public void createAccount(AccountBean account) {
		account.setAccountType();
		account.setAccountNum(createAccountNum(randomNum()));
		account.setCreateDate(createDate());
		list.add(account);
	}

	@Override
	public void createMinusAccount(MinusAccountBean account) {
		account.setAccountType();
		account.setAccountNum(createAccountNum(randomNum()));
		account.setCreateDate(createDate());
		list.add(account);
	}

	@Override
	public List<AccountBean> list() {
		return list;
	}

	@Override
	public String createAccountNum(String random) {
		String accountNum= "";
		for(int i=0;i<3;i++) {
			randomNum();
			accountNum+=(i!=2)?random+("-"):random;
		}
		return accountNum;
	}
	@Override
	public String randomNum() {
		return String.valueOf(((int)(Math.random()*999)+1));
	}
	
	@Override
	public List<AccountBean> findByName(String name) {
		List<AccountBean> res = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			if(name.equals(list.get(i).getName())) {
				res.add(list.get(i));
			}
		}
		return res;
	}

	@Override
	public AccountBean findById(AccountBean account) {
		AccountBean res = new AccountBean();
		for(int i=0;i<list.size();i++) {
			if(account.getUid().equals(list.get(i).getUid())
					&&
					account.getPass().equals(list.get(i).getPass())) {
				res=list.get(i);
				break;
			}
		}
		return res;
	}

	@Override
	public void chagePassword(AccountBean account) {
		String pass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[1];
		account.setPass(pass);
		if(account.getUid().equals(list.get(list.indexOf(findById(account))).getUid())
				&&
			account.getPass().equals(list.get(list.indexOf(findById(account))).getPass())) {
			list.get(list.indexOf(findById(account))).setPass(newPass);
		}
	}

	@Override
	public void deleteAccount(AccountBean account) {
		String pass = account.getPass().split("/")[0];
		String rePass = account.getPass().split("/")[1];
		account.setPass(pass);
		if(account.getUid().equals(list.get(list.indexOf(findById(account))).getUid())
				&&
			account.getPass().equals(list.get(list.indexOf(findById(account))).getPass())
			&&
			rePass.equals(list.get(list.indexOf(findById(account))).getPass())) {
			list.remove(list.indexOf(findById(account)));
		}
	}
	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

}