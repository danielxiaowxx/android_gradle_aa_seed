package com.daniel.android_gradle_aa_seed.app.secure.itemview;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daniel.android_gradle_aa_seed.app.R;
import com.daniel.android_gradle_aa_seed.app.secure.bo.ContactBO;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EViewGroup;
import org.androidannotations.annotations.ViewById;

/**
 * Created by Daniel on 14-5-15.
 */

@EViewGroup(R.layout.contact_list_item)
public class ContactListItem extends LinearLayout {

    @ViewById(R.id.contactListItemFirstName)
    TextView firstNameTextView;

    @ViewById(R.id.contactListItemLastName)
    TextView lastNameTextView;

    public ContactListItem(Context context) {
        super(context);
    }

    @Click(R.id.contactListItemEditBtn)
    protected void editContact() {
        Log.i("ContactListItem", firstNameTextView.getText().toString());
    }

    public void bind(ContactBO contact) {
        firstNameTextView.setText(contact.firstName);
        lastNameTextView.setText(contact.lastName);
    }

}
