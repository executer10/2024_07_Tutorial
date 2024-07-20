package com.koranIT.BAM.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
	
	public static String getDateStr() {
		//현재 날짜와 시간을 얻기
		LocalDateTime now = LocalDateTime.now();
		
		//원하는 형식으로 출력하기 위해 DateTimeFormatter를 사용
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		
		return now.format(formatter);
	}
}
