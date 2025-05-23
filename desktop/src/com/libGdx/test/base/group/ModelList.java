package com.libGdx.test.base.group;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.libGdx.test.base.view.ModelShowView;

public class ModelList extends Group {
    public ModelList(FileHandle fileHandle, ModelShowView modelShowView){
        String name = fileHandle.name();
        setSize(600,50);
        Label label = new Label(name,new Label.LabelStyle(){{
            font = Asset.getAsset().loadBitFont("font.fnt");
        }});
        label.setAlignment(Align.left);
        label.setPosition(getWidth()/2f,getHeight()/2f,Align.center);
        addActor(label);
        setOrigin(Align.center);
        addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                modelShowView.updateModel("model/"+fileHandle.name());
            }
        });
        label.setColor(Color.BLACK);
    }
}
