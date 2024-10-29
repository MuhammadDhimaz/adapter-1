package com.bpjstk.JSReport.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "QUERY")
@Getter
@Setter
public class Query {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "QUERY1")
    private String query1;

    @Column(name = "QUERY2")
    private String query2;

    @Column(name = "QUERY3")
    private String query3;

    @Column(name = "QUERY4")
    private String query4;

    @Column(name = "QUERY5")
    private String query5;

    @Column(name = "SHORTID")
    private String shortId;

    public Query() {
    }

    public Query(String id, String description, String query1, String query2, String query3, String query4, String query5, String shortId) {
        this.id = id;
        this.description = description;
        this.query1 = query1;
        this.query2 = query2;
        this.query3 = query3;
        this.query4 = query4;
        this.query5 = query5;
        this.shortId = shortId;
    }

    public List<String> getQueryList() {
        List<String> queryList = new ArrayList<>();
        if (query1 != null) {
            queryList.add(query1);
        }
        if (query2 != null) {
            queryList.add(query2);
        }
        if (query3 != null) {
            queryList.add(query3);
        }
        if (query4 != null) {
            queryList.add(query4);
        }
        if (query5 != null) {
            queryList.add(query5);
        }
        return queryList;
    }
}
