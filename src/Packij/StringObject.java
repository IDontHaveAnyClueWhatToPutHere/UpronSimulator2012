package Packij;

import utilities.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

import static Packij.Constants.*;

public class StringObject extends GameObject {

    private String thisString;

    StringObject(Vector2D p, Vector2D v, String s){
        super(p,v);
        thisString = s;
        objectColour = Color.WHITE;
    }


    @Override
    public void draw(Graphics2D g) {
        AffineTransform at = g.getTransform();
        g.translate(position.x, position.y);
        g.setColor(objectColour);
        FontMetrics metrics = g.getFontMetrics(Constants.sans);
        int w = metrics.stringWidth(thisString);
        g.drawString(thisString,0-(w/2),0);
        g.setTransform(at);
    }

    void showValue(int value){
        thisString = String.valueOf(value);
    }


    @Override
    public void update(){

        if (position.y < 0){
            dead = true;
        }
        if (!dead) {
            position.addScaled(velocity, DT);
        }
    }
}
