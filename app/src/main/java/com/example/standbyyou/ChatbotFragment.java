package com.example.standbyyou;

import android.content.Context;
import android.app.Activity;
import android.os.Bundle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.util.ArrayList;


public class ChatbotFragment extends Fragment {
    RecyclerView recyclerView;
    TextView welcomeTextView;
    EditText messageEditText;
    ImageButton sendButton;
    MessageAdapter messageAdapter;

    List<Message> messageList;
    Context thiscontext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        thiscontext = container.getContext();

        // for chatbot
        recyclerView= container.findViewById(R.id.recycler_view);
        welcomeTextView = container.findViewById(R.id.welcome_text_view);
        messageEditText= container.findViewById(R.id.message_edittext);
        messageList = new ArrayList<>();        // all messages store in it
        sendButton= sendButton.findViewById(R.id.send_btn);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = messageEditText.getText().toString().trim();
                addToChat(question, Message.SENT_BY_ME);
            }
        });

        MessageAdapter messageAdapter;
        //Setup recycler view for chat messages
        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setStackFromEnd(true);      // so that we can scroll from bottom and messages will go from down to top.
        recyclerView.setLayoutManager(llm);

        return inflater.inflate(R.layout.fragment_chatbot, container, false);
    }
    void addToChat(String message, String sentBy) {
        requireActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                messageList.add(new Message(message, sentBy));
                messageAdapter.notifyDataSetChanged();
                recyclerView.smoothScrollToPosition(messageAdapter.getItemCount());
            }
        });
    }
}