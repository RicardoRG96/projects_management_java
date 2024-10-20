package cl.ricardo.projectManagement.dataAccess;

import java.util.Objects;

public class WorkGroup {
    
    private Integer id = null;
    
    private Integer projectId;
    
    private String name;
    
    private Integer leaderId;
    
    private String createdAt = null;

    public WorkGroup() {
        this.projectId = null;
        this.name = "";
        this.leaderId = null;
        this.createdAt = "";
    }

    public WorkGroup(Integer projectId, String name, Integer leaderId) {
        this.projectId = projectId;
        this.name = name;
        this.leaderId = leaderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "WorkGroup{" + "id=" + id + ", projectId=" + projectId + ", name=" + name + ", leaderId=" + leaderId + ", createdAt=" + createdAt + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.projectId);
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.leaderId);
        hash = 17 * hash + Objects.hashCode(this.createdAt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WorkGroup other = (WorkGroup) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.projectId, other.projectId)) {
            return false;
        }
        return Objects.equals(this.leaderId, other.leaderId);
    }
    
}
