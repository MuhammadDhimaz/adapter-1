package com.bpjstk.JSReport.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


@Repository
public class ImpalaRepository {
    private final NamedParameterJdbcTemplate impalaJDBCTemplate;

    @Autowired
    public ImpalaRepository(@Qualifier("impalaJdbcTemplate") NamedParameterJdbcTemplate impalaJDBCTemplate) {
        this.impalaJDBCTemplate = impalaJDBCTemplate;
    }

    @Async
    public CompletableFuture<List<Map<String, Object>>> executeQueryForList(String sql, List<Map<String, String>> paramList) throws DataAccessException {
        MapSqlParameterSource params = new MapSqlParameterSource();
        paramList.forEach((map) -> map.forEach(params::addValue));
        return CompletableFuture.completedFuture(impalaJDBCTemplate.queryForList(sql, params));
    }
}
