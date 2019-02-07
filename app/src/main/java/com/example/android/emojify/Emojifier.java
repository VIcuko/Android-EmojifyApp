package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/**
 * Created by Vicuko on 7/2/19.
 */
// TODO (1): Create a Java class called Emojifier - Done
public class Emojifier {

    public static final String TAG = Emojifier.class.getSimpleName();

    // TODO (2): Create a static method in the Emojifier class - Done
    // called detectFaces() which detects and logs the number of faces in a given bitmap.
    public static void detectFaces(Bitmap bitmap, Context context){
        FaceDetector detector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .setProminentFaceOnly(false)
                .build();

        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        SparseArray<Face> faces = detector.detect(frame);

        Log.v(TAG,"Number of faces found in the image: " + faces.size());

        // Release the detector
        detector.release();
    }
}
