package com.airbrb.dao;

import com.airbrb.domain.Address;
import com.airbrb.domain.User;
import org.apache.ibatis.annotations.Insert;

public interface AddressDao {

    @Insert("insert into Address (id, street,city,state,postcode,country) values(#{id},#{street},#{city},#{state},#{postcode},#{country})")
    public void create(Address address);
}
