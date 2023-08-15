// src/main/java/com/example/demo/mapper/BoardMapper.java
package com.example.demo.mapper;

import com.example.demo.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {

    @Select("SELECT * FROM board")
    List<Board> findAll();

    @Insert("INSERT INTO board (title, contents) VALUES (#{title}, #{contents})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Board board);

    @Delete("DELETE FROM board WHERE id = #{id}")
    void delete(Long id);

    @Update("UPDATE board SET title=#{title}, contents=#{contents} WHERE id=#{id}")
    void update(Board board);

    @Select("SELECT * FROM board WHERE id = #{id}")
    Board findById(Long id);
}
