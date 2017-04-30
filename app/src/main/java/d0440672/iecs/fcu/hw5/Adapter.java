package d0440672.iecs.fcu.hw5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<teamName>{

    Context context;

    public Adapter(Context context, ArrayList<teamName> item){
        super(context,0,item);
        this.context=context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=LayoutInflater.from(context);
        LinearLayout itemlayout=null;

        if(convertView==null){
            itemlayout=(LinearLayout)inflater.inflate(R.layout.listitem,null);
        }
        else{
            itemlayout=(LinearLayout) convertView;
        }
        teamName item=(teamName)getItem(position);

        TextView T1Name=(TextView)itemlayout.findViewById(R.id.team1_tv);
        T1Name.setText(item.team1);
        TextView T2Name=(TextView)itemlayout.findViewById(R.id.team2_tv);
        T2Name.setText(item.team2);
        ImageView T1Img=(ImageView)itemlayout.findViewById(R.id.team1_img);
        T1Img.setImageResource(item.imgid1);
        ImageView T2Img=(ImageView)itemlayout.findViewById(R.id.team2_img);
        T2Img.setImageResource(item.imgid2);
        TextView T1score=(TextView)itemlayout.findViewById(R.id.score1_tv);
        T1score.setText(String.valueOf(item.score1));
        TextView T2score=(TextView)itemlayout.findViewById(R.id.score2_tv);
        T2score.setText(String.valueOf(item.score2));

        if(item.score1>item.score2){
            T1score.setTextColor(Color.RED);
        }
        else{
            T2score.setTextColor(Color.RED);
        }

        return itemlayout;
    }
}
