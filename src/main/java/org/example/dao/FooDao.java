package org.example.dao;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import org.example.entity.Foo;
import org.example.handler.UuidTypeHandler;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Mapper
public interface FooDao {

    @Select("SELECT * FROM test.foo WHERE uuid = #{uuid}")
    @Results(value = {
          @Result(id = true, property = "uuid", column = "uuid", javaType = UUID.class, typeHandler = UuidTypeHandler.class),
          @Result(property = "bars", column = "uuid", javaType = List.class,
                many = @Many(select = "org.example.dao.BarDao.getByFooId", fetchType = FetchType.EAGER))
    })
    Optional<Foo> getByUuid(UUID uuid);

    @Select("SELECT * FROM test.foo")
    @Results(value = {
          @Result(id = true, property = "uuid", column = "uuid", javaType = UUID.class, typeHandler = UuidTypeHandler.class),
          @Result(property = "bars", column = "uuid", javaType = List.class,
                many = @Many(select = "org.example.dao.BarDao.getByFooId", fetchType = FetchType.EAGER))
    })
    List<Foo> getAll();

}
