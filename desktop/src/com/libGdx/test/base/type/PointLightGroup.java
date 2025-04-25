package com.libGdx.test.base.type;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g3d.environment.PointLight;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.NinePatchDrawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;

public class PointLightGroup extends Table {
    public PointLightGroup(){
        setSize(400,400);
        Label label = new Label("AdmitLight",new Label.LabelStyle(){{font = Asset.getAsset().loadBitFont("Bahnschrift-Regular_40_1.fnt");}});
        add(label);
        label.setAlignment(Align.left);
        label.setPosition(0,getHeight(),Align.topLeft);
        row();
        Actor rlabel = createTextField("r", 4);
        add(rlabel);
        rlabel.setPosition(0,0);

        Actor glabel = createTextField("g", 4);
        add(glabel);
        glabel.setPosition(0,0);
        row();
        Actor blabel = createTextField("b", 4);
        add(blabel);
        blabel.setPosition(0,0);

        Actor xlabel = createTextField("x", 4);
        add(xlabel);
        xlabel.setPosition(0,0);
        pack();

        Actor ylabel = createTextField("y", 4);
        add(ylabel);
        ylabel.setPosition(0,0);

        Actor alabel = createTextField("z", 4);
        add(alabel);
        alabel.setPosition(0,0);
        pack();

        Actor instensityLabel = createTextField("instensity", 4);
        add(instensityLabel);
        instensityLabel.setPosition(0,0);
    }


    private Actor createTextField(String name, int i) {
        TextField field = new TextField("",new TextField.TextFieldStyle(){{
            font = Asset.getAsset().loadBitFont("Bahnschrift-Regular_40_1.fnt");
            background = new NinePatchDrawable(
                    new NinePatch(
                            Asset.getAsset().getSprite("textfield/textfieldbg.png"),
                            10,10,10,10));
            cursor = new TextureRegionDrawable(Asset.getAsset().getSprite("textfield/textcursor.png"));
            fontColor = Color.BLACK;
        }
        });
        field.setSize(200,50);
        field.setName(name);
        field.setMessageText(name);
        Group group = new Group();
        group.addActor(field);
        group.setSize(200,50);
        return group;
    }

}
