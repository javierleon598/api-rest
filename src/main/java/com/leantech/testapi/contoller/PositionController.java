package com.leantech.testapi.contoller;

import java.util.List;

import com.leantech.testapi.entity.Position;
import com.leantech.testapi.service.IPositionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class PositionController {

    @Autowired
    IPositionService positionService;

    @GetMapping("/position")
    public List<Position> getPositions(){
        return positionService.getPositions();
    }

    @PostMapping("/position")
    public Position savePositions(@RequestBody Position position){
        positionService.savePosition(position);
        return position;
    }
    	
	@PutMapping("/position")
	public Position modifyPosition(@RequestBody Position position) {
		positionService.savePosition(position);
		return position;
	} 
	
	@DeleteMapping("/position")
	public String deletePosition(@RequestParam("id") String id) {
		positionService.deletePosition(id);
		return "Position Deleted";
	}
    
}
