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

package be.yildizgames.engine.feature.city.server;

import be.yildizgames.common.geometry.Point3D;
import be.yildizgames.common.model.EntityId;
import be.yildizgames.common.model.PlayerId;
import be.yildizgames.engine.feature.city.BaseCity;
import be.yildizgames.engine.feature.city.CityId;
import be.yildizgames.engine.feature.city.building.BaseBuilding;
import be.yildizgames.engine.feature.city.building.BuildingType;
import be.yildizgames.engine.feature.city.building.GameBuildingData;
import be.yildizgames.engine.feature.resource.ResourceValue;

import java.util.Map;

/**
 * @author Grégory Van den Borre
 */
public class ServerBaseCity extends BaseCity<BaseBuilding, GameBuildingData> implements ServerCity {

    /**
     * Create a new BaseCity.
     *
     * @param id Id for this city.
     * @param initialResource Resource when the city is built.
     * @param positionOffset  Building positions.
     * @param datas Data about the available buildings.
     */
    public ServerBaseCity(CityId id, PlayerId owner, Point3D position, ResourceValue initialResource, Point3D[] positionOffset, Map<BuildingType, GameBuildingData> datas) {
        super(id, owner, position, initialResource, positionOffset, datas);
    }
}
