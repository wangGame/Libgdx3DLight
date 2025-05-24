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
    public BgItem(String pre,FileHandle fileHandle, Runnable runnable){
        String name = fileHandle.name();
        setDebug(true);
        setSize(100,100);
        Image image = new Image(Asset.getAsset().getTexture(pre+name));
        addActor(image);
        image.setOrigin(Align.center);
        float min = Math.max(image.getWidth() / getWidth(), image.getHeight() / getHeight());
        image.setScale(1.f/min);
        image.setPosition(getWidth()/2f,getHeight()/2f,Align.center);


        addListener(new OrdinaryButtonListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                runnable.run();
            }
        });
    }
}
