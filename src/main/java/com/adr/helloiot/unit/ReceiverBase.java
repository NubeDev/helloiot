//    HelloIoT is a dashboard creator for MQTT
//    Copyright (C) 2017-2018 Adrián Romero Corchado.
//
//    This file is part of HelloIot.
//
//    HelloIot is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    HelloIot is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with HelloIot.  If not, see <http://www.gnu.org/licenses/>.
//
package com.adr.helloiot.unit;

import com.adr.helloiotlib.unit.Unit;
import com.adr.helloiotlib.app.IoTApp;
import com.adr.helloiot.device.DeviceSubscribe;
import javafx.scene.Node;

/**
 *
 * @author adrian
 */
public abstract class ReceiverBase implements Unit {

    private DeviceSubscribe device = null;
    protected IoTApp app;

// The Subscribe is the abstract method
//    @Subscribe
//    public void receivedStatus(EventStatus message) {
//    }
    
    @Override
    public void construct(IoTApp app) {
        this.app = app;
        device.subscribeStatus(this);
    }

    @Override
    public void destroy() {
        device.unsubscribeStatus(this);
    }

    public void setDevice(DeviceSubscribe device) {
        this.device = device;
    }

    public DeviceSubscribe getDevice() {
        return device;
    }

    @Override
    public Node getNode() {
        return null;
    }
}
