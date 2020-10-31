package com.example.arencyclopedia;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.AugmentedImage;
import com.google.ar.core.AugmentedImageDatabase;
import com.google.ar.core.Config;
import com.google.ar.core.Frame;
import com.google.ar.core.HitResult;
import com.google.ar.core.Session;
import com.google.ar.core.TrackingState;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.FrameTime;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Scene;
import com.google.ar.sceneform.math.Quaternion;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.Color;
import com.google.ar.sceneform.rendering.ExternalTexture;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.ux.ArFragment;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.util.Collection;

public class MainActivity extends AppCompatActivity implements Scene.OnUpdateListener{

    private ArFragment arFragment ;
    private Scene scene ;
    private ExternalTexture texture1 ;
    private ExternalTexture texture2 ;
    private MediaPlayer mediaPlayer1 ;
    private MediaPlayer mediaPlayer2 ;
    private AnchorNode anchorNode;
    private ModelRenderable modelnull = null ;
    private InputStream inputStream ;
    private AugmentedImageDatabase imageDatabase;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arFragment = (CustomArFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);
        scene = arFragment.getArSceneView().getScene();
        scene.addOnUpdateListener(this);
        /*scene.setOnTouchListener((hitTestResult, motionEvent) -> {
            ontouch();

            return true;
            });*/
    }


    public void setupDatabase(Config config, Session session) {
        /*  Bitmap astronautBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.astronaut);
        Bitmap brainBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.brain);
        Bitmap dinosaurBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dinosaur);
        Bitmap moonstoneBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.moonstone);
        Bitmap trexBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.trex);
*/
        try {
            inputStream = this.getAssets().open("myimages.imgdb");
            imageDatabase = AugmentedImageDatabase.deserialize(session,inputStream);
        }
        catch(NotSerializableException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        /*
        AugmentedImageDatabase aid = new AugmentedImageDatabase(session);
        aid.addImage("astronaut",astronautBitmap);
        aid.addImage("brain",brainBitmap);
        aid.addImage("dinosaur",dinosaurBitmap);
        aid.addImage("trex",trexBitmap);
        aid.addImage("moonstone",moonstoneBitmap);
        setmessage("database created");
         */
        config.setAugmentedImageDatabase(imageDatabase);
    }

  /*  public void ontouch(){
        Frame frame = arFragment.getArSceneView().getArFrame();
        Collection<AugmentedImage> images = frame.getUpdatedTrackables(AugmentedImage.class);

        for (AugmentedImage image :images){
            if(image.getTrackingMethod() == AugmentedImage.TrackingMethod.FULL_TRACKING) {
                if(image.getName().equals("astronaut")){
                    Anchor anchor = image.createAnchor(image.getCenterPose());
                    modelastronaut(anchor);
                }
                else if(image.getName().equals("moonstone")) {
                    Anchor anchor = image.createAnchor(image.getCenterPose());

                    modelmoonstone(anchor,image);


                }
            }

        }
       setmessage("image not matched");

    }

   */

    @Override
    public void onUpdate(FrameTime frameTime) {

        Frame frame = arFragment.getArSceneView().getArFrame();
        Collection<AugmentedImage> images = frame.getUpdatedTrackables(AugmentedImage.class);

        for (AugmentedImage image :images){
            if(image.getTrackingMethod() == AugmentedImage.TrackingMethod.FULL_TRACKING) {
                if(image.getName().equals("moonstone")) {
                    Anchor anchor = image.createAnchor(image.getCenterPose());
                    scene.removeOnUpdateListener(this);
                    modelmoonstone(anchor,image);
                }
                else if(image.getName().equals("trex")) {
                    Anchor anchor = image.createAnchor(image.getCenterPose());
                    scene.removeOnUpdateListener(this);
                    modeltrex(anchor,image);
                }
                else if(image.getName().equals("astronaut")){
                    Anchor anchor = image.createAnchor(image.getCenterPose());
                    scene.removeOnUpdateListener(this);
                    modelastronaut(anchor);
                }
                else if(image.getName().equals("brain")){
                    Anchor anchor = image.createAnchor(image.getCenterPose());
                    scene.removeOnUpdateListener(this);
                    modelbrain(anchor);
                }
                else if(image.getName().equals("dinosaur")){
                    Anchor anchor = image.createAnchor(image.getCenterPose());
                    scene.removeOnUpdateListener(this);
                    modeldinosaur(anchor);
                }
            }
        }
    }


    private void modelastronaut(Anchor anchor)
    {
            setmessage("Model rendering start...");
            ModelRenderable
                    .builder()
                    .setSource(this, Uri.parse("astronaut.sfb"))
                    .build()
                    .thenAccept(modelRenderable -> {
                        putmodel(anchor, modelRenderable);
                    });
    }

    public void modelbrain(Anchor anchor){
        setmessage("Model rendering start...");
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("brain.sfb"))
                .build()
                .thenAccept(modelRenderable ->{
                    putmodel(anchor , modelRenderable);
                });
    }

    public void modeldinosaur(Anchor anchor){
        setmessage("Model rendering start...");
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("model.sfb"))
                .build()
                .thenAccept(modelRenderable ->{
                    putmodel(anchor , modelRenderable);
                });
    }

    public void modeltrex(Anchor anchor, AugmentedImage image){
        setmessage("Model rendering start...");
        texture2 = new ExternalTexture();
        mediaPlayer2 = MediaPlayer.create(this, R.raw.trex);
        mediaPlayer2.setSurface(texture2.getSurface());
        mediaPlayer2.setLooping(true);
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("chroma_key_video.sfb"))
                .build()
                .thenAccept(modelRenderable -> {
                    modelRenderable.getMaterial().setExternalTexture("videoTexture",texture2 );
                    modelRenderable.getMaterial().setFloat4("keyColor",new Color(0.01843f,1.0f,0.098f));
                    putmodeltrex(anchor,modelRenderable,image);
                });
    }



    public void modelmoonstone(Anchor anchor, AugmentedImage image){
            setmessage("Model rendering start...");
            texture1 = new ExternalTexture();
            mediaPlayer1 = MediaPlayer.create(this, R.raw.moonrock1);
            mediaPlayer1.setSurface(texture1.getSurface());
            mediaPlayer1.setLooping(true);
            ModelRenderable
                    .builder()
                    .setSource(this, Uri.parse("chroma_key_video.sfb"))
                    .build()
                    .thenAccept(modelRenderable -> {
                        modelRenderable.getMaterial().setExternalTexture("videoTexture", texture1);
                        modelRenderable.getMaterial().setFloat4("keyColor", new Color(0.01843f, 1.0f, 0.098f));
                        putmodelmoonstone(anchor, modelRenderable, image);
                    });
    }



    private void putmodel(Anchor anchor, ModelRenderable modelRenderable) {
            setmessage("Model rendered, adding node to scene");
            anchorNode = new AnchorNode(anchor);
            anchorNode.setRenderable(modelRenderable);
            scene.addChild(anchorNode);

            Button button = findViewById(R.id.dissolve);
            button.setOnClickListener(view -> {
                setmessage("starting dissolving");
                scene.removeChild(anchorNode);
                anchorNode.getAnchor().detach();
                anchorNode.setParent(null);
                anchorNode=null;
                setmessage("Model Removed !");
                scene.addOnUpdateListener(this);

            });



    }

    private void putmodelmoonstone(Anchor anchor, ModelRenderable videoRenderable1 , AugmentedImage image){

            setmessage("Model rendered, adding node to scene");
            anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());
            // Create a node to render the video and add it to the anchor.
            Node videoNode = new Node();
            videoNode.setParent(anchorNode);

            videoNode.setWorldScale(
                    new Vector3(image.getExtentX(), image.getExtentZ(), 1f));
            videoNode.setLocalRotation(
                    Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), -90.0f));
            videoNode.setLocalPosition(
                    new Vector3(0f,0f,(image.getExtentZ()/2))     );

            if (!mediaPlayer1.isPlaying()) {
                mediaPlayer1.start();
                // Wait to set the renderable until the first frame of the  video becomes available.
                // This prevents the renderable from briefly appearing as a black quad before the video
                // plays.
                texture1
                        .getSurfaceTexture()
                        .setOnFrameAvailableListener(
                                (SurfaceTexture surfaceTexture) -> {
                                    videoNode.setRenderable(videoRenderable1);
                                    texture1.getSurfaceTexture().setOnFrameAvailableListener(null);
                                });
            } else {
                videoNode.setRenderable(videoRenderable1);
            }

            Button button = findViewById(R.id.dissolve);
            button.setOnClickListener(view -> {
                setmessage("Model getting dissolved ....");
                mediaPlayer1.stop();
                scene.removeChild(anchorNode);
                anchorNode.getAnchor().detach();
                anchorNode.setParent(null);
                setmessage("Model Removed !");
                anchorNode=null;
                scene.addOnUpdateListener(this);
            });
    }

    private void putmodeltrex(Anchor anchor, ModelRenderable videoRenderable2 , AugmentedImage image){

        setmessage("Model rendered, adding node to scene");
        anchorNode = new AnchorNode(anchor) ;
        anchorNode.setParent(arFragment.getArSceneView().getScene());
        // Create a node to render the video and add it to the anchor.
        Node videoNode = new Node();
        videoNode.setParent(anchorNode);

        videoNode.setWorldScale(
                new Vector3(image.getExtentX()*2 , image.getExtentZ()*2 , 1f));
        videoNode.setLocalRotation(
                Quaternion.axisAngle(new Vector3(1.0f, 0.0f, 0.0f), -90.0f));
        videoNode.setLocalPosition(
                new Vector3(0f,0f,(image.getExtentZ()/2)));

        if (!mediaPlayer2.isPlaying()) {
            mediaPlayer2.start();
            // Wait to set the renderable until the first frame of the  video becomes available.
            // This prevents the renderable from briefly appearing as a black quad before the video
            // plays.
            texture2
                    .getSurfaceTexture()
                    .setOnFrameAvailableListener(
                            (SurfaceTexture surfaceTexture) -> {
                                videoNode.setRenderable(videoRenderable2);
                                texture2.getSurfaceTexture().setOnFrameAvailableListener(null);
                            });
        } else {
            videoNode.setRenderable(videoRenderable2);
        }

        Button button = findViewById(R.id.dissolve);
        button.setOnClickListener(view -> {
            setmessage("Model getting dissolved ....");
            mediaPlayer2.stop();
            scene.removeChild(anchorNode);
            anchorNode.getAnchor().detach();
            anchorNode.setParent(null);
            setmessage("Model Removed !");
            anchorNode=null;
            scene.addOnUpdateListener(this);
        });

    }

    private void setmessage(String message){
        Toast toast = Toast.makeText(this,message,Toast.LENGTH_SHORT);
        toast.show();
    }
}
