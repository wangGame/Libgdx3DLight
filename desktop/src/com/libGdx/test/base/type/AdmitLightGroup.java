package com.libGdx.test.base.type;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
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

public class AdmitLightGroup extends Table {
    private ColorAttribute colorAttribute;
    private MyStage3D stage3D;
    private Group rGroup;
    private Group gGroup;
    private Group bGroup;
    private Group aGroup;
    private Group indsGroup;
//    private Group yGroup;
//    private Group zGroup;

    public AdmitLightGroup(Stage3D stage3D){
        setSize(600,400);
        this.stage3D = (MyStage3D) stage3D;
        colorAttribute = new ColorAttribute(ColorAttribute.AmbientLight, 1, 1, 1, 1f);
        ((MyStage3D) stage3D).addColorAttribute(colorAttribute);
        {
            String simpleName = getClass().getSimpleName();
            Label label = new Label(simpleName, new Label.LabelStyle() {{
                font = Asset.getAsset().loadBitFont("Bahnschrift-Regular_40_1.fnt");
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
            add(gGroup).pad(10);
            gGroup.setPosition(0, 0);
            row();
            bGroup = createTextField("b", 4);
            add(bGroup).pad(10);
            bGroup.setPosition(0, 0);
            row();
            aGroup = createTextField("a", 4);
            add(aGroup).pad(10);
            aGroup.setPosition(0, 0);
            row();
            indsGroup = createTextField("i", 4);
            add(indsGroup).pad(10);
            indsGroup.setPosition(0, 0);
            row();

        }
//        {
//            row();
//            xGroup = createTextField("x", 4);
//            add(xGroup).pad(10);
//            xGroup.setPosition(0,0);
//            row();
//            yGroup = createTextField("y", 4);
//            add(yGroup).pad(10);
//            yGroup.setPosition(0,0);
//            row();
//            zGroup = createTextField("z", 4);
//            add(zGroup).pad(10);
//            zGroup.setPosition(0,0);
//            row();
//        }
        row();
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
                float i = getValue(indsGroup,"i");
                if (i<=0){
                    i = 1;
                }
//                colorAttribute.color.set(r,g,b,a);
                colorAttribute.color.r = r * i;
                colorAttribute.color.g = g * i;
                colorAttribute.color.b = b * i;

            }
        });
        pad(10);
        pack();
    }

    private float getValue(Group rGroup,String name) {
        TextField r = rGroup.findActor(name);
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
