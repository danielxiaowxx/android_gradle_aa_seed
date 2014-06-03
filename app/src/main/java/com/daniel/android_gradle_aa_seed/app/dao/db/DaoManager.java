package com.daniel.android_gradle_aa_seed.app.dao.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.daniel.android_gradle_aa_seed.app.R;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.res.StringRes;

/**
 * Created by Daniel on 14-5-29.
 */

@EBean(scope = EBean.Scope.Singleton)
public class DaoManager {

    @RootContext
    Context context;

    @StringRes(R.string.db_name)
    String dbName;

    private DaoSession daoSession = null;

    private DaoSession getDBSession() {
        if (daoSession == null) {
            DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, dbName, null);
            SQLiteDatabase db = helper.getWritableDatabase();
            DaoMaster daoMaster = new DaoMaster(db);
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }

    public UserDao getUserDao() {
        return getDBSession().getUserDao();
    }

}
