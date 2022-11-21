package com.airbrb.dao;

import com.airbrb.domain.Listing;
import com.airbrb.domain.ListingId;
import com.airbrb.domain.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
//@Mapper
//@Repository
public interface ListingDao {

    @Insert("insert into Listings (title,owner,price,thumbnail) values(#{title},#{owner},#{price},#{thumbnail})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    public int create(Listing listing);

//    @ResultMap("Test.BaseListingMap")
//    @Select("select * from Listings as l inner join Address as a On l.id = a.id")
    List<Listing> getAll();
}
