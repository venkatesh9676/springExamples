package com.hcl.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.hcl.model.Login;
import com.hcl.model.User;

public class UserDaoImpl implements UserDao {
 
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	  DataSource datasource;

	  public int register(User user) {
	    String sql = "insert into users values(?,?,?,?,?,?,?,?)";

	    return jdbcTemplate.update(sql, new Object[] { user.getId(),user.getUsername(), user.getPassword(), user.getFirstname(),
	        user.getLastname(), user.getEmail(), user.getAddress(), user.getPhone() });
	  }

	  public User validateUser(Login login) {
	    String sql = "select * from users where username='" + login.getUsername() + "' and password='" + login.getPassword()
	        + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());

	    return users.size() > 0 ? users.get(0) : null;
	  }

	public List<User> getUser() {
		      String SQL = "select * from users";
		      List <User> users = jdbcTemplate.query(SQL, new UserMapper());
		      return users;
			
	}

	public User findUserById(int id) {
		String sql = "select * from users where id = ?";
		
/*		User user =  (User) jdbcTemplate.query(sql, new Object[]{id}, new UserMapper());*/
		
		return jdbcTemplate.queryForObject(sql, new Object[] {id},(rs, rownum) -> new User(rs.getInt("id"),rs.getString("username"),rs.getString("password"),rs.getString("firstname"),
				                                      rs.getString("lastname"),rs.getString("email"),rs.getString("address"),rs.getInt("phone")));
	}

	public void updateUser(User user) {
		
		String sql = "UPDATE users SET username = ?, password = ?, firstname = ?, lastname = ?, email = ?, address = ?, phone = ? where id = ?";
		
		 jdbcTemplate.update(sql, new Object[] { user.getUsername(),user.getPassword(),user.getFirstname(),user.getLastname(),user.getEmail(),user.getAddress(),user.getPhone(),user.getId()});
	}

	
	public void deleteUser(int id) {
		
		String sql ="delete from users where id =?";
		jdbcTemplate.update(sql, new Object[] {id});
	}

	

	}

	class UserMapper implements RowMapper<User> {

	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
        
	    user.setId(rs.getInt("id"));
	    user.setUsername(rs.getString("username"));
	    user.setPassword(rs.getString("password"));
	    user.setFirstname(rs.getString("firstname"));
	    user.setLastname(rs.getString("lastname"));
	    user.setEmail(rs.getString("email"));
	    user.setAddress(rs.getString("address"));
	    user.setPhone(rs.getInt("phone"));
	    
	    return user;
	  }
	}
