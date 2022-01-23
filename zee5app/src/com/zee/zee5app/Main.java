package com.zee.zee5app;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.service.SubscriptionService;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserService2;
import com.zee.zee5app.service.impl.UserServiceImpl;

import lombok.Data;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Login;

@Data



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Register register = new Register();
		// Register : class name
		// register : reference which will refer your object
		try {
			register.setFirstName("vibhor");
			register.setLastName("kumar");
		} catch (InvalidNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		register.setEmail("xyz@gmail.com");
		register.setPassword("abc");
		System.out.println(register);
		System.out.println(register.toString());
		System.out.println(register.getFirstName());
		
		Login login = new Login();
		login.setUserName("vibhor");
		login.setPassword("abc");
		
		UserService2 userservice = UserServiceImpl.getInstance(); // interface
		
		for(int i=1;i<=11;i++) {
			Register register2 = new Register();
			try {
				register2.setId("ab00"+i);
				register2.setFirstName("vibh"+i);
			} catch (InvalidIdLengthException e1) {
				e1.printStackTrace();
			}
		    catch (InvalidNameException e) {
				e.printStackTrace();
			}
			register2.setPassword("abc");
			String result = userservice.addUser(register2);
			System.out.println(result);
		}
		
		Register register2 = userservice.getUserById("ab01");
		System.out.println(register2!=null);
		
		Register[] users = userservice.getAllUsers();
		for(Register user: users) {
			if(user!=null)
				System.out.println(user+" ");
		}
//		try {
//			Register optional = userservice.getUserById("ab0000001");
//		}
//		catch(IdNotFoundException e1) {
//			e1.printStackTrace();
//		}
		
		
		
		
		
		
		//subscription
		SubscriptionService subscription_service = SubscriptionService.getInstance();
		
		for(int i=1;i<=15;i++) {
			Subscription subscription1 = new Subscription();
			subscription1.setType("premium");
			subscription1.setStatus(true);
			subscription1.setPayment_Mode("online");
			subscription1.setPack_Country("India");
			subscription1.setId("x100");
			subscription1.setExpiry_Date("19th August 2022");
			subscription1.setDate_Of_Purchase("1st January 2022");
			subscription1.setAutoRenewal(true);
			String result = subscription_service.addSubscription(subscription1);
			System.out.println(result);
			
		}
		
		Subscription subscription1 = subscription_service.getSubscriptionById("x100");
		System.out.println(subscription1!=null);
		
		Subscription[] subscriptions = subscription_service.getAllSubscriptions();
		for(Subscription sub:subscriptions) {
			if(sub!=null) {
				System.out.println(sub);
			}
		}
		
		
		System.out.println(subscription_service.deleteSubscription("x100"));
		System.out.println(subscription_service.modifySubscription("x100", subscription1));
		
	}
	

}
