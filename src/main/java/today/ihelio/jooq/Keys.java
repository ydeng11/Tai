/*
 * This file is generated by jOOQ.
 */
package today.ihelio.jooq;


import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;

import today.ihelio.jooq.tables.Categories;
import today.ihelio.jooq.tables.Hashtags;
import today.ihelio.jooq.tables.Todo;
import today.ihelio.jooq.tables.records.CategoriesRecord;
import today.ihelio.jooq.tables.records.HashtagsRecord;
import today.ihelio.jooq.tables.records.TodoRecord;


/**
 * A class modelling foreign key relationships and constraints of tables in the
 * default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<CategoriesRecord> CATEGORIES__PK_CATEGORIES = Internal.createUniqueKey(Categories.CATEGORIES, DSL.name("pk_categories"), new TableField[] { Categories.CATEGORIES.ID }, true);
    public static final UniqueKey<CategoriesRecord> CATEGORIES__UK_CATEGORIES_38116639 = Internal.createUniqueKey(Categories.CATEGORIES, DSL.name("uk_categories_38116639"), new TableField[] { Categories.CATEGORIES.NAME }, true);
    public static final UniqueKey<HashtagsRecord> HASHTAGS__PK_HASHTAGS = Internal.createUniqueKey(Hashtags.HASHTAGS, DSL.name("pk_hashtags"), new TableField[] { Hashtags.HASHTAGS.ID }, true);
    public static final UniqueKey<HashtagsRecord> HASHTAGS__UK_HASHTAGS_46750378 = Internal.createUniqueKey(Hashtags.HASHTAGS, DSL.name("uk_hashtags_46750378"), new TableField[] { Hashtags.HASHTAGS.NAME }, true);
    public static final UniqueKey<TodoRecord> TODO__PK_TODO = Internal.createUniqueKey(Todo.TODO, DSL.name("pk_todo"), new TableField[] { Todo.TODO.ID }, true);
}
