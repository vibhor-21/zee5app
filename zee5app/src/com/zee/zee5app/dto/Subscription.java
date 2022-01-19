package com.zee.zee5app.dto;

import lombok.Data;

@Data
public class Subscription {
	
	private String type;
	private String date_Of_Purchase;
	private boolean status;
	private String pack_Country;
	private String payment_Mode;
	private boolean autoRenewal;
	private String expiry_Date;
	private String id;
}
