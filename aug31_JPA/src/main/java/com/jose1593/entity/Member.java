package com.jose1593.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
//영속성


@Entity // 엔티티는 데이터베이스와 연결되는 자바클래스 명 = DTO
		// 클래스 명 위에 @Entity Entity를 기입함 
@Data // lombok은 자동으로 getter & setter 해준다.
@Table(name = "jmember")

@NoArgsConstructor // 생성자 만들지마 
public class Member { 
	
	@Id // 기본 키 (primary key)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 1씩 자동으로 증가 auto_increment
	private int mno;
	
	@Column(length = 10) // 너 길이 10이야 => varchar(10) 
	private String mname;
	
	@Column(unique = true) // unique 중복 
	private String mid;
	
	@Column(nullable = false)
	private String mpw;
	
	@Column(columnDefinition = "TIMESTAMP") // 년, 월, 일, 시, 분, 초
	private LocalDateTime mjoindate;
	
		

}
