package com.example.standbyyou;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder>{

    List<Message> messageList;

    public MessageAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View chatView= LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item,null);
        MyViewHolder myViewHolder= new MyViewHolder(chatView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        // here i check that the message is sent by me or my chatbot

        Message message= messageList.get(position);
        if(message.getSentBy().equals(Message.SENT_BY_ME)){
            // ab agar maine message bheja hoga to bot wali side{ chat item.xml me } nahi dikhegi,
            // or agar bot ka message hoga to meri side ni dikhegi

            holder.leftchatview.setVisibility(View.GONE);
            holder.rightchatview.setVisibility(View.VISIBLE);
            holder.rightchattextview.setText(message.getMessage());


        }else {

            holder.rightchatview.setVisibility(View.GONE);
            holder.leftchatview.setVisibility(View.VISIBLE);
            holder.leftchattextview.setText(message.getMessage());

        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


    LinearLayout leftchatview ,rightchatview;
    TextView leftchattextview,rightchattextview;




        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            leftchatview= itemView.findViewById(R.id.left_chat_view);
            rightchatview= itemView.findViewById(R.id.right_chat_view);
            leftchatview= itemView.findViewById(R.id.left_chat_text_view);
            rightchatview= itemView.findViewById(R.id.right_chat_text_view);

        }
    }


}
