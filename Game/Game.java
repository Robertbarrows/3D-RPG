package com.base.game;

import com.base.engine.Input;
import static org.lwjgl.glfw.GLFW.*;

/**
 * 
 * @author Robert Barrows
 * @version 5/30/2016
 */
public class Game {
	/**
	 * 
	 */
	public Game(){
		
	}
	/**
	 * 
	 */
	public void input(){
		if(Input.getKeyDown(GLFW_KEY_DOWN)){
			System.out.println("Pressed the down key.");
			System.out.println("The Mouse position is: " + Input.getMousePosition().toString());
		}
		if(Input.getKeyUp(GLFW_KEY_DOWN)){
			System.out.println("Released the down key");
		}
		if(Input.getMouseDown(GLFW_MOUSE_BUTTON_RIGHT)){
			System.out.println("Right mouse button has been pressed");
		}
		if(Input.getMouseUp(GLFW_MOUSE_BUTTON_RIGHT)){
			System.out.println("Right mouse button has been released");
		}
	}
	/**
	 * 
	 */
	public void update(){
		
	}
	/**
	 * 
	 */
	public void render(){
		
	}
}
