package com.libGdx.test.base;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.libGdx.test.base.screen.GameScreen;

public class App extends LibGdxTestMain{
    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    @Override
    public void useShow(Stage stage) {
        super.useShow(stage);
        setScreen(GameScreen.class);
    }
}
