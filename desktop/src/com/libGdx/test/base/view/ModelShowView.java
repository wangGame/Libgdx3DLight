package com.libGdx.test.base.view;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Model;
import com.kw.gdx.asset.Asset;
import com.kw.gdx.d3.actor.BaseActor3DGroup;
import com.kw.gdx.d3.actor.ModelActor3D;
import com.kw.gdx.d3.asset.Asset3D;

public class ModelShowView extends BaseActor3DGroup {
    public ModelShowView(){
        Model deskModel = Asset3D.getAsset3D().getModel("table.g3db");
        ModelActor3D modelActor3D = new ModelActor3D(deskModel);
        addActor3D(modelActor3D);
        modelActor3D.setScale(100,100,100);
        Texture woodTexture = Asset.getAsset().getTexture("ButtonBackground.png");
        woodTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.Repeat);
        woodTexture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        modelActor3D.setMaterialTexture(woodTexture);
        ModelActor3D kitchenModel = new ModelActor3D(Asset3D.getAsset3D().getModel("KitchenCounter.g3db"));
        addActor3D(kitchenModel);


    }
}
