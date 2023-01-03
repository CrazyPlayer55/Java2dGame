package dev.crazy.game.input;

import dev.crazy.game.ui.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftClick, rightClick;
    private int mouseX, mouseY;
    private UIManager uiManager;

    public MouseManager(){

    }

    public void setUiManager(UIManager uiManager){
        this.uiManager = uiManager;
    }

    //Getters


    public boolean getLeftClick() {
        return leftClick;
    }

    public boolean getRightClick() {
        return rightClick;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    //Implemented
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftClick = true;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightClick = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
            leftClick = false;
        else if(e.getButton() == MouseEvent.BUTTON3)
            rightClick = false;

        if(uiManager != null)
            uiManager.onMouseRelease(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        if(uiManager != null)
            uiManager.onMouseMove(e);
    }
}
