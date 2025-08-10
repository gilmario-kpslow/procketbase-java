package br.com.pocketbase.colecao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author gilmario
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Campo {

    private String autogeneratePattern;
    private boolean hidden;
    private String id;
    private Integer max;
    private Integer min;
    private String name;
    private String pattern;
    private String type;
    private boolean presentable;
    private boolean primaryKey;
    private boolean required;
    private boolean system;

    public Campo() {
    }

    public String getAutogeneratePattern() {
        return autogeneratePattern;
    }

    public void setAutogeneratePattern(String autogeneratePattern) {
        this.autogeneratePattern = autogeneratePattern;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPresentable() {
        return presentable;
    }

    public void setPresentable(boolean presentable) {
        this.presentable = presentable;
    }

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

}
