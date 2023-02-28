package org.example.handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.UUID;

@MappedTypes({UUID.class})
public class UuidTypeHandler implements TypeHandler<UUID> {

    private static final Logger LOG = LoggerFactory.getLogger(UuidTypeHandler.class);

    private static UUID toUuid(String val) {
        if (StringUtils.isNotEmpty(val)) {
            try {
                return UUID.fromString(val);
            } catch (IllegalArgumentException e) {
                LOG.warn("Bad UUID found: {}", val);
            }
        }
        return null;
    }

    @Override
    public void setParameter(PreparedStatement ps, int i, UUID parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setObject(i, null, Types.OTHER);
        } else {
            ps.setObject(i, parameter.toString(), Types.OTHER);
        }
    }

    @Override
    public UUID getResult(ResultSet rs, String columnName) throws SQLException {
        return toUuid(rs.getString(columnName));
    }

    @Override
    public UUID getResult(ResultSet rs, int columnIndex) throws SQLException {
        return toUuid(rs.getString(columnIndex));
    }

    @Override
    public UUID getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return toUuid(cs.getString(columnIndex));
    }

}
