package com.libGdx.test.base;

import com.badlogic.gdx.graphics.g3d.environment.DirectionalShadowLight;
import com.kw.gdx.d3.stage.Stage3D;

public class MyStage3D extends Stage3D {
    @Override
    protected void initLight() {
        super.initLight();
//        environment.add((shadowLight = new DirectionalShadowLight(1024, 1024,
//                30f, 30f, 1f, 100f)).
//                set(0f, 0f, 0.8f, -1f, -.5f, -.2f));
    }
}
