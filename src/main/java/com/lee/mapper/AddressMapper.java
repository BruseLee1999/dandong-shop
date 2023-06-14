package com.lee.mapper;

import com.lee.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AddressMapper {
    List<Address> findAddressByUid(int uid);
    int addAddress(int uid, String name, String mobile, String type, String address);
    int deleteAddressByAid(int aid);
}
