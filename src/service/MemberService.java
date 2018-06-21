package service;
import java.util.Map;
import java.util.List;
import domain.*;
public interface MemberService {
	public void createUser(UserBean user);
	public void createStaff(StaffBean staff);
	public Map<String, MemberBean> map();
	public List<MemberBean> findByName(String param);
	public MemberBean findById(MemberBean member);
	public void updatePassword(MemberBean member);
	public void deleteMember(MemberBean member);
}
