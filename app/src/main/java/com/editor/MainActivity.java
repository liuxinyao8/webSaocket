package com.editor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.editor.adapters.ChatAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView txt_show;
    private TextView txt_source;
    private RecyclerView recyclerView;
    private List<String> msgs;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        txt_show = findViewById(R.id.txt_show);
        txt_source = findViewById(R.id.txt_source);
        recyclerView = findViewById(R.id.recyclerview);

        msgs = new ArrayList<>();

        StringBuilder msg = new StringBuilder();
        msg.append("this is a demo,you can input the face keyword in the FaceManager.java .It looks like").append(" [得意][偷笑][擦汗][酷]");
        msg.append("and so on .");
        msgs.add(msg.toString());
        msgs.add("You can download the demo from https://github.com/TracyZhangLei");
        msgs.add("[微笑][微笑][微笑]");
        msgs.add("[咖啡][微笑][咖啡]");
        msgs.add("[咖啡][微笑][咖啡]");
        msgs.add("[咖啡][微笑][咖啡]");
        msgs.add("[咖啡][微笑][咖啡]");
        msgs.add("[咖啡][微笑][咖啡]");
        msgs.add("[咖啡][微笑][咖啡]");
        msgs.add("[咖啡][微笑][咖啡]");

        msgs.add("中华人民共和国万岁！[微笑]");
        msgs.add("Long live the People's Republic of China！[微笑]");
        msgs.add("長い中華人民共和国ライブ！[微笑]");

        msgs.add("中华人民共和国万岁！");
        msgs.add("Long live the People's Republic of China！");
        msgs.add("長い中華人民共和国ライブ！");

        msgs.add("[微笑]中华人民共和国万岁！");
        msgs.add("[微笑]Long live the People's Republic of China！");
        msgs.add("[微笑]長い中華人民共和国ライブ！");

        msgs.add("Talk is cheap,show me the code.");

        chatAdapter = new ChatAdapter(this,msgs);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(chatAdapter);


        SmileyParser parser = new SmileyParser(this);
        String source = "[爱你][机器人][抱抱][拜拜][悲剧]";
        txt_show.setText("表情："+source);
        String content = "哈哈给你个[爱你][机器人]表情，抱抱[抱抱][拜拜][悲剧]";
        txt_source.setText(parser.replace("解析："+content));

        String sdk = SDKManager.initSDK();
        Toast.makeText(this,sdk,Toast.LENGTH_LONG).show();

    }
}
