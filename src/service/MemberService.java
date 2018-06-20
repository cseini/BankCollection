package service;
import java.util.List;
import domain.*;
public interface MemberService {
	public void createUser(UserBean user);
	public void createStaff(StaffBean staff);
	public List<MemberBean> list();
	public List<MemberBean> search(String param);
	public MemberBean search(MemberBean member);
	public void update(MemberBean member);
	public void delete(MemberBean member);
}
