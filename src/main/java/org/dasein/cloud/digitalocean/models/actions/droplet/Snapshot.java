/**
 * Copyright (C) 2012-2015 Dell, Inc.
 * See annotations for authorship information
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.dasein.cloud.digitalocean.models.actions.droplet;

import org.dasein.cloud.CloudException;
import org.dasein.cloud.digitalocean.models.rest.ActionType;
import org.dasein.cloud.digitalocean.models.rest.DigitalOceanPostAction;
import org.json.JSONException;
import org.json.JSONObject;


public class Snapshot extends DigitalOceanPostAction {	
		
	public String snapshotName;
	public Snapshot(String name) {
		actionType = ActionType.DROPLET;
		this.snapshotName = name;
	}
	
	@Override	
	public  String getType() {			
		return "snapshot";
	}
	
	@Override
	public JSONObject getParameters() throws CloudException, JSONException {
		JSONObject j =getDefaultJSON();
		if (snapshotName == null) {
			throw new CloudException("Snapshot name must be defined");
		}
		if (snapshotName.isEmpty()) {
			throw new CloudException("Snapshot name must not be empty");
		}
		
		j.put("name",  snapshotName);
		return j;
	}
	
}

