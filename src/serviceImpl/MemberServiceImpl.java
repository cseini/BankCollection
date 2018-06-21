package serviceImpl;
import java.util.*;
import domain.*;
import service.*;
public class MemberServiceImpl implements MemberService {
	Map<String,MemberBean> map;

	public MemberServiceImpl() {
		map = new HashMap<>();
	}
	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		map.put(user.getUid(), user);
	}

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("123");
		map.put(staff.getUid(), staff);
	}

	@Override
	public Map<String, MemberBean> map() {
		return map;
	}

	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp = new ArrayList<>();
		Set<MemberBean> set = new HashSet<>();
		for(Map.Entry<String,MemberBean> e: map.entrySet()) {
			if(name.equals(e.getValue().getName())) {
				set.add(e.getValue());
			}
		}
		Iterator<MemberBean> it = set.iterator();
		while(it.hasNext()) {
			temp.add(it.next());
		}
		return temp;
	}

	@Override
	public MemberBean findById(MemberBean member) {
		System.out.println("찾는 아이디"+map.get(member.getUid()));
		return map.get(member.getUid());
	}

	@Override
	public void updatePassword(MemberBean member) {
		String id = member.getUid();
		String oldPass =member.getPass().split("/")[0];
		String newPass =member.getPass().split("/")[1];
		MemberBean mem = map.get(member.getUid());
		if(mem==null) {
			System.out.println("수정하려는  ID 없음!");
		}else {
			if(oldPass.equals(map.get(id).getPass())){
				mem.setPass(newPass);
				map.put(id, mem);
			}
		}
	}

	@Override
	public void deleteMember(MemberBean member) {
		map.remove(member.getUid());
	}
}
