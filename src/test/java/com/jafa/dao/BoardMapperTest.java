package com.jafa.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.config.RootConfig;
import com.jafa.config.ServletConfig;
import com.jafa.dto.Board;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class,ServletConfig.class})
@WebAppConfiguration
public class BoardMapperTest {

	@Autowired
	BoardMapper mapper;
	
	@Autowired
	DataSource dataSource;
	
	@After
	public void setUP() throws IOException, SQLException {
		Reader reader = Resources.getResourceAsReader("sql/board_ex1.sql");
		ScriptRunner runner = new ScriptRunner(dataSource.getConnection());
		runner.runScript(reader);
	}
	
	@Test
	public void test() {
		List<Board> list = mapper.getList();
		assertEquals(list.size(), 4);
	}

	@Test
	public void insertTest() {
		Board board = new Board();
		board.setTitle("제목 : 테스트중");
		board.setContents("내용 : 테스트 중");
		board.setWriter("글쓴이");
		mapper.insert(board);
		List<Board> list = mapper.getList();
		assertEquals(5, list.size());
//		System.out.println(list);
	}
}
