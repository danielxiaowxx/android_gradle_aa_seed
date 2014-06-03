package com.daniel.android_gradle_aa_seed.app;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.daniel.android_gradle_aa_seed.app.secure.adapter.ContactListAdapter;
import com.daniel.android_gradle_aa_seed.app.secure.bo.ContactBO;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ItemClick;
import org.androidannotations.annotations.OptionsMenu;
import org.androidannotations.annotations.OptionsMenuItem;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
@OptionsMenu(R.menu.main)
public class MainActivity extends ActionBarActivity {

    @ViewById(R.id.contactListView)
    ListView contactListView;

    @OptionsMenuItem(R.id.action_search)
    MenuItem menuSearch;

    @Bean
    ContactListAdapter contactListAdapter;

    @AfterViews
    protected void init() {
        // do something after views had been created
        List<ContactBO> contacts = new ArrayList<ContactBO>();
        contacts.add(new ContactBO("daniel", "xiao"));
        contactListAdapter.data = contacts;
        contactListView.setAdapter(contactListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        SearchView searchView = (SearchView)MenuItemCompat.getActionView(menuSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                Log.i("aaaa", s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }

    @ItemClick
    void contactListViewItemClicked(ContactBO contactBO) {
        Toast.makeText(this, contactBO.firstName + " " + contactBO.lastName, Toast.LENGTH_SHORT).show();
    }
}
