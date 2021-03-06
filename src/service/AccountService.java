package service;
import domain.*;
import java.util.Map;
import java.util.List;
public interface AccountService {
	public void createAccount(AccountBean account);
	public void createMinusAccount(MinusAccountBean account);
	public Map<String,AccountBean> map();
	public String createAccountNum();
	public String randomNum();
	public String createDate();
	public List<AccountBean> findByName(String name);
	public AccountBean findById(AccountBean account);
	public void chagePassword(AccountBean account);
	public void deleteAccount(AccountBean account);
}
