package com.libGdx.test.base;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.BaseLight;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalShadowLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.graphics.g3d.environment.SpotLight;
import com.badlogic.gdx.graphics.g3d.shaders.DefaultShader;
import com.badlogic.gdx.graphics.g3d.utils.DefaultShaderProvider;
import com.badlogic.gdx.graphics.g3d.utils.DepthShaderProvider;
import com.badlogic.gdx.graphics.g3d.utils.ShaderProvider;
import com.badlogic.gdx.utils.Array;
import com.kw.gdx.d3.stage.Stage3D;

public class MyStage3D extends Stage3D {
    private Array<BaseLight> baseLights;
    @Override
    protected void initLight() {
        baseLights = new Array<>();
        shadowLight = new DirectionalShadowLight(1024, 1024, 30f, 30f, 1f, 100f);
//        eg。
//
//
//        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 1, 1, 1, 1f));//环境光
//        DirectionalLight set = new DirectionalLight().set(1f, 0f, 0f, 1, -1, 1);
//        environment.add(set);
//
//        DirectionalLight set1 = new DirectionalLight().set(0f, 1f, 0f, 1, 1, -1);
//        environment.add(set1);
    }

    @Override
    protected void initModelBatch() {
        DefaultShader.Config config = new DefaultShader.Config();
        config.numDirectionalLights = 12;
        config.numPointLights = 50;
        config.numSpotLights = 100;
        ShaderProvider shaderProvider = new DefaultShaderProvider(config);
        this.modelBatch = new ModelBatch(shaderProvider);
        this.shadowBatch = new ModelBatch(new DepthShaderProvider());
    }

    public void addBaseLight(BaseLight baseLight){
        baseLights.add(baseLight);
        environment.add(baseLight);
    }

    public void removeBaseLight(BaseLight baseLight){
        baseLights.removeValue(baseLight,false);
        environment.remove(baseLight);
    }

    public void addColorAttribute(ColorAttribute colorAttribute) {
        environment.set(colorAttribute);
    }
}
