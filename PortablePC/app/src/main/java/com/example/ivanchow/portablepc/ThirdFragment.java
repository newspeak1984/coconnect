package com.example.ivanchow.portablepc;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

import static android.app.Activity.RESULT_OK;


public class ThirdFragment extends Fragment {

    ImageView uploadImage;
    EditText userInput;
    DBHandler dbHandler;
    EditText article;
    //EditText author;
    EditText category;
    Bitmap titleImage;
    static final int REQUEST_LOAD_IMAGE = 1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_third, container, false);
        dbHandler = new DBHandler(getActivity(), null, null, 8);

        userInput = (EditText) v.findViewById(R.id.title);
        //author = (EditText) v.findViewById(R.id.author);
        article = (EditText) v.findViewById(R.id.article);
        category = (EditText) v.findViewById(R.id.category);
        Button upload = (Button) v.findViewById(R.id.upload);
        Button add = (Button) v.findViewById(R.id.add);
        Button delete = (Button) v.findViewById(R.id.delete);
        Button poll = (Button) v.findViewById(R.id.Poll);

       // if(!hasCamera())
         //   upload.setEnabled(false);

        add.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        dbHandler.addNewsStory(new NewsStory(userInput.getText().toString(), titleImage, article.getText().toString(), category.getText().toString()));

                    }
                }
        );
        delete.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        dbHandler.deleteNewsStory(userInput.getText().toString());
                    }
                }
        );
        upload.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                       uploadPhoto(v);

                    }
                }
        );

        poll.setOnClickListener(
               new View.OnClickListener(){
                   @Override
                   public void onClick(View v){
                       Intent Ppage = new Intent(getActivity(), Polling.class);
                      getActivity().startActivity(Ppage);
                   }
               }
        );

        return v;
    }

    public static ThirdFragment newInstance(String text) {

        ThirdFragment f = new ThirdFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    //Launching the camera
    public void uploadPhoto(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        //Take a picture and pass results along to onActivityResult
        startActivityForResult(intent, REQUEST_LOAD_IMAGE);
    }

    //If you want to return the image taken
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_LOAD_IMAGE && resultCode == RESULT_OK && data != null) {
            //Get the photo
            Bundle upload = data.getExtras();
            titleImage = (Bitmap) upload.get("data");

        }
    }



}