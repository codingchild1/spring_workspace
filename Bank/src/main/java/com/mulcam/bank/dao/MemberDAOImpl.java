package com.mulcam.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.mulcam.bank.dto.Member;

public class MemberDAOImpl implements MemberDAO {
	private JdbcTemplate template;
	private SimpleJdbcInsert jdbcInsert;
	
	public void setDataSource(DataSource dataSource) {
		this.template=new JdbcTemplate(dataSource);
		this.jdbcInsert=new SimpleJdbcInsert(dataSource).withTableName("member");
	}

	@Override
	public Member queryMember(String id) throws Exception {
		String sql="select * from member where id=?";
		Member mem=this.template.queryForObject(sql, new Object[] {id}, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setId(rs.getString("id"));
				mem.setName(rs.getString("name"));
				mem.setPassword(rs.getString("password"));
				mem.setEmail(rs.getString("email"));
				return mem;
			}
		});
		return mem;
	}

	@Override
	public void insertMember(Member mem) throws Exception {
		Map<String, Object> params=new HashMap<>();
		params.put("id", mem.getId());
		params.put("name", mem.getName());
		params.put("password", mem.getPassword());
		params.put("email", mem.getEmail());
		jdbcInsert.execute(params);
		
	}

}
