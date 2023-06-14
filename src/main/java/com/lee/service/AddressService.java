package com.lee.service;

import com.lee.mapper.AddressMapper;
import com.lee.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    AddressMapper addressMapper;

    public List<Address> findAddressByUid(int uid){
        return addressMapper.findAddressByUid(uid);
    }

    public int addAddress(int uid, String name, String mobile, String type, String address){
        return addressMapper.addAddress(uid,name,mobile,type,address);
    }

    public int deleteAddressByAid(int aid){return addressMapper.deleteAddressByAid(aid);}
}
