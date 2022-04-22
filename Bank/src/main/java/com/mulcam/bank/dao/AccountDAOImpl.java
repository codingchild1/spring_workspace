package com.mulcam.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.mulcam.bank.dto.Account;

public class AccountDAOImpl implements AccountDAO {
	private JdbcTemplate template;
	private SimpleJdbcInsert jdbcInsert;
	
	public void setDataSource(DataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
		this.jdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("account").usingColumns("id","name","balance","type","grade");
	}
	
	@Override
	public List<Account> accountList() throws Exception {
		String sql = "select * from account";
		RowMapper<Account> mapper=new BeanPropertyRowMapper<Account>(Account.class);
		return template.query(sql, mapper);
	}

	@Override
	public Account queryAccount(String id) throws Exception {
		String sql = "select * from account where id=?";
		Account acc = this.template.queryForObject(sql, new Object[] {id}, new RowMapper<Account>() {
			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account acc = new Account();
				acc.setId(rs.getString("id"));
				acc.setName(rs.getString("name"));
				acc.setBalance(rs.getInt("balance"));
				acc.setType(rs.getString("type"));
				acc.setGrade(rs.getString("grade"));
				return acc;
			}
		});
		return acc;
	}

	@Override
	public void insertAccount(Account acc) throws Exception {
		Map<String, Object> params = new HashMap<>();
		params.put("id", acc.getId());
		params.put("name", acc.getName());
		params.put("balance", acc.getBalance());
		params.put("type", acc.getType());
		params.put("grade", acc.getGrade());
		jdbcInsert.execute(params);
	}

	@Override
	public void updateAccount(Account acc) throws Exception {
		String sql = "update account set balance=? where id=?";
		int count = this.template.update(sql, acc.getBalance(),acc.getId());
		if(count==0) throw new Exception("잔액 변경 실패");
		
	}
	
}


