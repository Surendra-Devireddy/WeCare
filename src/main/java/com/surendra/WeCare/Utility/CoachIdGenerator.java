package com.surendra.WeCare.Utility;


import java.io.Serializable;
import java.time.LocalDateTime;

//import javax.persistence.Embeddable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

//import jakarta.persistence.Embeddable;


public class CoachIdGenerator implements IdentifierGenerator {
	private static int counter = 101;
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) {
		int id = counter++;
		LocalDateTime now = LocalDateTime.now();
		String value = "LC" + now.getDayOfMonth() + now.getMonthValue() + now.getYear() + now.getHour()
				+ now.getMinute();
		return value + id;
	}
}
