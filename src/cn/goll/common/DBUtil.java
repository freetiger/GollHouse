package cn.goll.common;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库底层操作工具类
 * 
 */
public class DBUtil {
	static DBUtil instance = null;
	static Connection conn = null;// 连接对象
	PreparedStatement ps = null;// 预编译语句对象
	ResultSet rs = null;// 结果集
	CallableStatement cs = null;// 调用存储过程的语句对象
	// mysql
	static final String mdriver = "com.mysql.jdbc.Driver";
	static final String mconStr = "jdbc:mysql://localhost:3306/gollhouse";
	static final String musername = "root";
	static final String mpwd = "1161hyx";

	private DBUtil() {
	}

	public static synchronized DBUtil getInstance() {
		if (instance == null)
			instance = new DBUtil();
		return instance;
	}

	public static Connection getConnections(){
		try {
			Class.forName(mdriver);
			conn = DriverManager.getConnection(mconStr,musername,mpwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 获取预编译语句对象
	 * 
	 * @param sql
	 * @return 预编译语句对象
	 */
	public PreparedStatement getPrepareStatement(String sql) {
		try {
			ps = getConnections().prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	/**
	 * 执行预编译语句对象的查询操作
	 * 
	 * @param ps
	 * @return 结果集
	 */
	public ResultSet executeQuery(PreparedStatement ps) {
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 执行预编译语句对象的增删改操作
	 * 
	 * @param ps
	 * @return 影响行数
	 */
	public int executeUpdate(PreparedStatement ps) {
		int count = 0;
		try {
			count = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	/**
	 * 获取预编译语句对象(PreparedStatement.RETURN_GENERATED_KEYS,立即返回新增的id)
	 * 
	 * @param sql
	 * @return 预编译语句对象
	 */
	public PreparedStatement getPrepareStatementWithReturnId(String sql) {
		try {
			ps = getConnections().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	/**
	 * 执行预编译语句对象的增加操作，并且返回id
	 * 
	 * @param ps
	 * @return id
	 */
	public long executeUpdateReturnId(PreparedStatement ps) {
		long id = 0;
		try {
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if (rs.next()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * 调用执行存储过程并传参
	 * 
	 * @param proc
	 * @param os
	 * @return 结果集
	 */
	public ResultSet getRSWithProc(String proc, Object[] os) {
		try {
			cs = getConnections().prepareCall(proc);
			if (os != null) {
				for (int i = 0; i < os.length; i++) {
					if (os[i] instanceof String)
						cs.setString(i + 1, (String) os[i]);
					if (os[i] instanceof Integer)
						cs.setInt(i + 1, (Integer) os[i]);
				}
			}
			rs = cs.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 * 关闭三个对象的方法，注意顺序
	 */
	/**
	 * 关闭结果集
	 */
	public void closeRs() {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭预编译语句对象
	 */
	public void closePs() {
		try {
			if (ps != null) {
				ps.close();
				ps = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭调用存储过程的语句对象
	 */
	public void closeCs() {
		try {
			if (cs != null) {
				cs.close();
				cs = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭连接对象
	 */
	public void closeConn() {
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
