package edu.ncu.csie.umleditor.controller;

import edu.ncu.csie.umleditor.view.Canvas;
import edu.ncu.csie.umleditor.util.ButtonState;

public class CanvasHandlerFactory {
    Canvas canvas;
    CanvasHandlerFactory(Canvas canvas){
        this.canvas = canvas;
    }
    public CanvasHandler createCanvasHandler(ButtonState state){
        switch(state){
            case SELECT:
            return new SelectHandler(canvas);
            case ASSOCIATE:
            return new AssociateHandler(canvas);
            case GENARALIZE:
            return new GeneralizeHandler(canvas);
            case COMPOSE:
            return new ComposeHandler(canvas);
            case CLASS:
            return new ClassHandler(canvas);
            case USECASE:
            return new UseCaseHandler(canvas);
            default:
            System.out.println("W: undefined button");
            return new CanvasHandler(canvas);
        }
    }
}
