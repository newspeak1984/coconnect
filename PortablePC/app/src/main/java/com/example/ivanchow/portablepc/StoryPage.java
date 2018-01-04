package com.example.ivanchow.portablepc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class StoryPage extends AppCompatActivity {
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_page);
        dbHandler = new DBHandler(this, null, null, 8);

        String storyTitle = getIntent().getStringExtra("ARTICLE");
        NewsStory story = dbHandler.getDB(storyTitle);

        ImageView image = (ImageView) findViewById(R.id.mainImage);
        TextView byline = (TextView) findViewById(R.id.byline);
        TextView article = (TextView) findViewById(R.id.article);
        TextView title = (TextView) findViewById(R.id.Title);

        String articleTitle = story.getTitle();
        title.setText(articleTitle);
        image.setImageBitmap(story.getTitleImage());
        //byline.setText(story.getAuthor());
        article.setText(story.getArticle());



    }


}




