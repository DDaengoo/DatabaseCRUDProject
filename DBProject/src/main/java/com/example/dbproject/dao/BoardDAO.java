package com.example.dbproject.dao;

import com.example.dbproject.bean.BoardVO;
import com.example.dbproject.util.JDBCUtil;

import  java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BoardDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String BOARD_INSERT = "insert into Smanagement (category, workname, workplace, deadline, note) values (?,?,?,?,?)";
    private final String BOARD_UPDATE = "update Smanagement set category=?, workname=?, workplace=?, deadline=?, note=? where seq=?";
    private final String BOARD_DELETE = "delete from Smanagement where seq=?";
    private final String BOARD_GET = "select * from Smanagement where seq=?";
    private final String BOARD_LIST = "select * from Smanagement order by seq desc";

    public int insertBoard(BoardVO vo) {
        System.out.println("===> JDBC로 insetBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_INSERT);
            stmt.setString (1, vo.getCategory());
            stmt.setString (2, vo.getWorkname());
            stmt.setString (3, vo.getWorkplace());
            stmt.setString (4, vo.getDeadline());
            stmt.setString (5, vo.getNote());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
    public void deleteBoard(BoardVO vo) {
        System.out.println("===> JDBC로 deleteBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_DELETE);
            stmt.setInt(1, vo.getSeq());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public int updateBoard(BoardVO vo) {
        System.out.println("===> JDBC로 updateBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_UPDATE);
            stmt.setString (1, vo.getCategory());
            stmt.setString (2, vo.getWorkname());
            stmt.setString (3, vo.getWorkplace());
            stmt.setString (4, vo.getDeadline());
            stmt.setString (5, vo.getNote());
            stmt.setInt(6, vo.getSeq());


            System.out.println(vo.getSeq() + "-" + vo.getCategory() + "-" + vo.getWorkname() + "-" + vo.getWorkplace() + "-" + vo.getDeadline() + "-" + vo.getNote());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public BoardVO getBoard(int seq) {
        BoardVO one = new BoardVO();
        System.out.println("===> JDBC로 getBoard() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_GET);
            stmt.setInt (1, seq);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setSeq(rs.getInt("seq"));
                one.setCategory(rs.getString("category"));
                one.setWorkname(rs.getString("workname"));
                one.setWorkplace(rs.getString("workplace"));
                one.setDeadline(rs.getString("deadline"));
                one.setNote(rs.getString("note"));

            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;

    }
    public List<BoardVO> getBoardList(){
        List <BoardVO> list = new ArrayList<BoardVO>();
        System.out.println("===> JDBC로 getBoardList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(BOARD_LIST);
            rs = stmt. executeQuery();
            while(rs.next()) {
                BoardVO one = new BoardVO();
                one.setSeq(rs.getInt("seq"));
                one.setCategory(rs.getString("category"));
                one.setWorkname(rs.getString("workname"));
                one.setWorkplace(rs.getString("workplace"));
                one.setDeadline(rs.getString("deadline"));
                one.setNote(rs.getString("note"));
                one.setRegdate(rs.getDate ("regdate"));

                list.add(one);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
