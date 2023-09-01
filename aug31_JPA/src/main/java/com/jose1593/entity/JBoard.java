package com.jose1593.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.LastModifiedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class JBoard {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int bno;
	
	@Column(name="btitle", length = 15)
	private String title;
	
	@Column(name="bcontent", columnDefinition = "MEDIUMTEXT")
	private String content;
	
	@LastModifiedDate // 수정된다면 마지막 수정 시간으로 바꿔줌
	@Column(columnDefinition="TIMESTAMP")
	private LocalDateTime bdate;
	
	
	@ManyToOne(fetch = FetchType.LAZY) // LAZY = 지연, 지금 바로 가져오는게 아니라 조금 늦게
	@JoinColumn(name="mno") // mno를 기준으로 join
	private Member member; // Member 테이블에 있는 값을 다 가져온다
	
}
