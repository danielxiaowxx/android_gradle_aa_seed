package com.daniel.codegen;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

public class AppDaoGenerator {

    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1000, "com.daniel.android_gradle_aa_seed.app.dao.db");

        addUser(schema);

        new DaoGenerator().generateAll(schema, "./codegen/gen/");
    }

    public static void addUser(Schema schema) {
        Entity note = schema.addEntity("User");
        note.addIdProperty();
        note.addStringProperty("username").notNull();
        note.addStringProperty("password");
        note.addDateProperty("createDate");
    }

}
