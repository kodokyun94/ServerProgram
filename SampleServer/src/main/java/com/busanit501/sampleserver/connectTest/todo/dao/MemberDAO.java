package com.busanit501.sampleserver.connectTest.todo.dao;

import com.busanit501.sampleserver.connectTest.todo.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {
    public MemberVO getWithpasswordMember(String mid,String mpw) throws Exception {
        String sql = "select * from tbl_member where mid = ? and mpw = ?";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, mid);
        pstmt.setString(2, mpw);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        resultSet.next();

        MemberVO memberVO = MemberVO.builder()
                .mid(resultSet.getString("mid"))
                .mpw(resultSet.getString("mpw"))
                .mname(resultSet.getString("mname"))
                .build();

        return memberVO;
    }

    public void updateUUID(String mid,String uuid) throws Exception {
        String sql = "update tbl_member set uuid = ? where mid = ? ";

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uuid);
        pstmt.setString(2, mid);
        pstmt.executeUpdate();

    }

}
