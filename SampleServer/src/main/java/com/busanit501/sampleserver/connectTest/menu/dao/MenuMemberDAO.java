package com.busanit501.sampleserver.connectTest.menu.dao;

import com.busanit501.sampleserver.connectTest.menu.domain.MenuMemberVO;
import com.busanit501.sampleserver.connectTest.todo.dao.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MenuMemberDAO {
    public MenuMemberVO getWithpasswordMember(String mid,String mpw) throws Exception {
        String sql = "select * from lunchMenu_member where mid = ? and mpw = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, mid);
        pstmt.setString(2, mpw);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();

        resultSet.next();

        MenuMemberVO menuMemberVO = MenuMemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .uuid(resultSet.getString("uuid"))
                .build();

        return menuMemberVO;
    }

    //업데이트
    public void updateUUID(String mid,String uuid) throws Exception {
        String sql = "update lunchMenu_member set uuid = ? where mid = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uuid);
        pstmt.setString(2, mid);
        pstmt.executeUpdate();

    }

    //회원가입
    public void insertMember(MenuMemberVO memberVO) throws Exception {
        String sql = "insert into lunchMenu_member (mid, mpw, mname) values (?,?,?);";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, memberVO.getMid());
        pstmt.setString(2, memberVO.getMpw());
        pstmt.setString(3, memberVO.getMname());
        pstmt.executeUpdate();

    }

    //하나의 uuid
    public MenuMemberVO selectUUID(String uuid) throws Exception {
        String sql = "select * from lunchMenu_member where uuid = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uuid);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();


        MenuMemberVO menuMemberVO = MenuMemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .uuid(resultSet.getString("uuid"))
                .build();

        return menuMemberVO;
    }

    public void checkAutoLogin(String mid, boolean autoLogined) throws Exception {
        String sql = "update lunchMenu_member set autoLogined = ? where mid = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setBoolean(1, autoLogined);
        pstmt.setString(2, mid);
        pstmt.executeUpdate();

    }
}
