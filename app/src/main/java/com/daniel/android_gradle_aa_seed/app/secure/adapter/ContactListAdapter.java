package com.daniel.android_gradle_aa_seed.app.secure.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.daniel.android_gradle_aa_seed.app.bo.ContactBO;
import com.daniel.android_gradle_aa_seed.app.secure.itemview.ContactListItem;
import com.daniel.android_gradle_aa_seed.app.secure.itemview.ContactListItem_;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 14-5-13.
 */
@EBean
public class ContactListAdapter extends BaseAdapter {

    public List<ContactBO> data = new ArrayList<ContactBO>();

    @RootContext
    Context context;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public ContactBO getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ContactListItem contactListItem;
        if (view == null) {
            contactListItem = ContactListItem_.build(context);
        } else {
            contactListItem = (ContactListItem)view;
        }

        contactListItem.bind(getItem(i));

        return contactListItem;
    }
}
