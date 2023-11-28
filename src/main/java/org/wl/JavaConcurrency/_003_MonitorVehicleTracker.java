package org.wl.JavaConcurrency;

import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ThreadSafe
public class _003_MonitorVehicleTracker {

    @NotThreadSafe
    public static class MutablePoint {

        public int x, y;

        public MutablePoint() {
            x = 0;
            y = 0;
        }

        public MutablePoint(MutablePoint point) {
            this.x = point.x;
            this.y = point.y;
        }
    }

    private final Map<String, MutablePoint> locations;

    public _003_MonitorVehicleTracker(Map<String, MutablePoint> locations) {
        this.locations = deepCopy(locations);
    }

    public synchronized Map<String, MutablePoint> getLocations() {
        return deepCopy(locations);
    }

    public synchronized MutablePoint getLocation(String id) {
        MutablePoint loc = locations.get(id);
        return loc == null ? null : new MutablePoint(loc);
    }

    public synchronized void setLocation(String id, int x, int y) {
        MutablePoint loc = locations.get(id);
        if (loc == null) throw new IllegalArgumentException("No such IDL " + id);
        loc.x = x;
        loc.y = y;
    }

    private static Map<String, MutablePoint> deepCopy(Map<String, MutablePoint> locations) {
        HashMap<String, MutablePoint> result = new HashMap<>();
        for (String id : locations.keySet()) {
            result.put(id, new MutablePoint(locations.get(id)));
        }
        return Collections.unmodifiableMap(result);
    }
}
