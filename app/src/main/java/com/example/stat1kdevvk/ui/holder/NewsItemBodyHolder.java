package com.example.stat1kdevvk.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.example.stat1kdevvk.R;
import com.example.stat1kdevvk.model.view.NewsFeedItemBodyViewModel;

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel> {

    public TextView mText;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);

        mText = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel newsFeedItemBodyViewModel) {
        mText.setText(newsFeedItemBodyViewModel.getText());
    }

    @Override
    public void unbindViewHolder() {
        mText.setText(null);
    }
}
