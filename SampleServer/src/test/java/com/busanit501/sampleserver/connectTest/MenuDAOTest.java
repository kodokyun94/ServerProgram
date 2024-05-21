package com.busanit501.sampleserver.connectTest;

import com.busanit501.sampleserver.connectTest.menu.dao.MenuDAO;
import com.busanit501.sampleserver.connectTest.menu.domain.MenuVO;
import com.busanit501.sampleserver.connectTest.todo.dao.TodoDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

public class MenuDAOTest {

    //디비 연결하고, 기능 테스트.
    // 다른 클래스의 인스턴스가 필요해요.
    // 사용하기위해서 방법? 주입, 포함
    // 선언만 했음. 여기 null (집주소가 없네. 0x100)
    private TodoDAO todoDAO;
    private MenuDAO menuDAO;
    // 각 단위 테스트가 실행되기전에,, 먼저 실행되는 어노테이션,
    // todoDAO 할당 함.
    @BeforeEach
    public void ready() {
        menuDAO = new MenuDAO();
    }

    @Test
    public void getTimeTest() throws Exception {

        // todoDAO.getTime() 이기능 확인. 단위테스트.
        // String time = todoDAO.getTime();
        String time = todoDAO.getTime2();
        System.out.println("time : " + time);
    }

    @Test
    public void getSelectAll() throws Exception {
        List<MenuVO> samples = menuDAO.selectAll();
        // 기본 출력이고, 전체 출력
        System.out.println("samples : " + samples);
        // 향상된 for, 목록에서 요소를 하나씩 뽑아서 출력함.
        // samples 목록에서, 하나 요소를 꺼내서 vo 에 담고, 그리고 개별 요소 출력하기.
        samples.forEach(vo ->System.out.println("각각 출력해보기 : " + vo) );
    }

//    @Test
//    public void getSelectOne() throws Exception {
//        TodoVO todoVO = todoDAO.selectOne(3L);
//        System.out.println("todoVO : " + todoVO);
//    }

//    @Test
//    public void insert() throws Exception {
//        TodoVO todoVO1 = TodoVO.builder()
//                .title("오늘 점심 뭐 먹지?")
//                .dueDate(LocalDate.of(2024,5,20))
//                .finished(false)
//                .build();
//        todoDAO.insert(todoVO1);
//    }

//    @Test
//    public void delete() throws Exception {
//        todoDAO.delete(2L);
//    }

//    @Test
//    public void update() throws Exception {
//        TodoVO todoVO1 = TodoVO.builder().tno(14L)
//                .title("오늘 점심 뭐 먹지? update")
//                .dueDate(LocalDate.now())
//                .finished(false)
//                .build();
//        todoDAO.update(todoVO1);
//    }



    //////////////////////////////////////////////////////
    //메뉴런치
    @Test
    public void getSelectOne() throws Exception {
        MenuVO menuVO = menuDAO.selectOne(1L);
        System.out.println("menuVO : " + menuVO);
    }

    @Test
    public void insert() throws Exception {
        MenuVO menuVO1 = MenuVO.builder()
                .menuTitle("오늘 점심 뭐 먹지? 22")
                .menuRegDate(LocalDate.of(2024,5,20))
                .build();
        menuDAO.insert(menuVO1);
    }

    @Test
    public void delete() throws Exception {
        menuDAO.delete(4L);
    }

    @Test
    public void update() throws Exception {
        MenuVO menuVO = MenuVO.builder().menuNo(4L)
                .menuTitle("오늘 점심 뭐 먹지? update22")
                .menuRegDate(LocalDate.now())
                .build();
        menuDAO.update(menuVO);
    }

}