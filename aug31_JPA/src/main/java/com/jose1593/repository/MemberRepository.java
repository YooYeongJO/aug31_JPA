package com.jose1593.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.jose1593.entity.Member;

public interface MemberRepository extends Repository<Member, Long> { 

	List<Member> findAll();

	void save(Member member);

	// 삭제
	// String findByMid(String string); 

	List<Member> findTop5ByOrderByMnoDesc();

	@Query(value = "SELECT count(*) FROM jmember j WHERE j.mid=?1 AND j.mpw=?2", nativeQuery = true)
	int count(String mid, String mpw); //@Query 써주면 JPA는 쿼리문을 자동으로 날려줌 
	// count(*)이 int 타입으로 count 값이 나간다

	// String findByMid(Member member);

	Member findByMid(String string); // 문자열(id)이 들어오면 해당 사용자의 정보 찾아오기

	Member findByMidAndMpw(String mid, String mpw); // 로그인 = mid, mpw

}
