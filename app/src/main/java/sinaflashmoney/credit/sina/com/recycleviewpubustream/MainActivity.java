package sinaflashmoney.credit.sina.com.recycleviewpubustream;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemLongClicekListener,ItemClickListener{

    private RecyclerView recyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);

        }
        setContentView(R.layout.activity_main);
        recyView = (RecyclerView) findViewById(R.id.recycleview);
        RecyclerView.LayoutManager manager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyView.setLayoutManager(manager);
        RecycleViewAdapter adapter=new RecycleViewAdapter(this,getDatas());
        recyView.setAdapter(adapter);
        recyView.setItemAnimator(new DefaultItemAnimator());
        recyView.addItemDecoration(new GridSpacingItemDecoration(3,10,true));
        recyView.setHasFixedSize(true);
        adapter.setOnItemClickListener(this);
        adapter.setOnItemLongClickListener(this);

    }

    private List<Integer> getDatas() {
        List<Integer> datas=new ArrayList<Integer>();
        datas.add(R.mipmap.meizhi001);
        datas.add(R.mipmap.meizhi002);
        datas.add(R.mipmap.meizhi003);
        datas.add(R.mipmap.meizhi004);
        datas.add(R.mipmap.meizhi005);
        datas.add(R.mipmap.meizhi006);
        datas.add(R.mipmap.meizhi007);
        datas.add(R.mipmap.meizhi008);
        datas.add(R.mipmap.meizhi009);
        datas.add(R.mipmap.meizhi010);
        datas.add(R.mipmap.meizhi011);
        datas.add(R.mipmap.meizhi012);
        datas.add(R.mipmap.meizhi013);
        datas.add(R.mipmap.meizhi014);
        datas.add(R.mipmap.meizhi015);
        datas.add(R.mipmap.meizhi016);
        datas.add(R.mipmap.meizhi017);
        datas.add(R.mipmap.meizhi018);
        return datas;

    }

    @Override
    public void onClick(RecyclerView.ViewHolder holder,int position) {
        Toast.makeText(this, "点击了第"+position+"条目", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongClick(RecyclerView.ViewHolder holder,int position) {
        Toast.makeText(this, "长按点击了第"+position+"条目", Toast.LENGTH_SHORT).show();
    }
}
