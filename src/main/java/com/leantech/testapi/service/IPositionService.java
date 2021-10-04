package com.leantech.testapi.service;

import java.util.List;

import com.leantech.testapi.entity.Position;

public interface IPositionService {

    void savePosition(Position position);

    List<Position> getPositions();

    void deletePosition(String id);

}
