package sinaflashmoney.credit.sina.com.recycleviewpubustream;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by Administrator on 2017/12/10 0010.
 */

public class FormActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private NormalRecyclerViewAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        initData();

    }

    private void initData() {
        mRecyclerView.setLayoutManager(
                new LinearLayoutManager(this));

        mAdapter = new NormalRecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        /**
         * 实现下划线
         *
         * 新建类DividerItemDecoration.class
         *
         * AppTheme加入:  <item name="android:listDivider">@drawable/item_bottom_line</item>
         *
         * DividerItemDecoration.VERTICAL_LIST : 这个方向要注意，如果是下划线，列表的是垂直的，不要弄错，否则出不来
         */

        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL_LIST));


        /**
         * 加入header
         */
        setAdaperHeader();
    }


    private void setAdaperHeader(){
        View view = LayoutInflater.from(this).inflate(R.layout.item_first_header,null);
        mAdapter.setHeader(view);
    }
}
