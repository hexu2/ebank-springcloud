package com.hexu.ebank.user.service.impl;

import com.hexu.ebank.user.entity.TUserLog;
import com.hexu.ebank.user.mapper.TUserLogMapper;
import com.hexu.ebank.user.service.TUserLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TUserLogServiceImpl implements TUserLogService {

    @Autowired
    private TUserLogMapper tUserLogMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return tUserLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(TUserLog record) {
        return tUserLogMapper.insert(record);
    }

    @Override
    public TUserLog selectByPrimaryKey(Integer id) {
        return tUserLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TUserLog> selectAll() {
        return tUserLogMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(TUserLog record) {
        return tUserLogMapper.updateByPrimaryKey(record);
    }
}
