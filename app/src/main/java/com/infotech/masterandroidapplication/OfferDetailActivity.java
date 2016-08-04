package com.infotech.masterandroidapplication;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StreamDownloadTask;

import java.io.InputStream;

public class OfferDetailActivity extends AppCompatActivity {

    private static StorageReference mStorage;
    private final String TAG = "JOBDETAIL";
    private static long MAX_SIZE = 1024 * 1024 * 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d(TAG, "OfferDetailActivity start");
        setContentView(R.layout.activity_offer_detail);
        mStorage = FirebaseStorage.getInstance().getReference();

        final Toolbar toolBar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String jobTitle = getIntent().getStringExtra("job_title");

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbar);
        collapsingToolbarLayout.setTitle(jobTitle);

        String imageLink = getIntent().getStringExtra("job_image");
        ImageView imageViewLogo = (ImageView) findViewById(R.id.logo);
        displayImageFromUri(imageViewLogo, imageLink);

    }

    private void displayImageFromUri(final ImageView imageView, String link) {

        Log.d(TAG, "diaplayImageFronUrl() start");
        mStorage.child(link).getBytes(MAX_SIZE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                imageView.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });
        /*
        mStorage.child(link).getStream().addOnSuccessListener(new OnSuccessListener<StreamDownloadTask.TaskSnapshot>() {
            ImageView image = imageView;
            @Override
            public void onSuccess(StreamDownloadTask.TaskSnapshot taskSnapshot) {
                Log.d(TAG, "onSuccess() start");
                InputStream input = taskSnapshot.getStream();
                Bitmap bitmap = BitmapFactory.decodeStream(input);
                image.setImageBitmap(bitmap);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG, e.getMessage());
            }
        });*/
        /*
        new AsyncTask<Object, Void, Bitmap>(){

            ImageView imageView;
            String link;
            Bitmap bitmap;

            @Override
            protected Bitmap doInBackground(Object... params) {
                imageView = (ImageView) params[0];
                link = (String)params[1];
                Log.d(TAG, "doInBackground() start");

                mStorage.child(link).getStream().addOnSuccessListener(new OnSuccessListener<StreamDownloadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(StreamDownloadTask.TaskSnapshot taskSnapshot) {
                        Log.d(TAG, "onSuccess() start");
                        InputStream input = taskSnapshot.getStream();
                        bitmap = BitmapFactory.decodeStream(input);
                        imageView.setImageBitmap(bitmap);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e(TAG, e.getMessage());
                    }
                });
                return bitmap;
                //return ImageUtil.getImage(link);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                Log.d(TAG, "doPostExecute() start");
                super.onPostExecute(bitmap);
                imageView.setImageBitmap(bitmap);
            }
        }.execute(imageView, link);
        */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
