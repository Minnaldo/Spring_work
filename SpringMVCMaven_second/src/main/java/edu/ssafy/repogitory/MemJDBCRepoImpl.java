package edu.ssafy.repogitory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import edu.ssafy.dto.Member;


@Repository(value="MemJDBCRepoImpl")
public class MemJDBCRepoImpl implements MemRepo {
	
    @Autowired
    private DataSource ds;
    
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    public MemJDBCRepoImpl() { }
    
    @Override
    public void insert(Member m) {
        // TODO Auto-generated method stub
        System.out.println("insert");
        String q = "insert into members(id, pw, name, email) values(?, ?, ?, ?)";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(q);
            pstmt.setString(1, m.getId());
            pstmt.setString(2, m.getPw());
            pstmt.setString(3, m.getName());
            pstmt.setString(4, m.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    @Override
    public void update(Member m) {
        // TODO Auto-generated method stub
        System.out.println("update");
        String q = "update members set pw = ?, name = ?, email = ? where id = ?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(q);
            pstmt.setString(4, m.getId());
            pstmt.setString(1, m.getPw());
            pstmt.setString(2, m.getName());
            pstmt.setString(3, m.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        System.out.println("delete");
        String q = "delete from members where id = ?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(q);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    @Override
    public Member selectone(String id) {
        // TODO Auto-generated method stub
        System.out.println("selectOne");
        Member m = null;
        String q = "select * from members where id = ?";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(q);
            pstmt.setString(1, m.getId());
            rs = pstmt.executeQuery();
            if(rs.next()) {
                m = new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("email"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return m;
    }
    @Override
    public ArrayList<Member> selectList() {
        // TODO Auto-generated method stub
        System.out.println("selectAll");
        Member m = null;
        ArrayList<Member> list = null;
        String q = "select * from members";
        try {
            conn = ds.getConnection();
            pstmt = conn.prepareStatement(q);
            rs = pstmt.executeQuery();
            list = new ArrayList<Member>();
            while(rs.next()) {
                m = new Member(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getString("email"));
                list.add(m);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
    
}
