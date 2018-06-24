package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import data.Board;

@RestController
public class RobotController {

	    private final Board board = new Board();

	    @RequestMapping("/PLACE")
	    public void place(@RequestParam(value="X") int x, 
	    		          @RequestParam(value="Y") int y,
	    		          @RequestParam(value="F") String face) {
	    	this.board.update(x, y, face);	    	
	    }
	    
	    @RequestMapping("/MOVE")
	    public void move() {
	    	this.board.move();	    	
	    }
	    
	    @RequestMapping("/LEFT")
	    public void left() {
	    	this.board.turnLeft();	    	
	    }
	    
	    @RequestMapping("/RIGHT")
	    public void right() {
	    	this.board.turnRight();	    	
	    }
	    
	    @RequestMapping("/REPORT")
	    public String report() {
	    	return this.board.report();	    	
	    }
}
