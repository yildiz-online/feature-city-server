/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2017 Grégory Van den Borre
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

package be.yildizgames.engine.feature.city.persistence;

import be.yildiz.common.collections.Maps;
import be.yildiz.common.id.EntityId;
import be.yildiz.module.database.data.PersistentData;
import be.yildizgames.engine.feature.city.City;
import be.yildizgames.engine.feature.city.ServerCity;
import be.yildizgames.engine.feature.city.ServerCityManager;
import be.yildizgames.engine.feature.city.building.BaseBuilding;
import be.yildizgames.engine.feature.city.building.GameBuildingData;
import be.yildizgames.engine.feature.city.building.construction.BuildingConstructionManager;
import be.yildizgames.engine.feature.city.generated.database.tables.Buildings;
import be.yildizgames.engine.feature.city.generated.database.tables.Cities;
import be.yildizgames.engine.feature.city.generated.database.tables.records.CitiesRecord;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.Map;
import java.util.Optional;

/**
 * Persistent data for buildings.
 *
 * @author Grégory Van den Borre
 */
public final class PersistentCity implements PersistentData<City, City>, RecordMapper<CitiesRecord, City> {

    /**
     * Persistent unit where data must be retrieved.
     */
    private static final Buildings table = Buildings.BUILDINGS;

    /**
     * Associated city manager.
     */
    private ServerCityManager cityManager;

    /**
     * Full constructor, retrieve data from persistent context.
     *
     * @param c Connection to the persistence unit.
     * @param constructionManager Construction manager.
     * @param em City manager.
     */
    public PersistentCity(final Connection c, BuildingConstructionManager<BaseBuilding, GameBuildingData, ServerCity> constructionManager, final ServerCityManager em) {
        super();
        this.cityManager = em;
        Map<EntityId, String> names = Maps.newMap();
        try (DSLContext create = this.getDSL(c)) {
            Optional.ofNullable(create.selectFrom(Cities.CITIES).fetch())
                    .ifPresent(citiesRecords ->
                            citiesRecords.forEach(r -> names.put(EntityId.valueOf(r.getEntId().longValue()), r.getName())));
            //        faire le set a la reception du message entity info response dans le client
        }
    }

    @Override
    public City save(final City data, Connection c) {
        try (DSLContext create = this.getDSL(c)) {

            return data;
        }
    }

    @Override
    public void update(final City data, Connection c) {
        try (DSLContext create = this.getDSL(c)) {

        }
    }

    @Override
    public City map(CitiesRecord r) {

        return null;
    }

    private DSLContext getDSL(Connection c) {
        Settings settings = new Settings();
        settings.setExecuteLogging(false);
        return DSL.using(c, settings);
    }
}
