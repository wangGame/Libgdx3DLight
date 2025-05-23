package com.libGdx.test.base.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Model;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.d3.actor.BaseActor3DGroup;
import com.kw.gdx.d3.actor.ModelActor3D;
import com.kw.gdx.d3.asset.Asset3D;
import com.kw.gdx.d3.stage.Stage3D;

public class ModelShowView extends BaseActor3DGroup {
    private String modePath;
    private String bgPicPath;
    private ModelActor3D modelActor3D;
    private ModelActor3D kitchenModel;
    private Stage3D stage3D;
    public ModelShowView(Stage3D stage3D){
        this.stage3D = stage3D;
        modePath = "model/table.g3db";
        bgPicPath = "bg/ButtonBackground.png";

        Model deskModel = Asset3D.getAsset3D().getModel(modePath);
        modelActor3D = new ModelActor3D(deskModel);
        addActor3D(modelActor3D);
        modelActor3D.setFromAxis(1,0,0,90);
        modelActor3D.setScale(100,100,100);
        modelActor3D.setPosition(0,0,-300);
        Texture woodTexture = Asset.getAsset().getTexture(bgPicPath);
        woodTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        woodTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        modelActor3D.setMaterialTexture(woodTexture);


        kitchenModel = new ModelActor3D(Asset3D.getAsset3D().getModel("model/KitchenCounter.g3db"));
        stage3D.addActor(kitchenModel);
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

    public void updateModel(String s) {
        if (kitchenModel!=null) {
            kitchenModel.getParent3D().remove();
            kitchenModel.remove();
        }
        kitchenModel = new ModelActor3D(Asset3D.getAsset3D().getModel(s));
        stage3D.addActor(kitchenModel);
    }

    public void updateModelTexture(String name) {
        Texture woodTexture = Asset.getAsset().getTexture(name);
        woodTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        woodTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        kitchenModel.setMaterialTexture(woodTexture);
    }

    public void updateModelScale(float scaleXV, float scaleYV, float scaleZV) {
        if (kitchenModel!=null) {
            kitchenModel.setScale(scaleXV,scaleYV,scaleZV);
        }
    }
}
