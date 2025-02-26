/**
 * Copyright (C) 2010 Peter Karich <>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.jtechme.jumpgo.reading;

import java.io.Serializable;
import java.util.Map;

/**
 * Simple impl of Map.Entry. So that we can have ordered maps.
 * 
 * @author Peter Karich, peat_hal ‘at’ users ‘dot’ sourceforge ‘dot’
 *         net
 */
public class MapEntry<K, V> implements Map.Entry<K, V>, Serializable {

    private static final long serialVersionUID = 1L;
    private final K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        this.value = value;
        return value;
    }

    @Override
    public String toString() {
        return key + ", " + value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MapEntry<K, V> other = (MapEntry<K, V>) obj;
        if (this.key != other.key && (this.key == null || !this.key.equals(other.key)))
            return false;
        return !(this.value != other.value && (this.value == null || !this.value
                .equals(other.value)));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + (this.key != null ? this.key.hashCode() : 0);
        hash = 19 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }
}
