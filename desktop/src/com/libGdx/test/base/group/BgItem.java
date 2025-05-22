package com.libGdx.test.base.group;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.libGdx.test.base.view.ModelShowView;

public class BgItem extends Group {
    public BgItem(FileHandle fileHandle, ModelShowView modelShowView){
        String name = fileHandle.name();
        setSize(190,190);
        Image image = new Image(Asset.getAsset().getTexture("bg/"+name));
        addActor(image);
        image.setOrigin(Align.center);
        float min = Math.min(image.getWidth() / 190, image.getHeight() / 190f);
        image.setScale(1.f/min);
        image.setPosition(100,100,Align.center);


        addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                modelShowView.updateBg("bg/"+fileHandle.name());
            }
        });
    }
}
