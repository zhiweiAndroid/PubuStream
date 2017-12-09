package sinaflashmoney.credit.sina.com.recycleviewpubustream;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/12/9 0009.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.Myholder>{

    private ItemLongClicekListener longListener;
    private ItemClickListener clickListener;
    private List<Integer> images;
    private Context context;
    private List<Integer> mHeights;

    public RecycleViewAdapter(Context context,List<Integer> datas) {
        this.context=context;
        images=datas;
        if (datas!=null){
            getRandomHeight(datas);
        }
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_image, null);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(final Myholder holder, final int position) {
        ViewGroup.LayoutParams layoutParams = holder.iv.getLayoutParams();
        layoutParams.height = mHeights.get(position);
        holder.iv.setLayoutParams(layoutParams);

        holder.iv.setImageDrawable(ContextCompat.getDrawable(context,images.get(position)));
        holder.iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (clickListener!=null){
                    clickListener.onClick(holder,position);
                }
            }
        });
        holder.iv.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if (longListener!=null){
                    longListener.onLongClick(holder,position);
                     return true;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return images==null?0:images.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{

        ImageView iv;

        public Myholder(View itemView) {
            super(itemView);
             iv =  itemView.findViewById(R.id.iv);

        }
    }

    public void setOnItemClickListener (ItemClickListener listener){
        clickListener=listener;
    }

    public void setOnItemLongClickListener(ItemLongClicekListener listener){
        longListener=listener;
    }

    public void getRandomHeight(List<Integer> mList){
        mHeights = new ArrayList<>();
        for(int i=0; i < mList.size();i++){
            //随机的获取一个范围为200-600直接的高度
            mHeights.add((int)(300+Math.random()*400));
        }
    }



}
