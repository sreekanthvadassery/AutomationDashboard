package com.ezeon.capp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ezeon.capp.domain.Contact;
import com.ezeon.capp.repository.ContactRepository;
import com.ezeon.capp.rm.ContactRowMapper;
import com.ezeon.capp.util.StringUtil;

@Service
@Transactional
public class ContactServiceImpl implements ContactService{

	private final ContactRepository contactRepository;

	public ContactServiceImpl(ContactRepository contactRepository) {
		this.contactRepository=contactRepository;
	}
	
	@Autowired
	public JdbcTemplate jdbcTemplate;

	@Override
	public void save(Contact contact) {
		contactRepository.save(contact);
	}

	@Override
	public void update(Contact contact) {
		Optional<Contact> contactFromDb = contactRepository.findById(contact.getContactId());
		contactFromDb.get().setUserId(contact.getUserId())
							.setName(contact.getName())
							.setPhone(contact.getPhone())
							.setEmail(contact.getEmail())
							.setAddress(contact.getAddress())
							.setRemark(contact.getRemark());
		contactRepository.save(contactFromDb);
	}

	@Override
	public void delete(Integer contactId) {
		contactRepository.deleteById(contactId);
	}

	@Override
	public void delete(Integer[] contactIds) {
		String ids = StringUtil.toCommaSeparatedString(contactIds);
		String sql = "DELETE FROM contact WHERE contactId IN ("+ids+") ";
		jdbcTemplate.update(sql);
	}

	@Override
	public List<Contact> findUserContact(Integer userId) {
		return contactRepository.findByUserId(userId);
	}

	@Override
	public List<Contact> findUserContact(Integer userId, String text) {
		String sql = "SELECT contactId,userId,name,phone,email,address,remark "
				+ " FROM contact WHERE userId=? AND "
				+ "(name LIKE '%"+text+"%' OR phone LIKE '%"+text+"%' OR email LIKE '%"+text+"%' OR address LIKE '%"+text+"%' OR remark LIKE '%"+text+"%' ) ";
		return jdbcTemplate.query(sql, new ContactRowMapper(),userId);
	}

}
