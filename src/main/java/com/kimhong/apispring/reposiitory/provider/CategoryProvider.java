package com.kimhong.apispring.reposiitory.provider;

import org.apache.ibatis.jdbc.SQL;

public class CategoryProvider {
    
    public String findOneSql() {
        return new SQL() {
            {
                SELECT("*");
                FROM("categories");
                WHERE("id = #{id}", "status=true");            
            }
        }.toString();
    }

    public String saveSql(){
        return new SQL(){{
           INSERT_INTO("categories");
           VALUES("name", "#{name}");
        }}.toString();
    }

    public String updateSql(){
        return new SQL(){{
            UPDATE("categories");
            SET("name = #{name}");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String deleteSql(){
        return new SQL(){{
            DELETE_FROM("categories");
            WHERE("id = #{id}");
        }}.toString();
    }
}