package com.codekidlabs.storagechooser.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.codekidlabs.storagechooser.R;
import com.codekidlabs.storagechooser.animators.MemorybarAnimation;
import com.codekidlabs.storagechooser.models.Storages;
import com.codekidlabs.storagechooser.utils.FileUtil;
import com.codekidlabs.storagechooser.utils.ThumbnailUtil;

import java.io.File;
import java.util.List;

public class FilePickerAdapter extends BaseAdapter {

    private List<String> storagesList;
    private Context mContext;
    private boolean shouldShowMemoryBar;
    private String selectedPath;
    public static boolean shouldEnable = true;


    public FilePickerAdapter(List<String> storagesList, Context mContext, boolean shouldShowMemoryBar, String selectedPath) {
        this.storagesList = storagesList;
        this.mContext = mContext;
        this.shouldShowMemoryBar = shouldShowMemoryBar;
        this.selectedPath = selectedPath;
    }

    @Override
    public int getCount() {
        return storagesList.size();
    }

    @Override
    public Object getItem(int i) {
        return storagesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rootView = inflater.inflate(R.layout.row_custom_paths, viewGroup, false);

        ImageView pathFolderIcon = (ImageView) rootView.findViewById(R.id.path_folder_icon);
        if(FileUtil.isDir(selectedPath + "/" + storagesList.get(i))) {
            appluFolderTint(pathFolderIcon);
        }

        ThumbnailUtil thumbnailUtil = new ThumbnailUtil(mContext);
        thumbnailUtil.init(pathFolderIcon, storagesList.get(i));

        TextView storageName = (TextView) rootView.findViewById(R.id.storage_name);
        storageName.setText(storagesList.get(i));

        return rootView;

    }


    /**
     * return the spannable index of character '('
     * @param str SpannableStringBuilder to apply typeface changes
     * @return index of '('
     */
    private int getSpannableIndex(SpannableStringBuilder str) {
        return str.toString().indexOf("(") + 1;
    }

    private void appluFolderTint(ImageView im) {
        im.setColorFilter(ContextCompat.getColor(mContext, R.color.colorPrimary));
    }

    @Override
    public boolean isEnabled(int position) {
        return shouldEnable;
    }
}
