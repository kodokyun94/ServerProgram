package com.busanit501.sampleserver.connectTest.menu.dao;

import com.busanit501.sampleserver.connectTest.menu.domain.MenuVO;
import com.busanit501.sampleserver.connectTest.todo.dao.ConnectionUtil;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
    public List<MenuVO> selectAll() throws Exception {
        String sql = "select * from lunchmenu ";
        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet resultSet = pstmt.executeQuery();
        // 디비에서 조회한 데이터 내용들을 담을 임시 List 가 필요함. 여기에 담을 예정.
        List<MenuVO> samples = new ArrayList<MenuVO>();
        while (resultSet.next()){
            MenuVO MenuVOBuilder = MenuVO.builder()
                    .menuNo (resultSet.getLong("menuNo"))
                    .MenuTitle (resultSet.getString("MenuTitle"))
                    .MenuRegDate(resultSet.getDate("MenuRegDate").toLocalDate())
                    .build();
            // 리스트에 담기.
            samples.add(MenuVOBuilder);
        }
        return samples;
    }
}
