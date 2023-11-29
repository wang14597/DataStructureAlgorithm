package org.wl.JavaConcurrency;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class _005_publishingVehicleTracker {

    @ThreadSafe
    public static class SafePoint {
        @GuardedBy("this")
        private int x, y;

        private SafePoint(int[] a) {
            this(a[0], a[1]);
        }

        public SafePoint(SafePoint p) {
            this(p.get());
        }

        public SafePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public synchronized void set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public synchronized int[] get() {
            return new int[]{x, y};
        }
    }

    private final Map<String, SafePoint> locations;
    private final Map<String, SafePoint> unmodifiableMap;

    public _005_publishingVehicleTracker(Map<String, SafePoint> locations) {
        this.locations = new ConcurrentHashMap<>(locations);
        this.unmodifiableMap = Collections.unmodifiableMap(this.locations);
    }

    public Map<String, SafePoint> getLocations() {
        return unmodifiableMap;
    }

    public SafePoint getLocation(String id) {
        return locations.get(id);
    }

    public void setLocations(String id, int x, int y) {
        if (!locations.containsKey(id)) throw new IllegalArgumentException("invalid vehicle name: " + id);
        locations.get(id).set(x, y);
    }
}
