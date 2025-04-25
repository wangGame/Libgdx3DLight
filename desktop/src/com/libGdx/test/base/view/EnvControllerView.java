package com.libGdx.test.base.view;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.kw.gdx.scrollpanel.ScrollPane;
import com.kw.gdx.utils.Layer;
import com.libGdx.test.base.type.EnvLightGroup;

public class EnvControllerView extends Group {
    private ScrollPane scrollPane;
    private Table contable;
    public EnvControllerView(){
        setSize(600,Constant.GAMEHIGHT);
        Image shadow = Layer.getShadow();
        shadow.setSize(getWidth(),getHeight());
        addActor(shadow);
        shadow.getColor().a = 0.5f;
        contable = new Table();
        scrollPane = new ScrollPane(contable,new ScrollPane.ScrollPaneStyle());
        addActor(scrollPane);
        addActor(new Table(){{

            Image addEnvLight = new Image(Asset.getAsset().getTexture("ButtonBackground.png"));
            add(addEnvLight);
            addEnvLight.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    contable.add(new EnvLightGroup());
                    contable.row();
                    contable.pack();
                }
            });

            Image addDirLight = new Image(Asset.getAsset().getTexture("ButtonBackground.png"));
            add(addDirLight);

            Image addPointLight = new Image(Asset.getAsset().getTexture("ButtonBackground.png"));
            add(addPointLight);

            pack();
            setPosition(100,100);
        }});


        setDebug(true);

        scrollPane.setSize(600, Constant.GAMEHIGHT);
        /*
        *
        *  environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 1f, 1f, 1f, 1f));//环境光
        //投影
        environment.add((shadowLight = new DirectionalShadowLight(1024, 1024,
                30f, 30f, 1f, 100f)).
                set(0.8f, 0.8f, 0.8f, -1f, -.5f, -.2f));
        environment.shadowMap = (ShadowMap) shadowLight;
        DirectionalLight set = new DirectionalLight().set(1f, 1f, 1f, 30, -30, 1);
        float intensity = 0.4f;
        Color color = Color.valueOf("#FFF4D6");
        color.r = color.r * intensity;
        color.g = color.g * intensity;
        color.b = color.b * intensity;
        color.a = 0.1f;
        set.setColor(color);
        environment.add(set);
        PointLight set1 = new PointLight().set(1.0f, 0f, 0f, 0.0f, 4.0f, 0.0f, 1140.3f);
        environment.add(set1);
        * */

    }

}
