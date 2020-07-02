package org.academiadecodigo.felinux.gtfo.field;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.ArrayList;

public class Field extends Picture {


    //yep, they are static, why shouldnt they
    public static Picture map;
    public static final int PADDING_X = 5;
    public static final int PADDING_Y = 65;
    private static final int PIXEL = 2;
    public static ArrayList<Area> notWalkableMap2 = new ArrayList<>();
    public static ArrayList<Area> notWalkable = new ArrayList<>();
    public static int height;
    public static int width;

    public Field () {
        map = new Picture(PADDING_X, PADDING_Y,"resources/images/FirstMap.png");
        setNotWalkable();
        setNotWalkableMap2();
        height = map.getHeight();
        width = map.getWidth();
    }

    public static int getPADDING_X() {
        return PADDING_X;
    }

    public static int getPADDING_Y() {
        return PADDING_Y;
    }

    public Picture getMap() {
        return map;
    }

    public static int getCellSize() {
        return PIXEL;
    }

    public ArrayList<Area> getNotWalkable() {
        return notWalkable;
    }

    public ArrayList<Area> getNotWalkableMap2() {
        return notWalkableMap2;
    }

    private void addNotWalkable(int xMin, int yMin, int xSize, int ySize){
        Area area =new Area(xMin, yMin, xSize, ySize);
        notWalkable.add(area);
    }

    public void setNotWalkable() {
        addNotWalkable(40 + PADDING_X, 99 + PADDING_Y, 105 - 40, 202 - 99); // House Nº1
        addNotWalkable(157 + PADDING_X, 99 + PADDING_Y, 208 - 157, 194 - 99); // House Nº2
        addNotWalkable(236 + PADDING_X, 120 + PADDING_Y, 316 - 236, 220 - 120); // House Nº3
        addNotWalkable(368 + PADDING_X, 160 + PADDING_Y, 410 - 368, 221 - 160); // House Nº4
        addNotWalkable(488 + PADDING_X, 158 + PADDING_Y, 517 - 488, 222 - 158); // House Nº5
        addNotWalkable(566 + PADDING_X, 120 + PADDING_Y, 622 - 566, 220 - 120); // House Nº6
        addNotWalkable(671 + PADDING_X,119 + PADDING_Y,728 - 671,222 - 119); // House Nº7
        addNotWalkable(1017 + PADDING_X,119 + PADDING_Y,1149 - 1017,261 - 119); // House Nº8
        addNotWalkable(105 + PADDING_X,336 + PADDING_Y,171 - 105,417-336); // Part of House Nº9
        addNotWalkable(169 + PADDING_X,376 + PADDING_Y,210 - 169,416 - 376); // Part of House Nº9
        addNotWalkable(355 + PADDING_X,375 + PADDING_Y,437 - 355,475 - 375); // House Nº10
        addNotWalkable(541 + PADDING_X,337 + PADDING_Y,591 - 541,457 - 337); // House Nº11
        addNotWalkable(764 + PADDING_X,357 + PADDING_Y,844 - 764,456 - 357); // House Nº12
        addNotWalkable(977 + PADDING_X,340 + PADDING_Y,1054 - 977,433 - 340); // House Nº13
        addNotWalkable(1199 + PADDING_X,336 + PADDING_Y,1253 - 1199,456 - 336); // House Nº14
        addNotWalkable(1123 + PADDING_X,1+ PADDING_Y,1239 - 1123,98-1); // Castle
        addNotWalkable(-1 + PADDING_X,512 + PADDING_Y,329 -(-1),593 - 512); // Water
        addNotWalkable(343 + PADDING_X,512 + PADDING_Y,689 - 343,594 - 512); // Water
        addNotWalkable(330 + PADDING_X,568 + PADDING_Y,343 - 330,594 - 568); // Water
        addNotWalkable(604 + PADDING_X,473 + PADDING_Y,689 - 604,514 - 473); // Water
        addNotWalkable(858 + PADDING_X,316 + PADDING_Y,883 - 858,594 - 316); // water
        addNotWalkable(858 + PADDING_X,120 + PADDING_Y,885 - 858,278- 120); // Water
        addNotWalkable(857 + PADDING_X,-1 + PADDING_Y,885 - 857,100 -(-1)); // Water
        addNotWalkable(990 + PADDING_X,1 + PADDING_Y,1097 - 990,100 - 1); // Water
        addNotWalkable(1069 + PADDING_X,100 + PADDING_Y,1097 - 1069,139 - 100); // Water
        addNotWalkable(1097 + PADDING_X,115 + PADDING_Y,1175 - 1097,139 - 115); // Water
        addNotWalkable(1188 + PADDING_X,115 + PADDING_Y,1318 - 1188,140 - 115); // Water
        addNotWalkable(1264 + PADDING_X,-1 + PADDING_Y,1319 - 1264,120 - (-1)); // Water
        addNotWalkable(-1 + PADDING_X,-1 + PADDING_Y,727 - (-1),40 - (-1));// Water
        addNotWalkable(1096 + PADDING_X,-1 + PADDING_Y,1264 - 1096,24 - (-1)); // Water
        addNotWalkable(13 + PADDING_X,59 + PADDING_Y,105 - 13,100 - 59); // Water
        addNotWalkable(119 + PADDING_X,60 + PADDING_Y,315 - 119,100 - 60); // Water
        addNotWalkable(330 + PADDING_X,61 + PADDING_Y,727 - 330,99 - 61); // Water
        addNotWalkable(390 + PADDING_X,40 + PADDING_Y,727 - 390,61 - 40); // Water


    }

    private void addNotWalkable2(int xMin, int yMin, int xMax, int yMax){
        Area area =new Area(xMin, yMin, xMax, yMax);
        area.getBoundArea().setColor(Color.RED);
        notWalkableMap2.add(area);
    }

    public void setNotWalkableMap2() {
    addNotWalkable2(-1 + PADDING_X,-1 + PADDING_Y,1499 - 1,90 -1); // TOP BORDER MAP2
    addNotWalkable2(-1 + PADDING_X,361 + PADDING_Y,1499 - 1,449 - 361); // LOWER BORDER MAP2
    addNotWalkable2(1380 + PADDING_X,-1 + PADDING_Y,1499 - 1380,449 - (-1)); // RIGHT BORDER MAP2
    addNotWalkable2(-1 + PADDING_X,-1 + PADDING_Y,135 - (-1),449 - (-1)); // LEFT BORDER MAP2


    }

}

