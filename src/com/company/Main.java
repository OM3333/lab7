package com.company;

import java.util.ArrayList;
import java.util.Locale;


public class Main {

    public static void main(String[] args) {
        Shape poly = new Polygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)});

        Shape poly2 = new SolidFilledPolygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)}, "red");

        System.out.println(poly2.toSvg(""));

//        SvgScene scene=new SvgScene();
//        scene.addShape(poly);
//        scene.saveHtml("scene.html");
    }
}
