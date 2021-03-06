/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
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
import be.yildizgames.engine.feature.city.generated.database.tables.records.CitiesRecord;
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
public class Cities extends TableImpl<CitiesRecord> {

    private static final long serialVersionUID = -242612427;

    /**
     * The reference instance of <code>PUBLIC.CITIES</code>
     */
    public static final Cities CITIES = new Cities();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<CitiesRecord> getRecordType() {
        return CitiesRecord.class;
    }

    /**
     * The column <code>PUBLIC.CITIES.CIT_ID</code>.
     */
    public final TableField<CitiesRecord, Integer> CIT_ID = createField("CIT_ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>PUBLIC.CITIES.ENT_ID</code>.
     */
    public final TableField<CitiesRecord, Integer> ENT_ID = createField("ENT_ID", org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>PUBLIC.CITIES.NAME</code>.
     */
    public final TableField<CitiesRecord, String> NAME = createField("NAME", org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * Create a <code>PUBLIC.CITIES</code> table reference
     */
    public Cities() {
        this(DSL.name("CITIES"), null);
    }

    /**
     * Create an aliased <code>PUBLIC.CITIES</code> table reference
     */
    public Cities(String alias) {
        this(DSL.name(alias), CITIES);
    }

    /**
     * Create an aliased <code>PUBLIC.CITIES</code> table reference
     */
    public Cities(Name alias) {
        this(alias, CITIES);
    }

    private Cities(Name alias, Table<CitiesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Cities(Name alias, Table<CitiesRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.PRIMARY_KEY_7);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<CitiesRecord, Integer> getIdentity() {
        return Keys.IDENTITY_CITIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<CitiesRecord> getPrimaryKey() {
        return Keys.PK_CITIES;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<CitiesRecord>> getKeys() {
        return Arrays.<UniqueKey<CitiesRecord>>asList(Keys.PK_CITIES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cities as(String alias) {
        return new Cities(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Cities as(Name alias) {
        return new Cities(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Cities rename(String name) {
        return new Cities(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Cities rename(Name name) {
        return new Cities(name, null);
    }

}
