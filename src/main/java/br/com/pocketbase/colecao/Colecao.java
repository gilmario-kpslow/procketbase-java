package br.com.pocketbase.colecao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

/**
 *
 * @author gilmario
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Colecao {

    private String id;
    private String listRule;
    private String viewRule;
    private String createRule;
    private String updateRule;
    private String deleteRule;
    private String name;
    private String type;
    private List<Campo> fields;
    private List<String> indexes;
    private String created;
    private String updated;
    private boolean system;

    public Colecao() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getListRule() {
        return listRule;
    }

    public void setListRule(String listRule) {
        this.listRule = listRule;
    }

    public String getViewRule() {
        return viewRule;
    }

    public void setViewRule(String viewRule) {
        this.viewRule = viewRule;
    }

    public String getCreateRule() {
        return createRule;
    }

    public void setCreateRule(String createRule) {
        this.createRule = createRule;
    }

    public String getUpdateRule() {
        return updateRule;
    }

    public void setUpdateRule(String updateRule) {
        this.updateRule = updateRule;
    }

    public String getDeleteRule() {
        return deleteRule;
    }

    public void setDeleteRule(String deleteRule) {
        this.deleteRule = deleteRule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Campo> getFields() {
        return fields;
    }

    public void setFields(List<Campo> fields) {
        this.fields = fields;
    }

    public List<String> getIndexes() {
        return indexes;
    }

    public void setIndexes(List<String> indexes) {
        this.indexes = indexes;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

}
