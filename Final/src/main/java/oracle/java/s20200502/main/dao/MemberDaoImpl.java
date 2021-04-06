package oracle.java.s20200502.main.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import oracle.java.s20200502.main.model.Member;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession sqlSession;
	@Override
	//로그인 체크 Dao
	public Member login(Member member, HttpSession session) {	
		System.out.println("MemberDaoImpl login Start()=>" + member.getM_email());
		System.out.println("MemberDaoImpl login Start()=>" + member.getM_password());
		System.out.println("MemberDaoImpl memberShip Start()=>" + member.getM_ban());
			return sqlSession.selectOne("loginSelect", member);
			
	}
	//회원가입 처리 Dao
	@Override
	public int memberShip(Member member) {
		System.out.println("MemberDaoImpl memberShipDao Start()=>" + member.getM_email());
		System.out.println("MemberDaoImpl memberShipDao Start()=>" + member.getM_password());
		System.out.println("MemberDaoImpl memberShipDao Start()=>" + member.getM_nickname());
		System.out.println("MemberDaoImpl memberShipDao Start()=>" + member.getM_phone());
		System.out.println("MemberDaoImpl memberShipDao Start()=>" + member.getM_bizname());
		System.out.println("MemberDaoImpl memberShipDao Start()=>" + member.getM_biznum());
		System.out.println("MemberDaoImpl memberShipDao Start()=>" + member.getM_name());
		return sqlSession.selectOne("memberShipInsert", member);
	}
	//이메일 중복체크
	@Override
	public Member duplicateCheck(Member member) {
		System.out.println("MemberDaoImpl duplicateCheck Start eamil()=>" + member.getM_email());
		return sqlSession.selectOne("duplicateCheck", member);
	}
	//회원정보 수정
	@Override
	public Member myInfoSave(Member member) {
		System.out.println("MemberDaoImpl myInfoSave Start=>" + member.getM_num());
		return sqlSession.selectOne("myInfoSave", member);
	}
	//닉네임 체크
	@Override
	public Member nickNameCheck(Member member) {
		System.out.println("MemberDaoImpl nickNameCheck Start=>" + member.getM_nickname());
		return sqlSession.selectOne("nickNameCheck", member);
	}
	//회원정보 삭제 dao
	@Override
	public Member memberDelete(Member member) {
		System.out.println("MemberDaoImpl memberDelete Start=>" + member.getM_num());
		return sqlSession.selectOne("memberDelete", member);
	}
	//패스워드 변경 dao
	@Override
	public Member pwChange(Member member) {
		System.out.println("MemberDaoImpl pwChage Start=>" + member.getM_password());
		return sqlSession.selectOne("pwChange", member);
	}
	//비밀번호 찾기
	@Override
	public Member emailNumSearch(Member member) {
		System.out.println("MemberDaoImpl emailNumSearchStart=>" + member.getM_email());
			return sqlSession.selectOne("emailNumSearch", member);
	}
	//이메일 찾기
	@Override
	public Member idExistenceChk(Member member) {
		System.out.println("MemberDaoImpl idExistenceChk Start=>" + member.getM_name());
		System.out.println("MemberDaoImpl idExistenceChk Start=>" + member.getM_phone());
			return sqlSession.selectOne("idExistenceChk", member);
	}
	//패스워드 재설정
	@Override
	public Member PassSearch(Member member) {
		System.out.println("MemberDaoImpl pwChage Start=>" + member.getM_num());
		return sqlSession.selectOne("pwChange", member);
	}
	//회원정보 수정 업데이트
	@Override
	public Member myIfoUpdate(Member member, HttpSession session) { 
		System.out.println("MemberDaoImpl myIfoUpdate Start=>" + member.getM_num());
		return sqlSession.selectOne("myInfoUpdate", member);
	}
	
}
