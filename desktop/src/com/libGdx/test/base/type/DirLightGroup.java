package com.libGdx.test.base.type;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
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
import com.libGdx.test.base.file.SaveData;

public class DirLightGroup extends Table {
    private Group rGroup;
    private Group gGroup;
    private Group bGroup;
    private Group aGroup;
    private Group xGroup;
    private Group yGroup;
    private Group zGroup;
    private DirectionalLight directionalLight;
    public DirLightGroup(Stage3D stage3D){
        setSize(400,400);
        directionalLight = new DirectionalLight().set(1, 1, 1, -0, -0.2f, -0.5f);
        String simpleName = this.getClass().getSimpleName();
        ((MyStage3D) stage3D).addBaseLight(directionalLight);
        {
            align(Align.center);
            Label label = new Label(simpleName, new Label.LabelStyle() {{
                font = Asset.getAsset().loadBitFont("font.fnt");
            }});
            add(label).pad(10);
            label.setAlignment(Align.center);
            label.setPosition(0, getHeight(), Align.topLeft);
            row();
            rGroup = createTextField("r", SaveData.getSaveData().getDirR());
            add(rGroup).colspan(2).pad(10);
            rGroup.setPosition(0, 0);
            row();
            gGroup = createTextField("g", SaveData.getSaveData().getDirG());
            add(gGroup).colspan(2).pad(10);
            gGroup.setPosition(0, 0);
            row();
            bGroup = createTextField("b", SaveData.getSaveData().getDirB());
            add(bGroup).colspan(2).pad(10);
            bGroup.setPosition(0, 0);
            row();
            aGroup = createTextField("a", SaveData.getSaveData().getDirA());
            add(aGroup).colspan(2).pad(10);
            aGroup.setPosition(0, 0);
        }
        {
            row();
            xGroup = createTextField("x", SaveData.getSaveData().getDirX());
            add(xGroup).colspan(2).pad(10);
            xGroup.setPosition(0,0);
            row();
            yGroup = createTextField("y", SaveData.getSaveData().getDirY());
            add(yGroup).colspan(2).pad(10);
            yGroup.setPosition(0,0);
            row();
            zGroup = createTextField("z", SaveData.getSaveData().getDirZ());
            add(zGroup).colspan(2).pad(10);
            zGroup.setPosition(0,0);
            row();
        }

        Image queding = new Image(Asset.getAsset().getTexture("btn/ok.png"));
        add(queding).colspan(1);
        queding.setOrigin(Align.center);
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



                SaveData.getSaveData().saveDirR(r);
                SaveData.getSaveData().saveDirG(g);
                SaveData.getSaveData().saveDirB(b);
                SaveData.getSaveData().saveDirA(a);
                SaveData.getSaveData().saveDirX(dx);
                SaveData.getSaveData().saveDirX(dy);
                SaveData.getSaveData().saveDirX(dz);



                directionalLight.color.set(r,g,b,a);
                directionalLight.direction.set(dx,dy,dz);
            }
        });

        Image delete = new Image(Asset.getAsset().getTexture("btn/delete.png"));
        add(delete).colspan(1);
        delete.setOrigin(Align.center);
        delete.addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                DirLightGroup.this.remove();
                ((MyStage3D) stage3D).removeBaseLight(directionalLight);
            }
        });

        directionalLight.color.set(SaveData.getSaveData().getDirR(),SaveData.getSaveData().getDirG(),SaveData.getSaveData().getDirB(),SaveData.getSaveData().getDirA());
        directionalLight.direction.set(SaveData.getSaveData().getDirX(),SaveData.getSaveData().getDirY(),SaveData.getSaveData().getDirZ());

        pad(10);
        pack();
    }

    private float getValue(Group rGroup,String name) {
        TextField r = rGroup.findActor(name);
        return ConvertUtil.convertToFloat(r.getText(),0);
    }

    private Group createTextField(String name, float i) {
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
        field.setText(i+"");
        field.setMessageText(name);
        Group group = new Group();
        group.addActor(field);
        group.setSize(400,50);
        return group;
    }
}
