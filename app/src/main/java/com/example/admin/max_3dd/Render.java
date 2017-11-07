package com.example.admin.max_3dd;

import android.graphics.Bitmap;

import min3d.Shared;
import min3d.Utils;
import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;
import min3d.vos.LightType;

/**
 * Created by admin on 27.10.2017.
 */
public class Render extends RendererActivity {
    private Object3dContainer starobj;

    private Object3dContainer planetObj;
    private Object3dContainer planetObjGas;
    private Object3dContainer cameraEnvirontment;
    private Object3dContainer focus_point;
    /** Called when the activity is first created. */
    @Override
    public void initScene(){


        Light myLight = new Light();

        myLight.position.setAll(0f, 0, 30);
        myLight.type(LightType.POSITIONAL);
        myLight.diffuse.setAll(255, 100, 100, 255);
        myLight.ambient.setAll(0, 0, 0, 0);
        myLight.specular.setAll(255, 100, 100, 100);
        myLight.emissive.setAll(0, 0, 0, 0);
        scene.lights().add(myLight);

        myLight = new Light();

        myLight.position.setAll(0, 0, -30);
        myLight.type(LightType.POSITIONAL);
        myLight.diffuse.setAll(255, 100, 100, 255);
        myLight.ambient.setAll(0, 0, 0, 0);
        myLight.specular.setAll(255, 100, 100, 255);
        myLight.emissive.setAll(0, 0, 0, 0);
        scene.lights().add(myLight);

        myLight = new Light();

        myLight.position.setAll(30, 0, 0);
        myLight.type(LightType.POSITIONAL);
        myLight.diffuse.setAll(255, 100, 100, 255);
        myLight.ambient.setAll(0, 0, 0, 0);
        myLight.specular.setAll(255, 100, 100, 255);
        myLight.emissive.setAll(0, 0, 0, 0);
        scene.lights().add(myLight);
        myLight = new Light();

        myLight.position.setAll(-30, 0, 0);
        myLight.type(LightType.POSITIONAL);
        myLight.diffuse.setAll(255, 100, 100, 255);
        myLight.ambient.setAll(0, 0, 0, 0);
        myLight.specular.setAll(255, 100, 100, 255);
        myLight.emissive.setAll(0, 0, 0, 0);
        scene.lights().add(myLight);

        myLight = new Light();

        myLight.position.setAll(0, 30, 0);
        myLight.type(LightType.POSITIONAL);
        myLight.diffuse.setAll(255, 100, 100, 255);
        myLight.ambient.setAll(0, 0, 0, 0);
        myLight.specular.setAll(255, 100, 100, 255);
        myLight.emissive.setAll(0, 0, 0, 0);
        scene.lights().add(myLight);

        myLight = new Light();

        myLight.position.setAll(0, -30, 0);
        myLight.type(LightType.POSITIONAL);
        myLight.diffuse.setAll(255, 100, 100, 255);
        myLight.ambient.setAll(0, 0, 0, 0);
        myLight.specular.setAll(255, 100, 100, 255);
        myLight.emissive.setAll(0, 0, 0, 0);
        scene.lights().add(myLight);




        IParser myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "com.example.admin.max_3dd:raw/star_obj",true);
        myParser.parse();
        starobj = myParser.getParsedObject();
        starobj.position().setAll(0,0,0);
        starobj.scale().x = starobj.scale().y = starobj.scale().z = 0.4f;
        scene.addChild(starobj);

       myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "com.example.admin.max_3dd:raw/planet_obj",true);
        myParser.parse();
        planetObj= myParser.getParsedObject();
        planetObj.position().x = (float) (Math.cos(1));
        planetObj.position().y = (float) (Math.sin(1));
        planetObj.position().z = 0;
        planetObj.scale().x = planetObj.scale().y =  planetObj.scale().z = 0.1f;
        scene.addChild(planetObj);

        myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "com.example.admin.max_3dd:raw/planet_obj",true);
        myParser.parse();
        Bitmap b;

        b = Utils.makeBitmapFromResourceId(this,R.drawable.gas_atm);
        Shared.textureManager().addTextureId(b, "gas_atm", false);
        b.recycle();


        planetObjGas= myParser.getParsedObject();
        planetObjGas.position().x = (float) (Math.cos(1));
        planetObjGas.position().y = (float) (Math.sin(1));
        planetObjGas.position().z = 0;
        planetObjGas.scale().x =planetObjGas.scale().y = planetObjGas.scale().z = 0.2f;

        scene.addChild(planetObjGas);
        planetObjGas.textures().addById("gas_atm");




        myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "com.example.admin.max_3dd:raw/camera_position_obj",true);
        myParser.parse();
        cameraEnvirontment= myParser.getParsedObject();
        cameraEnvirontment.position().x =100;
        cameraEnvirontment.position().y =100;
        cameraEnvirontment.position().z = 0;
        cameraEnvirontment.scale().x =  cameraEnvirontment.scale().y =   cameraEnvirontment.scale().z = 0.1f;
        scene.addChild( cameraEnvirontment);

        myParser = Parser.createParser(Parser.Type.OBJ, getResources(), "com.example.admin.max_3dd:raw/focus_point_obj",true);
        myParser.parse();
        focus_point= myParser.getParsedObject();
        focus_point.position().x =100;
        focus_point.position().y =100;
        focus_point.position().z = 0;
        focus_point.scale().x =  focus_point.scale().y =  focus_point.scale().z = 0.1f;
        scene.addChild(focus_point);




        scene.camera().target.setAll(starobj.position().x,starobj.position().y,starobj.position().z);
       // scene.camera().position.setAll(.5f,3,0);
        scene.camera().upAxis.setAll(0,0,8);
        scene.camera().frustum.zFar(1000);
        scene.camera().position.x = 120;
        scene.camera().position.y = 120;
        scene.camera().position.z = 5;



        //faceObject3D.position().setAll(roomObject3D.position().x,roomObject3D.position().y,roomObject3D.position().z);


        // Depending on the model you will need to change the scale faceObject3D.scale().x = faceObject3D.scale().y = faceObject3D.scale().z = 0.009f;        scene.addChild(faceObject3D);
    }
    float x;
    float adder= (float) 0.001;
    @Override
    public void updateScene() {


        x+=adder;
        planetObj.position().x = (float) (80*(Math.cos(x)));
        planetObj.position().y = (float) (80*(Math.sin(x)));




        planetObj.rotation().z += 1;

        planetObjGas.position().x = (float) (80*(Math.cos(x)));
        planetObjGas.position().y = (float) (80*(Math.sin(x)));

        cameraEnvirontment.position().x= planetObjGas.position().x+(float) (50*(Math.cos(x*50)));
        cameraEnvirontment.position().y= planetObjGas.position().y+(float) (50*(Math.sin(x*50)));
        cameraEnvirontment.rotation().y+=1;
        focus_point.position().x= planetObjGas.position().x;
        focus_point.position().y= planetObjGas.position().y;

       // scene.camera().position.x= planetObjGas.position().x+(float) (50*(Math.cos(x*50)))+10;
      //  scene.camera().position.y= planetObjGas.position().y+(float) (50*(Math.sin(x*50)))+10;
       // scene.camera().target.setAll(focus_point.position().x,focus_point.position().y,focus_point.position().z);

        planetObjGas.rotation().z += 1;









        //faceObject3D.rotation().z += 1;
    }
}
