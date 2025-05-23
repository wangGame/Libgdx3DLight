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

    public EnvControllerView(Stage3D stage3D){
        setSize(600,Constant.GAMEHIGHT);
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
            align(Align.center);
            contable.add(new AdmitLightGroup(stage3D));
            contable.row();
            contable.pack();
            Image addDirLight = new Image(Asset.getAsset().getTexture("btn/zsgBtn.png"));
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

            Image addPointLight = new Image(Asset.getAsset().getTexture("btn/pLight.png"));
            add(addPointLight).pad(30);
            addPointLight.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    contable.add(new PointLightGroup(stage3D));
                    contable.row();
                    contable.pack();
                }
            });
            pad(40);
            pack();

        }});
        scrollPane.setSize(600, Constant.GAMEHIGHT-200);
        scrollPane.setY(200);

    }

}
