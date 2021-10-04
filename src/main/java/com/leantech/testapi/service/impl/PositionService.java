package com.leantech.testapi.service.impl;

import java.util.List;

import com.leantech.testapi.entity.Position;
import com.leantech.testapi.repository.PositionRepository;
import com.leantech.testapi.service.IPositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService implements IPositionService {
    
    @Autowired
    PositionRepository positionRepository;

    @Override
    public void savePosition(Position position){
        positionRepository.save(position);
    }

    @Override
    public List<Position> getPositions(){
        return (List<Position>) positionRepository.findAll();
    }

    @Override
    public void deletePosition(String id){
        positionRepository.deleteById(Integer.parseInt(id));
    }


}
