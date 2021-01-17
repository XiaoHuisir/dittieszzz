package com.dittieszzz.ditties.ditties_zzz.ui.fragment;

import android.widget.TextView;

import com.dittieszzz.ditties.ditties_zzz.R;
import com.dittieszzz.ditties.ditties_zzz.base.BaseFragment;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.utils.SPUtils;

import butterknife.BindView;

public class NoteFragment extends BaseFragment {
    @BindView(R.id.tv_notes)
    TextView tvNotes;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_note;
    }

    @Override
    protected void initView() {
        String notes = (String) SPUtils.get(context, "notes", "");
        tvNotes.setText(notes);
    }
}
