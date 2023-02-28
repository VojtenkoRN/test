package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.example.entity.Bar;
import org.example.handler.UuidTypeHandler;

import java.util.Optional;
import java.util.UUID;

@Mapper
public interface BarDao {

    @Select("SELECT * FROM test.bar WHERE foo_id = #{fooUuid}")
    @Results(value = {
          @Result(id = true, property = "uuid", column = "uuid", javaType = UUID.class, typeHandler = UuidTypeHandler.class),
          @Result(column = "foo_id", property = "foo",
                one = @One(select = "org.example.dao.FooDao.getByUuid", fetchType = FetchType.LAZY))
    })
    Optional<Bar> getByFooId(UUID fooUuid);

}
