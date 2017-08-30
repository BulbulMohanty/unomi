/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.unomi.api;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * A value type to be used to constrain property values.
 */
@XmlRootElement
public class ValueType implements PluginType {

    private String id;
    private String nameKey;
    private String descriptionKey;
    private long pluginId;
    @Deprecated
    private Set<Tag> tags = new TreeSet<>();
    private Set<String> tagIds = new LinkedHashSet<>();

    /**
     * Instantiates a new Value type.
     */
    public ValueType() {
    }

    /**
     * Instantiates a new Value type with the specified identifier.
     *
     * @param id the identifier
     */
    public ValueType(String id) {
        this.id = id;
    }

    /**
     * Retrieves this ValueType's identifier.
     *
     * @return this ValueType's identifier
     */
    public String getId() {
        return id;
    }

    /**
     * Sets this ValueType's identifier.
     *
     * @param id this ValueType's identifier
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the {@link java.util.ResourceBundle} key used to localize this ValueType's name.
     *
     * @return the {@link java.util.ResourceBundle} key used to localize this ValueType's name
     */
    public String getNameKey() {
        if (nameKey == null) {
            nameKey = "type." + id;
        }
        return nameKey;
    }

    /**
     * Sets the name key.
     *
     * @param nameKey the name key
     */
    public void setNameKey(String nameKey) {
        this.nameKey = nameKey;
    }

    /**
     * Retrieves the {@link java.util.ResourceBundle} key used to localize this ValueType's description.
     *
     * @return the {@link java.util.ResourceBundle} key used to localize this ValueType's name
     */
    public String getDescriptionKey() {
        if (descriptionKey == null) {
            descriptionKey = "type." + id + ".description";
        }
        return descriptionKey;
    }

    /**
     * Sets the description key.
     *
     * @param descriptionKey the description key
     */
    public void setDescriptionKey(String descriptionKey) {
        this.descriptionKey = descriptionKey;
    }

    @XmlTransient
    public long getPluginId() {
        return pluginId;
    }

    public void setPluginId(long pluginId) {
        this.pluginId = pluginId;
    }

    /**
     * Retrieves the tags used by this ValueType.
     *
     * @return the tags used by this ValueType
     * @deprecated will be removed in next major release as tag become an open string
     */
    @XmlTransient
    @Deprecated
    public Set<Tag> getTags() {
        return tags;
    }

    /**
     * Sets the tags used by this ValueType.
     *
     * @param tags the tags used by this ValueType
     * @deprecated will be removed in next major release as tag become an open string
     */
    @Deprecated
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Retrieves the identifiers of the tags used by this ValueType.
     *
     * @return the identifiers of the tags used by this ValueType
     * @deprecated will be rename to getTags() in next major release as tag become an open string
     */
    @XmlElement(name = "tags")
    @Deprecated
    public Set<String> getTagIds() {
        return tagIds;
    }

    /**
     * Sets the identifiers of the tags used by this ValueType.
     *
     * @param tagIds the identifiers of the tags used by this ValueType
     * @deprecated will be rename to setTags(Set&lt;String&gt; tags) in next major release as tag become an open string
     */
    @Deprecated
    public void setTagIds(Set<String> tagIds) {
        this.tagIds = tagIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValueType valueType = (ValueType) o;

        return id.equals(valueType.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
