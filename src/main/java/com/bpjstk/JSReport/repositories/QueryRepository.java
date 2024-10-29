package com.bpjstk.JSReport.repositories;

import com.bpjstk.JSReport.models.Query;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query, String> {


    @Modifying
    @Transactional
    @org.springframework.data.jpa.repository.Query(value = "UPDATE QUERY SET QUERY1 = :newSql WHERE id = :id", nativeQuery = true)
    void updateQueryById(String id, String newSql);
}

