package com.libGdx.test.base.type;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.d3.stage.Stage3D;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.kw.gdx.utils.ConvertUtil;
import com.libGdx.test.base.MyStage3D;

public class PointLightGroup extends Table {
    private Group rGroup;
    private Group gGroup;
    private Group bGroup;
    private Group aGroup;
    private Group xGroup;
    private Group yGroup;
    private Group zGroup;
    private Group intensityGroup;
    private PointLight pointLightGroup;
    public PointLightGroup(Stage3D stage3D){
        setSize(400,400);
        pointLightGroup = new PointLight().set(1.0f, 0f, 0f, 0.0f, 4.0f, 0.0f, 1140.3f);
        ((MyStage3D) stage3D).addBaseLight(pointLightGroup);
        {
            String simpleName = getClass().getSimpleName();
            Label label = new Label(simpleName, new Label.LabelStyle() {{
                font = Asset.getAsset().loadBitFont("font.fnt");
            }});
            add(label).pad(10);
            label.setAlignment(Align.left);
            label.setPosition(0, getHeight(), Align.topLeft);
            row();
            rGroup = createTextField("r", 4);
            add(rGroup).colspan(2).pad(10);
            rGroup.setPosition(0, 0);
            row();
            gGroup = createTextField("g", 4);
            add(gGroup).colspan(2).pad(10);
            gGroup.setPosition(0, 0);
            row();
            bGroup = createTextField("b", 4);
            add(bGroup).colspan(2).pad(10);
            bGroup.setPosition(0, 0);
            row();
            aGroup = createTextField("a", 4);
            add(aGroup).colspan(2).pad(10);
            aGroup.setPosition(0, 0);
        }
        {
            row();
            xGroup = createTextField("x", 4);
            add(xGroup).colspan(2).pad(10);
            xGroup.setPosition(0,0);
            row();
            yGroup = createTextField("y", 4);
            add(yGroup).colspan(2).pad(10);
            yGroup.setPosition(0,0);
            row();
            zGroup = createTextField("z", 4);
            add(zGroup).colspan(2).pad(10);
            zGroup.setPosition(0,0);
            row();
            intensityGroup = createTextField("intensity", 4);
            add(intensityGroup).colspan(2).pad(10);
            intensityGroup.setPosition(0,0);
            row();

        }

        Image queding = new Image(Asset.getAsset().getTexture("btn/ok.png"));
        add(queding);
        queding.addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                float r = getValue(rGroup,"r");
                float g = getValue(gGroup,"g");
                float b = getValue(bGroup,"b");
                float a = getValue(aGroup,"a");
                float dx = getValue(xGroup,"x");
                float dy = getValue(yGroup,"y");
                float dz = getValue(zGroup,"z");
                float intensity = getValue(intensityGroup,"intensity");
                System.out.println("---------------------");
                pointLightGroup.color.set(r,g,b,a);
                pointLightGroup.position.set(dx,dy,dz);
                pointLightGroup.setIntensity(intensity);
            }
        });

        Image delete = new Image(Asset.getAsset().getTexture("btn/delete.png"));
        add(delete);
        delete.addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                PointLightGroup.this.remove();
                ((MyStage3D) stage3D).removeBaseLight(pointLightGroup);
            }
        });

        pad(10);
        pack();
    }

    private float getValue(Group rGroup,String name) {
        TextField r = rGroup.findActor(name);
        System.out.println(name);
        return ConvertUtil.convertToFloat(r.getText(),0);
    }


    private Group createTextField(String name, int i) {
        TextField field = new TextField("",new TextField.TextFieldStyle(){{
            font = Asset.getAsset().loadBitFont("font.fnt");
            background = new NinePatchDrawable(
                    new NinePatch(
                            Asset.getAsset().getSprite("textfield/textfieldbg.png"),
                            10,10,10,10));
            cursor = new TextureRegionDrawable(Asset.getAsset().getSprite("textfield/textcursor.png"));
            fontColor = Color.BLACK;
        }
        });
        field.setSize(400,50);
        field.setName(name);
        field.setMessageText(name);
        Group group = new Group();
        group.addActor(field);
        group.setSize(400,50);
        return group;
    }
}
