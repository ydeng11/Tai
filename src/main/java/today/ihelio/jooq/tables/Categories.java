/*
 * This file is generated by jOOQ.
 */
package today.ihelio.jooq.tables;


import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function2;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import today.ihelio.jooq.DefaultSchema;
import today.ihelio.jooq.Keys;
import today.ihelio.jooq.tables.records.CategoriesRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Categories extends TableImpl<CategoriesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>categories</code>
     */
    public static final Categories CATEGORIES = new Categories();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CategoriesRecord> getRecordType() {
        return CategoriesRecord.class;
    }

    /**
     * The column <code>categories.id</code>.
     */
    public final TableField<CategoriesRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.identity(true), this, "");

    /**
     * The column <code>categories.name</code>.
     */
    public final TableField<CategoriesRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(64), this, "");

    private Categories(Name alias, Table<CategoriesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Categories(Name alias, Table<CategoriesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>categories</code> table reference
     */
    public Categories(String alias) {
        this(DSL.name(alias), CATEGORIES);
    }

    /**
     * Create an aliased <code>categories</code> table reference
     */
    public Categories(Name alias) {
        this(alias, CATEGORIES);
    }

    /**
     * Create a <code>categories</code> table reference
     */
    public Categories() {
        this(DSL.name("categories"), null);
    }

    public <O extends Record> Categories(Table<O> child, ForeignKey<O, CategoriesRecord> key) {
        super(child, key, CATEGORIES);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<CategoriesRecord, Integer> getIdentity() {
        return (Identity<CategoriesRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<CategoriesRecord> getPrimaryKey() {
        return Keys.CATEGORIES__PK_CATEGORIES;
    }

    @Override
    public List<UniqueKey<CategoriesRecord>> getUniqueKeys() {
        return Arrays.asList(Keys.CATEGORIES__UK_CATEGORIES_38116639);
    }

    @Override
    public Categories as(String alias) {
        return new Categories(DSL.name(alias), this);
    }

    @Override
    public Categories as(Name alias) {
        return new Categories(alias, this);
    }

    @Override
    public Categories as(Table<?> alias) {
        return new Categories(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Categories rename(String name) {
        return new Categories(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Categories rename(Name name) {
        return new Categories(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Categories rename(Table<?> name) {
        return new Categories(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<Integer, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super Integer, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super Integer, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
