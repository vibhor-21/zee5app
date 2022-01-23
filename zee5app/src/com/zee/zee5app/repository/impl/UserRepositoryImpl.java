package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.UserRepository2;

public class UserRepositoryImpl implements UserRepository2 {
	
	private ArrayList<Register> arrayList = new ArrayList<>();

	private UserRepositoryImpl() {
		
	}
	
	private static UserRepository2 repository;
	
	public static UserRepository2 getInstance() {
		
		if(repository==null) {
			repository = new UserRepositoryImpl();
		}
		
		return null;
	}
	
	@Override
	public String addUser(Register register) {
		// TODO Auto-generated method stub
		
		boolean result = this.arrayList.add(register);
		if(result)
			return "success";
		return "fail";
	}

	@Override
	public String updateUser(String id, Register register) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Register> getUserById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Register register2 = null;
		for(Register register:arrayList) {
			if(register.getId().equals(id)) {
//				return Optional.of(register);
				register2 = register;
			}
		}
//		return Optional.empty();
		return Optional.ofNullable(Optional.of(register2).orElseThrow(()-> new IdNotFoundException("id not found ")));
	}

	@Override
	public Register[] getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteUserById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
