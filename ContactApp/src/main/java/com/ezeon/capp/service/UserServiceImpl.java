package com.ezeon.capp.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.ezeon.capp.domain.User;
import com.ezeon.capp.exception.UserBlockedException;
import com.ezeon.capp.repository.UserRepository;
import com.ezeon.capp.rm.UserRowMapper;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public void register(User user) {
		userRepository.save(user);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public User login(String loginName, String password) throws UserBlockedException {
		String sql = "SELECT userId, name, phone, email, address, role, loginStatus, loginName "+
				 " FROM user WHERE loginName=:ln AND password=:pw";
		Map map =new HashMap();
		map.put("ln", loginName);
		map.put("pw", password);
		
		try {
			User user = namedParameterJdbcTemplate.queryForObject(sql, map, new UserRowMapper());
			if(user.getLoginStatus().equals(UserService.LOGIN_STATUS_BLOCKED)) {
				throw new UserBlockedException("User account has been blocked. Please contact admin.");
			}
			else {
				return user;
			}
		} 
		catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public List<User> getUserList() {
		return userRepository.findByRole(UserService.ROLE_USER);
	}

	@Override
	public void changeLoginStatus(Integer userId, Integer loginStatus) {
		// TODO Auto-generated method stub
	}

}
