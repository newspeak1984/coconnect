package com.example.ivanchow.portablepc;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddGroup extends AppCompatActivity{

    private static final int RESULT_LOAD_IMAGE = 1;

    EditText editTextName;
    Button buttonAdd;
    DatabaseReference databaseGroups;

    ImageView upload;
    Button uploadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addgroup);

        databaseGroups = FirebaseDatabase.getInstance().getReference("groups");

        editTextName = (EditText) findViewById(R.id.editTextName);
        buttonAdd = (Button) findViewById(R.id.buttonAddGroup);

        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                addGroup();
            }
        });

        upload = (ImageView) findViewById(R.id.imageToUpload);
        uploadImage = (Button) findViewById(R.id.buttonAddImage);
        uploadImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addPicture();
            }
        });
    }
    private void addPicture(){
        Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(galleryIntent, RESULT_LOAD_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && data != null){
            Uri selectedImage = data.getData();
            upload.setImageURI(selectedImage);
        }
    }

    private void addGroup(){
        String name = editTextName.getText().toString().trim();
        if(!TextUtils.isEmpty(name)){
            String id = databaseGroups.push().getKey();
            Group group = new Group(id, name);
            databaseGroups.child(id).setValue(group);
            Toast.makeText(this,"Group added", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Enter a group name", Toast.LENGTH_LONG).show();
        }
    }
}