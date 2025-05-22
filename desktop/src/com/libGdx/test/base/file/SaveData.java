package com.libGdx.test.base.file;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

public class SaveData {
    public static SaveData saveData;
    private Preferences preferences;
    private SaveData(){
        preferences = Gdx.app.getPreferences("light3Ddata");
    }

    public static SaveData getSaveData() {
        if (saveData == null){
            saveData = new SaveData();
        }
        return saveData;
    }

    //环境光
    public void saveAdmitLightR(float v){
        flushFloat("AdmitLightR",v);
    }

    public float getAdmitLightR(){
        return getFloatData("AdmitLightR");
    }

    private float getFloatData(String name) {
        return preferences.getFloat(name, 1);
    }

    private void flushFloat(String name,float v) {
        preferences.putFloat(name, v);
        preferences.flush();
    }

    public void saveAdmitLightG(float v){
        flushFloat("AdmitLightG",v);
    }

    public void getAdmitLightG(){
        getFloatData("AdmitLightG");
    }

    public void saveAdmitLightB(float v){
        flushFloat("AdmitLightB",v);
    }

    public void getAdmitLightB(){
        getFloatData("AdmitLightB");
    }

    public void saveAdmitLightA(float v){
        flushFloat("AdmitLightA",v);
    }

    public void getAdmitLightA(){
        getFloatData("AdmitLightA");
    }
    //DIR
    public void saveDirR(float v){
        flushFloat("DirR",v);
    }

    public void getDirR(float v){
        getFloatData("DirR",v);
    }

    public void saveDirG(float v){
        flushFloat("DirG",v);
    }

    public void saveDirB(float v){
        flushFloat("DirB",v);
    }

    public void saveDirA(float v){
        flushFloat("DirA",v);
    }


    public void saveDirX(float v){
        flushFloat("DirX",v);
    }


    public void saveDirY(float v){
        flushFloat("DirY",v);
    }


    public void saveDirZ(float v){
        flushFloat("DirZ",v);
    }
    //point

    public void savePointR(float v){
        flushFloat("PointR",v);
    }

    public void savePointG(float v){
        flushFloat("PointG",v);
    }

    public void savePointB(float v){
        flushFloat("PointB",v);
    }

    public void savePointA(float v){
        flushFloat("PointA",v);
    }

    public void savePointX(float v){
        flushFloat("PointX",v);
    }

    public void savePointY(float v){
        flushFloat("PointY",v);
    }

    public void savePointZ(float v){
        flushFloat("PointZ",v);
    }

    public void savePointIntensity(float v){
        flushFloat("PointIntensity",v);
    }

}
