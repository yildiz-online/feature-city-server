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

package be.yildizgames.engine.feature.city.persistence;

import be.yildiz.module.database.data.PersistentData;
import be.yildizgames.engine.feature.city.City;
import be.yildizgames.engine.feature.city.CityId;
import be.yildizgames.engine.feature.city.ServerCity;
import be.yildizgames.engine.feature.city.ServerCityManager;
import be.yildizgames.engine.feature.city.building.BaseBuilding;
import be.yildizgames.engine.feature.city.building.BuildingPosition;
import be.yildizgames.engine.feature.city.building.BuildingType;
import be.yildizgames.engine.feature.city.building.GameBuildingData;
import be.yildizgames.engine.feature.city.building.construction.BuildingConstructionManager;
import be.yildizgames.engine.feature.city.building.staff.Staff;
import be.yildizgames.engine.feature.city.generated.database.tables.Buildings;
import be.yildizgames.engine.feature.city.generated.database.tables.records.BuildingsRecord;
import be.yildizgames.engine.feature.entity.Level;
import org.jooq.DSLContext;
import org.jooq.RecordMapper;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.util.Optional;

/**
 * Persistent data for buildings.
 *
 * @author Grégory Van den Borre
 */
public final class PersistentBuilding implements PersistentData<BaseBuilding, BaseBuilding, BaseBuilding>, RecordMapper<BuildingsRecord, BaseBuilding> {

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
    public PersistentBuilding(final Connection c, BuildingConstructionManager<BaseBuilding, GameBuildingData, ServerCity> constructionManager, final ServerCityManager em) {
        super();
        this.cityManager = em;
        try (DSLContext create = this.getDSL(c)) {
            Optional
                    .ofNullable(create.selectFrom(table).fetch())
                    .ifPresent(data -> data.map(this)
                            .stream()
                            .filter(BaseBuilding::exists)
                            .forEach(constructionManager::createBuilding));
            em.getCities().forEach(City::initializeProducer);
        }
    }

    @Override
    public BaseBuilding save(final BaseBuilding data, Connection c) {
        try (DSLContext create = this.getDSL(c)) {
            create.insertInto(table, table.CIT_ID, table.POSITION, table.TYPE, table.LEVEL, table.STAFF)
                    .values(
                            (int) data.getCity().value,
                            (byte) data.getBuildingPosition().value,
                            (byte)data.getType().type,
                            (byte)data.getLevel().value,
                            (short)data.getStaff().value)
                    .execute();
            return data;
        }
    }

    @Override
    public void update(final BaseBuilding data, Connection c) {
        try (DSLContext create = this.getDSL(c)) {
            BuildingsRecord building = create.fetchOne(table, table.CIT_ID.equal((int)data.getCity().value).and(table.POSITION.equal((byte)data.getBuildingPosition().value)));
            building.setCitId((int)data.getCity().value);
            building.setType((byte)data.getType().type);
            building.setLevel((byte)data.getLevel().value);
            building.setStaff((short)data.getStaff().value);
            create.executeUpdate(building);
        }
    }

    @Override
    public BaseBuilding map(BuildingsRecord r) {
        CityId id = CityId.valueOf(r.getCitId());
        BuildingPosition pos = BuildingPosition.valueOf(r.getPosition().intValue());
        BuildingType type = BuildingType.valueOf(r.getType().intValue());
        Level level = Level.valueOf(r.getLevel().intValue());
        Staff staff = Staff.valueOf(r.getStaff().intValue());
        return new BaseBuilding(id, cityManager.getData(type), pos, level, staff);
    }

    private DSLContext getDSL(Connection c) {
        Settings settings = new Settings();
        settings.setExecuteLogging(false);
        return DSL.using(c, settings);
    }
}
