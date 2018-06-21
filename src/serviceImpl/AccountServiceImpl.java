package serviceImpl;
import java.util.*;
import java.text.SimpleDateFormat;
import domain.*;
import service.AccountService;
public class AccountServiceImpl implements AccountService {
	Map<String, AccountBean> map;
	public AccountServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void createAccount(AccountBean account) {
		account.setAccountType();
		account.setAccountNum(createAccountNum());
		account.setCreateDate(createDate());
		map.put(account.getUid(),account);
	}

	@Override
	public void createMinusAccount(MinusAccountBean account) {
		account.setAccountType();
		account.setAccountNum(createAccountNum());
		account.setCreateDate(createDate());
		map.put(account.getUid(), account);
	}

	@Override
	public Map<String, AccountBean> map() {
		return map;
	}

	@Override
	public String createAccountNum() {
		String accountNum= "";
		for(int i=0;i<3;i++) {
			accountNum+=(i!=2)?randomNum()+("-"):randomNum();
		}
		return accountNum;
	}
	@Override
	public String randomNum() {
		return String.valueOf(((int)(Math.random()*999)+1));
	}
	
	@Override
	public List<AccountBean> findByName(String name) {
		List<AccountBean> temp = new ArrayList<>();
		Set<AccountBean> set = new HashSet<>();
		for(Map.Entry<String, AccountBean> e : map.entrySet()) {
			if(name.equals(e.getValue().getName())) {
				set.add(e.getValue());
			}
		}
		Iterator<AccountBean> it = set.iterator();
		while(it.hasNext()) {
			temp.add(it.next());
		}
		return temp;
	}

	@Override
	public AccountBean findById(AccountBean account) {
		return map.get(account.getUid());
	}

	@Override
	public void chagePassword(AccountBean account) {
		String id = account.getUid();
		String oldPass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[1];
		AccountBean acc = map.get(account.getUid());
		if(acc==null) {
			System.out.println("수정하려는 아이디 없음");
		} else {
			if(oldPass.equals(map.get(acc.getUid()).getPass()));
			acc.setPass(newPass);
			map.put(id, acc);
		}
	}

	@Override
	public void deleteAccount(AccountBean account) {
		map.remove(findById(account).getUid());
	}
	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}
}