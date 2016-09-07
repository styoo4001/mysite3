package kr.co.saramin.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.saramin.mysite.exception.UserDaoException;
import kr.co.saramin.mysite.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	SqlSession sqlSession;
	
	
	/*
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			String url = "jdbc:mysql://localhost/webdb";
		
			connection = DriverManager.getConnection(url, "webdb", "webdb");
		
		} catch( ClassNotFoundException ex ) {
			ex.printStackTrace();
		}
		
		return connection;
	}
	*/
	public UserVo get( UserVo vo ) {
		
		UserVo userVo= sqlSession.selectOne("getByEmailAndPassword" , vo);
		
		return userVo;
		/*
		UserVo userVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			
			String sql = "SELECT no, name FROM user WHERE email=? AND passwd=password(?)"; 
			pstmt = conn.prepareStatement( sql );
			
			pstmt.setString( 1, vo.getEmail() );
			pstmt.setString( 2, vo.getPassword() );

			rs = pstmt.executeQuery();
			if( rs.next() ) {
				Long no = rs.getLong( 1 );
				String name = rs.getString( 2 );

				userVo = new UserVo();
				userVo.setNo(no);
				userVo.setName(name);
			}
			
			return userVo;
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		} finally {
			try{
				if( rs != null ) {
					rs.close();
				}
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}
		
		*/
	}
	
	public void update( UserVo vo) {
		
		sqlSession.update("user.update" , vo);
		
	}
	
	public void insert( UserVo vo ) throws UserDaoException {
	
		sqlSession.insert( "user.insert" , vo);
		
		/*
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			String sql = "INSERT INTO user VALUES (null, ?, ?, password(?), ? )";
		//	String sql = "INSERT INTO user VAL (null, ?, ?, password(?), ? )";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString( 1, vo.getName() );
			pstmt.setString( 2, vo.getEmail() );
			pstmt.setString( 3, vo.getPassword() );
			pstmt.setString( 4,  vo.getGender() );
			
			pstmt.executeUpdate();
			
		} catch (SQLException ex) {
		//	ex.printStackTrace();
			
			throw new UserDaoException( ex.getMessage());
			
		} finally {
			try{
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			}catch( SQLException e ) {
				e.printStackTrace();
			}
		}
		
		*/
	}	
}