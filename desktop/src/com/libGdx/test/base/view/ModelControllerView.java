package com.libGdx.test.base.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.constant.Constant;
import com.kw.gdx.scrollpanel.ScrollPane;
import com.kw.gdx.utils.Layer;
import com.libGdx.test.base.group.BgItem;
import com.libGdx.test.base.group.ModelList;


public class ModelControllerView extends Group {
    public ModelControllerView(ModelShowView modelShowView){
        setSize(600,Constant.GAMEHIGHT);
        Image shadow = Layer.getShadow();
        shadow.setSize(getWidth(),getHeight());
        addActor(shadow);
        shadow.getColor().a = 1f;
        {
            ScrollPane bg = new ScrollPane(new Table() {{
                FileHandle bgFile = Gdx.files.internal("bg");
                int index = 0;
                for (FileHandle fileHandle : bgFile.list()) {

                    if (index == 3) {
                        index = 0;
                        row();
                    }
                    index++;
                    BgItem bgItem = new BgItem("bg/",fileHandle, new Runnable() {
                        @Override
                        public void run() {
                            modelShowView.updateBg("bg/"+fileHandle.name());
                        }
                    });
                    add(bgItem).pad(5);

                }
                pack();
                align(Align.topLeft);
            }});
            addActor(bg);
            bg.setSize(600, 300);
            bg.setY(getHeight() - 100, Align.top);
        }

        {
            ScrollPane bg = new ScrollPane(new Table() {{
                FileHandle bgFile = Gdx.files.internal("model");
                for (FileHandle fileHandle : bgFile.list()) {
                    if (fileHandle.name().endsWith(".g3db")){
                        row();
                        ModelList modelList = new ModelList(fileHandle,modelShowView);
                        add(modelList);
                    }
                }
                pack();
                align(Align.topLeft);
            }});
            addActor(bg);
            bg.setSize(600, 300);
            bg.setY(getHeight() - 100 - 300 - 100, Align.top);
        }

        {
            ScrollPane bg = new ScrollPane(new Table() {{
                FileHandle bgFile = Gdx.files.internal("model");
                for (FileHandle fileHandle : bgFile.list()) {
                    if (fileHandle.name().endsWith(".png")){
                        row();
                        BgItem bgItem = new BgItem("model/",fileHandle, new Runnable() {
                            @Override
                            public void run() {
                                modelShowView.updateModelTexture("model/"+fileHandle.name());
                            }
                        });
                        add(bgItem).pad(5);
                    }
                }
                pack();
                align(Align.topLeft);
            }});
            addActor(bg);
            bg.setSize(600, 300);
            bg.setY(getHeight() - 100 - 600 - 100, Align.top);
        }
    }
}
