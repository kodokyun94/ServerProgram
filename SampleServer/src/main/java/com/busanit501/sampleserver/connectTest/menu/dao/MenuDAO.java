package com.busanit501.sampleserver.connectTest.menu.dao;

import com.busanit501.sampleserver.connectTest.menu.domain.MenuVO;
import com.busanit501.sampleserver.connectTest.todo.dao.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
    public List<MenuVO> selectAll() throws Exception {
        String sql = "select * from lunchmenu";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        // 디비에서 조회한 데이터 내용들을 담을 임시 List 가 필요함. 여기에 담을 예정.

        List<MenuVO> samples = new ArrayList<MenuVO>();
        while (resultSet.next()){
            MenuVO MenuVOBuilder = MenuVO.builder()
                    .menuNo (resultSet.getLong("menuNo"))
                    .menuTitle (resultSet.getString("menuTitle"))
                    .menuRegDate(resultSet.getDate("menuRegDate").toLocalDate())
                    .build();
            // 리스트에 담기.
            samples.add(MenuVOBuilder);
        }
        return samples;
    }

    public MenuVO selectOne(Long menuNo) throws Exception {
        String sql = "select * from lunchMenu where menuNo = ?";
        //1)
        @Cleanup Connection conn = com.busanit501.sampleserver.connectTest.todo.dao.ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1, menuNo);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();


        resultSet.next();
        MenuVO menuVO = MenuVO.builder()
                .menuNo(resultSet.getLong("menuNo"))
                .menuTitle(resultSet.getString("menuTitle"))
                .menuRegDate(resultSet.getDate("menuRegDate").toLocalDate())
                .build();
        return menuVO;
    }

    public void insert(MenuVO menuVO1) throws Exception {
        String sql = "insert into lunchMenu (menuTitle, menuRegDate) values (?,?)";

        @Cleanup Connection conn = com.busanit501.sampleserver.connectTest.todo.dao.ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,menuVO1.getMenuTitle());
        pstmt.setDate(2, Date.valueOf(menuVO1.getMenuRegDate()));;
        pstmt.executeUpdate();
    }

    public void  delete(Long menuNo) throws Exception {
        String sql = "delete from lunchMenu where menuNo=?";

        @Cleanup Connection conn = com.busanit501.sampleserver.connectTest.todo.dao.ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setLong(1,menuNo);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        pstmt.executeUpdate();
    }

    public void  update(MenuVO menuVO) throws Exception {
        String sql = "update lunchMenu set  menuTitle = ?, menuRegDate = ? where menuNo = ?";
        //1)
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);


        pstmt.setString(1,menuVO.getMenuTitle());
        pstmt.setDate(2, Date.valueOf(menuVO.getMenuRegDate()));
        pstmt.setLong(3, menuVO.getMenuNo());

        pstmt.executeUpdate();
    }
}
