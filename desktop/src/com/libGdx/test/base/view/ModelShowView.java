package com.libGdx.test.base.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.d3.actor.BaseActor3DGroup;
import com.kw.gdx.d3.actor.ModelActor3D;
import com.kw.gdx.d3.asset.Asset3D;
import com.kw.gdx.utils.Layer;

public class ModelShowView extends BaseActor3DGroup {
    private String modePath;
    private String bgPicPath;
    private ModelActor3D modelActor3D;
    public ModelShowView(){
        modePath = "table.g3db";
        bgPicPath = "bg/ButtonBackground.png";

        Model deskModel = Asset3D.getAsset3D().getModel(modePath);
        modelActor3D = new ModelActor3D(deskModel);
        addActor3D(modelActor3D);
        modelActor3D.setScale(100,100,100);
        Texture woodTexture = Asset.getAsset().getTexture(bgPicPath);
        woodTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        woodTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        modelActor3D.setMaterialTexture(woodTexture);


        ModelActor3D kitchenModel = new ModelActor3D(Asset3D.getAsset3D().getModel("KitchenCounter.g3db"));
        addActor3D(kitchenModel);
    }

    public String getModePath() {
        return modePath;
    }

    public void updateBg(String name) {
        if (bgPicPath.equals(name)) {
            return;
        }
        bgPicPath = name;
        Texture woodTexture = Asset.getAsset().getTexture(bgPicPath);
        woodTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        woodTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        modelActor3D.setMaterialTexture(woodTexture);
    }
}
