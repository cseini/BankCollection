package serviceImpl;
import java.util.ArrayList;
import java.util.List;
import domain.*;
import service.MemberService2;
public class MemberServiceImpl2 implements MemberService2 {
	List<MemberBean> list;

	public MemberServiceImpl2() {
		list = new ArrayList<MemberBean>();
	}
	@Override
	public void createUser(UserBean user) {
		user.setCreditRating("7등급");
		/*boolean flag = list.add(user);*/
		/*if(list.add(user)) {
			res ="등록성공";
		} else {
			res ="등록실패";
		}*/
		System.out.println("실행결과 : "+ ((list.add(user))?"등록성공":"등록실패"));
	}

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("123");
		System.out.println("실행결과 : "+ ((list.add(staff))?"등록성공":"등록실패"));
	}

	@Override
	public List<MemberBean> list() {
		return list;
	}

	@Override
	public List<MemberBean> search(String param) {
		List<MemberBean> temp = new ArrayList<>();
		for(MemberBean e: list) {
			if(param.equals(e.getName())) {
				temp.add(e);
			}
		}
		return temp;
	}

	@Override
	public MemberBean search(MemberBean member) {
		MemberBean dap = new MemberBean();
		for(MemberBean e : list) {
			if(member.getUid().equals(e.getUid())) {
				dap=e;
				break;
			}
		}
		return dap;
	}

	@Override
	public void update(MemberBean member) {
		list.get(list.indexOf(search(member))).setPass(member.getPass());
	}

	@Override
	public void delete(MemberBean member) {
		list.remove(list.indexOf(search(member)));
		//list.remove(search(member)); 위와 동일
		
	}

}
