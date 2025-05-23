package com.libGdx.test.base.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.NinePatch;
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
import com.kw.gdx.constant.Constant;
import com.kw.gdx.listener.OrdinaryButtonListener;
import com.kw.gdx.scrollpanel.ScrollPane;
import com.kw.gdx.utils.ConvertUtil;
import com.kw.gdx.utils.Layer;
import com.libGdx.test.base.group.BgItem;
import com.libGdx.test.base.group.ModelList;


public class ModelControllerView extends Group {
    public ModelControllerView(ModelShowView modelShowView){
        setSize(600,Constant.GAMEHIGHT);
        Image shadow = Layer.getShadow();
        shadow.setSize(getWidth(),getHeight());
        addActor(shadow);
        shadow.setColor(Color.BLACK);
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


        Table table = new Table(){{
            align(Align.center);
            Group scaleX = createTextField("scaleX", 0);
            add(scaleX);
            row();
            Group scaleY = createTextField("scaleY", 0);
            add(scaleY);
            row();
            Group scaleZ = createTextField("scaleZ", 0);
            add(scaleZ);
            row();
            Actor ok = new Image(Asset.getAsset().getTexture("btn/ok.png"));
            add(ok);
            ok.setOrigin(Align.center);
            ok.addListener(new OrdinaryButtonListener(){
                @Override
                public void clicked(InputEvent event, float x, float y) {
                    super.clicked(event, x, y);
                    float scaleXV = getValue(scaleX, "scaleX");
                    float scaleYV = getValue(scaleY, "scaleY");
                    float scaleZV = getValue(scaleZ, "scaleZ");
                    modelShowView.updateModelScale(scaleXV,scaleYV,scaleZV);
                }
            });
            pack();
        }};
        addActor(table);
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
