package com.libGdx.test.base.view;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.d3.stage.Stage3D;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.kw.gdx.scrollpanel.ScrollPane;
import com.kw.gdx.utils.Layer;
import com.libGdx.test.base.MyStage3D;
import com.libGdx.test.base.type.AdmitLightGroup;
import com.libGdx.test.base.type.DirLightGroup;
import com.libGdx.test.base.type.PointLightGroup;

public class EnvControllerView extends Group {
    private ScrollPane scrollPane;
    private Table contable;
    private MyStage3D stage3D;
    public EnvControllerView(Stage3D stage3D){
        setSize(600,Constant.GAMEHIGHT);
        this.stage3D = (MyStage3D) stage3D;
        Image shadow = Layer.getShadow();
        shadow.setSize(getWidth(),getHeight());
        addActor(shadow);
        shadow.setColor(Color.BLACK);
        shadow.getColor().a = 0.8f;
        contable = new Table();
        contable.align(Align.top);
        scrollPane = new ScrollPane(contable,new ScrollPane.ScrollPaneStyle());
        addActor(scrollPane);
        addActor(new Table(){{
            contable.add(new AdmitLightGroup(stage3D));
            contable.row();
            contable.pack();
            Image addDirLight = new Image(Asset.getAsset().getTexture("ButtonBackground.png"));
            add(addDirLight);
            addDirLight.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    contable.add(new DirLightGroup(stage3D));
                    contable.row();
                    contable.pack();
                }
            });

            Image addPointLight = new Image(Asset.getAsset().getTexture("ButtonBackground.png"));
            add(addPointLight);
            addPointLight.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    contable.add(new PointLightGroup(stage3D));
                    contable.row();
                    contable.pack();
                }
            });
            pack();

        }});
        scrollPane.setSize(600, Constant.GAMEHIGHT-200);
        scrollPane.setY(200);
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
