/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

/*
 * This file is generated by jOOQ.
*/
package be.yildizgames.engine.feature.city.generated.database.tables;


import be.yildizgames.engine.feature.city.generated.database.Indexes;
import be.yildizgames.engine.feature.city.generated.database.Keys;
import be.yildizgames.engine.feature.city.generated.database.Public;
import be.yildizgames.engine.feature.city.generated.database.tables.records.BuildingsRecord;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Buildings extends TableImpl<BuildingsRecord> {

    private static final long serialVersionUID = -1647801449;

    /**
     * The reference instance of <code>PUBLIC.BUILDINGS</code>
     */
    public static final Buildings BUILDINGS = new Buildings();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<BuildingsRecord> getRecordType() {
        return BuildingsRecord.class;
    }

    /**
     * The column <code>PUBLIC.BUILDINGS.BLD_ID</code>.
     */
    public final TableField<BuildingsRecord, Integer> BLD_ID = createField("BLD_ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.BUILDINGS.CIT_ID</code>.
     */
    public final TableField<BuildingsRecord, Integer> CIT_ID = createField("CIT_ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>PUBLIC.BUILDINGS.POSITION</code>.
     */
    public final TableField<BuildingsRecord, Byte> POSITION = createField("POSITION", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>PUBLIC.BUILDINGS.TYPE</code>.
     */
    public final TableField<BuildingsRecord, Byte> TYPE = createField("TYPE", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>PUBLIC.BUILDINGS.LEVEL</code>.
     */
    public final TableField<BuildingsRecord, Byte> LEVEL = createField("LEVEL", org.jooq.impl.SQLDataType.TINYINT, this, "");

    /**
     * The column <code>PUBLIC.BUILDINGS.STAFF</code>.
     */
    public final TableField<BuildingsRecord, Short> STAFF = createField("STAFF", org.jooq.impl.SQLDataType.SMALLINT, this, "");

    /**
     * Create a <code>PUBLIC.BUILDINGS</code> table reference
     */
    public Buildings() {
        this(DSL.name("BUILDINGS"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.BUILDINGS</code> table reference
     */
    public Buildings(String alias) {
        this(DSL.name(alias), BUILDINGS);
    }

    /**
     * Create an aliased <code>PUBLIC.BUILDINGS</code> table reference
     */
    public Buildings(Name alias) {
        this(alias, BUILDINGS);
    }

    private Buildings(Name alias, Table<BuildingsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Buildings(Name alias, Table<BuildingsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_5);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<BuildingsRecord, Integer> getIdentity() {
        return Keys.IDENTITY_BUILDINGS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<BuildingsRecord> getPrimaryKey() {
        return Keys.PK_BUILDINGS;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<BuildingsRecord>> getKeys() {
        return Arrays.<UniqueKey<BuildingsRecord>>asList(Keys.PK_BUILDINGS);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Buildings as(String alias) {
        return new Buildings(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Buildings as(Name alias) {
        return new Buildings(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Buildings rename(String name) {
        return new Buildings(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Buildings rename(Name name) {
        return new Buildings(name, null);
    }
}
