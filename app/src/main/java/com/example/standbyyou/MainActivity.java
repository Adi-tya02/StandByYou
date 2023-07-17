package com.example.standbyyou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment= new HomeFragment();
    ChatbotFragment chatbotFragment= new ChatbotFragment();
//    ChatFragment chatFragment = new ChatFragment();
//    CommunityFragment communityFragment= new CommunityFragment();
    ProfileFragment profileFragment= new ProfileFragment();

    // for chatbot
    RecyclerView recyclerView;
    TextView welcomeTextView;
    EditText messageEditText;
//    ImageButton sendButton;
//    MessageAdapter messageAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        chatbotFragment = new ChatbotFragment();

        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // to directly open home freagment when app will start
        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, homeFragment).commit() ;


        // to get a icon of no. of noti's in any fragment
//        BadgeDrawable badgeDrawable= bottomNavigationView.getOrCreateBadge(R.id.community_btm_nav);
//        BadgeDrawable badgeDrawable2= bottomNavigationView.getOrCreateBadge(R.id.chat_btm_nav);
//            badgeDrawable.setVisible(true);
//            badgeDrawable2.setVisible(true);
//
//            badgeDrawable.setNumber(5);
//            badgeDrawable2.setNumber(2);


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_btm_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, homeFragment).commit();
                        break;

//                    case R.id.chat_btm_nav:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, chatFragment).commit();
//                        break;

                    case R.id.chatbot_btm_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, chatbotFragment).commit();
                        break;

//                    case R.id.community_btm_nav:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, communityFragment).commit();
//                        break;

                    case R.id.profile_btm_nav:
                        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout, profileFragment).commit();
                        break;
                }
                return false;
            }
        });



//        // for chatbot
//        recyclerView= findViewById(R.id.recycler_view);
//        welcomeTextView = findViewById(R.id.welcome_text_view);
//        messageEditText= findViewById(R.id.message_edittext);
//        messageList = new ArrayList<>();        // all messages store in it
//        sendButton= findViewById(R.id.send_btn);
//        sendButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String question = messageEditText.getText().toString().trim();
//                addToChat(question, Message.SENT_BY_ME);
//            }
//        });





    }


}