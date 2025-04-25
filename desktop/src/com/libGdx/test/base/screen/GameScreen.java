package com.libGdx.test.base.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.BaseGame;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.d3.screen.BaseScreen3D;
import com.libGdx.test.base.MyStage3D;
import com.libGdx.test.base.view.EnvControllerView;
import com.libGdx.test.base.type.EnvLightGroup;
import com.libGdx.test.base.view.ModelControllerView;
import com.libGdx.test.base.view.ModelShowView;

public class GameScreen extends BaseScreen3D {

    public GameScreen(BaseGame game) {
        super(game);
        this.stage3D = new MyStage3D();
        InputMultiplexer multiplexer = getMultiplexer();
        multiplexer.clear();
        multiplexer.addProcessor(stage3D);
        multiplexer.addProcessor(stage);
        multiplexer.addProcessor(stage3D.getCamController());
        Gdx.input.setInputProcessor(multiplexer);
    }

    @Override
    public void initView() {
        super.initView();
        ModelShowView modelShowView = new ModelShowView();
        stage3D.addActor(modelShowView);
        modelShowView.setPosition(0,0,0);
        ModelControllerView controllerView = new ModelControllerView();
        addActor(controllerView);
        controllerView.setX(Constant.GAMEWIDTH, Align.right);
        EnvControllerView envControllerView = new EnvControllerView();
        addActor(envControllerView);



    }

    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(delta);
        stage.draw();
    }
}
